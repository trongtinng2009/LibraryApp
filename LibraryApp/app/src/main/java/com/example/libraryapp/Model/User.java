package com.example.libraryapp.Model;

import com.google.firebase.Timestamp;

public class User {
    private String id;
    private String loginname,username,email,password,role,avatar;
    private boolean isMale;
    private Timestamp add_date;

    public User() {
    }

    public User(String username, String role, String avatar) {
        this.username = username;
        this.role = role;
        this.avatar = avatar;
    }

    public User(String id, String loginname, String username, String email, String password, String role, String avatar, boolean isMale,Timestamp add_date) {
        this.id = id;
        this.loginname = loginname;
        this.username = username;
        this.email = email;
        this.password = password;
        this.role = role;
        this.avatar = avatar;
        this.isMale = isMale;
        this.add_date = add_date;
    }

    public Timestamp getAdd_date() {
        return add_date;
    }

    public void setAdd_date(Timestamp add_date) {
        this.add_date = add_date;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getLoginname() {
        return loginname;
    }

    public void setLoginname(String loginname) {
        this.loginname = loginname;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public boolean getMale() {
        return isMale;
    }

    public void setMale(boolean male) {
        isMale = male;
    }
}
