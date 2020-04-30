package com.example.cookingbook;

public class Food {
    String title, link;
    int imageView1, imageView2, bigImage;

    public Food(String title, int imageView1, int imageView2, String link, int bigImage) {
        this.title = title;
        this.imageView1 = imageView1;
        this.imageView2 = imageView2;
        this.link = link;
        this.bigImage = bigImage;
    }
}
