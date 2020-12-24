package com.baby.bunny.student.management.screen.CenterTeacherActivity;

import android.view.View;

import androidx.recyclerview.widget.RecyclerView;

import com.baby.bunny.student.management.R;
import com.baby.bunny.student.management.screen.CenterStudentActivity.CenterStudentActivity;
import com.rts.commonutils_2_0.deviceinfo.DeviceResolution;

public class CenterTeacherViewBind extends DeviceResolution {
    CenterTeacherActivity centerTeacherActivity;
    View view;
    RecyclerView teacherrv;

    public CenterTeacherViewBind(CenterTeacherActivity centerTeacherActivity, View view) {
        super(centerTeacherActivity);
        this.centerTeacherActivity=centerTeacherActivity;
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
        teacherrv=view.findViewById(R.id.teacherrv);

        // btn_hello_wrold=view.findViewById(R.id.btn_hello_wrold) ;
    }
}


