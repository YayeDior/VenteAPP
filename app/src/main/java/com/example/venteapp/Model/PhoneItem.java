package com.example.venteapp.Model;

public class PhoneItem {

    //fields
    private String name;
    private double price;
    private String tag;
    private String storage;
    private String imgUrl;
    private String color;



    //Constructor
    public PhoneItem(String name, String tag, double price, String storage, String imgUrl, String color){
        this.name=name;
        this.tag=tag;
        this.price=price;
        this.storage=storage;
        this.imgUrl = imgUrl;
        this.color=color;
    }

    //methods
    public String getName() {return name;}
    public  double getPrice() {return price;}
    public String getTag(){return  tag;}
    public String getStorage() { return storage; }
    public String getColor()   {return color;    }
    public String getImgUrl() { return imgUrl; }
}
