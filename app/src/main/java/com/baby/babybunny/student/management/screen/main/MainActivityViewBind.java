package com.baby.babybunny.student.management.screen.main;

import android.view.View;
import android.widget.LinearLayout;

import com.baby.babybunny.student.management.R;
import com.rts.commonutils_2_0.deviceinfo.DeviceResolution;

public class MainActivityViewBind extends DeviceResolution {
    MainActivity mainActivity;
    View view;
    LinearLayout studentlvid,lvcentermanagerid,lvteacherid;

    public MainActivityViewBind(MainActivity mainActivity, View view) {
        super(mainActivity);
        this.mainActivity=mainActivity;
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
        studentlvid=view.findViewById(R.id.studentlvid);
        lvcentermanagerid=view.findViewById(R.id.lvcentermanagerid);
        lvteacherid=view.findViewById(R.id.lvteacherid);
       // btn_hello_wrold=view.findViewById(R.id.btn_hello_wrold) ;
    }
}
