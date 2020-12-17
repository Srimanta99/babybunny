package com.baby.bunny.student.management.screen.StudentOTPActivity;

import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.baby.bunny.student.management.R;
import com.baby.bunny.student.management.screen.StudentHomeActivity.StudentHomeActivity;
import com.baby.bunny.student.management.utils.SessionManager;

public class StudentOTPOnClick implements View.OnClickListener{
    StudentOTPActivity stuOTP_activity;
    StudentOTPViewBind studentOTP_viewBind;
    String otp;

    public StudentOTPOnClick(StudentOTPActivity stuOTP_activity, StudentOTPViewBind studentOTP_viewBind) {
        this.stuOTP_activity=stuOTP_activity;
        this.studentOTP_viewBind=studentOTP_viewBind;
        setonclicklistner();
    }
    // set click listner.
    private void setonclicklistner() {

        studentOTP_viewBind.tvsubmmitid.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.tvsubmmitid:{

             otp=    studentOTP_viewBind.etotpno1id.getText().toString()+ studentOTP_viewBind.etotpno2id.getText().toString()+studentOTP_viewBind.etotpno3id.getText().toString()+
                        studentOTP_viewBind.etotpno4id.getText().toString()+ studentOTP_viewBind.etotpno5id.getText().toString()+ studentOTP_viewBind.etotpno6id.getText().toString();
                Log.d("sunnnnnnnnnnn", "onClick: "+otp);

                if (stuOTP_activity.otp.equalsIgnoreCase(otp)) {
                    Log.d("aaaaaaa", "onClick: "+stuOTP_activity.otp);

                     /*   studentOTP_viewBind.cardpasswordid.setVisibility(View.VISIBLE);

                        if (studentOTP_viewBind.etpasswordid.getText().toString().length()==5){
                            Log.d("aaaaaaa", "onClick: "+studentOTP_viewBind.etpasswordid);*/
                            stuOTP_activity.loadsubmit(stuOTP_activity.otp, studentOTP_viewBind.etpasswordid.getText().toString());

                            Intent mainIntent = new Intent(stuOTP_activity, StudentHomeActivity.class);
                              SessionManager.setLogged(true);
                            stuOTP_activity.startActivity(mainIntent);
                             mainIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_CLEAR_TOP);
                            stuOTP_activity. finish();



                            Toast.makeText(stuOTP_activity, "" +stuOTP_activity.message, Toast.LENGTH_SHORT).show();
                       /* }else {
                            Toast.makeText(stuOTP_activity, "please enter your passord any 5 numbers", Toast.LENGTH_SHORT).show();
                        }*/

                } else {
                    Toast.makeText(stuOTP_activity, "Enter Correct OTP", Toast.LENGTH_SHORT).show();
                }

            }
            break;
        }
    }

}

