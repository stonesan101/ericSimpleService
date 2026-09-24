package com.example.ericsimpleservice;

public class Comic {
    private int id;
    private String title;
    private String publisher;
    private String author;
    private int edition;
    private double price;

    public Comic(int id, String title, String publisher, String author, int edition, double price) {
        this.id = id;
        this.title = title;
        this.publisher = publisher;
        this.author = author;
        this.edition = edition;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getEdition() {
        return edition;
    }

    public void setEdition(int edition) {
        this.edition = edition;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }


}
