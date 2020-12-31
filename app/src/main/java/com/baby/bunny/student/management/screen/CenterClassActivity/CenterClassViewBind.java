package com.baby.bunny.student.management.screen.CenterClassActivity;

import android.view.View;
import android.widget.ImageView;

import androidx.recyclerview.widget.RecyclerView;

import com.baby.bunny.student.management.R;
import com.baby.bunny.student.management.screen.CenterStudentActivity.CenterStudentActivity;
import com.rts.commonutils_2_0.deviceinfo.DeviceResolution;

public class CenterClassViewBind extends DeviceResolution {
    CenterClassActivity centerClassActivity;
    View view;
    RecyclerView classrv;
    ImageView back_icon;

    public CenterClassViewBind(CenterClassActivity centerClassActivity, View view) {
        super(centerClassActivity);
        this.centerClassActivity=centerClassActivity;
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
        classrv=view.findViewById(R.id.classrv);
        back_icon=view.findViewById(R.id.back_icon);
        // btn_hello_wrold=view.findViewById(R.id.btn_hello_wrold) ;
    }
}


