package com.baby.babybunny.student.management.screen.TeacherFragment.TeacherHomeFragment;

import android.content.Intent;
import android.view.View;

import com.baby.babybunny.student.management.R;
import com.baby.babybunny.student.management.screen.StudentCompanyAchievmentActivity.StudentCompanyAchievmentActivity;
import com.baby.babybunny.student.management.screen.StudentHolidayActivity.Student_HolidayList_Activity;
import com.baby.babybunny.student.management.screen.TeacherAttendenceActivity.TeacherAttendenceActivity;
import com.baby.babybunny.student.management.screen.TeacherEducationActivity;
import com.baby.babybunny.student.management.screen.TeacherFeedbacklistActivity;
import com.baby.babybunny.student.management.screen.TeacherHomeTaskActivity.TeacherHomeTaskActivity;
import com.baby.babybunny.student.management.screen.TeacherNotificationActivity;
import com.baby.babybunny.student.management.screen.TeacherStudentsActivity.TeacherStudentsActivity;
import com.baby.babybunny.student.management.screen.TeacherTodaysClass.TeacherTodaysClass;
import com.baby.babybunny.student.management.screen.UpcomingEventActivity.UpcomingEventsActivity;

public class TeacherHomeFragmentOnclick implements View.OnClickListener{
    TeacherHomeFragment teacherHomeFragment;
    TeacherHomeFragmentViewBind teacherHomeFragmentViewBind;

    public TeacherHomeFragmentOnclick(TeacherHomeFragment teacherHomeFragment, TeacherHomeFragmentViewBind teacherHomeFragmentViewBind) {
        this.teacherHomeFragment=teacherHomeFragment;
        this.teacherHomeFragmentViewBind=teacherHomeFragmentViewBind;
        setonclicklistner();
    }
    // set click listner.
    private void setonclicklistner() {
        teacherHomeFragmentViewBind.lvidholidaylist.setOnClickListener(this);
        teacherHomeFragmentViewBind.lv_education.setOnClickListener(this);
       teacherHomeFragmentViewBind.lv_feedbacklist.setOnClickListener(this);

        teacherHomeFragmentViewBind.lvidCompanyAchievment.setOnClickListener(this);
        teacherHomeFragmentViewBind.lvidTodaysClass.setOnClickListener(this);
        teacherHomeFragmentViewBind.lvidCompanyAchievment.setOnClickListener(this);
        teacherHomeFragmentViewBind.lvupcomingeventsid.setOnClickListener(this);
        teacherHomeFragmentViewBind.lvidattendance.setOnClickListener(this);
        teacherHomeFragmentViewBind.lv_hometask.setOnClickListener(this);
        teacherHomeFragmentViewBind.lv_students.setOnClickListener(this);
        teacherHomeFragmentViewBind.lv_notifications.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.lvidholidaylist:{
                // Toast.makeText(mainActivity,"hello",Toast.LENGTH_LONG).show();

                Intent intent=new Intent(teacherHomeFragment.getActivity(), Student_HolidayList_Activity.class);
                teacherHomeFragment.getActivity().startActivity(intent);

            }
            break;
            case R.id.lv_education:{
                // Toast.makeText(mainActivity,"hello",Toast.LENGTH_LONG).show();


                Intent intent=new Intent(teacherHomeFragment.getContext(), TeacherEducationActivity.class);
                teacherHomeFragment.startActivity(intent);
            }
            break;

            case R.id.lv_feedbacklist:{
                Intent intent=new Intent(teacherHomeFragment.getContext(), TeacherFeedbacklistActivity.class);
                teacherHomeFragment.startActivity(intent);
            }
            break;

            case R.id.lvidCompanyAchievment:{
                Intent intent=new Intent(teacherHomeFragment.getContext(), StudentCompanyAchievmentActivity.class);
                teacherHomeFragment.startActivity(intent);
            }
            break;

            case R.id.lv_notifications:{
                Intent intent=new Intent(teacherHomeFragment.getContext(), TeacherNotificationActivity.class);
                teacherHomeFragment.startActivity(intent);
            }
            break;

            case R.id.lvidTodaysClass:{

                Intent intent=new Intent(teacherHomeFragment.getContext(), TeacherTodaysClass.class);
                teacherHomeFragment.startActivity(intent);
            }
            break;

            case R.id.lvupcomingeventsid:{
                Intent intent=new Intent(teacherHomeFragment.getContext(), UpcomingEventsActivity.class);
                teacherHomeFragment.startActivity(intent);
            }
            break;
            case R.id.lvidattendance:{
                Intent intent=new Intent(teacherHomeFragment.getContext(), TeacherAttendenceActivity.class);
                teacherHomeFragment.startActivity(intent);
            }
            break;

            case R.id.lv_hometask:{
                Intent intent=new Intent(teacherHomeFragment.getContext(), TeacherHomeTaskActivity.class);
                teacherHomeFragment.startActivity(intent);
            }
            break;

            case R.id.lv_students:{
                Intent intent=new Intent(teacherHomeFragment.getContext(), TeacherStudentsActivity.class);
                teacherHomeFragment.startActivity(intent);
            }
            break;
        }
    }
}
