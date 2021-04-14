package com.baby.babybunny.student.management.screen.TeacherAttendenceActivity;

import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
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
import com.baby.babybunny.student.management.Interface.TeacherGetAllStudentInterface;
import com.baby.babybunny.student.management.R;
import com.baby.babybunny.student.management.adapter.TeacherGetAllStudentAdapter;
import com.baby.babybunny.student.management.adapter.TeachetGetAllClassAdapter;
import com.baby.babybunny.student.management.model.TeacherGetAllStudentModel;
import com.baby.babybunny.student.management.model.TeachetGetAllClassModel;
import com.baby.babybunny.student.management.screen.NoDataFound.NoDataFound;
import com.baby.babybunny.student.management.utils.ApplicationConstant;
import com.baby.babybunny.student.management.utils.CustomAlertDialog;
import com.baby.babybunny.student.management.utils.MyToast;
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

public class TeacherAttendenceActivity extends AppCompatActivity {
    TeacherAttendenceViewBind teacherAttendenceViewBind;
    TeacherAttendenceOnClick teacherAttendenceOnClick;
    ArrayList<TeachetGetAllClassModel> teachetGetAllClassModels;
    List<TeacherGetAllStudentModel> teacherGetAllStudentModels;
    String class_name,Class_id,studentID_arr,attendance_status_arr,currentdate;
    ArrayList studentID_arraylist,attendance_status_arraylist;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        View view= LayoutInflater.from(this).inflate(R.layout.activity_teacher_attendence,null);
        setContentView(view);
        teacherAttendenceViewBind= new TeacherAttendenceViewBind(this,view);
        teacherAttendenceOnClick=new TeacherAttendenceOnClick(this,teacherAttendenceViewBind);

        teacherAttendenceViewBind. actionBarDrawerToggle = new ActionBarDrawerToggle(this,teacherAttendenceViewBind. drawerLayout, R.string.app_name, R.string.app_name);

        teacherAttendenceViewBind. drawerLayout.addDrawerListener( teacherAttendenceViewBind.actionBarDrawerToggle);
        teacherAttendenceViewBind. actionBarDrawerToggle.syncState();

