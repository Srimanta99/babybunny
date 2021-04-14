package com.baby.babybunny.student.management.screen.main;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.baby.babybunny.student.management.R;

import org.jsoup.Jsoup;

public class MainActivity extends AppCompatActivity {
    MainActivityViewBind mainActivityViewBind;
    MainActivityOnClick mainActivityOnClick;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        View view= LayoutInflater.from(this).inflate(R.layout.activity_main,null);
        setContentView(view);
        mainActivityViewBind= new MainActivityViewBind(this,view);
        mainActivityOnClick=new MainActivityOnClick(this,mainActivityViewBind);


    }


}
