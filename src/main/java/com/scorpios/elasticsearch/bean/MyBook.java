package com.scorpios.elasticsearch.bean;

import org.springframework.data.elasticsearch.annotations.Document;

/**
 * @author Think
 * @Title: MyBook
 * @ProjectName springboot-elasticsearch
 * @Description: TODO
 * @date 2018/12/1616:31
 */

@Document(indexName = "scorpios", type = "book")
public class MyBook {

    private Integer id;
    private String name;
    private String author;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
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

    public MyBook(Integer id, String name, String author) {
        this.id = id;
        this.name = name;
        this.author = author;
    }

    @Override
    public String toString() {
        return "MyBook{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", author='" + author + '\'' +
                '}';
    }
}
