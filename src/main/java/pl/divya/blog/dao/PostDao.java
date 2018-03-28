package pl.divya.blog.dao;

import pl.divya.blog.entity.Post;

import java.util.List;


public interface PostDao {
    List<Post> getAllPosts();
    Post getPostById(int id);
    List<Post> getPostsByLimit(int startPosition,int limit);
    void addNewPost(Post post);
    List<Post> getPostsByUser(int userId,int startPosition, int limit);
    List<Post> getPostsByCategory(int categoryId,int startPosition,int limit);
    void deletePost(int id);
    void deletePostByAuthor(int id);
    void deleteAllPosts();
    void deletePostByCategory(int categoryId);
    void updateCategory(int categoryId, String categoryName);
   int postCount();
    int postCountByUser(int userId);
    int postCountByCategory(int categoryId);

}
