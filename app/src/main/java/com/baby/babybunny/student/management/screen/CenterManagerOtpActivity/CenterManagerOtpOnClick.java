package com.baby.babybunny.student.management.screen.CenterManagerOtpActivity;

import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.baby.babybunny.student.management.R;
import com.baby.babybunny.student.management.screen.CenterManagerHomeActivity.CenterManagerHomeActivity;
import com.baby.babybunny.student.management.utils.SessionManager;

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


                  //  Toast.makeText(centerManagerOtpActivity, "" +centerManagerOtpActivity.message, Toast.LENGTH_SHORT).show();

                } else {
                    Toast.makeText(centerManagerOtpActivity, "Enter Correct OTP", Toast.LENGTH_SHORT).show();
                }

            }
            break;
        }
    }

}

