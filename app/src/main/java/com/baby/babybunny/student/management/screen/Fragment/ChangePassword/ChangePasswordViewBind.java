package com.baby.babybunny.student.management.screen.Fragment.ChangePassword;

import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;

import com.baby.babybunny.student.management.R;
import com.rts.commonutils_2_0.deviceinfo.DeviceResolution;

public class ChangePasswordViewBind extends DeviceResolution {
    ChangePasswordFragment changePasswordFragment;
    View view;
    ImageView show_pass_id,show_new_password_id,show_confirm_pass_id;
    EditText evpasswordid,et_show_new_password_id,et_show_confirm_pass_id;



    public ChangePasswordViewBind(ChangePasswordFragment changePasswordFragment, View view) {
        super(changePasswordFragment.getActivity());
        this.changePasswordFragment=changePasswordFragment;
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
        show_pass_id=view.findViewById(R.id.show_pass_id);
        evpasswordid=view.findViewById(R.id.evpasswordid);

        et_show_new_password_id=view.findViewById(R.id.et_show_new_password_id);
        show_new_password_id=view.findViewById(R.id.show_new_password_id);

        et_show_confirm_pass_id= view.findViewById(R.id.et_show_confirm_pass_id);

        show_confirm_pass_id=view.findViewById(R.id.show_confirm_pass_id);


    }
}
