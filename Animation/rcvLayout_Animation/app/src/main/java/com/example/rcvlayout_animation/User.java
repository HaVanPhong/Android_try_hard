package com.example.rcvlayout_animation;

public class User {

    private int img;
    private String username;
    private String address;

    public  User(){

    }
    public int getImg() {
        return img;
    }

    public void setImg(int img) {
        this.img = img;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public User(int img, String username, String address) {
        this.img = img;
        this.username = username;
        this.address = address;
    }
}
