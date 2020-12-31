package com.baby.bunny.student.management.model;

public class SelectClassModel {
    String class_name,id;

    public SelectClassModel(String class_name, String id) {
        this.class_name = class_name;
        this.id = id;
    }

    public String getClass_name() {
        return class_name;
    }

    public void setClass_name(String class_name) {
        this.class_name = class_name;
    }
}
