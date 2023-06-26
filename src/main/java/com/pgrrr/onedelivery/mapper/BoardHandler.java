package com.pgrrr.onedelivery.mapper;

import com.pgrrr.onedelivery.domain.Post;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface BoardHandler {
    void createPost(Post post);

    Post getPost(Long id);

    List<Post> readAll(@Param("offset") int offset, @Param("limit") int limit);

    void update(Post post);

    void delete(Long id);
}
