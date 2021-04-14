package com.baby.babybunny.student.management.model;

public class TeacherListModel {
    String teacher_image, teacher_name,teacher_id,email_id,teacher_mobile,blood_group,dob;


    public TeacherListModel(String teacher_image, String teacher_name, String teacher_id, String email_id, String teacher_mobile, String blood_group, String dob) {
        this.teacher_image = teacher_image;
        this.teacher_name = teacher_name;
        this.teacher_id = teacher_id;
        this.email_id = email_id;
        this.teacher_mobile = teacher_mobile;
        this.blood_group = blood_group;
        this.dob = dob;
    }

    public String getTeacher_image() {
        return teacher_image;
    }

    public void setTeacher_image(String teacher_image) {
        this.teacher_image = teacher_image;
    }

    public String getTeacher_name() {
        return teacher_name;
    }

    public void setTeacher_name(String teacher_name) {
        this.teacher_name = teacher_name;
    }

    public String getTeacher_id() {
        return teacher_id;
    }

    public void setTeacher_id(String teacher_id) {
        this.teacher_id = teacher_id;
    }

    public String getEmail_id() {
        return email_id;
    }

    public void setEmail_id(String email_id) {
        this.email_id = email_id;
    }

    public String getTeacher_mobile() {
        return teacher_mobile;
    }

    public void setTeacher_mobile(String teacher_mobile) {
        this.teacher_mobile = teacher_mobile;
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
