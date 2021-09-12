package com.example.agamjyotsingh.portfolio;

import java.io.Serializable;

public class PortfolioItems implements Serializable {

    private int image;
    private String title,description;

    public PortfolioItems(){
    }

    public PortfolioItems(int image) {
        this.image = image;
    }

    public PortfolioItems(int image, String title) {
        this.image = image;
        this.title = title;
    }

    public PortfolioItems(int image, String title, String description) {
        this.image = image;
        this.title = title;
        this.description = description;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
