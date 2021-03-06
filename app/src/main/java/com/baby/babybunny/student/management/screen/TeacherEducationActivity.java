package com.baby.babybunny.student.management.screen;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.baby.babybunny.student.management.R;

public class TeacherEducationActivity extends AppCompatActivity implements View.OnClickListener {
TextView toolname_id;
ImageView back_icon;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teacher_education);

        toolname_id=findViewById(R.id.toolname_id);
        back_icon=findViewById(R.id.back_icon);

        toolname_id.setText("Education");

        back_icon.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.back_icon:{
                onBackPressed();
            }
        }
    }
}