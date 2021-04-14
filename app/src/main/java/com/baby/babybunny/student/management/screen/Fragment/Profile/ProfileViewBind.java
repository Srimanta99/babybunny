package com.baby.babybunny.student.management.screen.Fragment.Profile;

import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.baby.babybunny.student.management.R;
import com.rts.commonutils_2_0.deviceinfo.DeviceResolution;

public class ProfileViewBind extends DeviceResolution {
    ProfileFragment profileFragment;
    View view;

    EditText etnameid,et_email_id,et_ph_no_id;
    TextView tvsubmmitid;
    ImageView imageiconid;

    public ProfileViewBind(ProfileFragment profileFragment, View view) {
        super(profileFragment.getActivity());
        this.profileFragment=profileFragment;
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
        etnameid=view.findViewById(R.id.etnameid);
        et_email_id=view.findViewById(R.id.et_email_id);
        et_ph_no_id=view.findViewById(R.id.et_ph_no_id);
        tvsubmmitid=view.findViewById(R.id.tvsubmmitid);
        imageiconid=view.findViewById(R.id.imageiconid);

    }
}

