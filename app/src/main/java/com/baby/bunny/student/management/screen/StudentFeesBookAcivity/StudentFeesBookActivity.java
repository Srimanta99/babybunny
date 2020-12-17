package com.baby.bunny.student.management.screen.StudentFeesBookAcivity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;

import com.baby.bunny.student.management.R;
import com.baby.bunny.student.management.screen.main.MainActivityOnClick;
import com.baby.bunny.student.management.screen.main.MainActivityViewBind;

public class StudentFeesBookActivity extends AppCompatActivity {
    StudentFeesBookViewBind studentFeesBookViewBind;
    StudentFeesBookOnClick studentFeesBookOnClick;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        View view= LayoutInflater.from(this).inflate(R.layout.activity_student_fees_book,null);
        setContentView(view);
        studentFeesBookViewBind= new StudentFeesBookViewBind(this,view);
        studentFeesBookOnClick=new StudentFeesBookOnClick(this,studentFeesBookViewBind);
    }


    @Override
    public void onBackPressed() {
        if (getFragmentManager().getBackStackEntryCount() > 0) {
            getFragmentManager().popBackStack();
        } else {
            super.onBackPressed();
        }
    }
}