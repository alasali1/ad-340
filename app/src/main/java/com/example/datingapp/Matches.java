package com.example.datingapp;

public class Matches {
    private String name;
    private Boolean liked;
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
}
