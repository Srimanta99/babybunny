package com.baby.babybunny.student.management.screen.TeacherStudentsActivity;

import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.content.Intent;
import android.os.Bundle;
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
import com.baby.babybunny.student.management.adapter.TeacherStudentListAdapter;
import com.baby.babybunny.student.management.adapter.TeachetGetAllClassAdapter;
import com.baby.babybunny.student.management.model.TeacherGetAllStudentModel;
import com.baby.babybunny.student.management.model.TeacherListModel;
import com.baby.babybunny.student.management.model.TeacherStudentsListModel;
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
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TeacherStudentsActivity extends AppCompatActivity {
    TeacherStudentsViewBind teacherStudentsViewBind;
    TeacherStudentsOnClick teacherStudentsOnClick;
    List<TeacherListModel> teacherListModelList;
    List<TeacherStudentsListModel> teacherStudentsListModels;
    ArrayList<TeachetGetAllClassModel> teachetGetAllClassModels;
    List<TeacherGetAllStudentModel> teacherGetAllStudentModels;

    String class_name,Class_id;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        View view= LayoutInflater.from(this).inflate(R.layout.activity_teacher_students,null);
        setContentView(view);


        teacherStudentsViewBind= new TeacherStudentsViewBind(this,view);
        teacherStudentsOnClick=new TeacherStudentsOnClick(this,teacherStudentsViewBind);

        teacherStudentsViewBind. actionBarDrawerToggle = new ActionBarDrawerToggle(this,teacherStudentsViewBind. drawerLayout, R.string.app_name, R.string.app_name);

        teacherStudentsViewBind. drawerLayout.addDrawerListener( teacherStudentsViewBind.actionBarDrawerToggle);
        teacherStudentsViewBind. actionBarDrawerToggle.syncState();

        findViewById(R.id.img_nav).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                teacherStudentsViewBind. drawerLayout.openDrawer(Gravity.RIGHT);

            }
        }); findViewById(R.id.img_navclose).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                teacherStudentsViewBind. drawerLayout.closeDrawer(Gravity.RIGHT);

            }
        });

        teacherListModelList=new ArrayList<>();
        teacherGetAllStudentModels=new ArrayList<>();
        teacherStudentsListModels=new ArrayList<>();

        teachetGetAllClassModels=new ArrayList<>();
        LinearLayoutManager layoutManager = new LinearLayoutManager(TeacherStudentsActivity.this);

        teacherStudentsViewBind. studentrv.setLayoutManager(layoutManager);

        getAllClass();

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

                        TeachetGetAllClassAdapter selectClassAdapter=new TeachetGetAllClassAdapter(TeacherStudentsActivity.this, teachetGetAllClassModels);
                        teacherStudentsViewBind.select_class_spinnerid.setAdapter(selectClassAdapter);


                    }


                    teacherStudentsViewBind.select_class_spinnerid.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
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
               // hashMap.put("branch_id", "9");
                return hashMap;
            }
        };
        Volley.newRequestQueue(this).add(stringRequest);
    }


    public void getAllStudent(String Class_id){
        ProgressBar progressBar = (ProgressBar)findViewById(R.id.progress);
        teacherStudentsViewBind.progresslvid.setVisibility(View.VISIBLE);
        Sprite doubleBounce = new FadingCircle();
        progressBar.setIndeterminateDrawable(doubleBounce);
        teacherStudentsViewBind.tvSearchid.setVisibility(View.GONE);
        teacherStudentsViewBind.progress_bar.setVisibility(View.VISIBLE);
        teacherStudentsViewBind.progress_bar.getProgress();
        StringRequest stringRequest=new StringRequest(Request.Method.POST, ApplicationConstant.Teacherurl_getAllStudent, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

                teacherStudentsViewBind. drawerLayout.closeDrawer(Gravity.RIGHT);
                try {
                    JSONObject jsonObject = new JSONObject(response);

                    String    success = jsonObject.getString("success");
                    if (success.equalsIgnoreCase("0")){
                        progressBar.setVisibility(View.GONE);
                        teacherStudentsListModels.clear();

                        teacherStudentsViewBind.progresslvid.setVisibility(View.GONE);
                        teacherStudentsViewBind.nodatafoundlvid.setVisibility(View.VISIBLE);
                        teacherStudentsViewBind.tvSearchid.setVisibility(View.VISIBLE);
                        teacherStudentsViewBind.progress_bar.setVisibility(View.GONE);
                        Intent intent=new Intent(TeacherStudentsActivity.this, NoDataFound.class);
                        startActivity(intent);
                    } else{
                        teacherStudentsViewBind.nodatafoundlvid.setVisibility(View.GONE);
                        progressBar.setVisibility(View.GONE);
                        teacherStudentsViewBind.tvSearchid.setVisibility(View.VISIBLE);
                        teacherStudentsViewBind.progress_bar.setVisibility(View.GONE);
                        teacherStudentsListModels.clear();
                        JSONArray jsonArray = jsonObject.getJSONArray("data");
                        for (int i = 0; i < jsonArray.length(); i++) {

                            JSONObject jsonObject1 = jsonArray.getJSONObject(i);

                            TeacherStudentsListModel studentsListModel = new TeacherStudentsListModel(
                                    jsonObject1.getString("student_image"),
                                    jsonObject1.getString("student_name"),
                                    jsonObject1.getString("student_id"),
                                    jsonObject1.getString("guardian_name"),
                                    jsonObject1.getString("email_id"),
                                    jsonObject1.getString("mobile_no"),
                                    jsonObject1.getString("blood_group"),
                                    jsonObject1.getString("dob"),
                                    jsonObject1.getString("id")
                            );
                            teacherStudentsListModels.add(studentsListModel);

                        }

                        TeacherStudentListAdapter studentListAdapter = new TeacherStudentListAdapter(TeacherStudentsActivity.this, teacherStudentsListModels);
                        teacherStudentsViewBind.studentrv.setAdapter(studentListAdapter);


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