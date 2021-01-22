package com.baby.bunny.student.management.screen.Fragment.ParentsZone;

import android.content.Context;
import android.view.View;
import android.widget.LinearLayout;

import com.baby.bunny.student.management.R;
import com.baby.bunny.student.management.screen.main.MainActivity;
import com.rts.commonutils_2_0.deviceinfo.DeviceResolution;

public class ParentZoneViewBind extends DeviceResolution {
    ParentsZoneFragment parentsZoneFragment;
    View view;

    LinearLayout lvidattendance,lvidholidaylist,lvidquery,lvidreview,lvidfeesbook,lvidCompanyAchievment,lvidTodaysClass,lvupcomingeventsid;


    public ParentZoneViewBind(ParentsZoneFragment parentsZoneFragment, View view) {
        super(parentsZoneFragment.getActivity());
        this.parentsZoneFragment=parentsZoneFragment;
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
        lvidattendance=view.findViewById(R.id.lvidattendance);
        lvidholidaylist=view.findViewById(R.id.lvidholidaylist);
        lvidquery=view.findViewById(R.id.lvidquery);
        lvidreview=view.findViewById(R.id.lvidreview);
        lvidfeesbook=view.findViewById(R.id.lvidfeesbook);
        lvidCompanyAchievment=view.findViewById(R.id.lvidCompanyAchievment);
        lvidTodaysClass=view.findViewById(R.id.lvidTodaysClass);
        lvupcomingeventsid=view.findViewById(R.id.lvupcomingeventsid);
    }
}
