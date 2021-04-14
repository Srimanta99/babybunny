package com.baby.babybunny.student.management.screen.CenterHomeTaskActivity;

import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.app.DatePickerDialog;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.DatePicker;
import android.widget.ImageView;
import android.widget.ProgressBar;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.baby.babybunny.student.management.R;
import com.baby.babybunny.student.management.adapter.CenterHomeTaskAdapter;
import com.baby.babybunny.student.management.model.CenterHomeTaskModel;
import com.baby.babybunny.student.management.model.TeacherListModel;
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

public class CenterHomeTaskActivity extends AppCompatActivity {
    CenterHomeTaskViewBind centerHomeTaskViewBind;
    CenterHomeTaskOnClick centerHomeTaskOnClick;
    ImageView back_icon;
    DatePickerDialog  StartTime;
    String cal_date="2020-04-10";
    List<CenterHomeTaskModel> centerHomeTaskModels;
    List<TeacherListModel> teacherListModelList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        View view= LayoutInflater.from(this).inflate(R.layout.activity_center_home_task,null);
        setContentView(view);
        centerHomeTaskViewBind= new CenterHomeTaskViewBind(this,view);
        centerHomeTaskOnClick=new CenterHomeTaskOnClick(this,centerHomeTaskViewBind);

      //  centerHomeTaskViewBind. toolname_id.setText("Home Task ");

        centerHomeTaskViewBind. actionBarDrawerToggle = new ActionBarDrawerToggle(this,centerHomeTaskViewBind. drawerLayout, R.string.app_name, R.string.app_name);

        centerHomeTaskViewBind. drawerLayout.addDrawerListener( centerHomeTaskViewBind.actionBarDrawerToggle);
        centerHomeTaskViewBind. actionBarDrawerToggle.syncState();

