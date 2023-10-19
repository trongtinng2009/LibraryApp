package com.example.libraryapp.Model;

import com.google.firebase.Timestamp;
import com.google.firebase.firestore.DocumentReference;

import java.io.Serializable;
import java.util.ArrayList;

public class BookOffline implements Serializable {
    private String id,author,img_url,name,publisher,summary;
    private ArrayList<DocumentReference> categories;
    private int quantity,remain_quantity,view_point,borrow_point;
    private double rating_point;
    private Timestamp add_date,pub_date;

    public BookOffline() {
    }

    public BookOffline(String id, String author, String img_url, String name, String publisher, String summary, ArrayList<DocumentReference> categories, int quantity, int remain_quantity, int view_point, int borrow_point, double rating_point, Timestamp add_date, Timestamp pub_date) {
        this.id = id;
        this.author = author;
        this.img_url = img_url;
        this.name = name;
        this.publisher = publisher;
        this.summary = summary;
        this.categories = categories;
        this.quantity = quantity;
        this.remain_quantity = remain_quantity;
        this.view_point = view_point;
        this.borrow_point = borrow_point;
        this.rating_point = rating_point;
        this.add_date = add_date;
        this.pub_date = pub_date;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getImg_url() {
        return img_url;
    }

    public void setImg_url(String img_url) {
        this.img_url = img_url;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public ArrayList<DocumentReference> getCategories() {
        return categories;
    }

    public void setCategories(ArrayList<DocumentReference> categories) {
        this.categories = categories;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getRemain_quantity() {
        return remain_quantity;
    }

    public void setRemain_quantity(int remain_quantity) {
        this.remain_quantity = remain_quantity;
    }

    public int getView_point() {
        return view_point;
    }

    public void setView_point(int view_point) {
        this.view_point = view_point;
    }

    public int getBorrow_point() {
        return borrow_point;
    }

    public void setBorrow_point(int borrow_point) {
        this.borrow_point = borrow_point;
    }

    public double getRating_point() {
        return rating_point;
    }

    public void setRating_point(double rating_point) {
        this.rating_point = rating_point;
    }

    public Timestamp getAdd_date() {
        return add_date;
    }

    public void setAdd_date(Timestamp add_date) {
        this.add_date = add_date;
    }

    public Timestamp getPub_date() {
        return pub_date;
    }

    public void setPub_date(Timestamp pub_date) {
        this.pub_date = pub_date;
    }
}
