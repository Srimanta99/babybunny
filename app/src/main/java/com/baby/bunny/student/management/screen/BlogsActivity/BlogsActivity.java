package com.baby.bunny.student.management.screen.BlogsActivity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;

import com.baby.bunny.student.management.R;
import com.baby.bunny.student.management.screen.main.MainActivityOnClick;
import com.baby.bunny.student.management.screen.main.MainActivityViewBind;

public class BlogsActivity extends AppCompatActivity {
    BlogsViewBind blogsViewBind;
    BlogsOnClick blogsOnClick;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        View view= LayoutInflater.from(this).inflate(R.layout.activity_blogs,null);
        setContentView(view);
        blogsViewBind= new BlogsViewBind(this,view);
        blogsOnClick=new BlogsOnClick(this,blogsViewBind);
    }
    @Override
    public void onBackPressed() {
        if (getFragmentManager().getBackStackEntryCount() > 0) {
            getFragmentManager().popBackStack();
        } else {
            super.onBackPressed();
        }
    }
}