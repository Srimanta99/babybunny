package com.baby.bunny.student.management.screen.CenterTodayActivity;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import androidx.recyclerview.widget.RecyclerView;

import com.baby.bunny.student.management.R;
import com.baby.bunny.student.management.screen.main.MainActivity;
import com.rts.commonutils_2_0.deviceinfo.DeviceResolution;

public class CenterTodayViewBind extends DeviceResolution {
    CenterTodayActivity centerTodayActivity;
    View view;
    ImageView back_icon;
    LinearLayout nodatafoundlvid,progresslvid;
    RecyclerView todayinnovationrv;

    public CenterTodayViewBind(CenterTodayActivity centerTodayActivity, View view) {
        super(centerTodayActivity);
        this.centerTodayActivity=centerTodayActivity;
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
        nodatafoundlvid=view.findViewById(R.id.nodatafoundlvid);
        progresslvid=view.findViewById(R.id.progresslvid);
        back_icon=view. findViewById(R.id.back_icon);
        todayinnovationrv=view.findViewById(R.id.todayinnovationrv);

        // btn_hello_wrold=view.findViewById(R.id.btn_hello_wrold) ;
    }
}

