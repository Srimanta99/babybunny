package com.baby.babybunny.student.management.screen.CenterStudentsFeesActivity;

import android.content.Intent;
import android.view.View;
import android.widget.Toast;

import com.baby.babybunny.student.management.R;
import com.baby.babybunny.student.management.screen.CenterAddStudentFeesActivity.CenterAddStudentFeesActivity;
import com.baby.babybunny.student.management.utils.MyToast;

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
        centerStudentsFeesViewBind.floatingbtnid.setOnClickListener(this);
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

            String nul=null;
            String classid="0";
            String typeid=null;

            if (centerStudentsFeesActivity.student_id == nul){
                MyToast.show(centerStudentsFeesActivity,"please select student",true);

                break;
            }/*else if (centerStudentsFeesActivity.Class_id == classid){
                Toast.makeText(centerStudentsFeesActivity, "please select class", Toast.LENGTH_SHORT).show();
                  break;
            }*/else if (centerStudentsFeesActivity.value == typeid){
                MyToast.show(centerStudentsFeesActivity,"please select type",true);

                break;
            } else {

                centerStudentsFeesActivity.getStudentFees_Searchbtn(centerStudentsFeesActivity.Class_id,
                        centerStudentsFeesActivity.cal_date, centerStudentsFeesActivity.student_id,
                        centerStudentsFeesActivity.value);
            }
                        }
                        break;

                        case R.id.floatingbtnid :{
                            Intent intent=new Intent(centerStudentsFeesActivity, CenterAddStudentFeesActivity.class);
                            centerStudentsFeesActivity.startActivity(intent);
                        }
                        break;

                    }



    }
}


