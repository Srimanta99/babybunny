package com.baby.babybunny.student.management.model;

public class TeacherGetAllStudentModel {
    String id, student_image, student_name,student_id,email_id,mobile_no;

    public TeacherGetAllStudentModel(String id, String student_image, String student_name, String student_id, String email_id, String mobile_no) {
        this.id = id;
        this.student_image = student_image;
        this.student_name = student_name;
        this.student_id = student_id;
        this.email_id = email_id;
        this.mobile_no = mobile_no;
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
}
