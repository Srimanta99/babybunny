package com.baby.bunny.student.management.screen.BlogsActivity;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.baby.bunny.student.management.R;
import com.baby.bunny.student.management.screen.main.MainActivity;
import com.rts.commonutils_2_0.deviceinfo.DeviceResolution;

public class BlogsViewBind extends DeviceResolution {
    BlogsActivity blogsActivity;
    View view;
    LinearLayout lvpreschoolid;
    ImageView back_icon;

    public BlogsViewBind( BlogsActivity blogsActivity, View view) {
        super(blogsActivity);
        this.blogsActivity=blogsActivity;
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
        lvpreschoolid=view.findViewById(R.id.lvpreschoolid);
        back_icon =view.findViewById(R.id.back_icon);
        // btn_hello_wrold=view.findViewById(R.id.btn_hello_wrold) ;
    }
}