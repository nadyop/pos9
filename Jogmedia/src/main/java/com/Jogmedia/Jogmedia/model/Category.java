package com.Jogmedia.Jogmedia.model;

public class Category {
    private int category_id;
    private String category_name, category_desc;

    public Category(int category_id, String category_name, String category_desc) {
        this.category_id = category_id;
        this.category_name = category_name;
        this.category_desc = category_desc;
    }

    public Category(){}

    public int getCategory_id() {
        return category_id;
    }

    public void setCategory_id(Integer category_id) {
        this.category_id = category_id;
    }

    public String getCategory_name() {
        return category_name;
    }

    public void setCategory_name(String category_name) {
        this.category_name = category_name;
    }

    public String getCategory_desc() {
        return category_desc;
    }

    public void setCategory_desc(String category_desc) {
        this.category_desc = category_desc;
    }
}
