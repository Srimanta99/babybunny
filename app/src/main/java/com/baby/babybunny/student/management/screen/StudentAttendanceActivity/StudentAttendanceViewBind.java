package com.baby.babybunny.student.management.screen.StudentAttendanceActivity;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.baby.babybunny.student.management.R;
import com.rts.commonutils_2_0.deviceinfo.DeviceResolution;

public class StudentAttendanceViewBind extends DeviceResolution {
    StudentAttendanceActivity studentAttendanceActivity;
    View view;
    RecyclerView recyclerView;
    ImageView back_icon;
    TextView toolname_id,tvid_present,tvid_absent;


    public StudentAttendanceViewBind(StudentAttendanceActivity studentAttendanceActivity, View view) {
        super(studentAttendanceActivity);
        this.studentAttendanceActivity=studentAttendanceActivity;
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
        recyclerView=view.findViewById(R.id.recyclerViewid);
        back_icon =view. findViewById(R.id.back_icon);
        toolname_id=view.findViewById(R.id.toolname_id);
        tvid_present=view.findViewById(R.id.tvid_present);
        tvid_absent=view.findViewById(R.id.tvid_absent);
        // btn_hello_wrold=view.findViewById(R.id.btn_hello_wrold) ;
    }
}

