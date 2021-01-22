package com.baby.bunny.student.management.screen.StudentCompanyAchievmentActivity;

import android.content.Intent;
import android.view.View;

import com.baby.bunny.student.management.R;
import com.baby.bunny.student.management.screen.StudentLoginActivity.StudentLoginActivity;
import com.baby.bunny.student.management.screen.main.MainActivity;
import com.baby.bunny.student.management.screen.main.MainActivityViewBind;

public class CompanyAchievmentOnClick implements View.OnClickListener{
    StudentCompanyAchievmentActivity studentCompanyAchievmentActivity;
    CompanyAchievementViewBind companyAchievementViewBind;

    public CompanyAchievmentOnClick(StudentCompanyAchievmentActivity studentCompanyAchievmentActivity, CompanyAchievementViewBind companyAchievementViewBind) {
        this.studentCompanyAchievmentActivity=studentCompanyAchievmentActivity;
        this.companyAchievementViewBind=companyAchievementViewBind;
        setonclicklistner();
    }
    // set click listner.
    private void setonclicklistner() {
      //  companyAchievementViewBind.studentlvid.setOnClickListener(this);

        companyAchievementViewBind.back_icon.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.back_icon:{
                studentCompanyAchievmentActivity.onBackPressed();
            }
            break;
        }
    }
}

