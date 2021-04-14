package com.baby.babybunny.student.management.screen.StudentFeesBookAcivity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;

import com.baby.babybunny.student.management.R;

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

        studentFeesBookViewBind.toolname_id.setText("Fees Book      ");

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