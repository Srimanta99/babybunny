package com.baby.bunny.student.management.model;

public class CenterTodayinovationModel {
    String id,teacher_id,teacher_class_id,branch_id,subject,details,video,
            is_active,ddate,teacher_name,class_name,final_video_URLthamnil,final_video_URL;

    public CenterTodayinovationModel(String id, String teacher_id, String teacher_class_id, String branch_id, String subject, String details, String video, String is_active, String ddate, String teacher_name, String class_name, String final_video_URLthamnil, String final_video_URL) {
        this.id = id;
        this.teacher_id = teacher_id;
        this.teacher_class_id = teacher_class_id;
        this.branch_id = branch_id;
        this.subject = subject;
        this.details = details;
        this.video = video;
        this.is_active = is_active;
        this.ddate = ddate;
        this.teacher_name = teacher_name;
        this.class_name = class_name;
        this.final_video_URLthamnil = final_video_URLthamnil;
        this.final_video_URL = final_video_URL;
    }

    public String getFinal_video_URLthamnil() {
        return final_video_URLthamnil;
    }

    public void setFinal_video_URLthamnil(String final_video_URLthamnil) {
        this.final_video_URLthamnil = final_video_URLthamnil;
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

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public String getVideo() {
        return video;
    }

    public void setVideo(String video) {
        this.video = video;
    }

    public String getIs_active() {
        return is_active;
    }

    public void setIs_active(String is_active) {
        this.is_active = is_active;
    }

    public String getDdate() {
        return ddate;
    }

    public void setDdate(String ddate) {
        this.ddate = ddate;
    }

    public String getTeacher_name() {
        return teacher_name;
    }

    public void setTeacher_name(String teacher_name) {
        this.teacher_name = teacher_name;
    }

    public String getClass_name() {
        return class_name;
    }

    public void setClass_name(String class_name) {
        this.class_name = class_name;
    }

    public String getFinal_video_URL() {
        return final_video_URL;
    }

    public void setFinal_video_URL(String final_video_URL) {
        this.final_video_URL = final_video_URL;
    }
}
