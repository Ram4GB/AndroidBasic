package com.example.landingmark;

public class Point {
    private String title;
    private String point;
    private String linkUrl;

    public Point(String title, String point, String linkUrl) {
        this.title = title;
        this.point = point;
        this.linkUrl = linkUrl;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPoint() {
        return point;
    }

    public void setPoint(String point) {
        this.point = point;
    }

    public String getLinkUrl() {
        return linkUrl;
    }

    public void setLinkUrl(String linkUrl) {
        this.linkUrl = linkUrl;
    }
}
