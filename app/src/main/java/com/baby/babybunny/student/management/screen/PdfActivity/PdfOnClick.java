package com.baby.babybunny.student.management.screen.PdfActivity;

import android.view.View;

import com.baby.babybunny.student.management.R;

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
        pdfViewBind.back_icon.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.studentlvid:{
                // Toast.makeText(mainActivity,"hello",Toast.LENGTH_LONG).show();

                //  mainActivity.finish();
            }
            break;

            case R.id.back_icon:{
                pdfActivity.onBackPressed();
            }
            break;
        }
    }
}

