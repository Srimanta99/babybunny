package com.baby.babybunny.student.management.screen.StudentReviewActivity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.baby.babybunny.student.management.R;

import java.util.ArrayList;

public class StudentReviewActivity extends AppCompatActivity {

    StudentReviewViewBind studentReviewViewBind;
    StudentReviewOnClick studentReviewOnClick;

Spinner spinnerid;
String[] name;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        View view= LayoutInflater.from(this).inflate(R.layout.activity_student_review,null);
        setContentView(view);
        studentReviewViewBind= new StudentReviewViewBind(this,view);
        studentReviewOnClick=new StudentReviewOnClick(this,studentReviewViewBind);
        this.getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_PAN);

        studentReviewViewBind.toolname_id.setText("Review      ");


        spinnerid=findViewById(R.id.spinnerid);

        name=getResources().getStringArray(R.array.names);

        ArrayList<String> Sp_list= new ArrayList<>();
        Sp_list.clear();
        Sp_list.add("Center Manager");
        Sp_list.add("Corporate Office");
        Sp_list.add("Teacher");
        CustomAdapter adapter=new CustomAdapter(this,Sp_list);
        spinnerid.setAdapter(adapter);


    }



    @Override
    public void onBackPressed() {
        if (getFragmentManager().getBackStackEntryCount() > 0) {
            getFragmentManager().popBackStack();
        } else {
            super.onBackPressed();
        }
    }


    public class CustomAdapter extends BaseAdapter {
        Context context;
        ArrayList<String> extraList;
        LayoutInflater inflter;

        public CustomAdapter(Context applicationContext, ArrayList<String> extraList) {
            this.context = applicationContext;
            this.extraList = extraList;
            inflter = (LayoutInflater.from(applicationContext));
        }

        @Override
        public int getCount() {
            return extraList.size();
        }

        @Override
        public Object getItem(int i) {
            return null;
        }

        @Override
        public long getItemId(int i) {
            return 0;
        }

        @SuppressLint("SetTextI18n")
        @Override
        public View getView(int i, View view, ViewGroup viewGroup) {

            view = inflter.inflate(R.layout.lyt_spinner_item, null);
            TextView txt_item = view.findViewById(R.id.txt_item);
            View view1 = view.findViewById(R.id.view);
            //   TextView price = view.findViewById(R.id.txtprice)
            //
            //  ;
            if (i==0){
                view1.setVisibility(View.GONE);
            }
            txt_item.setText(extraList.get(i));


            spinnerid.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

                    view1.setVisibility(View.GONE);


                }

                @Override
                public void onNothingSelected(AdapterView<?> adapterView) {

                }
            });

            return view;
        }
    }
}