package com.baby.babybunny.student.management.screen.Fragment.Profile;

import android.view.View;

import com.baby.babybunny.student.management.R;

public class ProfileOnClick implements View.OnClickListener{
    ProfileFragment profileFragment;
    ProfileViewBind profileViewBind;

    public ProfileOnClick(ProfileFragment profileFragment, ProfileViewBind profileViewBind) {
        this.profileFragment=profileFragment;
        this.profileViewBind=profileViewBind;
        setonclicklistner();
    }
    // set click listner.
    private void setonclicklistner() {
        profileViewBind.imageiconid.setOnClickListener(this);
profileViewBind.tvsubmmitid.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.imageiconid:{
                // Toast.makeText(mainActivity,"hello",Toast.LENGTH_LONG).show();

        //     profileFragment.showPictureDialog();

            }
            break;

           /* case R.id.tvsubmmitid:{
                profileFragment. OwnerDetailsloaddata(profileFragment.id);
            }
*/
        }
    }
}
