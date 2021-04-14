package com.baby.babybunny.student.management.screen.TeacherHomeTaskActivity;

import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ProgressBar;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.baby.babybunny.student.management.R;
import com.baby.babybunny.student.management.adapter.TeacherHomeTaskAdapter;
import com.baby.babybunny.student.management.adapter.TeachetGetAllClassAdapter;
import com.baby.babybunny.student.management.model.TeacherHomeWorkTaskModel;
import com.baby.babybunny.student.management.model.TeachetGetAllClassModel;
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

public class TeacherHomeTaskActivity extends AppCompatActivity {
    TeacherHomeTaskViewBind teacherHomeTaskViewBind;
    TeacherHomeTaskOnClick teacherHomeTaskOnClick;
    List<TeacherHomeWorkTaskModel> teacherHomeWorkTaskModels;
    ArrayList<TeachetGetAllClassModel> teachetGetAllClassModels;
    String DOB,Class_id,class_name,currentdate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        View view= LayoutInflater.from(this).inflate(R.layout.activity_teacher_home_task,null);
        setContentView(view);


        teacherHomeTaskViewBind= new TeacherHomeTaskViewBind(this,view);
        teacherHomeTaskOnClick=new TeacherHomeTaskOnClick(this,teacherHomeTaskViewBind);



        teacherHomeTaskViewBind. actionBarDrawerToggle = new ActionBarDrawerToggle(this,teacherHomeTaskViewBind. drawerLayout, R.string.app_name, R.string.app_name);

        teacherHomeTaskViewBind. drawerLayout.addDrawerListener( teacherHomeTaskViewBind.actionBarDrawerToggle);
        teacherHomeTaskViewBind. actionBarDrawerToggle.syncState();

