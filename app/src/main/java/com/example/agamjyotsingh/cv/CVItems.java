package com.example.agamjyotsingh.cv;

public class CVItems {

    private String title;
    private String description;

    public CVItems(String title, String description) {
        this.title = title;
        this.description = description;
    }

    public CVItems() {
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
