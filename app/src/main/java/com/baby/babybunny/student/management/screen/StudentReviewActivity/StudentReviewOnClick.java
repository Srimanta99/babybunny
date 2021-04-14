package com.baby.babybunny.student.management.screen.StudentReviewActivity;

import android.view.View;

import com.baby.babybunny.student.management.R;

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
