package com.baby.babybunny.student.management.screen.FragmentCenterManager.CenterManagerFragment;

import android.content.Intent;
import android.view.View;

import com.baby.babybunny.student.management.R;
import com.baby.babybunny.student.management.screen.CenterClassActivity.CenterClassActivity;
import com.baby.babybunny.student.management.screen.CenterFeedbacklistActivity.CenterFeedbacklistActivity;
import com.baby.babybunny.student.management.screen.CenterHolidayListActivity.CenterHolidayListActivity;
import com.baby.babybunny.student.management.screen.CenterHomeTaskActivity.CenterHomeTaskActivity;
import com.baby.babybunny.student.management.screen.CenterStudentActivity.CenterStudentActivity;
import com.baby.babybunny.student.management.screen.CenterStudentsFeesActivity.CenterStudentsFeesActivity;
import com.baby.babybunny.student.management.screen.CenterTeacherActivity.CenterTeacherActivity;
import com.baby.babybunny.student.management.screen.CenterTodayActivity.CenterTodayActivity;

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
        certerManagerFragmentViewBind.lvidholidaylist.setOnClickListener(this);
        certerManagerFragmentViewBind.lvstudentsfeesid.setOnClickListener(this);
        certerManagerFragmentViewBind.lvidFeedbacklist.setOnClickListener(this);
        certerManagerFragmentViewBind.lvidhometask.setOnClickListener(this);
        certerManagerFragmentViewBind.lvidtoday.setOnClickListener(this);

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

            case R.id.lvidholidaylist:{
                Intent intent=new Intent(certerManagerFragment.getContext(), CenterHolidayListActivity.class);
                certerManagerFragment.startActivity(intent);
            }
            break;

            case R.id.lvstudentsfeesid :{
                Intent intent=new Intent(certerManagerFragment.getContext(), CenterStudentsFeesActivity.class);
                certerManagerFragment.startActivity(intent);
            }
            break;
            case R.id.lvidhometask :{
                Intent intent=new Intent(certerManagerFragment.getContext(), CenterHomeTaskActivity.class);
                certerManagerFragment.startActivity(intent);
            }
            break;

            case R.id.lvidtoday :{
                Intent intent=new Intent(certerManagerFragment.getContext(), CenterTodayActivity.class);
                certerManagerFragment.startActivity(intent);
            }
            break;

            case R.id.lvidFeedbacklist :{
                Intent intent=new Intent(certerManagerFragment.getContext(), CenterFeedbacklistActivity.class);
                certerManagerFragment.startActivity(intent);
            }
            break;


        }
    }
}
