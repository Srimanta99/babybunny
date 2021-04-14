package com.baby.babybunny.student.management.screen.TeacherHomeActivity;

import android.content.Intent;
import android.view.Gravity;
import android.view.View;

import androidx.core.view.GravityCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.baby.babybunny.student.management.R;
import com.baby.babybunny.student.management.screen.StudentHomeActivity.StudentHomeActivity;
import com.baby.babybunny.student.management.screen.TeacherFragment.TeacherHomeFragment.TeacherHomeFragment;
import com.baby.babybunny.student.management.screen.TeacherLoginActivity.TeacherLoginActivity;
import com.baby.babybunny.student.management.utils.SessionManager;

public class TeacherHomeOnClick extends StudentHomeActivity implements View.OnClickListener{
    TeacherHomeActivity teacherHomeActivity;
    TeacherHomeViewBind teacherHomeViewBind;

    public TeacherHomeOnClick(TeacherHomeActivity teacherHomeActivity, TeacherHomeViewBind teacherHomeViewBind) {
        this.teacherHomeActivity=teacherHomeActivity;
        this.teacherHomeViewBind=teacherHomeViewBind;


        setonclicklistner();



    }
    // set click listner.
    public void setonclicklistner() {
        teacherHomeViewBind.homeid.setOnClickListener(this);
        teacherHomeViewBind.menuIcon.setOnClickListener(this);
        teacherHomeViewBind.logoutid.setOnClickListener(this);

    }

    @Override
    public void onBackPressed(){

        if (teacherHomeViewBind.drawer.isDrawerOpen(GravityCompat.START)) {
            teacherHomeViewBind.drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.homeid:{
                loadFragment(new TeacherHomeFragment());
                teacherHomeViewBind.tv_teacher.setText("Teacher");
                closeDrawer();
            }
            break;
            case R.id.menu_icon:
                teacherHomeViewBind.drawer.openDrawer(Gravity.LEFT);
                break;

            case R.id.logoutid:

                SessionManager.setTeacherLogged(false);
                closeDrawer();
                Intent intent=new Intent(teacherHomeActivity, TeacherLoginActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                teacherHomeActivity.startActivity(intent);

                break;
        }
    }

    public void closeDrawer() {
        if (teacherHomeViewBind.drawer.isDrawerOpen(GravityCompat.START)) {
            teacherHomeViewBind.drawer.closeDrawer(GravityCompat.START);
        }
    }

    public void loadFragment(Fragment fragment) {
        FragmentTransaction transaction =teacherHomeActivity.getSupportFragmentManager().beginTransaction();

        // Replace whatever is in the fragment_container view with this fragment,
        // and add the transaction to the back stack so the user can navigate back
        transaction.replace(R.id.fragmentid, fragment);
        transaction.addToBackStack(null);

        // Commit the transaction
        transaction.commit();

    }



}

