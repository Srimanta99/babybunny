package com.baby.babybunny.student.management.model;

public class ClassListModel {
    String class_name,admission_fees,monthly_fees;

    public ClassListModel(String class_name, String admission_fees, String monthly_fees) {
        this.class_name = class_name;
        this.admission_fees = admission_fees;
        this.monthly_fees = monthly_fees;
    }

    public String getClass_name() {
        return class_name;
    }

    public void setClass_name(String class_name) {
        this.class_name = class_name;
    }

    public String getAdmission_fees() {
        return admission_fees;
    }

    public void setAdmission_fees(String admission_fees) {
        this.admission_fees = admission_fees;
    }

    public String getMonthly_fees() {
        return monthly_fees;
    }

    public void setMonthly_fees(String monthly_fees) {
        this.monthly_fees = monthly_fees;
    }
}
