package com.example.luyentapsearch.Model;

public class product {
    private String title, author, imageLink, description;
    private long price;

    public product(String title, String imageLink, long price) {
        this.title = title;
        this.author = "author";
        this.imageLink = imageLink;
        this.description = "description";
        this.price=price;
    }

    public product() {
    }

    public long getPrice() {
        return price;
    }

    public void setPrice(long price) {
        this.price = price;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getImageLink() {
        return imageLink;
    }

    public void setImageLink(String imageLink) {
        this.imageLink = imageLink;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
