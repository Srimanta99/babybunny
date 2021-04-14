package com.baby.babybunny.student.management.model;

public class StudentFeesListModel {
    String id,student_id,branch_id,fees_for,fees_date,fees,year,is_paid,student_name,student_code,student_class_id,type_name,class_name,student_image;

    public StudentFeesListModel(String id, String student_id, String branch_id, String fees_for, String fees_date, String fees, String year, String is_paid, String student_name, String student_code, String student_class_id, String type_name, String class_name, String student_image) {
        this.id = id;
        this.student_id = student_id;
        this.branch_id = branch_id;
        this.fees_for = fees_for;
        this.fees_date = fees_date;
        this.fees = fees;
        this.year = year;
        this.is_paid = is_paid;
        this.student_name = student_name;
        this.student_code = student_code;
        this.student_class_id = student_class_id;
        this.type_name = type_name;
        this.class_name = class_name;
        this.student_image = student_image;
    }

    public String getStudent_image() {
        return student_image;
    }

    public void setStudent_image(String student_image) {
        this.student_image = student_image;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getStudent_id() {
        return student_id;
    }

    public void setStudent_id(String student_id) {
        this.student_id = student_id;
    }

    public String getBranch_id() {
        return branch_id;
    }

    public void setBranch_id(String branch_id) {
        this.branch_id = branch_id;
    }

    public String getFees_for() {
        return fees_for;
    }

    public void setFees_for(String fees_for) {
        this.fees_for = fees_for;
    }

    public String getFees_date() {
        return fees_date;
    }

    public void setFees_date(String fees_date) {
        this.fees_date = fees_date;
    }

    public String getFees() {
        return fees;
    }

    public void setFees(String fees) {
        this.fees = fees;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getIs_paid() {
        return is_paid;
    }

    public void setIs_paid(String is_paid) {
        this.is_paid = is_paid;
    }

    public String getStudent_name() {
        return student_name;
    }

    public void setStudent_name(String student_name) {
        this.student_name = student_name;
    }

    public String getStudent_code() {
        return student_code;
    }

    public void setStudent_code(String student_code) {
        this.student_code = student_code;
    }

    public String getStudent_class_id() {
        return student_class_id;
    }

    public void setStudent_class_id(String student_class_id) {
        this.student_class_id = student_class_id;
    }

    public String getType_name() {
        return type_name;
    }

    public void setType_name(String type_name) {
        this.type_name = type_name;
    }

    public String getClass_name() {
        return class_name;
    }

    public void setClass_name(String class_name) {
        this.class_name = class_name;
    }
}
