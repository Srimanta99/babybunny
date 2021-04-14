package com.baby.babybunny.student.management.model;

public class TeacherTodayClassTaskModel {
    String teacher_name,subject,content,ddate;

    public TeacherTodayClassTaskModel(String teacher_name, String subject, String content, String ddate) {
        this.teacher_name = teacher_name;
        this.subject = subject;
        this.content = content;
        this.ddate = ddate;
    }

    public String getTeacher_name() {
        return teacher_name;
    }

    public void setTeacher_name(String teacher_name) {
        this.teacher_name = teacher_name;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getDdate() {
        return ddate;
    }

    public void setDdate(String ddate) {
        this.ddate = ddate;
    }
}
