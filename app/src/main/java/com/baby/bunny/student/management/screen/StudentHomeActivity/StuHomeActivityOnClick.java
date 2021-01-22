package com.baby.bunny.student.management.screen.StudentHomeActivity;

import android.content.Intent;
import android.view.Gravity;
import android.view.View;

import androidx.core.view.GravityCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.baby.bunny.student.management.R;
import com.baby.bunny.student.management.screen.CenterManagerLoginActivity.CenterManagerLoginActivity;
import com.baby.bunny.student.management.screen.Fragment.ChangePassword.ChangePasswordFragment;
import com.baby.bunny.student.management.screen.Fragment.ParentCounseling.ParentCounselingFragment;
import com.baby.bunny.student.management.screen.Fragment.ParentsZone.ParentsZoneFragment;
import com.baby.bunny.student.management.screen.Fragment.Profile.ProfileFragment;
import com.baby.bunny.student.management.screen.StudentLoginActivity.StudentLoginActivity;
import com.baby.bunny.student.management.utils.SessionManager;

public class StuHomeActivityOnClick extends StudentHomeActivity implements View.OnClickListener{
    StudentHomeActivity stu_home_activity;
    StuHomeActivityViewBind stuHomeActivityViewBind;

    public StuHomeActivityOnClick(StudentHomeActivity stu_home_activity, StuHomeActivityViewBind stuHomeActivityViewBind) {
        this.stu_home_activity=stu_home_activity;
        this.stuHomeActivityViewBind=stuHomeActivityViewBind;


        setonclicklistner();



    }
    // set click listner.
    public void setonclicklistner() {
        stuHomeActivityViewBind.homeid.setOnClickListener(this);
        stuHomeActivityViewBind.menuIcon.setOnClickListener(this);
        stuHomeActivityViewBind.logoutid.setOnClickListener(this);
        stuHomeActivityViewBind.parent_counseling_id.setOnClickListener(this);
        stuHomeActivityViewBind.change_passwordid.setOnClickListener(this);

        stuHomeActivityViewBind.profilelinearlayoutid.setOnClickListener(this);
    }

    @Override
    public void onBackPressed(){

        if (stuHomeActivityViewBind.drawer.isDrawerOpen(GravityCompat.START)) {
            stuHomeActivityViewBind.drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.homeid:{
                loadFragment(new ParentsZoneFragment());
                stuHomeActivityViewBind.parentzoneid.setText("Parent's Zone");

                closeDrawer();
            }
            break;
            case R.id.menu_icon:
                stuHomeActivityViewBind.drawer.openDrawer(Gravity.LEFT);


                break;

            case R.id.logoutid:

                SessionManager.setLogged(false);
                closeDrawer();
                Intent intent=new Intent(stu_home_activity,StudentLoginActivity.class);

                stu_home_activity.startActivity(intent);
              //  stu_home_activity.startActivity(new Intent(stu_home_activity, StudentLoginActivity.class));

                stu_home_activity.   finish();

                break;

            case R.id.parent_counseling_id:{
                loadFragment(new ParentCounselingFragment());
                stuHomeActivityViewBind.parentzoneid.setText("Parent's Counseling");



                closeDrawer();
            }
            break;

            case    R.id.change_passwordid:{

                loadFragment(new ChangePasswordFragment());
                stuHomeActivityViewBind.parentzoneid.setText("Change Password");
            //    stuHomeActivityViewBind.menuIcon.setImageResource(R.drawable.backbuttn);

               /* stuHomeActivityViewBind.menuIcon.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        stu_home_activity.onBackButtonPressed();

                        stuHomeActivityViewBind.menuIcon.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                stuHomeActivityViewBind.drawer.openDrawer(Gravity.LEFT);
                            }
                        });
                    }
                });*/

                closeDrawer();
            }
            break;

            case   R.id.profilelinearlayoutid:{

                loadFragment(new ProfileFragment());
                stuHomeActivityViewBind.parentzoneid.setText("Profile   ");

                closeDrawer();
            }
            break;


        }
    }

    public void closeDrawer() {
        if (stuHomeActivityViewBind.drawer.isDrawerOpen(GravityCompat.START)) {
            stuHomeActivityViewBind.drawer.closeDrawer(GravityCompat.START);
        }
    }

    public void loadFragment(Fragment fragment) {
        FragmentTransaction transaction =stu_home_activity.getSupportFragmentManager().beginTransaction();

        // Replace whatever is in the fragment_container view with this fragment,
        // and add the transaction to the back stack so the user can navigate back
        transaction.replace(R.id.fragmentid, fragment);
        transaction.addToBackStack(null);

        // Commit the transaction
        transaction.commit();

    }



}