        findViewById(R.id.img_nav).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                teacherAttendenceViewBind. drawerLayout.openDrawer(Gravity.RIGHT);

            }
        }); findViewById(R.id.img_navclose).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                teacherAttendenceViewBind. drawerLayout.closeDrawer(Gravity.RIGHT);

            }
        });

        Calendar c = Calendar.getInstance();
        int year = c.get(Calendar.YEAR);
        int month = c.get(Calendar.MONTH);
        int day = c.get(Calendar.DATE);
         int months =month+1;
        currentdate=year+"-"+addZeroLeading(months)+"-"+day;

        teacherGetAllStudentModels=new ArrayList<>();
        teachetGetAllClassModels=new ArrayList<>();

        LinearLayoutManager layoutManager = new LinearLayoutManager(TeacherAttendenceActivity.this);

        teacherAttendenceViewBind. teacherrv.setLayoutManager(layoutManager);


        if (isConnected()) {
            getAllClass();

        } else {

            CustomAlertDialog.NoInternetAlert(TeacherAttendenceActivity.this);
        }
    }

    public boolean isConnected() {
        boolean connected = false;
        try {
            ConnectivityManager cm = (ConnectivityManager) TeacherAttendenceActivity.this.getSystemService(Context.CONNECTIVITY_SERVICE);
            NetworkInfo nInfo = cm.getActiveNetworkInfo();
            connected = nInfo != null && nInfo.isAvailable() && nInfo.isConnected();
            return connected;
        } catch (Exception e) {
            Log.e("Connectivity Exception", e.getMessage());
        }
        return connected;
    }

    @Override
    public void onBackPressed() {
        if (getFragmentManager().getBackStackEntryCount() > 0) {
            getFragmentManager().popBackStack();
        } else {
            super.onBackPressed();
        }
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

                        TeachetGetAllClassAdapter selectClassAdapter=new TeachetGetAllClassAdapter(TeacherAttendenceActivity.this, teachetGetAllClassModels);
                        teacherAttendenceViewBind.select_class_spinnerid.setAdapter(selectClassAdapter);


                    }


                    teacherAttendenceViewBind.select_class_spinnerid.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
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
               // hashMap.put("branch_id","9");
                return hashMap;
            }
        };
        Volley.newRequestQueue(this).add(stringRequest);
    }

    public void getAllStudent(String Class_id){

        ProgressBar progressBar = (ProgressBar)findViewById(R.id.progress);
        teacherAttendenceViewBind.progresslvid.setVisibility(View.VISIBLE);
        Sprite doubleBounce = new FadingCircle();
        progressBar.setIndeterminateDrawable(doubleBounce);
        teacherAttendenceViewBind.tvSearchid.setVisibility(View.GONE);
        teacherAttendenceViewBind.progress_bar.setVisibility(View.VISIBLE);
        teacherAttendenceViewBind.progress_bar.getProgress();

        StringRequest stringRequest=new StringRequest(Request.Method.POST, ApplicationConstant.Teacherurl_getAllStudent, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

                teacherAttendenceViewBind. drawerLayout.closeDrawer(Gravity.RIGHT);
                try {

                    JSONObject jsonObject = new JSONObject(response);

                    String    success = jsonObject.getString("success");
                    if (success.equalsIgnoreCase("0")){

                        progressBar.setVisibility(View.GONE);
                        teacherAttendenceViewBind.tvSearchid.setVisibility(View.VISIBLE);
                        teacherAttendenceViewBind.progress_bar.setVisibility(View.GONE);
                        teacherGetAllStudentModels.clear();
                        teacherAttendenceViewBind.progresslvid.setVisibility(View.GONE);
                        teacherAttendenceViewBind.nodatafoundlvid.setVisibility(View.VISIBLE);
                        Intent intent=new Intent(TeacherAttendenceActivity.this, NoDataFound.class);
                        startActivity(intent);

                    } else  if (success.equalsIgnoreCase("1")){
                        teacherAttendenceViewBind.nodatafoundlvid.setVisibility(View.GONE);
                        progressBar.setVisibility(View.GONE);
                        teacherAttendenceViewBind.tvSearchid.setVisibility(View.VISIBLE);
                        teacherAttendenceViewBind.progress_bar.setVisibility(View.GONE);
                        teacherGetAllStudentModels.clear();
                        JSONArray jsonArray = jsonObject.getJSONArray("data");
                        for (int i = 0; i < jsonArray.length(); i++) {

                            JSONObject jsonObject1 = jsonArray.getJSONObject(i);

                            TeacherGetAllStudentModel stuListModel = new TeacherGetAllStudentModel(
                                    jsonObject1.getString("id"),
                                    jsonObject1.getString("student_image"),
                                    jsonObject1.getString("student_name"),
                                    jsonObject1.getString("student_id"),
                                    jsonObject1.getString("email_id"),
                                    jsonObject1.getString("mobile_no")


                            );
                            teacherGetAllStudentModels.add(stuListModel);

                        }

                        TeacherGetAllStudentAdapter teacherListAdapter = new TeacherGetAllStudentAdapter(TeacherAttendenceActivity.this, teacherGetAllStudentModels, new TeacherGetAllStudentInterface() {
                            @Override
                            public void teacherGetAllStudentInterface(int position, ArrayList attendance_status_array, ArrayList studentID_array) {

                                 studentID_arraylist=studentID_array;
                                attendance_status_arraylist=attendance_status_array;
                            }
                        });
                        teacherAttendenceViewBind.teacherrv.setAdapter(teacherListAdapter);

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
                hashMap.put("branch_id",SessionManager.getTeacher_branch_idvalue());
               // hashMap.put("branch_id","9");
                hashMap.put("class_id",Class_id);
                Log.d("hash", "getParams: "+hashMap);
                return hashMap;
            }
        };
        Volley.newRequestQueue(this).add(stringRequest);
    }

    public void insertattendence(String Class_id){
        StringRequest stringRequest=new StringRequest(Request.Method.POST, ApplicationConstant.Teacherurl_insertattendence, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

                try {
                    JSONObject jsonObject=new JSONObject(response);
                    if (jsonObject.getString("success").equalsIgnoreCase("1")){
                        MyToast.show(TeacherAttendenceActivity.this,""+jsonObject.getString("message"),true);
                    }else {
                        MyToast.show(TeacherAttendenceActivity.this,""+jsonObject.getString("message"),true);
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
                hashMap.put("class_id", Class_id);

                for (int i=0;i<studentID_arraylist.size();i++) {

                    studentID_arr=studentID_arraylist.get(i).toString();


                    hashMap.put("student_id["+i+"]", studentID_arr);


                }

                for (int i=0;i<attendance_status_arraylist.size();i++) {

                    attendance_status_arr=attendance_status_arraylist.get(i).toString();
                    hashMap.put("attendance_status["+i+"]",attendance_status_arr);

                }

                hashMap.put("ddate",currentdate);

                Log.d("hashMap", "getParams: "+hashMap);
                return hashMap;
            }
        };
        Volley.newRequestQueue(this).add(stringRequest);
    }
}