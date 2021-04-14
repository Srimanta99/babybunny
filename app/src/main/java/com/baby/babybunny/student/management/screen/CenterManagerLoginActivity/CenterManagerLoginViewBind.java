package com.baby.babybunny.student.management.screen.CenterManagerLoginActivity;

import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.baby.babybunny.student.management.R;
import com.rts.commonutils_2_0.deviceinfo.DeviceResolution;

public class CenterManagerLoginViewBind extends DeviceResolution {
    CenterManagerLoginActivity centerManagerLoginActivity;
    View view;
    EditText etphnoid;
    TextView tvsubmitid;

    LinearLayout cardpasswordid;
    EditText etpasswordid;



    public CenterManagerLoginViewBind( CenterManagerLoginActivity centerManagerLoginActivity, View view) {
        super(centerManagerLoginActivity);
        this.centerManagerLoginActivity=centerManagerLoginActivity;
        this.view=view;
        initviewBind();
        setCustomTypeface();
    }

    // for adding custom typeface
    private void setCustomTypeface() {

    }

    // for findview
    private void initviewBind() {
        etphnoid=view.findViewById(R.id.etphnoid);
        tvsubmitid=view.findViewById(R.id.tvsubmmitid);
        cardpasswordid=view.findViewById(R.id.cardpasswordid);
        etpasswordid=view.findViewById(R.id.etpasswordid);


    }
}
