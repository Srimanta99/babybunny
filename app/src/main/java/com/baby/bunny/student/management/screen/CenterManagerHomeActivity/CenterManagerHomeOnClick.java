package com.baby.bunny.student.management.screen.CenterManagerHomeActivity;

import android.content.Intent;
import android.view.Gravity;
import android.view.View;

import androidx.core.view.GravityCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.baby.bunny.student.management.R;
import com.baby.bunny.student.management.screen.Fragment.ChangePassword.ChangePasswordFragment;
import com.baby.bunny.student.management.screen.Fragment.ParentCounseling.ParentCounselingFragment;
import com.baby.bunny.student.management.screen.Fragment.ParentsZone.ParentsZoneFragment;
import com.baby.bunny.student.management.screen.Fragment.Profile.ProfileFragment;
import com.baby.bunny.student.management.screen.FragmentCenterManager.CenterManagerFragment.CerterManagerFragment;
import com.baby.bunny.student.management.screen.StudentHomeActivity.StuHomeActivityViewBind;
import com.baby.bunny.student.management.screen.StudentHomeActivity.StudentHomeActivity;
import com.baby.bunny.student.management.screen.StudentLoginActivity.StudentLoginActivity;
import com.baby.bunny.student.management.utils.SessionManager;

public class CenterManagerHomeOnClick extends StudentHomeActivity implements View.OnClickListener{
    CenterManagerHomeActivity centerManagerHomeActivity;
    CenterManagerHomeViewBind centerManagerHomeViewBind;

    public CenterManagerHomeOnClick(CenterManagerHomeActivity centerManagerHomeActivity,CenterManagerHomeViewBind centerManagerHomeViewBind) {
        this.centerManagerHomeActivity=centerManagerHomeActivity;
        this.centerManagerHomeViewBind=centerManagerHomeViewBind;


        setonclicklistner();



    }
    // set click listner.
    public void setonclicklistner() {
        centerManagerHomeViewBind.homeid.setOnClickListener(this);
        centerManagerHomeViewBind.menuIcon.setOnClickListener(this);


    }

    @Override
    public void onBackPressed(){

        if (centerManagerHomeViewBind.drawer.isDrawerOpen(GravityCompat.START)) {
            centerManagerHomeViewBind.drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.homeid:{
                loadFragment(new CerterManagerFragment());
                stuHomeActivityViewBind.parentzoneid.setText("Center Manager");
                closeDrawer();
            }
            break;
            case R.id.menu_icon:
                centerManagerHomeViewBind.drawer.openDrawer(Gravity.LEFT);
                break;


        }
    }

    public void closeDrawer() {
        if (centerManagerHomeViewBind.drawer.isDrawerOpen(GravityCompat.START)) {
            centerManagerHomeViewBind.drawer.closeDrawer(GravityCompat.START);
        }
    }

    public void loadFragment(Fragment fragment) {
        FragmentTransaction transaction =centerManagerHomeActivity.getSupportFragmentManager().beginTransaction();

        // Replace whatever is in the fragment_container view with this fragment,
        // and add the transaction to the back stack so the user can navigate back
        transaction.replace(R.id.fragmentid, fragment);
        transaction.addToBackStack(null);

        // Commit the transaction
        transaction.commit();

    }



}

