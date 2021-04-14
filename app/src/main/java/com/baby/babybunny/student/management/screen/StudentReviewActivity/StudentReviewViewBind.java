package com.baby.babybunny.student.management.screen.StudentReviewActivity;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.baby.babybunny.student.management.R;
import com.rts.commonutils_2_0.deviceinfo.DeviceResolution;

public class StudentReviewViewBind extends DeviceResolution {
    StudentReviewActivity studentReviewActivity;
    View view;
    ImageView back_icon;
    TextView toolname_id;


    public StudentReviewViewBind(StudentReviewActivity studentReviewActivity, View view) {
        super(studentReviewActivity);
        this.studentReviewActivity=studentReviewActivity;
        this.view=view;
        initviewBind();
        setCustomTypeface();
    }

    // for adding custom typeface
    private void setCustomTypeface() {
        // studentlvid.setTypeface(getbebas(mainActivity));
//        btn_hello_wrold.setTypeface(getbebas(mainActivity));
    }

    // for findview
    private void initviewBind() {
        back_icon =view. findViewById(R.id.back_icon);
        toolname_id=view.findViewById(R.id.toolname_id);

        // btn_hello_wrold=view.findViewById(R.id.btn_hello_wrold) ;
    }
}