        findViewById(R.id.img_nav).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                teacherHomeTaskViewBind. drawerLayout.openDrawer(Gravity.RIGHT);

            }
        }); findViewById(R.id.img_navclose).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                teacherHomeTaskViewBind. drawerLayout.closeDrawer(Gravity.RIGHT);

            }
        });

        teacherHomeWorkTaskModels=new ArrayList<>();
        teachetGetAllClassModels=new ArrayList<>();




        LinearLayoutManager layoutManager = new LinearLayoutManager(TeacherHomeTaskActivity.this);

        teacherHomeTaskViewBind.hometaskrv .setLayoutManager(layoutManager);




        getAllClass();

        currentdate();


    }

    private void currentdate() {
        Calendar c = Calendar.getInstance();
        int year = c.get(Calendar.YEAR);
        int month = c.get(Calendar.MONTH);
        int day = c.get(Calendar.DATE);

        currentdate=year+"-"+addZeroLeading( month+1)+"-"+day;
    }

    public String addZeroLeading(int num){
        if(num<10){
            String retstr=String.valueOf(num);
            return  "0"+retstr;
        }
        else
            return String.valueOf(num);


    }


    public  void getAllClass(){

        StringRequest stringRequest=new StringRequest(Request.Method.POST, ApplicationConstant.Teacherurl_getAllclass, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {


                try {
                    JSONObject jsonObject=new JSONObject(response);
                    JSONArray jsonArray=jsonObject.getJSONArray("data");

                    teachetGetAllClassModels.add(new TeachetGetAllClassModel("0","0","Select Class"));

                    for (int i=0;i<jsonArray.length();i++){

                        JSONObject jsonObject1=jsonArray.getJSONObject(i);
                        TeachetGetAllClassModel selectClassModel=new TeachetGetAllClassModel(
                                jsonObject1.getString("id"),
                                jsonObject1.getString("branch_id"),
                                class_name= jsonObject1.getString("class_name")
                        );

                        teachetGetAllClassModels.add(selectClassModel);

                        TeachetGetAllClassAdapter selectClassAdapter=new TeachetGetAllClassAdapter(TeacherHomeTaskActivity.this, teachetGetAllClassModels);
                        teacherHomeTaskViewBind.select_class_spinnerid.setAdapter(selectClassAdapter);


                    }


                    teacherHomeTaskViewBind.select_class_spinnerid.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                        @Override
                        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                            Class_id= teachetGetAllClassModels.get(position).getId();
                        }

                        @Override
                        public void onNothingSelected(AdapterView<?> parent) {

                        }
                    });


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
                hashMap.put("branch_id", SessionManager.getTeacher_branch_idvalue());
              //  hashMap.put("branch_id","9");

                return hashMap;
            }
        };
        Volley.newRequestQueue(this).add(stringRequest);
    }


    public  void apiForhometaskSearch(String class_id){

        ProgressBar progressBar = (ProgressBar)findViewById(R.id.progress);
        teacherHomeTaskViewBind.progresslvid.setVisibility(View.VISIBLE);
        Sprite doubleBounce = new FadingCircle();
        progressBar.setIndeterminateDrawable(doubleBounce);
        teacherHomeTaskViewBind.tvSearchid.setVisibility(View.GONE);
        teacherHomeTaskViewBind.progress_bar.setVisibility(View.VISIBLE);
        teacherHomeTaskViewBind.progress_bar.getProgress();
        StringRequest stringRequest=new StringRequest(Request.Method.POST, ApplicationConstant.Teacherurl_hometask, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Log.d("sunita", "onResponse: "+response);
              //  progressBar.setVisibility(View.GONE);
                teacherHomeTaskViewBind. drawerLayout.closeDrawer(Gravity.RIGHT);
                try {
                    JSONObject jsonObject = new JSONObject(response);

                    String    success = jsonObject.getString("success");
                    if (success.equalsIgnoreCase("0")){
                        progressBar.setVisibility(View.GONE);
                       /* teacherHomeTaskViewBind.progresslvid.setVisibility(View.GONE);
                        teacherHomeTaskViewBind.nodatafoundlvid.setVisibility(View.VISIBLE);*/
                        Intent intent=new Intent(TeacherHomeTaskActivity.this, NoDataFound.class);
                        startActivity(intent);

                    } else   if (success.equalsIgnoreCase("1")){
                        teacherHomeTaskViewBind.nodatafoundlvid.setVisibility(View.GONE);
                        progressBar.setVisibility(View.GONE);
                        teacherHomeTaskViewBind.tvSearchid.setVisibility(View.VISIBLE);
                        teacherHomeTaskViewBind.progress_bar.setVisibility(View.GONE);
                        teacherHomeWorkTaskModels.clear();
                        JSONArray jsonArray = jsonObject.getJSONArray("data");
                        if (jsonArray.isNull(0)){

                            Intent intent=new Intent(TeacherHomeTaskActivity.this, NoDataFound.class);
                            startActivity(intent);
                        }else {
                            for (int i = 0; i < jsonArray.length(); i++) {

                                JSONObject jsonObject1 = jsonArray.getJSONObject(i);
                                JSONArray jsonArray1 = jsonObject1.getJSONArray("task");
                                for (int j = 0; j < jsonArray1.length(); j++) {

                                    JSONObject jsonObject2 = jsonArray1.getJSONObject(j);

                                    Log.d("jsonObject2", "onResponse: " + jsonObject2);

                                    TeacherHomeWorkTaskModel teacherHomeWorkTaskModel = new TeacherHomeWorkTaskModel(
                                            jsonObject2.getString("teacher_name"),
                                            jsonObject2.getString("homework_for"),
                                            jsonObject2.getString("homework_details"),
                                            jsonObject2.getString("ddate")
                                    );


                                    teacherHomeWorkTaskModels.add(teacherHomeWorkTaskModel);

                                }


                            }
                        }
                        TeacherHomeTaskAdapter teacherListAdapter = new TeacherHomeTaskAdapter(TeacherHomeTaskActivity.this, teacherHomeWorkTaskModels);
                        teacherHomeTaskViewBind.hometaskrv.setAdapter(teacherListAdapter);

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
                hashMap.put("ddate",currentdate);
                hashMap.put("class_id",class_id);
                Log.d("hashMap", "getParams: "+hashMap);
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