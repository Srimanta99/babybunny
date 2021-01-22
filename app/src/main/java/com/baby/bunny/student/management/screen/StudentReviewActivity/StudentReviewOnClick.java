package com.baby.bunny.student.management.screen.StudentReviewActivity;

import android.content.Intent;
import android.view.View;

import com.baby.bunny.student.management.R;
import com.baby.bunny.student.management.screen.StudentLoginActivity.StudentLoginActivity;
import com.baby.bunny.student.management.screen.main.MainActivity;
import com.baby.bunny.student.management.screen.main.MainActivityViewBind;

public class StudentReviewOnClick implements View.OnClickListener{
    StudentReviewActivity studentReviewActivity;
    StudentReviewViewBind studentReviewViewBind;

    public StudentReviewOnClick(StudentReviewActivity studentReviewActivity, StudentReviewViewBind studentReviewViewBind) {
        this.studentReviewActivity=studentReviewActivity;
        this.studentReviewViewBind=studentReviewViewBind;
        setonclicklistner();
    }
    // set click listner.
    private void setonclicklistner() {

        studentReviewViewBind.back_icon.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.back_icon:{
                studentReviewActivity.onBackPressed();

            }
            break;
        }
    }
}
