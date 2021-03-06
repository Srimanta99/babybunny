package com.baby.babybunny.student.management.screen.BlogsActivity;

import android.content.Intent;
import android.view.View;

import com.baby.babybunny.student.management.R;

import com.baby.babybunny.student.management.screen.StudentPreSchoolActivity.PreSchoolActivity;

public class BlogsOnClick implements View.OnClickListener{
    BlogsActivity blogsActivity;
    BlogsViewBind blogsViewBind;

    public BlogsOnClick(BlogsActivity blogsActivity, BlogsViewBind blogsViewBind) {
        this.blogsActivity=blogsActivity;
        this.blogsViewBind=blogsViewBind;
        setonclicklistner();
    }
    // set click listner.
    private void setonclicklistner() {
        blogsViewBind.lvpreschoolid.setOnClickListener(this);
        blogsViewBind.back_icon.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.lvpreschoolid:{
                // Toast.makeText(mainActivity,"hello",Toast.LENGTH_LONG).show();
                Intent mainIntent = new Intent(blogsActivity, PreSchoolActivity.class);
                blogsActivity.startActivity(mainIntent);
                //  mainActivity.finish();
            }
            break;
            case R.id.back_icon:{
                blogsActivity.onBackPressed();
            }
            break;


        }
    }
}
