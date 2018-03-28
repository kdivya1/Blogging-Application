package pl.divya.blog.service;

import pl.divya.blog.entity.Post;

import java.util.List;

public interface PostService {
    List<Post> getAllPosts();

    List<Post> getPostsByLimit(int startPosition,int limit);

    Post getPostById(int id);

    void addNewPost(Post post);

    List<Post> getPostsByUser(int userId,int startPosition, int limit);

    List<Post> getPostsByCategory(int categoryId, int startPosition, int limit);

    List<Post> search(String criteria);

    List<Post> limitPosts(List<Post> posts,int start, int limit);

    void deletePost(int id);

    void deletePostByAuthor(int id);

    void deleteAllPosts();

    void deletePostByCategory(int categoryId);

    void updateCategory(int categoryId, String categoryName);

    public int postCount();

    int postCountByUser(int userId);

    int postCountByCategory(int categoryId);

}
