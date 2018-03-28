package pl.divya.blog.service;

import pl.divya.blog.entity.Comment;

import java.util.List;

public interface CommentService {
    List<Comment> getCommentsByPostId(int id);
    public void addNewComment(Comment comment);
    void deleteCommentByPost(int postId);
    void deleteCommentsByUser(int authorId);
    void deleteCommentsByCategory(int categoryId);
    public void deleteAllComments();
}
