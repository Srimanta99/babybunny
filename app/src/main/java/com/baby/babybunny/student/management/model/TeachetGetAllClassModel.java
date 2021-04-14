package com.baby.babybunny.student.management.model;

public class TeachetGetAllClassModel {
    String id,branch_id,class_name;

    public TeachetGetAllClassModel(String id, String branch_id, String class_name) {
        this.id = id;
        this.branch_id = branch_id;
        this.class_name = class_name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getBranch_id() {
        return branch_id;
    }

    public void setBranch_id(String branch_id) {
        this.branch_id = branch_id;
    }

    public String getClass_name() {
        return class_name;
    }

    public void setClass_name(String class_name) {
        this.class_name = class_name;
    }
}
