package com.baby.babybunny.student.management.screen.StudentQueryActivity;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.baby.babybunny.student.management.R;
import com.rts.commonutils_2_0.deviceinfo.DeviceResolution;

public class StudentQueryViewBind extends DeviceResolution {
    Student_Query_Activity studentQueryActivity;
    View view;
    ImageView back_icon;
    TextView toolname_id;


    public StudentQueryViewBind( Student_Query_Activity studentQueryActivity, View view) {
        super(studentQueryActivity);
        this.studentQueryActivity=studentQueryActivity;
        this.view=view;
        initviewBind();
        setCustomTypeface();
    }

    // for adding custom typeface
    private void setCustomTypeface() {

    }

    // for findview
    private void initviewBind() {
        back_icon =view. findViewById(R.id.back_icon);
        toolname_id=view.findViewById(R.id.toolname_id);

    }
}

