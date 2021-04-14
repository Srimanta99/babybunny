package com.baby.babybunny.student.management.model;

public class TeacherHomeWorkTaskModel {
    String teacher_name,homework_for,homework_details,ddate;

    public TeacherHomeWorkTaskModel(String teacher_name, String homework_for, String homework_details, String ddate) {
        this.teacher_name = teacher_name;
        this.homework_for = homework_for;
        this.homework_details = homework_details;
        this.ddate = ddate;
    }

    public String getTeacher_name() {
        return teacher_name;
    }

    public void setTeacher_name(String teacher_name) {
        this.teacher_name = teacher_name;
    }

    public String getHomework_for() {
        return homework_for;
    }

    public void setHomework_for(String homework_for) {
        this.homework_for = homework_for;
    }

    public String getHomework_details() {
        return homework_details;
    }

    public void setHomework_details(String homework_details) {
        this.homework_details = homework_details;
    }

    public String getDdate() {
        return ddate;
    }

    public void setDdate(String ddate) {
        this.ddate = ddate;
    }
}
