package com.pgrrr.onedelivery.repository;

import com.pgrrr.onedelivery.domain.Post;
import com.pgrrr.onedelivery.mapper.BoardHandler;
import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class BoardHandlerImpl implements BoardHandler {

    private final SqlSession sqlSession;

    @Autowired
    public BoardHandlerImpl(SqlSession sqlSession) {
        this.sqlSession = sqlSession;
    }

    @Override
    public void createPost(Post post) {
        sqlSession.insert("createPost", post);
    }

    @Override
    public Post getPost(Long id) {
        return sqlSession.selectOne("getPost", id);
    }

    @Override
    public List<Post> readAll(int offset, int limit) {
        RowBounds rowBounds = new RowBounds(offset, limit);
        return sqlSession.selectList("readAll", rowBounds);
    }

    @Override
    public void update(Post post) {
        sqlSession.update("update", post);
    }

    @Override
    public void delete(Long id) {
        sqlSession.delete("delete", id);
    }
}
