package com.baby.babybunny.student.management.screen.Fragment.ParentCounseling;

import android.view.View;
import android.widget.LinearLayout;

import com.baby.babybunny.student.management.R;
import com.rts.commonutils_2_0.deviceinfo.DeviceResolution;

public class ParentCounselingViewBind extends DeviceResolution {
    ParentCounselingFragment parentCounselingFragment;
    View view;

    LinearLayout pdfid,blogsid,videoclipsid,lvDoandDontsid;


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
        blogsid=view.findViewById(R.id.blogsid);
        videoclipsid=view.findViewById(R.id.videoclipsid);
        lvDoandDontsid=view.findViewById(R.id.lvDoandDontsid);

    }
}

