package com.baby.babybunny.student.management.screen.PdfActivity;

import android.view.View;
import android.widget.ImageView;

import com.baby.babybunny.student.management.R;
import com.rts.commonutils_2_0.deviceinfo.DeviceResolution;

public class PdfViewBind extends DeviceResolution {
    PdfActivity pdfActivity;
    View view;
ImageView back_icon;
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
        back_icon=view.findViewById(R.id.back_icon);
        // btn_hello_wrold=view.findViewById(R.id.btn_hello_wrold) ;
    }
}
