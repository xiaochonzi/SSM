package com.xiaochonzi.dao;

import com.xiaochonzi.entity.Comment;
import com.xiaochonzi.entity.User;

import java.util.List;

/**
 * Created by stone on 17/6/8.
 */
public interface CommentDAO {

    /**
     * 新增评论
     * @param comment
     * @return
     */
    public int insertComment(Comment comment);

    /**
     * 删除评论
     * @param id
     * @return
     */
    public int deleteCommentById(int id);

    /**
     * 查询文章评论
     * @param postId
     * @return
     */
    public List<Comment> selectCommentByPostId(int postId);

    /**
     * 评论点赞人数
     * @param commentId
     * @return
     */
    public int commentLikeCount(int commentId);

    /**
     * 评论点赞人
     * @param commentId
     * @return
     */
    public List<User> selectCommentLikeUsers(int commentId);
}
