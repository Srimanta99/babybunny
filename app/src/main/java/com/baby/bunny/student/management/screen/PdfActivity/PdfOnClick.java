package com.baby.bunny.student.management.screen.PdfActivity;

import android.content.Intent;
import android.view.View;

import com.baby.bunny.student.management.R;
import com.baby.bunny.student.management.screen.StudentLoginActivity.StudentLoginActivity;
import com.baby.bunny.student.management.screen.main.MainActivity;
import com.baby.bunny.student.management.screen.main.MainActivityViewBind;

public class PdfOnClick implements View.OnClickListener{
    PdfActivity pdfActivity;
    PdfViewBind pdfViewBind;

    public PdfOnClick(PdfActivity pdfActivity,  PdfViewBind pdfViewBind) {
        this.pdfActivity=pdfActivity;
        this.pdfViewBind=pdfViewBind;
        setonclicklistner();
    }
    // set click listner.
    private void setonclicklistner() {
     //   mainActivityViewBind.studentlvid.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.studentlvid:{
                // Toast.makeText(mainActivity,"hello",Toast.LENGTH_LONG).show();

                //  mainActivity.finish();
            }
            break;
        }
    }
}

