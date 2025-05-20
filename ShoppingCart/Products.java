package com.example.ShoppingCart;

import java.util.*;

public class Products {

    String name;
    float price;
    int quantity;

    Products(){};

    Products(String name,float price,int quantity){
        this.name=name;
        this.price=price;
        this.quantity=quantity;
    }

    public void setName(String name){
        this.name=name;
    }
    public void setPrice(float price){
        this.price=price;
    }
    public void setQuantity(int quantity){
        this.quantity=quantity;
    }
    public String getName(){
        return this.name;
    }
    public int getQuantity(){
        return this.quantity;
    }
    public float getPrice(){
        return this.price;
    }

}
