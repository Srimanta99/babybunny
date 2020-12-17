package com.baby.bunny.student.management.screen.Fragment.ParentCounseling;

import android.view.View;
import android.widget.LinearLayout;

import com.baby.bunny.student.management.R;
import com.baby.bunny.student.management.screen.Fragment.ParentsZone.ParentsZoneFragment;
import com.rts.commonutils_2_0.deviceinfo.DeviceResolution;

public class ParentCounselingViewBind extends DeviceResolution {
    ParentCounselingFragment parentCounselingFragment;
    View view;

    LinearLayout pdfid;


    public ParentCounselingViewBind(ParentCounselingFragment parentCounselingFragment, View view) {
        super(parentCounselingFragment.getActivity());
        this.parentCounselingFragment=parentCounselingFragment;
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
        pdfid=view.findViewById(R.id.pdfid);

    }
}

