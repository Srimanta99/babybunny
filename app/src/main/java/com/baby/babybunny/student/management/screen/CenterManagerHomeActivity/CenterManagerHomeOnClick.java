package com.baby.babybunny.student.management.screen.CenterManagerHomeActivity;

import android.content.Intent;
import android.view.Gravity;
import android.view.View;

import androidx.core.view.GravityCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.baby.babybunny.student.management.R;
import com.baby.babybunny.student.management.screen.CenterManagerLoginActivity.CenterManagerLoginActivity;
import com.baby.babybunny.student.management.screen.FragmentCenterManager.CenterManagerFragment.CerterManagerFragment;
import com.baby.babybunny.student.management.screen.StudentHomeActivity.StudentHomeActivity;
import com.baby.babybunny.student.management.utils.SessionManager;

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
          centerManagerHomeViewBind.logoutid.setOnClickListener(this);

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
                centerManagerHomeViewBind.parentzoneid.setText("Center Manager");
                closeDrawer();
            }
            break;
            case R.id.menu_icon:
                centerManagerHomeViewBind.drawer.openDrawer(Gravity.LEFT);
                break;

            case R.id.logoutid:

                SessionManager.setCenterManagerLogged(false);
                closeDrawer();
                Intent intent=new Intent(centerManagerHomeActivity, CenterManagerLoginActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                centerManagerHomeActivity.startActivity(intent);

           //     centerManagerHomeActivity.startActivity(new Intent(centerManagerHomeActivity, CenterManagerLoginActivity.class));
           //     finish();

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

