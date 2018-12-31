package com.scorpios.elasticsearch.bean;


import io.searchbox.annotations.JestId;

/**
 * @author Think
 * @Title: Article
 * @ProjectName springboot-elasticsearch
 * @Description: TODO
 * @date 2018/12/1615:42
 */
public class Article {

    @JestId
    private int id;
    private String name;
    private String author;
    private String content;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Article(int id, String name, String author, String content) {
        this.id = id;
        this.name = name;
        this.author = author;
        this.content = content;
    }

    @Override
    public String toString() {
        return "Article{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", author='" + author + '\'' +
                ", content='" + content + '\'' +
                '}';
    }
}
