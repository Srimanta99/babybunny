package com.baby.babybunny.student.management.screen.splash;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.baby.babybunny.student.management.R;
import com.baby.babybunny.student.management.screen.CenterManagerHomeActivity.CenterManagerHomeActivity;
import com.baby.babybunny.student.management.screen.StudentHomeActivity.StudentHomeActivity;
import com.baby.babybunny.student.management.screen.TeacherHomeActivity.TeacherHomeActivity;
import com.baby.babybunny.student.management.screen.main.MainActivity;
import com.baby.babybunny.student.management.utils.ApplicationConstant;
import com.baby.babybunny.student.management.utils.SessionManager;


public class SplashActivity extends AppCompatActivity {
    SharedPreferences sharedpreferences;
    boolean savelogin,saveCenterManagerlogin,saveTeacherlogin;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        savelogin= SessionManager.isLogged();
        saveCenterManagerlogin=SessionManager.isCenterManageLogged();
        saveTeacherlogin=SessionManager.isTeacherLogged();

        View view= LayoutInflater.from(this).inflate(R.layout.activity_splash,null);
        setContentView(view);
        new Handler().postDelayed(new Runnable(){
            @Override
            public void run() {



                if (!saveCenterManagerlogin && !savelogin && !saveTeacherlogin){

                    Intent intent=new Intent(SplashActivity.this, MainActivity.class);
                    startActivity(intent);
                    finish();
                    return;


                } else if (saveCenterManagerlogin) {

                    Intent intent = new Intent(SplashActivity.this, CenterManagerHomeActivity.class);
                    startActivity(intent);
                    finish();

                    return;
                }

                else   if (savelogin){

                    Intent intent = new Intent(SplashActivity.this, StudentHomeActivity.class);
                    startActivity(intent);
                    finish();
                    return;
                }

                else   if (saveTeacherlogin){

                    Intent intent = new Intent(SplashActivity.this, TeacherHomeActivity.class);
                    startActivity(intent);
                    finish();
                }


            }
        }, ApplicationConstant.SPLASH_DISPLAY_LENGTH);
    }
}
