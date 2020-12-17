package com.baby.bunny.student.management.screen.Fragment.ParentCounseling;

import android.content.Intent;
import android.view.View;

import com.baby.bunny.student.management.R;
import com.baby.bunny.student.management.screen.Fragment.ParentsZone.ParentZoneViewBind;
import com.baby.bunny.student.management.screen.Fragment.ParentsZone.ParentsZoneFragment;
import com.baby.bunny.student.management.screen.PdfActivity;
import com.baby.bunny.student.management.screen.StudentCompanyAchievmentActivity.StudentCompanyAchievmentActivity;
import com.baby.bunny.student.management.screen.StudentFeesBookAcivity.StudentFeesBookActivity;
import com.baby.bunny.student.management.screen.StudentHolidayActivity.Student_HolidayList_Activity;
import com.baby.bunny.student.management.screen.StudentQueryActivity.Student_Query_Activity;
import com.baby.bunny.student.management.screen.StudentReviewActivity.StudentReviewActivity;
import com.baby.bunny.student.management.screen.StudentTodaysClassActivity.StudentTodaysClass;

public class ParentCounselingOnClick implements View.OnClickListener{
    ParentCounselingFragment parentCounselingFragment;
    ParentCounselingViewBind parentCounselingViewBind;

    public ParentCounselingOnClick(ParentCounselingFragment parentCounselingFragment, ParentCounselingViewBind parentCounselingViewBind) {
        this.parentCounselingFragment=parentCounselingFragment;
        this.parentCounselingViewBind=parentCounselingViewBind;
        setonclicklistner();
    }
    // set click listner.
    private void setonclicklistner() {
        parentCounselingViewBind.pdfid.setOnClickListener(this);

    }


    public void onClick(View view) {
        switch (view.getId()){
            case R.id.pdfid:{
                // Toast.makeText(mainActivity,"hello",Toast.LENGTH_LONG).show();
                Intent intent=new Intent(parentCounselingFragment.getActivity(), PdfActivity.class);
                parentCounselingFragment.getActivity().startActivity(intent);


            }
            break;


        }
    }
}
