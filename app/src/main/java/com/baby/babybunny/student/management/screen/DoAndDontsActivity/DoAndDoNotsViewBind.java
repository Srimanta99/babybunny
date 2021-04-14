package com.baby.babybunny.student.management.screen.DoAndDontsActivity;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.baby.babybunny.student.management.R;
import com.rts.commonutils_2_0.deviceinfo.DeviceResolution;

public class DoAndDoNotsViewBind extends DeviceResolution {
    DoAndDoNotsActivity doAndDoNotsActivity;
    View view;
    RecyclerView recyclerView;
    ImageView back_icon;
    LinearLayout nodatafoundlvid,progresslvid;
    TextView toolname_id;


    public DoAndDoNotsViewBind(DoAndDoNotsActivity doAndDoNotsActivity, View view) {
        super(doAndDoNotsActivity);
        this.doAndDoNotsActivity=doAndDoNotsActivity;
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
        back_icon =view.findViewById(R.id.back_icon);
        progresslvid=view.findViewById(R.id.progresslvid);
        nodatafoundlvid=view.findViewById(R.id.nodatafoundlvid);
        toolname_id=view.findViewById(R.id.toolname_id);

        // btn_hello_wrold=view.findViewById(R.id.btn_hello_wrold) ;
    }
}
