package com.baby.bunny.student.management.screen.CenterManagerOtpActivity;

import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.baby.bunny.student.management.R;
import com.baby.bunny.student.management.screen.CenterManagerHomeActivity.CenterManagerHomeActivity;
import com.baby.bunny.student.management.screen.StudentHomeActivity.StudentHomeActivity;
import com.baby.bunny.student.management.screen.StudentOTPActivity.StudentOTPActivity;
import com.baby.bunny.student.management.screen.StudentOTPActivity.StudentOTPViewBind;
import com.baby.bunny.student.management.utils.SessionManager;

public class CenterManagerOtpOnClick implements View.OnClickListener{
    CenterManagerOtpActivity centerManagerOtpActivity;
    CenterManagerOtpViewBind centerManagerOtpViewBind;
    String otp;

    public CenterManagerOtpOnClick(CenterManagerOtpActivity centerManagerOtpActivity ,CenterManagerOtpViewBind centerManagerOtpViewBind) {
        this.centerManagerOtpActivity=centerManagerOtpActivity;
        this.centerManagerOtpViewBind=centerManagerOtpViewBind;
        setonclicklistner();
    }
    // set click listner.
    private void setonclicklistner() {

        centerManagerOtpViewBind.tvsubmmitid.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.tvsubmmitid:{


                otp=    centerManagerOtpViewBind.etotpno1id.getText().toString()+ centerManagerOtpViewBind.etotpno2id.getText().toString()+centerManagerOtpViewBind.etotpno3id.getText().toString()+
                        centerManagerOtpViewBind.etotpno4id.getText().toString()+ centerManagerOtpViewBind.etotpno5id.getText().toString()+ centerManagerOtpViewBind.etotpno6id.getText().toString();
                Log.d("sunnnnnnnnnnn", "onClick: "+otp);

                if (centerManagerOtpActivity.otp.equalsIgnoreCase(otp)) {
                    Log.d("aaaa", "onClick: "+centerManagerOtpActivity.otp);


                    centerManagerOtpActivity.loadsubmit(centerManagerOtpActivity.otp);

                    Intent mainIntent = new Intent(centerManagerOtpActivity, CenterManagerHomeActivity.class);
                    SessionManager.setCenterManageridboolean(true);

                    SessionManager.setCenterManagerLogged(true);
                    mainIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                    centerManagerOtpActivity.startActivity(mainIntent);

                    centerManagerOtpActivity. finish();



                  //  Toast.makeText(centerManagerOtpActivity, "" +centerManagerOtpActivity.message, Toast.LENGTH_SHORT).show();

                } else {
                    Toast.makeText(centerManagerOtpActivity, "Enter Correct OTP", Toast.LENGTH_SHORT).show();
                }

            }
            break;
        }
    }

}

