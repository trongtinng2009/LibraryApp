package com.example.libraryapp.Model;

public class BookOffline {
    private int id;
    private String img,title;
    private double ratingpoint;

    public BookOffline() {
    }

    public BookOffline(String img, String title, double ratingpoint) {
        this.img = img;
        this.title = title;
        this.ratingpoint = ratingpoint;
    }

    public BookOffline(int id, String img, String title, double ratingpoint) {
        this.id = id;
        this.img = img;
        this.title = title;
        this.ratingpoint = ratingpoint;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public double getRatingpoint() {
        return ratingpoint;
    }

    public void setRatingpoint(double ratingpoint) {
        this.ratingpoint = ratingpoint;
    }
}
