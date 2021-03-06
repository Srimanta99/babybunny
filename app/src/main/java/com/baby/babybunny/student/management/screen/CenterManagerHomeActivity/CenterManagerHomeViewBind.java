package com.baby.babybunny.student.management.screen.CenterManagerHomeActivity;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.drawerlayout.widget.DrawerLayout;

import com.baby.babybunny.student.management.R;
import com.google.android.material.navigation.NavigationView;
import com.rts.commonutils_2_0.deviceinfo.DeviceResolution;

public class CenterManagerHomeViewBind extends DeviceResolution {
    CenterManagerHomeActivity centerManagerHomeActivity;
    View view;
    TextView homeid;
    public static TextView parentzoneid;
    public static ImageView menuIcon;
    LinearLayout logoutid,parent_counseling_id,change_passwordid,profilelinearlayoutid;
    DrawerLayout drawer;
    // ImageView menuIcon;
    NavigationView navigationView;
    TextView name,email_id;

    public CenterManagerHomeViewBind( CenterManagerHomeActivity centerManagerHomeActivity, View view) {
        super(centerManagerHomeActivity);
        this.centerManagerHomeActivity=centerManagerHomeActivity;
        this.view=view;
        initviewBind();
        setCustomTypeface();
    }

    // for adding custom typeface
    private void setCustomTypeface() {

    }

    // for findview
    public void initviewBind() {

        drawer =view.findViewById(R.id.drawer_layout);
        navigationView =view.findViewById(R.id.nav_view);
        menuIcon = view.findViewById(R.id.menu_icon);

        homeid=view. findViewById(R.id.homeid);
        logoutid=view. findViewById(R.id.logoutid);
        parent_counseling_id=view.findViewById(R.id.parent_counseling_id);

        parentzoneid=view.findViewById(R.id.parentzoneid);

        change_passwordid=view.findViewById(R.id.change_passwordid);
        profilelinearlayoutid=view.findViewById(R.id.profilelinearlayoutid);
        name=view.findViewById(R.id.name);
        email_id=view.findViewById(R.id.email_id);
    }
}