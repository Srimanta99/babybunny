package com.baby.babybunny.student.management.screen.TeacherAttendenceActivity;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.baby.babybunny.student.management.R;
import com.rts.commonutils_2_0.deviceinfo.DeviceResolution;

public class TeacherAttendenceViewBind extends DeviceResolution {
    TeacherAttendenceActivity teacherAttendenceActivity;
    View view;
  TextView toolname_id;
    DrawerLayout drawerLayout;
    ActionBarDrawerToggle actionBarDrawerToggle;
    Spinner select_class_spinnerid;
    LinearLayout nodatafoundlvid,progresslvid;
    RecyclerView teacherrv;
    TextView tvSearchid,tvsubmmitid;
    ImageView back_icon;
    ProgressBar progress_bar;
    public TeacherAttendenceViewBind(TeacherAttendenceActivity teacherAttendenceActivity, View view) {
        super(teacherAttendenceActivity);
        this.teacherAttendenceActivity=teacherAttendenceActivity;
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
        toolname_id=view.findViewById(R.id.toolname_id);
        drawerLayout = view.findViewById(R.id.drawer_layout);
        select_class_spinnerid=view.findViewById(R.id.select_class_spinnerid);
        nodatafoundlvid=view.findViewById(R.id.nodatafoundlvid);
        progresslvid=view.findViewById(R.id.progresslvid);
        teacherrv=view.findViewById(R.id.teacherrv);
        tvSearchid=view.findViewById(R.id.tvSearchid);
        tvsubmmitid=view.findViewById(R.id.tvsubmmitid);
        back_icon =view.findViewById(R.id.back_icon);
        progress_bar=view.findViewById(R.id.progress_bar);
        // btn_hello_wrold=view.findViewById(R.id.btn_hello_wrold) ;
    }
}
