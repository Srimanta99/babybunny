package com.baby.babybunny.student.management.screen.CenterHomeTaskActivity;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.baby.babybunny.student.management.R;
import com.rts.commonutils_2_0.deviceinfo.DeviceResolution;

public class CenterHomeTaskViewBind extends DeviceResolution {
    CenterHomeTaskActivity centerHomeTaskActivity;
    View view;
    ImageView back_icon;
    DrawerLayout drawerLayout;
    ActionBarDrawerToggle actionBarDrawerToggle;
    TextView select_calender,tvSearchid;
    RecyclerView hometaskrv;
    LinearLayout nodatafoundlvid;
    LinearLayout progresslvid;
    TextView toolname_id;

    public CenterHomeTaskViewBind(CenterHomeTaskActivity centerHomeTaskActivity, View view) {
        super(centerHomeTaskActivity);
        this.centerHomeTaskActivity=centerHomeTaskActivity;
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
        back_icon=view.findViewById(R.id.back_icon);
        drawerLayout = view.findViewById(R.id.drawer_layout);
        select_calender=view.findViewById(R.id.select_calender);
        hometaskrv=view.findViewById(R.id.hometaskrv);
        nodatafoundlvid=view.findViewById(R.id.nodatafoundlvid);
        tvSearchid=view.findViewById(R.id.tvSearchid);
        toolname_id=view.findViewById(R.id.toolname_id);

        progresslvid=view.findViewById(R.id.progresslvid);
        // btn_hello_wrold=view.findViewById(R.id.btn_hello_wrold) ;
    }
}
