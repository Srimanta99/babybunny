package com.baby.bunny.student.management.screen.PdfActivity;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.baby.bunny.student.management.R;


public class PdfActivity extends AppCompatActivity {
    PdfViewBind pdfViewBind;
    PdfOnClick pdfOnClick;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        View view= LayoutInflater.from(this).inflate(R.layout.activity_pdf,null);
        setContentView(view);

        pdfViewBind= new PdfViewBind(this,view);
        pdfOnClick=new PdfOnClick(this,pdfViewBind);

    }
}