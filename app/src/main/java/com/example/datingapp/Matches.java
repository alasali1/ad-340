package com.example.datingapp;

public class Matches {
    private String name;
    private Boolean liked;
    private String imageUrl;
    private String lat;
    private String longitude;
    private String uid;

    public Matches(){
        //default constructor
    }
    public Matches(String name){
        this.name = name;
    }

    public String getName(){
        return name;
    }

    public  void setName(String name){
        this.name = name;
    }

    public Boolean isLiked(){
        return liked;
    }

    public void setLiked(boolean liked){
        this.liked = liked;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getLat() {
        return lat;
    }

    public void setLat(String lat) {
        this.lat = lat;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }
}
