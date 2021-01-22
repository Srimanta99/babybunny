package com.baby.bunny.student.management.screen.StudentFeesBookAcivity;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.baby.bunny.student.management.R;
import com.baby.bunny.student.management.screen.main.MainActivity;
import com.rts.commonutils_2_0.deviceinfo.DeviceResolution;

public class StudentFeesBookViewBind extends DeviceResolution {
    StudentFeesBookActivity studentFeesBookActivity;
    View view;
    ImageView back_icon;

    public StudentFeesBookViewBind(StudentFeesBookActivity studentFeesBookActivity, View view) {
        super(studentFeesBookActivity);
        this.studentFeesBookActivity=studentFeesBookActivity;
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
        back_icon =view.findViewById(R.id.back_icon);
        // btn_hello_wrold=view.findViewById(R.id.btn_hello_wrold) ;
    }
}

