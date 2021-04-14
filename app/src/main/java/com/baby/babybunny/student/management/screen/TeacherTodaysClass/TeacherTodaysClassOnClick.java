package com.baby.babybunny.student.management.screen.TeacherTodaysClass;

import android.content.Intent;
import android.view.View;

import com.baby.babybunny.student.management.R;
import com.baby.babybunny.student.management.screen.TeacherAddTodaysClassActivity.TeacherAddTodaysClassActivity;
import com.baby.babybunny.student.management.utils.MyToast;

public class TeacherTodaysClassOnClick implements View.OnClickListener{
    TeacherTodaysClass teacherTodaysClass;
    TeacherTodaysClassViewBind teacherTodaysClassViewBind;



    public TeacherTodaysClassOnClick( TeacherTodaysClass teacherTodaysClass,TeacherTodaysClassViewBind teacherTodaysClassViewBind) {
        this.teacherTodaysClass=teacherTodaysClass;
        this.teacherTodaysClassViewBind=teacherTodaysClassViewBind;
        setonclicklistner();
    }
    // set click listner.
    private void setonclicklistner() {
        teacherTodaysClassViewBind.select_calender.setOnClickListener(this);
        teacherTodaysClassViewBind.back_icon.setOnClickListener(this);
        teacherTodaysClassViewBind.tvSearchid.setOnClickListener(this);
        teacherTodaysClassViewBind.floatingbtnid.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.back_icon:{
                // Toast.makeText(mainActivity,"hello",Toast.LENGTH_LONG).show();
                teacherTodaysClass.onBackPressed();

            }
            break;

            case R.id.select_calender:{

                teacherTodaysClass.calender();

            }
            break;

            case R.id.tvSearchid :{


                 if (teacherTodaysClass.DOB.equalsIgnoreCase("null")){
                     MyToast.show(teacherTodaysClass,"Please select date",true);
                 }else {
                     teacherTodaysClass.apiForTeacherTodaysClassSearch(teacherTodaysClass.DOB);
                 }

            }
            break;

            case R.id.floatingbtnid :{
                Intent intent=new Intent(teacherTodaysClass, TeacherAddTodaysClassActivity.class);
                teacherTodaysClass.startActivity(intent);
            }
            break;

        }



    }
}