package com.example.libraryapp.Model;


import com.google.firebase.Timestamp;
import com.google.firebase.firestore.DocumentReference;

import java.io.Serializable;

public class Libcard implements Serializable {
    //vinh
    private String id,firstname,lastname,address,phonenum,image_url;
    private Timestamp dob,request_date,acc_date;
    private DocumentReference user;
    private int cardstate;
    public static enum CardState {
        REQUESTING(1), JUSTACCEPTED(2), ACCEPTED(3);
        public int value;

        private CardState(int value) {
            this.value = value;
        }
    }

    public Libcard() {
    }

    public Libcard(String id, String firstname, String lastname, String address, String phonenum, String image_url, Timestamp dob, Timestamp request_date, Timestamp acc_date, DocumentReference user, int cardstate) {
        this.id = id;
        this.firstname = firstname;
        this.lastname = lastname;
        this.address = address;
        this.phonenum = phonenum;
        this.image_url = image_url;
        this.dob = dob;
        this.request_date = request_date;
        this.acc_date = acc_date;
        this.user = user;
        this.cardstate = cardstate;
    }

    public DocumentReference getUser() {
        return user;
    }

    public void setUser(DocumentReference user) {
        this.user = user;
    }

    public Libcard(String firstname, String lastname, String image_url) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.image_url = image_url;
    }

    public int getCardstate() {
        return cardstate;
    }

    public void setCardstate(int cardstate) {
        this.cardstate = cardstate;
    }

    public String getImage_url() {
        return image_url;
    }

    public void setImage_url(String image_url) {
        this.image_url = image_url;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhonenum() {
        return phonenum;
    }

    public void setPhonenum(String phonenum) {
        this.phonenum = phonenum;
    }

    public Timestamp getDob() {
        return dob;
    }

    public void setDob(Timestamp dob) {
        this.dob = dob;
    }

    public Timestamp getRequest_date() {
        return request_date;
    }

    public void setRequest_date(Timestamp request_date) {
        this.request_date = request_date;
    }

    public Timestamp getAcc_date() {
        return acc_date;
    }

    public void setAcc_date(Timestamp acc_date) {
        this.acc_date = acc_date;
    }
}
