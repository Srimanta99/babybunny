package com.baby.babybunny.student.management.screen.TeacherTodaysClass;

import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.DatePicker;
import android.widget.ProgressBar;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.baby.babybunny.student.management.R;
import com.baby.babybunny.student.management.adapter.TeacherTodayClassTaskAdapter;
import com.baby.babybunny.student.management.model.TeacherTodayClassTaskModel;
import com.baby.babybunny.student.management.screen.NoDataFound.NoDataFound;
import com.baby.babybunny.student.management.utils.ApplicationConstant;
import com.baby.babybunny.student.management.utils.SessionManager;
import com.github.ybq.android.spinkit.sprite.Sprite;
import com.github.ybq.android.spinkit.style.FadingCircle;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TeacherTodaysClass extends AppCompatActivity {
    TeacherTodaysClassViewBind teacherTodaysClassViewBind;
    TeacherTodaysClassOnClick teacherTodaysClassOnClick;
    List<TeacherTodayClassTaskModel> teacherTodayClassTaskModels;

    String DOB="null",Class_id;

    String currentdate;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        View view= LayoutInflater.from(this).inflate(R.layout.activity_teacher_todays_class,null);
        setContentView(view);


        teacherTodaysClassViewBind= new TeacherTodaysClassViewBind(this,view);
        teacherTodaysClassOnClick=new TeacherTodaysClassOnClick(this,teacherTodaysClassViewBind);



        teacherTodaysClassViewBind. actionBarDrawerToggle = new ActionBarDrawerToggle(this,teacherTodaysClassViewBind. drawerLayout, R.string.app_name, R.string.app_name);

        teacherTodaysClassViewBind. drawerLayout.addDrawerListener( teacherTodaysClassViewBind.actionBarDrawerToggle);
        teacherTodaysClassViewBind. actionBarDrawerToggle.syncState();

        findViewById(R.id.img_nav).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                teacherTodaysClassViewBind. drawerLayout.openDrawer(Gravity.RIGHT);

            }
        }); findViewById(R.id.img_navclose).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                teacherTodaysClassViewBind. drawerLayout.closeDrawer(Gravity.RIGHT);

            }
        });

        teacherTodayClassTaskModels=new ArrayList<>();





        LinearLayoutManager layoutManager = new LinearLayoutManager(TeacherTodaysClass.this);

        teacherTodaysClassViewBind.todaysclassrv .setLayoutManager(layoutManager);


        apiForTeacherTodaysClass();
    }

    public void calender(){

        Calendar newCalendar = Calendar.getInstance();
        final DatePickerDialog StartTime = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
            public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                Calendar newDate = Calendar.getInstance();
                newDate.set(year, monthOfYear, dayOfMonth);
                DOB=year+ "-"+ addZeroLeading(monthOfYear + 1) + "-"
                        +String.format("%02d",dayOfMonth) ;
                teacherTodaysClassViewBind.select_calender.setText(DOB);


            }

        }, newCalendar.get(Calendar.YEAR), newCalendar.get(Calendar.MONTH), newCalendar.get(Calendar.DAY_OF_MONTH));
        StartTime.show();
    }


    public String addZeroLeading(int num){
        if(num<10){
            String retstr=String.valueOf(num);
            return  "0"+retstr;
        }
        else
            return String.valueOf(num);


    }



    public  void apiForTeacherTodaysClass(){

        ProgressBar progressBar = (ProgressBar)findViewById(R.id.progress);
        teacherTodaysClassViewBind.progresslvid.setVisibility(View.VISIBLE);
        Sprite doubleBounce = new FadingCircle();
        progressBar.setIndeterminateDrawable(doubleBounce);

        StringRequest stringRequest=new StringRequest(Request.Method.POST, ApplicationConstant.Teacherurl_todayclass, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Log.d("sunita", "onResponse: "+response);
                progressBar.setVisibility(View.GONE);
                try {
                    JSONObject jsonObject = new JSONObject(response);

                    String    success = jsonObject.getString("success");
                    if (success.equalsIgnoreCase("0")){
                        progressBar.setVisibility(View.GONE);
                        teacherTodaysClassViewBind.progresslvid.setVisibility(View.GONE);
                        teacherTodaysClassViewBind.nodatafoundlvid.setVisibility(View.VISIBLE);
                    } else{
                        teacherTodaysClassViewBind.nodatafoundlvid.setVisibility(View.GONE);
                        progressBar.setVisibility(View.GONE);
                        JSONArray jsonArray = jsonObject.getJSONArray("data");

                        if (jsonArray.isNull(0)){
                            progressBar.setVisibility(View.GONE);
                            teacherTodaysClassViewBind.progresslvid.setVisibility(View.GONE);
                            teacherTodaysClassViewBind.nodatafoundlvid.setVisibility(View.VISIBLE);
                        }

                        for (int i = 0; i < jsonArray.length(); i++) {

                            JSONObject jsonObject1 = jsonArray.getJSONObject(i);
                            JSONArray jsonArray1=jsonObject1.getJSONArray("task");
                            for (int j=0;j<jsonArray1.length();j++){

                                JSONObject jsonObject2=jsonArray1.getJSONObject(j);

                                Log.d("jsonObject2", "onResponse: "+jsonObject2);

                                TeacherTodayClassTaskModel teacherTodayClassTaskModel=new TeacherTodayClassTaskModel(
                                        jsonObject2.getString("teacher_name"),
                                        jsonObject2.getString("subject"),
                                        jsonObject2.getString("content"),
                                        jsonObject2.getString("ddate")
                                );


                                teacherTodayClassTaskModels.add(teacherTodayClassTaskModel);

                            }


                        }

                        TeacherTodayClassTaskAdapter teacherListAdapter = new TeacherTodayClassTaskAdapter(TeacherTodaysClass.this, teacherTodayClassTaskModels);
                        teacherTodaysClassViewBind.todaysclassrv.setAdapter(teacherListAdapter);

                    }

                } catch (JSONException e) {
                    e.printStackTrace();
                }

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        }){
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                HashMap<String,String> hashMap=new HashMap<>();
                hashMap.put("secret_key","D32B55F2853AF98C9732D74942F4A");
                hashMap.put("token_key","1D555E491ED458AB22858516998CF");
                hashMap.put("teacher_id", SessionManager.getTeacheridvalue());
              //  hashMap.put("teacher_id","14");



                return hashMap;
            }
        };
        Volley.newRequestQueue(this).add(stringRequest);
    }

