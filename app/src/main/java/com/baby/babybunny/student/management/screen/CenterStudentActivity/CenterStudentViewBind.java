package com.baby.babybunny.student.management.screen.CenterStudentActivity;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.baby.babybunny.student.management.R;
import com.rts.commonutils_2_0.deviceinfo.DeviceResolution;

public class CenterStudentViewBind extends DeviceResolution {
    CenterStudentActivity centerStudentActivity;
    View view;
   RecyclerView studentrv;
   ImageView back_icon;
    LinearLayout nodatafoundlvid,progresslvid;
    TextView toolname_id;


    public CenterStudentViewBind(CenterStudentActivity centerStudentActivity, View view) {
        super(centerStudentActivity);
        this.centerStudentActivity=centerStudentActivity;
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
        studentrv=view.findViewById(R.id.studentrv);
        back_icon=view.findViewById(R.id.back_icon);
        nodatafoundlvid=view.findViewById(R.id.nodatafoundlvid);
        progresslvid=view.findViewById(R.id.progresslvid);
        toolname_id=view.findViewById(R.id.toolname_id);



        // btn_hello_wrold=view.findViewById(R.id.btn_hello_wrold) ;
    }
}

