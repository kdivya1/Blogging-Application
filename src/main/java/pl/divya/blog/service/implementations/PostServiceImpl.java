package pl.divya.blog.service.implementations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.divya.blog.dao.PostDao;
import pl.divya.blog.entity.Post;
import pl.divya.blog.service.PostService;

import java.util.*;


@Service
public class PostServiceImpl implements PostService {
    @Autowired
    PostDao postDao;

    @Transactional
    @Override
    public List<Post> getAllPosts() {
        return postDao.getAllPosts();
    }

    @Transactional
    @Override
    public List<Post> getPostsByLimit(int startPosition, int limit) {
        return postDao.getPostsByLimit(startPosition, limit);
    }

    @Transactional
    @Override
    public Post getPostById(int id) {
        return postDao.getPostById(id);
    }

    @Transactional
    @Override
    public void addNewPost(Post post) {
        postDao.addNewPost(post);
    }

    @Transactional
    @Override
    public List<Post> getPostsByUser(int userId, int startPosition, int limit) {
        return postDao.getPostsByUser(userId, startPosition, limit);
    }

    @Transactional
    @Override
    public List<Post> getPostsByCategory(int categoryId, int startPosition, int limit) {
        return postDao.getPostsByCategory(categoryId, startPosition, limit);
    }

    @Transactional
    @Override
    public void deletePost(int id) {
        postDao.deletePost(id);
    }

    @Transactional
    @Override
    public void deletePostByAuthor(int id) {
        postDao.deletePostByAuthor(id);
    }

    @Transactional
    @Override
    public void deleteAllPosts() {
        postDao.deleteAllPosts();
    }

    @Transactional
    @Override
    public void deletePostByCategory(int categoryId) {
        postDao.deletePostByCategory(categoryId);
    }

    @Transactional
    @Override
    public void updateCategory(int categoryId, String categoryName) {
        postDao.updateCategory(categoryId, categoryName);
    }

    @Transactional
    @Override
    public int postCount() {
        return postDao.postCount();
    }

    @Transactional
    @Override
    public int postCountByUser(int userId) {
        return postDao.postCountByUser(userId);
    }

    @Transactional
    @Override
    public int postCountByCategory(int categoryId) {
        return postDao.postCountByCategory(categoryId);
    }

    @Transactional
    @Override
    public List<Post> search(String criteria) {
        List<Post> allPosts = postDao.getAllPosts();
        Set<Post> searchedPosts = new HashSet<>();
        for (Post post : allPosts) {
            if (post.getTitle().toLowerCase().indexOf(criteria.toLowerCase()) != -1) {
                searchedPosts.add(post);
            }  else if (post.getContent().toLowerCase().indexOf(criteria.toLowerCase()) != -1) {
                searchedPosts.add(post);
            }
        }
        List<Post> matchedPosts = new ArrayList<>();
            matchedPosts.addAll(searchedPosts);
        Collections.sort(matchedPosts, new Comparator<Post>() {
            @Override
            public int compare(Post o1, Post o2) {
                return (o2.getDate().compareTo(o1.getDate()));
            }
        });

        return matchedPosts;
    }

    @Override
    public List<Post> limitPosts(List<Post> posts,int start,int limit){
        List<Post> limitedMatchedPosts = new ArrayList<>();
        int scope = (start-1) *5;
        for (int i =scope;i<scope+5;i++){
            try{
                limitedMatchedPosts.add(posts.get(i));
            }
            catch (IndexOutOfBoundsException e){
                break;
            }
        }
        return limitedMatchedPosts;
    }
}
