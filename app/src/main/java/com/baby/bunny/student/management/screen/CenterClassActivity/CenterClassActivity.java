package com.baby.bunny.student.management.screen.CenterClassActivity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.baby.bunny.student.management.R;
import com.baby.bunny.student.management.adapter.ClassListAdapter;
import com.baby.bunny.student.management.adapter.StudentListAdapter;
import com.baby.bunny.student.management.model.ClassListModel;
import com.baby.bunny.student.management.model.StudentsListModel;
import com.baby.bunny.student.management.screen.CenterStudentActivity.CenterStudentActivity;
import com.baby.bunny.student.management.screen.CenterStudentActivity.CenterStudentOnClick;
import com.baby.bunny.student.management.screen.CenterStudentActivity.CenterStudentViewBind;
import com.baby.bunny.student.management.utils.ApplicationConstant;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CenterClassActivity extends AppCompatActivity {
    CenterClassViewBind centerClassViewBind;
    CenterClassOnClick centerClassOnClick;
    List<ClassListModel>  classListModels;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        View view= LayoutInflater.from(this).inflate(R.layout.activity_center_class,null);
        setContentView(view);
        centerClassViewBind= new CenterClassViewBind(this,view);
        centerClassOnClick=new CenterClassOnClick(this,centerClassViewBind);

        classListModels=new ArrayList<>();

        LinearLayoutManager layoutManager = new LinearLayoutManager(CenterClassActivity.this);

        centerClassViewBind. classrv.setLayoutManager(layoutManager);

        getAllClass();
    }
    public  void getAllClass(){

        StringRequest stringRequest=new StringRequest(Request.Method.POST, ApplicationConstant.CenterManager_getAllClass, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Log.d("sunita", "onResponse: "+response);

                try {
                    JSONObject jsonObject=new JSONObject(response);
                    JSONArray jsonArray=jsonObject.getJSONArray("data");
                    for (int i=0;i<jsonArray.length();i++){

                        JSONObject jsonObject1=jsonArray.getJSONObject(i);

                        ClassListModel studentsListModel=new ClassListModel(

                                jsonObject1.getString("class_name"),
                                jsonObject1.getString("admission_fees"),
                                jsonObject1.getString("monthly_fees")
                        );
                        classListModels.add(studentsListModel);

                    }

                    ClassListAdapter classListAdapter=new ClassListAdapter(CenterClassActivity.this,classListModels);
                    centerClassViewBind.classrv.setAdapter(classListAdapter);
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
                hashMap.put("branch_id","9");

                return hashMap;
            }
        };
        Volley.newRequestQueue(this).add(stringRequest);
    }
}