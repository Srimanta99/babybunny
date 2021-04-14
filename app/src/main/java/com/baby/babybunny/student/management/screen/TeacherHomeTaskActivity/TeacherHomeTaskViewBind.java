package com.baby.babybunny.student.management.screen.TeacherHomeTaskActivity;

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
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.rts.commonutils_2_0.deviceinfo.DeviceResolution;

public class TeacherHomeTaskViewBind extends DeviceResolution {
    TeacherHomeTaskActivity teacherHomeTaskActivity;
    View view;
    RecyclerView hometaskrv;
    ImageView back_icon;
    Spinner select_class_spinnerid,select_type_spinnerid;
    FloatingActionButton floatingbtnid;

    DrawerLayout drawerLayout;
    ActionBarDrawerToggle actionBarDrawerToggle;
    TextView select_calender,tvSearchid;
    LinearLayout progresslvid,nodatafoundlvid;
    RecyclerView select_student_rv;
    ProgressBar progress_bar;
    public TeacherHomeTaskViewBind(TeacherHomeTaskActivity teacherHomeTaskActivity, View view) {
        super(teacherHomeTaskActivity);
        this.teacherHomeTaskActivity=teacherHomeTaskActivity;
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
        hometaskrv=view.findViewById(R.id.hometaskrv);
        drawerLayout = view.findViewById(R.id.drawer_layout);
        select_class_spinnerid=view.findViewById(R.id.select_class_spinnerid);
        select_type_spinnerid=view.findViewById(R.id.select_type_spinnerid);
        select_calender=view.findViewById(R.id.select_calender);
        select_student_rv=view.findViewById(R.id.select_student_rv);
        back_icon=view.findViewById(R.id.back_icon);
        tvSearchid=view.findViewById(R.id.tvSearchid);
        floatingbtnid=view.findViewById(R.id.floatingbtnid);
        nodatafoundlvid=view.findViewById(R.id.nodatafoundlvid);
        progresslvid=view.findViewById(R.id.progresslvid);
        progress_bar=view.findViewById(R.id.progress_bar);

    }
}
