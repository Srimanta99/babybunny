package com.baby.bunny.student.management.model;

import java.util.List;

public class StudentTodaysClassDateModel {
    public String section_name, sections_sounds;
    List<StudentTodayClassTestModel>  studentTodayClassTestModels;
    public boolean expanded=false;


    public boolean isExpanded() {
        return expanded;
    }

    public void setExpanded(boolean expanded) {
        this.expanded = expanded;
    }

    public String getSection_name() {
        return section_name;
    }

    public void setSection_name(String section_name) {
        this.section_name = section_name;
    }

    public String getSections_sounds() {
        return sections_sounds;
    }

    public void setSections_sounds(String sections_sounds) {
        this.sections_sounds = sections_sounds;
    }

    public List<StudentTodayClassTestModel> getStudentTodayClassTestModels() {
        return studentTodayClassTestModels;
    }

    public void setStudentTodayClassTestModels(List<StudentTodayClassTestModel> studentTodayClassTestModels) {
        this.studentTodayClassTestModels = studentTodayClassTestModels;
    }
}