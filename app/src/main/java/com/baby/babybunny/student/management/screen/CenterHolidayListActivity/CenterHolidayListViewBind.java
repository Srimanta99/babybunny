package com.baby.babybunny.student.management.screen.CenterHolidayListActivity;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.baby.babybunny.student.management.R;
import com.rts.commonutils_2_0.deviceinfo.DeviceResolution;

public class CenterHolidayListViewBind extends DeviceResolution {
    CenterHolidayListActivity centerHolidayListActivity;
    View view;
    RecyclerView rvidholidaylist;
    ImageView back_icon;
    TextView toolname_id;

    LinearLayout progresslvid,nodatafoundlvid;


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
        back_icon=view.findViewById(R.id.back_icon);
        nodatafoundlvid=view.findViewById(R.id.nodatafoundlvid);
        progresslvid=view.findViewById(R.id.progresslvid);
        toolname_id=view.findViewById(R.id.toolname_id);


        // btn_hello_wrold=view.findViewById(R.id.btn_hello_wrold) ;
    }
}


