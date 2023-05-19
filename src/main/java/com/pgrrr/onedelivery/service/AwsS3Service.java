package com.pgrrr.onedelivery.service;

import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.*;
import com.amazonaws.util.IOUtils;
import com.pgrrr.onedelivery.exception.*;
import com.pgrrr.onedelivery.util.CommonUtils;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;

@Slf4j
@RequiredArgsConstructor
@Service
public class AwsS3Service {

    private final AmazonS3 amazonS3;

    @Value("${cloud.aws.s3.bucket}")
    private String bucketName;

    public String uploadFileV1(String category, MultipartFile multipartFile) {
        validateFileExists(multipartFile);

        String fileName = CommonUtils.buildFileName(category, multipartFile.getOriginalFilename());

        ObjectMetadata objectMetadata = new ObjectMetadata();
        objectMetadata.setContentType(multipartFile.getContentType());

        try (InputStream inputStream = multipartFile.getInputStream()) {
            amazonS3.putObject(
                    new PutObjectRequest(bucketName, fileName, inputStream, objectMetadata)
                            .withCannedAcl(CannedAccessControlList.PublicRead));
        } catch (IOException e) {
            throw new FileUploadFailedException(ErrorCode.FILE_UPLOAD_FAILED);
        }

        return amazonS3.getUrl(bucketName, fileName).toString();
    }

    private void validateFileExists(MultipartFile multipartFile) {
        if (multipartFile.isEmpty()) {
            throw new EmptyFileException(ErrorCode.FILE_SIZE_EXCEED);
        }
    }

    public byte[] downloadFileV1(String resourcePath) {
        validateFileExistsAtUrl(resourcePath);

        S3Object s3Object = amazonS3.getObject(bucketName, resourcePath);
        S3ObjectInputStream inputStream = s3Object.getObjectContent();
        try {
            return IOUtils.toByteArray(inputStream);
        } catch (IOException e) {
            throw new FileDownloadFailedException(ErrorCode.FILE_DOWNLOAD_FAILED);
        }
    }

    private void validateFileExistsAtUrl(String resourcePath) {
        if (!amazonS3.doesObjectExist(bucketName, resourcePath)) {
            throw new FileNotFoundException(ErrorCode.FILE_NOT_FOUND);
        }
    }
}
