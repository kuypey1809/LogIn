package com.khoidut.login;

public class Book{
    private String id, name, description, author_id, image_url, created_at, updated_at;
    private Integer total, borrow;

    public Book(String id, String name, String description, String author_id, String image_url, String created_at, String updated_at, Integer total, Integer borrow) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.author_id = author_id;
        this.image_url = image_url;
        this.created_at = created_at;
        this.updated_at = updated_at;
        this.total = total;
        this.borrow = borrow;
    }

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getAuthor_id() {
        return author_id;
    }

    public void setAuthor_id(String author_id) {
        this.author_id = author_id;
    }

    public String getImage_url() {
        return image_url;
    }

    public void setImage_url(String image_url) {
        this.image_url = image_url;
    }

    public String getCreated_at() {
        return created_at;
    }

    public void setCreated_at(String created_at) {
        this.created_at = created_at;
    }

    public String getUpdated_at() {
        return updated_at;
    }

    public void setUpdated_at(String updated_at) {
        this.updated_at = updated_at;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public Integer getBorrow() {
        return borrow;
    }

    public void setBorrow(Integer borrow) {
        this.borrow = borrow;
    }
};
