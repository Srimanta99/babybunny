package com.baby.babybunny.student.management.screen.Fragment.ChangePassword;

import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.widget.ImageView;

import com.baby.babybunny.student.management.R;

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
