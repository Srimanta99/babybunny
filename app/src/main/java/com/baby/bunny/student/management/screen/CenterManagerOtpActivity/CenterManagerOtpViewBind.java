package com.baby.bunny.student.management.screen.CenterManagerOtpActivity;

import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.baby.bunny.student.management.R;
import com.baby.bunny.student.management.screen.StudentOTPActivity.StudentOTPActivity;
import com.rts.commonutils_2_0.deviceinfo.DeviceResolution;

public class CenterManagerOtpViewBind extends DeviceResolution {
    CenterManagerOtpActivity centerManagerOtpActivity;
    View view;
    EditText etotpno1id,etotpno2id,etotpno3id,etotpno4id,etotpno5id,etotpno6id,etpasswordid;
    TextView tvsubmmitid;
    String stuphno;
    String   success;
    String   message,otp;
    LinearLayout cardpasswordid;
    String id;

    static StudentOTPActivity INSTANCE;

    public CenterManagerOtpViewBind(CenterManagerOtpActivity centerManagerOtpActivity, View view) {
        super(centerManagerOtpActivity);
        this.centerManagerOtpActivity=centerManagerOtpActivity;
        this.view=view;
        initviewBind();
        setCustomTypeface();
    }

    // for adding custom typeface
    private void setCustomTypeface() {
    }

    // for findview
    private void initviewBind() {
        etotpno1id=view.findViewById(R.id.etotpno1id);
        etotpno2id=view.findViewById(R.id.etotpno2id);
        etotpno3id=view.findViewById(R.id.etotpno3id);
        etotpno4id=view.findViewById(R.id.etotpno4id);
        etotpno5id=view.findViewById(R.id.etotpno5id);
        etotpno6id=view.findViewById(R.id.etotpno6id);
        cardpasswordid=view.findViewById(R.id.cardpasswordid);
        etpasswordid=view.findViewById(R.id.etpasswordid);
        tvsubmmitid=view.findViewById(R.id.tvsubmmitid);
    }
}
