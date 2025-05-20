package com.example.LibraryApplication;

public class Books {
    String title;
    String author;
    float price;


    Books(){}

    Books(String title,String author,float price){
        this.title=title;
        this.author=author;
        this.price=price;
    }

    public void setTitle(String title){
        this.title=title;
    }
    public void setAuthor(String author){
        this.author=author;
    }
    public void setPrice(float price){
        this.price=price;
    }

    public String getTitle(){
        return this.title;
    }

    public String getAuthor(){
        return this.author;
    }
    public float getPrice(){
        return this.price;
    }
}
