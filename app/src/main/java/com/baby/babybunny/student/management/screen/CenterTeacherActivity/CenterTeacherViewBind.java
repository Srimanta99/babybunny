package com.baby.babybunny.student.management.screen.CenterTeacherActivity;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.baby.babybunny.student.management.R;
import com.rts.commonutils_2_0.deviceinfo.DeviceResolution;

public class CenterTeacherViewBind extends DeviceResolution {
    CenterTeacherActivity centerTeacherActivity;
    View view;
    RecyclerView teacherrv;
    ImageView back_icon;

    LinearLayout nodatafoundlvid,progresslvid;

    Spinner select_class_spinnerid;

    TextView tvSearchid;

     DrawerLayout drawerLayout;
     ActionBarDrawerToggle actionBarDrawerToggle;

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
        drawerLayout = view.findViewById(R.id.drawer_layout);
        select_class_spinnerid=view.findViewById(R.id.select_class_spinnerid);
        back_icon=view.findViewById(R.id.back_icon);
        tvSearchid=view.findViewById(R.id.tvSearchid);
        nodatafoundlvid=view.findViewById(R.id.nodatafoundlvid);
        progresslvid=view.findViewById(R.id.progresslvid);
        // btn_hello_wrold=view.findViewById(R.id.btn_hello_wrold) ;
    }
}


