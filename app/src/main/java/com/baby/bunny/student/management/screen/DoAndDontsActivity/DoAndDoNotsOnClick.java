package com.baby.bunny.student.management.screen.DoAndDontsActivity;

import android.content.Intent;
import android.view.View;

import com.baby.bunny.student.management.R;
import com.baby.bunny.student.management.screen.StudentLoginActivity.StudentLoginActivity;
import com.baby.bunny.student.management.screen.main.MainActivity;
import com.baby.bunny.student.management.screen.main.MainActivityViewBind;

public class DoAndDoNotsOnClick implements View.OnClickListener{
    DoAndDoNotsActivity doAndDoNotsActivity;
    DoAndDoNotsViewBind doAndDoNotsViewBind;

    public DoAndDoNotsOnClick(DoAndDoNotsActivity doAndDoNotsActivity, DoAndDoNotsViewBind doAndDoNotsViewBind) {
        this.doAndDoNotsActivity=doAndDoNotsActivity;
        this.doAndDoNotsViewBind=doAndDoNotsViewBind;
        setonclicklistner();
    }
    // set click listner.
    private void setonclicklistner() {
        doAndDoNotsViewBind.recyclerView.setOnClickListener(this);
        doAndDoNotsViewBind.back_icon.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.back_icon:{
                // Toast.makeText(mainActivity,"hello",Toast.LENGTH_LONG).show();
               doAndDoNotsActivity.onBackPressed();
                //  mainActivity.finish();
            }
            break;
        }
    }
}