public void apiForTeacherTodaysClassSearch(String DOB){
    ProgressBar progressBar = (ProgressBar)findViewById(R.id.progress);
    teacherTodaysClassViewBind.progresslvid.setVisibility(View.VISIBLE);
    Sprite doubleBounce = new FadingCircle();
    progressBar.setIndeterminateDrawable(doubleBounce);
    teacherTodaysClassViewBind.tvSearchid.setVisibility(View.GONE);
    teacherTodaysClassViewBind.progress_bar.setVisibility(View.VISIBLE);
    teacherTodaysClassViewBind.progress_bar.getProgress();

    StringRequest stringRequest=new StringRequest(Request.Method.POST, ApplicationConstant.Teacherurl_todayclass, new Response.Listener<String>() {
        @Override
        public void onResponse(String response) {
            Log.d("sunita", "onResponse: "+response);
            progressBar.setVisibility(View.GONE);
            teacherTodaysClassViewBind. drawerLayout.closeDrawer(Gravity.RIGHT);
            try {
                JSONObject jsonObject = new JSONObject(response);

                String    success = jsonObject.getString("success");
                if (success.equalsIgnoreCase("0")){
                    progressBar.setVisibility(View.GONE);
                /*    teacherTodaysClassViewBind.progresslvid.setVisibility(View.GONE);
                    teacherTodaysClassViewBind.nodatafoundlvid.setVisibility(View.VISIBLE);*/
                    Intent intent=new Intent(TeacherTodaysClass.this, NoDataFound.class);
                    startActivity(intent);
                } else{
                    teacherTodaysClassViewBind.nodatafoundlvid.setVisibility(View.GONE);
                    progressBar.setVisibility(View.GONE);
                    teacherTodaysClassViewBind.tvSearchid.setVisibility(View.VISIBLE);
                    teacherTodaysClassViewBind.progress_bar.setVisibility(View.GONE);
                    teacherTodayClassTaskModels.clear();
                    JSONArray jsonArray = jsonObject.getJSONArray("data");
                   if (jsonArray.isNull(0)){
                            teacherTodaysClassViewBind.progresslvid.setVisibility(View.GONE);
                    teacherTodaysClassViewBind.nodatafoundlvid.setVisibility(View.VISIBLE);

                   }else {
                       for (int i = 0; i < jsonArray.length(); i++) {

                           JSONObject jsonObject1 = jsonArray.getJSONObject(i);
                           JSONArray jsonArray1 = jsonObject1.getJSONArray("task");
                           for (int j = 0; j < jsonArray1.length(); j++) {

                               JSONObject jsonObject2 = jsonArray1.getJSONObject(j);

                               Log.d("jsonObject2", "onResponse: " + jsonObject2);

                               TeacherTodayClassTaskModel teacherTodayClassTaskModel = new TeacherTodayClassTaskModel(
                                       jsonObject2.getString("teacher_name"),
                                       jsonObject2.getString("subject"),
                                       jsonObject2.getString("content"),
                                       jsonObject2.getString("ddate")
                               );


                               teacherTodayClassTaskModels.add(teacherTodayClassTaskModel);

                           }


                       }
                   }
                    TeacherTodayClassTaskAdapter teacherListAdapter = new TeacherTodayClassTaskAdapter(TeacherTodaysClass.this, teacherTodayClassTaskModels);
                    teacherTodaysClassViewBind.todaysclassrv.setAdapter(teacherListAdapter);

                }

            } catch (JSONException e) {
                e.printStackTrace();
            }

        }
    }, new Response.ErrorListener() {
        @Override
        public void onErrorResponse(VolleyError error) {

        }
    }){
        @Override
        protected Map<String, String> getParams() throws AuthFailureError {
            HashMap<String,String> hashMap=new HashMap<>();
            hashMap.put("secret_key","D32B55F2853AF98C9732D74942F4A");
            hashMap.put("token_key","1D555E491ED458AB22858516998CF");
            hashMap.put("teacher_id", SessionManager.getTeacheridvalue());
          //  hashMap.put("teacher_id", "14");
            hashMap.put("ddate",DOB);

            return hashMap;
        }
    };
    Volley.newRequestQueue(this).add(stringRequest);
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