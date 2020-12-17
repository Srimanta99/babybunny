package com.baby.bunny.student.management.screen.StudentTodaysClassActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.baby.bunny.student.management.R;
import com.baby.bunny.student.management.adapter.StudentTodaysClassDateAdapter;
import com.baby.bunny.student.management.model.StudentTodayClassTestModel;
import com.baby.bunny.student.management.model.StudentTodaysClassDateModel;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class StudentTodaysClass extends AppCompatActivity {
    StudentTodayClassViewBind studentTodayClassViewBind;
    StudentTodayClassOnClick studentTodayClassOnClick;
    List<StudentTodaysClassDateModel> studentTodaysClassDateModels;
    List<StudentTodayClassTestModel> studentTodayClassTestModels;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        View view= LayoutInflater.from(this).inflate(R.layout.activity_student_todays_class,null);
        setContentView(view);
        studentTodayClassViewBind= new StudentTodayClassViewBind(this,view);
        studentTodayClassOnClick=new StudentTodayClassOnClick(this,studentTodayClassViewBind);

        studentTodaysClassDateModels=new ArrayList<>();

        loaddata();
    }


    @Override
    public void onBackPressed() {
        if (getFragmentManager().getBackStackEntryCount() > 0) {
            getFragmentManager().popBackStack();
        } else {
            super.onBackPressed();
        }
    }

    public void loaddata(){
        String url="https://desitik.in/API/index.php?p=allSounds";
        StringRequest stringRequest=new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {


                try {
                    JSONObject jsonObject=new JSONObject(response);

                    JSONArray jsonArray=jsonObject.getJSONArray("msg");

                    for (int i = 0; i < jsonArray.length(); i++) {
                        JSONObject obj = jsonArray.getJSONObject(i);

                        studentTodayClassTestModels=new ArrayList<>();

                        StudentTodaysClassDateModel studentTodaysClassDateModel=new StudentTodaysClassDateModel();

                        studentTodaysClassDateModel.setSection_name(obj.getString("section_name"));

                        JSONArray jsonArray1=obj.getJSONArray("sections_sounds");


                        for (int j=0;j<jsonArray1.length();j++){

                            JSONObject jsonObject1=jsonArray1.getJSONObject(j);

                            StudentTodayClassTestModel studentTodayClassTestModel=new StudentTodayClassTestModel();
                            studentTodayClassTestModel.setDescription(jsonObject1.getString("created"));

                            studentTodayClassTestModels.add(studentTodayClassTestModel);

                        }
                        studentTodaysClassDateModel.setStudentTodayClassTestModels(studentTodayClassTestModels);


                      studentTodaysClassDateModels.add(studentTodaysClassDateModel);

                    }

                    StudentTodaysClassDateAdapter adapter = new StudentTodaysClassDateAdapter(studentTodaysClassDateModels, StudentTodaysClass.this);
                    studentTodayClassViewBind.recyclerView.setHasFixedSize(true);
                    studentTodayClassViewBind.recyclerView.setLayoutManager(new LinearLayoutManager( StudentTodaysClass.this));
                    studentTodayClassViewBind.recyclerView.setAdapter(adapter);

                } catch (JSONException e) {
                    e.printStackTrace();


                }


/*
                StudentTodaysClassDateAdapter adapter = new StudentTodaysClassDateAdapter(studentTodaysClassDateModels, StudentTodaysClass.this);
                studentTodayClassViewBind.recyclerView.setHasFixedSize(true);
                studentTodayClassViewBind.recyclerView.setLayoutManager(new LinearLayoutManager( StudentTodaysClass.this));
                studentTodayClassViewBind.recyclerView.setAdapter(adapter);*/
            }



        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.d("amrdadurki", "onResponse: "+error.getMessage());

            }
        });

        Volley.newRequestQueue(this).add(stringRequest);
    }

}