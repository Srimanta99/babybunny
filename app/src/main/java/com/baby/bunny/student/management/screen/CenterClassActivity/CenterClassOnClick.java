package com.baby.bunny.student.management.screen.CenterClassActivity;

import android.view.View;

import com.baby.bunny.student.management.screen.CenterStudentActivity.CenterStudentActivity;
import com.baby.bunny.student.management.screen.CenterStudentActivity.CenterStudentViewBind;

public class CenterClassOnClick implements View.OnClickListener{
    CenterClassActivity centerClassActivity;
    CenterClassViewBind centerClassViewBind;

    public CenterClassOnClick(CenterClassActivity centerClassActivity,CenterClassViewBind centerClassViewBind) {
        this.centerClassActivity=centerClassActivity;
        this.centerClassViewBind=centerClassViewBind;
        setonclicklistner();
    }
    // set click listner.
    private void setonclicklistner() {
        //  mainActivityViewBind.studentlvid.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
        /*    case R.id.studentlvid:{
                // Toast.makeText(mainActivity,"hello",Toast.LENGTH_LONG).show();
                Intent mainIntent = new Intent(mainActivity, StudentLoginActivity.class);
                mainActivity.startActivity(mainIntent);
                //  mainActivity.finish();
            }
            break;
*/

        }
    }
}

