package com.baby.babybunny.student.management.screen.StudentQueryActivity;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.baby.babybunny.student.management.R;

public class Student_Query_Activity extends AppCompatActivity {
    StudentQueryViewBind studentQueryViewBind;
    StudentQueryOnClick studentQueryOnClick;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
      //  setContentView(R.layout.activity_student__query_);
        View view= LayoutInflater.from(this).inflate(R.layout.activity_student__query_,null);
        setContentView(view);
        studentQueryViewBind= new StudentQueryViewBind(this,view);
        studentQueryOnClick=new StudentQueryOnClick(this,studentQueryViewBind);
        studentQueryViewBind. toolname_id.setText("Query      ");


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