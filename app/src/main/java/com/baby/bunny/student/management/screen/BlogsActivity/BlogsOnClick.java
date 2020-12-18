package com.baby.bunny.student.management.screen.BlogsActivity;

import android.content.Intent;
import android.view.View;

import com.baby.bunny.student.management.R;
import com.baby.bunny.student.management.screen.PreSchoolActivity.PreSchoolActivity;
import com.baby.bunny.student.management.screen.StudentLoginActivity.StudentLoginActivity;
import com.baby.bunny.student.management.screen.main.MainActivity;
import com.baby.bunny.student.management.screen.main.MainActivityViewBind;

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
