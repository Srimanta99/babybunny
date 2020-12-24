package com.baby.bunny.student.management.screen.FragmentCenterManager.CenterManagerFragment;

import android.content.Intent;
import android.view.View;

import com.baby.bunny.student.management.R;
import com.baby.bunny.student.management.screen.CenterClassActivity.CenterClassActivity;
import com.baby.bunny.student.management.screen.CenterStudentActivity.CenterStudentActivity;
import com.baby.bunny.student.management.screen.CenterTeacherActivity.CenterTeacherActivity;
import com.baby.bunny.student.management.screen.Fragment.ParentsZone.ParentZoneViewBind;
import com.baby.bunny.student.management.screen.Fragment.ParentsZone.ParentsZoneFragment;
import com.baby.bunny.student.management.screen.StudentAttendanceActivity.StudentAttendanceActivity;
import com.baby.bunny.student.management.screen.StudentCompanyAchievmentActivity.StudentCompanyAchievmentActivity;
import com.baby.bunny.student.management.screen.StudentFeesBookAcivity.StudentFeesBookActivity;
import com.baby.bunny.student.management.screen.StudentHolidayActivity.Student_HolidayList_Activity;
import com.baby.bunny.student.management.screen.StudentQueryActivity.Student_Query_Activity;
import com.baby.bunny.student.management.screen.StudentReviewActivity.StudentReviewActivity;
import com.baby.bunny.student.management.screen.StudentTodaysClassActivity.StudentTodaysClass;
import com.baby.bunny.student.management.screen.UpcomingEventActivity.UpcomingEventsActivity;

public class CerterManagerFragmentOnClick implements View.OnClickListener{
    CerterManagerFragment certerManagerFragment;
    CerterManagerFragmentViewBind certerManagerFragmentViewBind;

    public CerterManagerFragmentOnClick(CerterManagerFragment certerManagerFragment,  CerterManagerFragmentViewBind certerManagerFragmentViewBind) {
        this.certerManagerFragment=certerManagerFragment;
        this.certerManagerFragmentViewBind=certerManagerFragmentViewBind;
        setonclicklistner();
    }
    // set click listner.
    private void setonclicklistner() {
        certerManagerFragmentViewBind.lvidstudents.setOnClickListener(this);
        certerManagerFragmentViewBind.lvidteachers.setOnClickListener(this);
        certerManagerFragmentViewBind.classlvid.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.lvidstudents:{
                // Toast.makeText(mainActivity,"hello",Toast.LENGTH_LONG).show();

                Intent intent=new Intent(certerManagerFragment.getActivity(), CenterStudentActivity.class);
                certerManagerFragment.getActivity().startActivity(intent);

            }
            break;
            case R.id.lvidteachers:{
                // Toast.makeText(mainActivity,"hello",Toast.LENGTH_LONG).show();


                Intent intent=new Intent(certerManagerFragment.getContext(), CenterTeacherActivity.class);
                certerManagerFragment.startActivity(intent);
            }
            break;
            case R.id.classlvid:{
                // Toast.makeText(mainActivity,"hello",Toast.LENGTH_LONG).show();


                Intent intent=new Intent(certerManagerFragment.getContext(), CenterClassActivity.class);
                certerManagerFragment.startActivity(intent);
            }
            break;


        }
    }
}
