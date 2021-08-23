package com.forbitbd.bcspreperation.model;

public class BcsQuestion {

    String cattitle,title;

    public BcsQuestion(String cattitle, String title) {
        this.cattitle = cattitle;
        this.title = title;
    }

    public String getCattitle() {
        return cattitle;
    }

    public void setCattitle(String cattitle) {
        this.cattitle = cattitle;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
