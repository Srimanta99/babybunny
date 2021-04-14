package com.baby.babybunny.student.management.screen.StudentPreSchoolActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import com.baby.babybunny.student.management.R;

public class PreSchoolActivity extends AppCompatActivity {
ImageView back_icon;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pre_school);
        back_icon=findViewById(R.id.back_icon);

        back_icon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });
    }
}