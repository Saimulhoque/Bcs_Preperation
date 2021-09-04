package com.forbitbd.bcspreperation.model;

import java.io.Serializable;

public class QBSubcategory implements Serializable {

    private String _id;
    private String image;
    private String name;

    public QBSubcategory() {
    }

    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
