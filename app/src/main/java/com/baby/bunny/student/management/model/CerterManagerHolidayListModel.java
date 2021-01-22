package com.baby.bunny.student.management.model;

public class CerterManagerHolidayListModel {
    String id,center_id,holyday_details,holyday_from,holyday_to,holyday_year,isActive;

    public CerterManagerHolidayListModel(String id, String center_id, String holyday_details, String holyday_from, String holyday_to, String holyday_year, String isActive) {
        this.id = id;
        this.center_id = center_id;
        this.holyday_details = holyday_details;
        this.holyday_from = holyday_from;
        this.holyday_to = holyday_to;
        this.holyday_year = holyday_year;
        this.isActive = isActive;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCenter_id() {
        return center_id;
    }

    public void setCenter_id(String center_id) {
        this.center_id = center_id;
    }

    public String getHolyday_details() {
        return holyday_details;
    }

    public void setHolyday_details(String holyday_details) {
        this.holyday_details = holyday_details;
    }

    public String getHolyday_from() {
        return holyday_from;
    }

    public void setHolyday_from(String holyday_from) {
        this.holyday_from = holyday_from;
    }

    public String getHolyday_to() {
        return holyday_to;
    }

    public void setHolyday_to(String holyday_to) {
        this.holyday_to = holyday_to;
    }

    public String getHolyday_year() {
        return holyday_year;
    }

    public void setHolyday_year(String holyday_year) {
        this.holyday_year = holyday_year;
    }

    public String getIsActive() {
        return isActive;
    }

    public void setIsActive(String isActive) {
        this.isActive = isActive;
    }
}
