package com.baby.bunny.student.management.screen.StudentCompanyAchievmentActivity;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import androidx.recyclerview.widget.RecyclerView;

import com.baby.bunny.student.management.R;
import com.baby.bunny.student.management.screen.main.MainActivity;
import com.rts.commonutils_2_0.deviceinfo.DeviceResolution;

public class CompanyAchievementViewBind extends DeviceResolution {
    StudentCompanyAchievmentActivity studentCompanyAchievmentActivity;
    View view;
   RecyclerView recyclerView;
    ImageView back_icon;

    public CompanyAchievementViewBind(StudentCompanyAchievmentActivity studentCompanyAchievmentActivity, View view) {
        super(studentCompanyAchievmentActivity);
        this.studentCompanyAchievmentActivity=studentCompanyAchievmentActivity;
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
        // btn_hello_wrold=view.findViewById(R.id.btn_hello_wrold) ;
    }
}
