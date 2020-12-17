package com.baby.bunny.student.management.screen.Fragment.ParentsZone;

import android.content.Intent;
import android.view.View;

import com.baby.bunny.student.management.R;
import com.baby.bunny.student.management.screen.StudentCompanyAchievmentActivity.StudentCompanyAchievmentActivity;
import com.baby.bunny.student.management.screen.StudentHolidayActivity.Student_HolidayList_Activity;
import com.baby.bunny.student.management.screen.StudentQueryActivity.Student_Query_Activity;
import com.baby.bunny.student.management.screen.StudentReviewActivity.StudentReviewActivity;
import com.baby.bunny.student.management.screen.StudentFeesBookAcivity.StudentFeesBookActivity;
import com.baby.bunny.student.management.screen.StudentTodaysClassActivity.StudentTodaysClass;

public class ParentsZoneOnclick implements View.OnClickListener{
    ParentsZoneFragment parentsZoneFragment;
    ParentZoneViewBind parentZoneViewBind;

    public ParentsZoneOnclick(ParentsZoneFragment parentsZoneFragment, ParentZoneViewBind parentZoneViewBind) {
        this.parentsZoneFragment=parentsZoneFragment;
        this.parentZoneViewBind=parentZoneViewBind;
        setonclicklistner();
    }
    // set click listner.
    private void setonclicklistner() {
        parentZoneViewBind.lvidholidaylist.setOnClickListener(this);
        parentZoneViewBind.lvidquery.setOnClickListener(this);
        parentZoneViewBind.lvidreview.setOnClickListener(this);
        parentZoneViewBind.lvidfeesbook.setOnClickListener(this);
        parentZoneViewBind.lvidCompanyAchievment.setOnClickListener(this);
        parentZoneViewBind.lvidTodaysClass.setOnClickListener(this);
        parentZoneViewBind.lvidCompanyAchievment.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.lvidholidaylist:{
                // Toast.makeText(mainActivity,"hello",Toast.LENGTH_LONG).show();

                Intent intent=new Intent(parentsZoneFragment.getActivity(), Student_HolidayList_Activity.class);
                parentsZoneFragment.getActivity().startActivity(intent);

            }
            break;
            case R.id.lvidquery:{
                // Toast.makeText(mainActivity,"hello",Toast.LENGTH_LONG).show();


                Intent intent=new Intent(parentsZoneFragment.getContext(), Student_Query_Activity.class);
                parentsZoneFragment.startActivity(intent);
            }
            break;

            case R.id.lvidreview:{
                Intent intent=new Intent(parentsZoneFragment.getContext(), StudentReviewActivity.class);
                parentsZoneFragment.startActivity(intent);
            }
            break;

            case R.id.lvidfeesbook:{
                Intent intent=new Intent(parentsZoneFragment.getContext(), StudentFeesBookActivity.class);
                parentsZoneFragment.startActivity(intent);
            }
            break;
            case R.id.lvidCompanyAchievment:{
                Intent intent=new Intent(parentsZoneFragment.getContext(), StudentCompanyAchievmentActivity.class);
                parentsZoneFragment.startActivity(intent);
            }
            break;

            case R.id.lvidTodaysClass:{

                Intent intent=new Intent(parentsZoneFragment.getContext(), StudentTodaysClass.class);
                parentsZoneFragment.startActivity(intent);
            }

        }
    }
}
