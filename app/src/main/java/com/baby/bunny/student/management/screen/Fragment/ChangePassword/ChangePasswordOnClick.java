package com.baby.bunny.student.management.screen.Fragment.ChangePassword;

import android.content.Intent;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.widget.ImageView;

import com.baby.bunny.student.management.R;
import com.baby.bunny.student.management.screen.Fragment.ParentsZone.ParentZoneViewBind;
import com.baby.bunny.student.management.screen.Fragment.ParentsZone.ParentsZoneFragment;
import com.baby.bunny.student.management.screen.StudentCompanyAchievmentActivity.StudentCompanyAchievmentActivity;
import com.baby.bunny.student.management.screen.StudentFeesBookAcivity.StudentFeesBookActivity;
import com.baby.bunny.student.management.screen.StudentHolidayActivity.Student_HolidayList_Activity;
import com.baby.bunny.student.management.screen.StudentQueryActivity.Student_Query_Activity;
import com.baby.bunny.student.management.screen.StudentReviewActivity.StudentReviewActivity;
import com.baby.bunny.student.management.screen.StudentTodaysClassActivity.StudentTodaysClass;

public class ChangePasswordOnClick implements View.OnClickListener{
    ChangePasswordFragment changePasswordFragment;
    ChangePasswordViewBind changePasswordViewBind;

    public ChangePasswordOnClick( ChangePasswordFragment changePasswordFragment,ChangePasswordViewBind changePasswordViewBind) {
        this.changePasswordFragment=changePasswordFragment;
        this.changePasswordViewBind=changePasswordViewBind;
        setonclicklistner();
    }
    // set click listner.
    private void setonclicklistner() {
        changePasswordViewBind.show_pass_id.setOnClickListener(this);
        changePasswordViewBind.show_new_password_id.setOnClickListener(this);
        changePasswordViewBind.show_confirm_pass_id.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.show_pass_id:{
                // Toast.makeText(mainActivity,"hello",Toast.LENGTH_LONG).show();
                if(view.getId()==R.id.show_pass_id){

                    if(changePasswordViewBind. evpasswordid.getTransformationMethod().equals(PasswordTransformationMethod.getInstance())){
                        changePasswordViewBind. show_pass_id.setImageResource(R.drawable.showpassword);

                        //Show Password
                        changePasswordViewBind. evpasswordid.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
                    }
                    else{
                        ((ImageView)(view)).setImageResource(R.drawable.hidepassword);

                        //Hide Password
                        changePasswordViewBind.evpasswordid.setTransformationMethod(PasswordTransformationMethod.getInstance());

                    }
                }

            }
            break;

            case R.id.show_new_password_id:{
                if(view.getId()==R.id.show_new_password_id){

                    if(  changePasswordViewBind. et_show_new_password_id.getTransformationMethod().equals(PasswordTransformationMethod.getInstance())){
                        changePasswordViewBind. show_new_password_id.setImageResource(R.drawable.showpassword);

                        //Show Password
                        changePasswordViewBind. et_show_new_password_id.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
                    }
                    else{
                        ((ImageView)(view)).setImageResource(R.drawable.hidepassword);

                        //Hide Password
                        changePasswordViewBind. et_show_new_password_id.setTransformationMethod(PasswordTransformationMethod.getInstance());

                    }
                }
            }

            break;

          case   R.id.show_confirm_pass_id : {
              if(view.getId()==R.id.show_confirm_pass_id){

                  if(  changePasswordViewBind.et_show_confirm_pass_id.getTransformationMethod().equals(PasswordTransformationMethod.getInstance())){
                      changePasswordViewBind. show_confirm_pass_id.setImageResource(R.drawable.showpassword);

                      //Show Password
                      changePasswordViewBind.  et_show_confirm_pass_id.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
                  }
                  else{
                      ((ImageView)(view)).setImageResource(R.drawable.hidepassword);

                      //Hide Password
                      changePasswordViewBind.  et_show_confirm_pass_id.setTransformationMethod(PasswordTransformationMethod.getInstance());

                  }
              }
            }
            break;

        }
    }
}
