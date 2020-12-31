package com.baby.bunny.student.management.screen.CenterStudentsFeesActivity;

import android.app.DatePickerDialog;
import android.view.Gravity;
import android.view.View;
import android.widget.DatePicker;

import com.baby.bunny.student.management.R;
import com.baby.bunny.student.management.screen.CenterTeacherActivity.CenterTeacherActivity;
import com.baby.bunny.student.management.screen.CenterTeacherActivity.CenterTeacherViewBind;

import java.util.Calendar;

public class CenterStudentsFeesOnClick implements View.OnClickListener{
    CenterStudentsFeesActivity centerStudentsFeesActivity;
    CenterStudentsFeesViewBind centerStudentsFeesViewBind;



    public CenterStudentsFeesOnClick( CenterStudentsFeesActivity centerStudentsFeesActivity,CenterStudentsFeesViewBind centerStudentsFeesViewBind) {
        this.centerStudentsFeesActivity=centerStudentsFeesActivity;
        this.centerStudentsFeesViewBind=centerStudentsFeesViewBind;
        setonclicklistner();
    }
    // set click listner.
    private void setonclicklistner() {
        centerStudentsFeesViewBind.select_calender.setOnClickListener(this);
        centerStudentsFeesViewBind.back_icon.setOnClickListener(this);
        centerStudentsFeesViewBind.tvSearchid.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.back_icon:{
                // Toast.makeText(mainActivity,"hello",Toast.LENGTH_LONG).show();
                centerStudentsFeesActivity.onBackPressed();

            }
            break;

            case R.id.select_calender:{

                centerStudentsFeesActivity.calender();
               /* StartTime .show();*/
            }
            break;

            case R.id.tvSearchid :{

                centerStudentsFeesActivity.getStudentFees_Searchbtn(centerStudentsFeesActivity.id,
                        centerStudentsFeesActivity.cal_date,centerStudentsFeesActivity.student_id,
                        centerStudentsFeesActivity.value);

            }
            break;

        }



    }
}


