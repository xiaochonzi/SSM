package com.xiaochonzi.dao;

import com.xiaochonzi.entity.Comment;
import com.xiaochonzi.entity.Post;
import com.xiaochonzi.entity.User;

import java.util.List;

/**
 * Created by stone on 17/6/8.
 */
public interface PostDAO {

    /**
     * 新增文章
     * @param post
     * @return
     */
    public int insertPost(Post post);

    /**
     * 删除文章
     * @param id
     * @return
     */
    public int deletePostById(int id);

    /**
     * 修改文章
     * @param post
     * @return
     */
    public int updatePost(Post post);

    /**
     * 查找文章
     * 通过id
     * @param id
     * @return
     */
    public Post selectPostById(int id);

    /**
     * 查找文章
     * 根据作者
     * @param authorId
     * @return
     */
    public List<Post> selectPostByAuthor(int authorId);

    /**
     * 文章点赞人数
     * @param postId
     * @return
     */
    public int postLikeCount(int postId);

    /**
     * 文章点赞人
     * @param postId
     * @return
     */
    public List<User> selectPostLikeUsers(int postId);
}
