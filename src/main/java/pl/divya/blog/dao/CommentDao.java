package pl.divya.blog.dao;

import pl.divya.blog.entity.Comment;

import java.util.List;

public interface CommentDao {
    List<Comment> getCommentsByPostId(int id);
    void addNewComment(Comment comment);
    void deleteCommentsByPost(int postId);
    void deleteCommentsByUser(int authorId);
    void deleteCommentsByCategory(int categoryId);
    public void deleteAllComments();
}
