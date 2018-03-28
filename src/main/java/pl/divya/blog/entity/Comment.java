package pl.divya.blog.entity;

import javax.persistence.Entity;
import javax.persistence.Table;

import javax.persistence.*;

@Entity
@Table(name = "comments")
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_comment")
    private int id;

    @Column(name = "id_post")
    private int idPost;

    @Column(name= "author")
    String author;

    @Column(name = "content")
    private String content;

    @Column(name = "ip")
    private String ip;

    @Column(name="date")
    private String date;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdPost() {
        return idPost;
    }

    public void setIdPost(int idPost) {
        this.idPost = idPost;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    @Override
    public String toString() {
        return "Comment{" +
                "id=" + id +
                ", idPost=" + idPost +
                ", author='" + author + '\'' +
                ", content='" + content + '\'' +
                ", ip='" + ip + '\'' +
                ", date='" + date + '\'' +
                '}';
    }
}
