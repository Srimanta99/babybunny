package com.baby.bunny.student.management.model;

import java.util.List;

public class StudentTodaysClassDateModel {
    public String tdate, task;
    List<StudentTodayClassTestModel>  studentTodayClassTestModels;
    public boolean expanded=false;


    public boolean isExpanded() {
        return expanded;
    }

    public void setExpanded(boolean expanded) {
        this.expanded = expanded;
    }

    public String getTdate() {
        return tdate;
    }

    public void setTdate(String tdate) {
        this.tdate = tdate;
    }

    public String getTask() {
        return task;
    }

    public void setTask(String task) {
        this.task = task;
    }



    public List<StudentTodayClassTestModel> getStudentTodayClassTestModels() {
        return studentTodayClassTestModels;
    }

    public void setStudentTodayClassTestModels(List<StudentTodayClassTestModel> studentTodayClassTestModels) {
        this.studentTodayClassTestModels = studentTodayClassTestModels;
    }
}