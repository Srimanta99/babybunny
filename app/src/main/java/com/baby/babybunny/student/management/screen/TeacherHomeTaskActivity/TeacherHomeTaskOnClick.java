package com.baby.babybunny.student.management.screen.TeacherHomeTaskActivity;

import android.content.Intent;
import android.view.View;

import com.baby.babybunny.student.management.R;
import com.baby.babybunny.student.management.screen.TeacherAddHomeTaskActivity.TeacherAddHomeTaskActivity;
import com.baby.babybunny.student.management.utils.MyToast;

public class TeacherHomeTaskOnClick implements View.OnClickListener{
    TeacherHomeTaskActivity teacherHomeTaskActivity;
    TeacherHomeTaskViewBind teacherHomeTaskViewBind;



    public TeacherHomeTaskOnClick( TeacherHomeTaskActivity teacherHomeTaskActivity, TeacherHomeTaskViewBind teacherHomeTaskViewBind) {
        this.teacherHomeTaskActivity=teacherHomeTaskActivity;
        this.teacherHomeTaskViewBind=teacherHomeTaskViewBind;
        setonclicklistner();
    }
    // set click listner.
    private void setonclicklistner() {

        teacherHomeTaskViewBind.back_icon.setOnClickListener(this);
        teacherHomeTaskViewBind.tvSearchid.setOnClickListener(this);
        teacherHomeTaskViewBind.floatingbtnid.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.back_icon:{
                // Toast.makeText(mainActivity,"hello",Toast.LENGTH_LONG).show();
                teacherHomeTaskActivity.onBackPressed();

            }
            break;



            case R.id.tvSearchid :{




                if (teacherHomeTaskActivity.Class_id.equalsIgnoreCase("0")){
                    MyToast.show(teacherHomeTaskActivity,"Please select class",true);
                }else {
                    teacherHomeTaskActivity.apiForhometaskSearch(teacherHomeTaskActivity.Class_id);
                }

            }
            break;

            case R.id.floatingbtnid :{
                Intent intent=new Intent(teacherHomeTaskActivity, TeacherAddHomeTaskActivity.class);
                teacherHomeTaskActivity.startActivity(intent);
            }
            break;

        }



    }
}