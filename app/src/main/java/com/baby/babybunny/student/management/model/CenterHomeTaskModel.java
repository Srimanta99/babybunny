package com.baby.babybunny.student.management.model;

public class CenterHomeTaskModel {
    String id,teacher_id,teacher_class_id,branch_id,homework_details,homework_for,ddate,isActive,class_name,teacher_name,teacher_image;

    public CenterHomeTaskModel(String id, String teacher_id, String teacher_class_id, String branch_id, String homework_details, String homework_for, String ddate, String isActive, String class_name, String teacher_name, String teacher_image) {
        this.id = id;
        this.teacher_id = teacher_id;
        this.teacher_class_id = teacher_class_id;
        this.branch_id = branch_id;
        this.homework_details = homework_details;
        this.homework_for = homework_for;
        this.ddate = ddate;
        this.isActive = isActive;
        this.class_name = class_name;
        this.teacher_name = teacher_name;
        this.teacher_image = teacher_image;
    }

    public String getTeacher_image() {
        return teacher_image;
    }

    public void setTeacher_image(String teacher_image) {
        this.teacher_image = teacher_image;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTeacher_id() {
        return teacher_id;
    }

    public void setTeacher_id(String teacher_id) {
        this.teacher_id = teacher_id;
    }

    public String getTeacher_class_id() {
        return teacher_class_id;
    }

    public void setTeacher_class_id(String teacher_class_id) {
        this.teacher_class_id = teacher_class_id;
    }

    public String getBranch_id() {
        return branch_id;
    }

    public void setBranch_id(String branch_id) {
        this.branch_id = branch_id;
    }

    public String getHomework_details() {
        return homework_details;
    }

    public void setHomework_details(String homework_details) {
        this.homework_details = homework_details;
    }

    public String getHomework_for() {
        return homework_for;
    }

    public void setHomework_for(String homework_for) {
        this.homework_for = homework_for;
    }

    public String getDdate() {
        return ddate;
    }

    public void setDdate(String ddate) {
        this.ddate = ddate;
    }

    public String getIsActive() {
        return isActive;
    }

    public void setIsActive(String isActive) {
        this.isActive = isActive;
    }

    public String getClass_name() {
        return class_name;
    }

    public void setClass_name(String class_name) {
        this.class_name = class_name;
    }

    public String getTeacher_name() {
        return teacher_name;
    }

    public void setTeacher_name(String teacher_name) {
        this.teacher_name = teacher_name;
    }
}
