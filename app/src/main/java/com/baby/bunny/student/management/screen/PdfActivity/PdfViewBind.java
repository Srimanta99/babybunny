package com.baby.bunny.student.management.screen.PdfActivity;

import android.view.View;
import android.widget.LinearLayout;

import com.baby.bunny.student.management.R;
import com.baby.bunny.student.management.screen.main.MainActivity;
import com.rts.commonutils_2_0.deviceinfo.DeviceResolution;

public class PdfViewBind extends DeviceResolution {
    PdfActivity pdfActivity;
    View view;

    public PdfViewBind( PdfActivity pdfActivity, View view) {
        super(pdfActivity);
        this.pdfActivity=pdfActivity;
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
     //   studentlvid=view.findViewById(R.id.studentlvid);
        // btn_hello_wrold=view.findViewById(R.id.btn_hello_wrold) ;
    }
}
