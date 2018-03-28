package pl.divya.blog.service.implementations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.divya.blog.dao.CommentDao;
import pl.divya.blog.entity.Comment;
import pl.divya.blog.service.CommentService;

import java.util.List;

@Service
public class CommentServiceImpl implements CommentService{

    @Autowired
    CommentDao commentDao;

    @Transactional
    @Override
    public List<Comment> getCommentsByPostId(int id) {
        return commentDao.getCommentsByPostId(id);
    }
    @Transactional
    @Override
    public void addNewComment(Comment comment) {
        commentDao.addNewComment(comment);
    }

    @Transactional
    @Override
    public void deleteCommentByPost(int postId) {
        commentDao.deleteCommentsByPost(postId);
    }

    @Transactional
    @Override
    public void deleteCommentsByUser(int authorId) {
        commentDao.deleteCommentsByUser(authorId);
    }

    @Transactional
    @Override
    public void deleteAllComments(){
        commentDao.deleteAllComments();
    }

    @Transactional
    @Override
    public void deleteCommentsByCategory(int categoryId) {
        commentDao.deleteCommentsByCategory(categoryId);
    }
}
