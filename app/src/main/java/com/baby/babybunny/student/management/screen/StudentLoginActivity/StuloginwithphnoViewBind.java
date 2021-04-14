package com.baby.babybunny.student.management.screen.StudentLoginActivity;

import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.baby.babybunny.student.management.R;
import com.rts.commonutils_2_0.deviceinfo.DeviceResolution;

public class StuloginwithphnoViewBind extends DeviceResolution {
   StudentLoginActivity stuloginwithphno;
    View view;
    EditText etphnoid;
    TextView tvsubmitid;

    LinearLayout cardpasswordid;
    EditText etpasswordid;



    public StuloginwithphnoViewBind(StudentLoginActivity stuloginwithphno, View view) {
        super(stuloginwithphno);
        this.stuloginwithphno=stuloginwithphno;
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
