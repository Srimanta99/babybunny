package com.baby.babybunny.student.management.screen.TeacherOtpActivity;

import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.baby.babybunny.student.management.R;

public class TeacherOtpOnClick implements View.OnClickListener{
    TeacherOtpActivity teacherOtpActivity;
    TeacherOtpViewBind teacherOtpViewBind;
    String otp;

    public TeacherOtpOnClick(TeacherOtpActivity teacherOtpActivity , TeacherOtpViewBind teacherOtpViewBind) {
        this.teacherOtpActivity=teacherOtpActivity;
        this.teacherOtpViewBind=teacherOtpViewBind;
        setonclicklistner();
    }
    // set click listner.
    private void setonclicklistner() {

        teacherOtpViewBind.tvsubmmitid.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.tvsubmmitid:{


                otp=    teacherOtpViewBind.etotpno1id.getText().toString()+ teacherOtpViewBind.etotpno2id.getText().toString()+teacherOtpViewBind.etotpno3id.getText().toString()+
                        teacherOtpViewBind.etotpno4id.getText().toString()+ teacherOtpViewBind.etotpno5id.getText().toString()+ teacherOtpViewBind.etotpno6id.getText().toString();
                Log.d("sunnnnnnnnnnn", "onClick: "+otp);

                if (teacherOtpActivity.otp.equalsIgnoreCase(otp)) {
                    Log.d("aaaa", "onClick: "+teacherOtpActivity.otp);


                    teacherOtpActivity.loadsubmit(teacherOtpActivity.otp);

                   /* Intent mainIntent = new Intent(teacherOtpActivity, TeacherHomeActivity.class);
                    SessionManager.setTeacheridboolean(true);

                    SessionManager.setTeacherLogged(true);
                  //  mainIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                    teacherOtpActivity.startActivity(mainIntent);
                    teacherOtpActivity. finish();
*/


                    //  Toast.makeText(centerManagerOtpActivity, "" +centerManagerOtpActivity.message, Toast.LENGTH_SHORT).show();

                } else {
                    Toast.makeText(teacherOtpActivity, "Enter Correct OTP", Toast.LENGTH_SHORT).show();
                }

            }
            break;
        }
    }

}

