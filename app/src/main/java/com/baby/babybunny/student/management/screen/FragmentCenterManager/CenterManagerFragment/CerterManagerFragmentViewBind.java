package com.baby.babybunny.student.management.screen.FragmentCenterManager.CenterManagerFragment;

import android.view.View;
import android.widget.LinearLayout;

import com.baby.babybunny.student.management.R;
import com.rts.commonutils_2_0.deviceinfo.DeviceResolution;

public class CerterManagerFragmentViewBind extends DeviceResolution {
    CerterManagerFragment certerManagerFragment;
    View view;

    LinearLayout lvidstudents,lvidteachers,classlvid,lvidholidaylist,lvstudentsfeesid,lvidFeedbacklist,lvidtoday,lvidhometask;


    public CerterManagerFragmentViewBind( CerterManagerFragment certerManagerFragment, View view) {
        super(certerManagerFragment.getActivity());
        this.certerManagerFragment=certerManagerFragment;
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
        lvidstudents=view.findViewById(R.id.lvidstudents);
        lvidteachers=view.findViewById(R.id.lvidteachers);
        classlvid=view.findViewById(R.id.classlvid);
        lvidholidaylist=view.findViewById(R.id.lvidholidaylist);
        lvstudentsfeesid=view.findViewById(R.id.lvstudentsfeesid);
        lvidhometask=view.findViewById(R.id.lvidhometask);
        lvidFeedbacklist=view.findViewById(R.id.lvidFeedbacklist);
        lvidtoday=view.findViewById(R.id.lvidtoday);
    }
}

