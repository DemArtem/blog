package com.ivl_plus.blog.models;

import javax.persistence.*;

@Entity
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String title, anons;
    @Column(name = "full_text")
    private String fullText;
    private int views;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAnons() {
        return anons;
    }

    public void setAnons(String anons) {
        this.anons = anons;
    }

    public String getFull_text() {//почитай сode conventions оп наименованию
        return fullText;
    }

    public void setFull_text(String fullText) {
        this.fullText = fullText;
    }

    public int getViews() {
        return views;
    }

    public void setViews(int views) {
        this.views = views;
    }

    public Post() {
    }

    public Post(String title, String anons, String fullText) {
        this.title = title;
        this.anons = anons;
        this.fullText = fullText;
    }
}
