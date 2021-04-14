package com.baby.babybunny.student.management.model;

public class StudentsListModel {
    String student_image,student_name,student_id,guardian_name,email_id,mobile_no,class_name,blood_group,dob,id;
    Boolean ischceked=false;

    public StudentsListModel(String student_image, String student_name, String student_id, String guardian_name, String email_id, String mobile_no, String class_name, String blood_group, String dob, String id) {
        this.student_image = student_image;
        this.student_name = student_name;
        this.student_id = student_id;
        this.guardian_name = guardian_name;
        this.email_id = email_id;
        this.mobile_no = mobile_no;
        this.class_name = class_name;
        this.blood_group = blood_group;
        this.dob = dob;
        this.id = id;
    }

    public Boolean getIschceked() {
        return ischceked;
    }

    public void setIschceked(Boolean ischceked) {
        this.ischceked = ischceked;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getStudent_image() {
        return student_image;
    }

    public void setStudent_image(String student_image) {
        this.student_image = student_image;
    }

    public String getStudent_name() {
        return student_name;
    }

    public void setStudent_name(String student_name) {
        this.student_name = student_name;
    }

    public String getStudent_id() {
        return student_id;
    }

    public void setStudent_id(String student_id) {
        this.student_id = student_id;
    }

    public String getGuardian_name() {
        return guardian_name;
    }

    public void setGuardian_name(String guardian_name) {
        this.guardian_name = guardian_name;
    }

    public String getEmail_id() {
        return email_id;
    }

    public void setEmail_id(String email_id) {
        this.email_id = email_id;
    }

    public String getMobile_no() {
        return mobile_no;
    }

    public void setMobile_no(String mobile_no) {
        this.mobile_no = mobile_no;
    }

    public String getClass_name() {
        return class_name;
    }

    public void setClass_name(String class_name) {
        this.class_name = class_name;
    }

    public String getBlood_group() {
        return blood_group;
    }

    public void setBlood_group(String blood_group) {
        this.blood_group = blood_group;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }
}
