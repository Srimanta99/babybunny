package com.baby.babybunny.student.management.utils;

import android.app.Application;

public class AppController extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        new SessionManager(this);
    }
}