        findViewById(R.id.img_nav).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                centerHomeTaskViewBind. drawerLayout.openDrawer(Gravity.RIGHT);

            }
        }); findViewById(R.id.img_navclose).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                centerHomeTaskViewBind. drawerLayout.closeDrawer(Gravity.RIGHT);

            }
        });




        Calendar newCalendar = Calendar.getInstance();
        StartTime = new DatePickerDialog(CenterHomeTaskActivity.this, new DatePickerDialog.OnDateSetListener() {
            public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                Calendar newDate = Calendar.getInstance();
                newDate.set(year, monthOfYear, dayOfMonth);


                cal_date=year+"-"+ addZeroLeading( monthOfYear + 1)+"-"+ addZeroLeading(dayOfMonth);

                centerHomeTaskViewBind. select_calender.setText(cal_date);

            }

        }, newCalendar.get(Calendar.YEAR), newCalendar.get(Calendar.MONTH), newCalendar.get(Calendar.DAY_OF_MONTH));


        centerHomeTaskModels=new ArrayList<>();
        teacherListModelList=new ArrayList<>();
        homework();

    }

    public String addZeroLeading(int num){
        if(num<10){
            String retstr=String.valueOf(num);
            return  "0"+retstr;
        }
        else
            return String.valueOf(num);


    }

    @Override
    public void onBackPressed() {
        if (getFragmentManager().getBackStackEntryCount() > 0) {
            getFragmentManager().popBackStack();
        } else {
            super.onBackPressed();
        }
    }




    public void homework(){
        ProgressBar progressBar = (ProgressBar)findViewById(R.id.progress);
        centerHomeTaskViewBind.progresslvid.setVisibility(View.VISIBLE);
        Sprite doubleBounce = new FadingCircle();
        progressBar.setIndeterminateDrawable(doubleBounce);
        StringRequest stringRequest=new StringRequest(Request.Method.POST, ApplicationConstant.CenterManager_homework, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {


                try {
                    JSONObject jsonObject=new JSONObject(response);
                    String    success = jsonObject.getString("success");
                    if (success.equalsIgnoreCase("0")){
                        progressBar.setVisibility(View.GONE);
                        centerHomeTaskViewBind.progresslvid.setVisibility(View.GONE);
                        centerHomeTaskViewBind.nodatafoundlvid.setVisibility(View.VISIBLE);
                    } else{
                        centerHomeTaskViewBind.nodatafoundlvid.setVisibility(View.GONE);
                        progressBar.setVisibility(View.GONE);
                    JSONArray jsonArray=jsonObject.getJSONArray("data");

                        for (int i=0;i<jsonArray.length();i++) {

                            JSONObject jsonObject1 = jsonArray.getJSONObject(i);
                            CenterHomeTaskModel selectClassModel=new CenterHomeTaskModel(

                                    jsonObject1.getString("id"),
                                    jsonObject1.getString("teacher_id"),
                                    jsonObject1.getString("teacher_class_id"),
                                    jsonObject1.getString("branch_id"),
                                    jsonObject1.getString("homework_details"),
                                    jsonObject1.getString("homework_for"),
                                    jsonObject1.getString("ddate"),
                                    jsonObject1.getString("isActive"),
                                    jsonObject1.getString("class_name"),
                                    jsonObject1.getString("teacher_name"),
                                    jsonObject1.getString("teacher_image")


                            );
                            centerHomeTaskModels.add(selectClassModel);

                            CenterHomeTaskAdapter selectClassAdapter=new CenterHomeTaskAdapter(CenterHomeTaskActivity.this,centerHomeTaskModels);
                            centerHomeTaskViewBind.hometaskrv.setAdapter(selectClassAdapter);
                            LinearLayoutManager layoutManager = new LinearLayoutManager(CenterHomeTaskActivity.this);

                            centerHomeTaskViewBind.hometaskrv.setLayoutManager(layoutManager);


                        }

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
                hashMap.put("branch_id", SessionManager.getCenterManabranch_idvalue());
               // hashMap.put("branch_id","9");

                return hashMap;
            }
        };
        Volley.newRequestQueue(this).add(stringRequest);
    }

    public void calender(){
        StartTime.show();
    }

    public void homework_filter(){
        centerHomeTaskModels.clear();

        ProgressDialog pd = new ProgressDialog(this);
        pd.setMessage("loading");
        pd.setCancelable(false);
        pd.show();
        ProgressBar progressBar = (ProgressBar)findViewById(R.id.progress);
        centerHomeTaskViewBind.progresslvid.setVisibility(View.VISIBLE);
        Sprite doubleBounce = new FadingCircle();
        progressBar.setIndeterminateDrawable(doubleBounce);
        StringRequest stringRequest=new StringRequest(Request.Method.POST, ApplicationConstant.CenterManager_homework_filter, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                centerHomeTaskViewBind. drawerLayout.closeDrawer(Gravity.RIGHT);
                pd.dismiss();
                try {
                    JSONObject jsonObject=new JSONObject(response);
                    String    success = jsonObject.getString("success");
                    if (success.equalsIgnoreCase("0")){
                        progressBar.setVisibility(View.GONE);
                        centerHomeTaskViewBind.progresslvid.setVisibility(View.GONE);
                        centerHomeTaskViewBind.nodatafoundlvid.setVisibility(View.VISIBLE);

                        Intent intent=new Intent(CenterHomeTaskActivity.this, NoDataFound.class);
                        startActivity(intent);
                    } else{
                        centerHomeTaskViewBind.nodatafoundlvid.setVisibility(View.GONE);
                        progressBar.setVisibility(View.GONE);
                        JSONArray jsonArray=jsonObject.getJSONArray("data");

                        for (int i=0;i<jsonArray.length();i++) {

                            JSONObject jsonObject1 = jsonArray.getJSONObject(i);
                            CenterHomeTaskModel selectClassModel=new CenterHomeTaskModel(

                                 jsonObject1.getString("id"),
                             jsonObject1.getString("teacher_id"),
                                jsonObject1.getString("teacher_class_id"),
                                jsonObject1.getString("branch_id"),
                                jsonObject1.getString("homework_details"),
                                jsonObject1.getString("homework_for"),
                                jsonObject1.getString("ddate"),
                                jsonObject1.getString("isActive"),
                                jsonObject1.getString("class_name"),
                                jsonObject1.getString("teacher_name"),
                                    jsonObject1.getString("teacher_image")


                        );
                            centerHomeTaskModels.add(selectClassModel);

                            CenterHomeTaskAdapter selectClassAdapter=new CenterHomeTaskAdapter(CenterHomeTaskActivity.this,centerHomeTaskModels);
                        centerHomeTaskViewBind.hometaskrv.setAdapter(selectClassAdapter);
                            LinearLayoutManager layoutManager = new LinearLayoutManager(CenterHomeTaskActivity.this);

                            centerHomeTaskViewBind.hometaskrv.setLayoutManager(layoutManager);


                        }
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
             //   hashMap.put("branch_id","9");
                hashMap.put("branch_id",SessionManager.getCenterManabranch_idvalue());
               hashMap.put("date",cal_date);
                return hashMap;
            }
        };
        Volley.newRequestQueue(this).add(stringRequest);
    }

}