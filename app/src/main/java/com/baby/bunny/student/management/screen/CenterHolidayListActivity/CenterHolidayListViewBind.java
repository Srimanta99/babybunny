package com.baby.bunny.student.management.screen.CenterHolidayListActivity;

import android.view.View;

import androidx.recyclerview.widget.RecyclerView;

import com.baby.bunny.student.management.R;
import com.baby.bunny.student.management.screen.CenterStudentActivity.CenterStudentActivity;
import com.rts.commonutils_2_0.deviceinfo.DeviceResolution;

public class CenterHolidayListViewBind extends DeviceResolution {
    CenterHolidayListActivity centerHolidayListActivity;
    View view;
    RecyclerView rvidholidaylist;

    public CenterHolidayListViewBind( CenterHolidayListActivity centerHolidayListActivity, View view) {
        super(centerHolidayListActivity);
        this.centerHolidayListActivity=centerHolidayListActivity;
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
        rvidholidaylist=view.findViewById(R.id.rvidholidaylist);

        // btn_hello_wrold=view.findViewById(R.id.btn_hello_wrold) ;
    }
}


