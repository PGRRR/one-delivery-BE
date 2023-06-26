package com.pgrrr.onedelivery.service;

import com.pgrrr.onedelivery.domain.Post;
import com.pgrrr.onedelivery.mapper.BoardHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BoardService {

    private final BoardHandler boardHandler;

    @Autowired
    public BoardService(BoardHandler boardHandler) {
        this.boardHandler = boardHandler;
    }

    public void createPost(Post post) {
        boardHandler.createPost(post);
    }

    public Post getPost(Long id) {
        return boardHandler.getPost(id);
    }
}
