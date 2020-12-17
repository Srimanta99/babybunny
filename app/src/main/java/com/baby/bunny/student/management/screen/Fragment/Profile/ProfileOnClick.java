package com.baby.bunny.student.management.screen.Fragment.Profile;

import android.content.Intent;
import android.view.View;

import com.baby.bunny.student.management.R;
import com.baby.bunny.student.management.screen.Fragment.ParentsZone.ParentZoneViewBind;
import com.baby.bunny.student.management.screen.Fragment.ParentsZone.ParentsZoneFragment;
import com.baby.bunny.student.management.screen.StudentCompanyAchievmentActivity.StudentCompanyAchievmentActivity;
import com.baby.bunny.student.management.screen.StudentFeesBookAcivity.StudentFeesBookActivity;
import com.baby.bunny.student.management.screen.StudentHolidayActivity.Student_HolidayList_Activity;
import com.baby.bunny.student.management.screen.StudentQueryActivity.Student_Query_Activity;
import com.baby.bunny.student.management.screen.StudentReviewActivity.StudentReviewActivity;
import com.baby.bunny.student.management.screen.StudentTodaysClassActivity.StudentTodaysClass;

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

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.imageiconid:{
                // Toast.makeText(mainActivity,"hello",Toast.LENGTH_LONG).show();

             profileFragment.   showPictureDialog();

            }
            break;

        }
    }
}
