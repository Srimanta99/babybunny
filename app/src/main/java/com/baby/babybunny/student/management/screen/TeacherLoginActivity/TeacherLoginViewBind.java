package com.baby.babybunny.student.management.screen.TeacherLoginActivity;

import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.baby.babybunny.student.management.R;
import com.rts.commonutils_2_0.deviceinfo.DeviceResolution;

public class TeacherLoginViewBind extends DeviceResolution {
    TeacherLoginActivity teacherLoginActivity;
    View view;
    EditText etphnoid;
    TextView tvsubmitid;

    LinearLayout cardpasswordid;
    EditText etpasswordid;



    public TeacherLoginViewBind( TeacherLoginActivity teacherLoginActivity, View view) {
        super(teacherLoginActivity);
        this.teacherLoginActivity=teacherLoginActivity;
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

