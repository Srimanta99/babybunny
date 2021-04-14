package com.baby.babybunny.student.management.screen.BlogsActivity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;

import com.baby.babybunny.student.management.R;

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

        blogsViewBind. toolname_id.setText("Blogs");
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