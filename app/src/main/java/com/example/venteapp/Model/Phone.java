package com.example.venteapp.Model;

public class Phone {

    private static String name;
    private static double price;
    private static String storage;
    private static String color;
    private static String tag;



    //fields


    private String imgUrl;





    //Constructor
    public Phone ( String name, String tag, double price, String storage, String imgUrl, String color){
        this.name=name;
        this.tag=tag;
        this.price=price;
        this.storage=storage;
        this.imgUrl = imgUrl;
        this.color=color;
    }

    //methods
    public static String getName () {return name;}
    public static double getPrice () {return price;}
    public static String getTag (){return  tag;}
    public static String getStorage () { return storage; }
    public static String getColor ()   {return color;    }
    public String getImgUrl() { return imgUrl; }
}
