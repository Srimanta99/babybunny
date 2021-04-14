package com.baby.babybunny.student.management.screen.StudentTodaysClassActivity;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ProgressBar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.baby.babybunny.student.management.R;
import com.baby.babybunny.student.management.adapter.StudentTodaysClassDateAdapter;
import com.baby.babybunny.student.management.model.StudentTodayClassTestModel;
import com.baby.babybunny.student.management.model.StudentTodaysClassDateModel;
import com.baby.babybunny.student.management.utils.ApplicationConstant;
import com.baby.babybunny.student.management.utils.CustomAlertDialog;
import com.github.ybq.android.spinkit.sprite.Sprite;
import com.github.ybq.android.spinkit.style.FadingCircle;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

        studentTodayClassViewBind.toolname_id.setText("Today's Class     ");


        studentTodaysClassDateModels=new ArrayList<>();
        if (isConnected()) {
            loaddata();

        } else {

            CustomAlertDialog.NoInternetAlert(StudentTodaysClass.this);
        }

    }

    public boolean isConnected() {
        boolean connected = false;
        try {
            ConnectivityManager cm = (ConnectivityManager) StudentTodaysClass.this.getSystemService(Context.CONNECTIVITY_SERVICE);
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

    public void loaddata(){
        ProgressBar progressBar = (ProgressBar)findViewById(R.id.progress);
        studentTodayClassViewBind.progresslvid.setVisibility(View.VISIBLE);
        Sprite doubleBounce = new FadingCircle();
        progressBar.setIndeterminateDrawable(doubleBounce);
        StringRequest stringRequest=new StringRequest(Request.Method.POST, ApplicationConstant.student_todayclass, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

                progressBar.setVisibility(View.GONE);

                try {
                    JSONObject jsonObject=new JSONObject(response);

                    String    success = jsonObject.getString("success");
                    if (success.equalsIgnoreCase("0")){
                        progressBar.setVisibility(View.GONE);
                        studentTodayClassViewBind .progresslvid.setVisibility(View.GONE);
                        studentTodayClassViewBind.nodatafoundlvid.setVisibility(View.VISIBLE);
                    } else {
                        studentTodayClassViewBind.nodatafoundlvid.setVisibility(View.GONE);
                        progressBar.setVisibility(View.GONE);
                        JSONArray jsonArray = jsonObject.getJSONArray("data");

                        for (int i = 0; i < jsonArray.length(); i++) {
                            JSONObject obj = jsonArray.getJSONObject(i);

                            studentTodayClassTestModels = new ArrayList<>();

                            StudentTodaysClassDateModel studentTodaysClassDateModel = new StudentTodaysClassDateModel();

                            studentTodaysClassDateModel.setTdate(obj.getString("tdate"));

                            JSONArray jsonArray1 = obj.getJSONArray("task");


                            for (int j = 0; j < jsonArray1.length(); j++) {

                                JSONObject jsonObject1 = jsonArray1.getJSONObject(j);

                                StudentTodayClassTestModel studentTodayClassTestModel = new StudentTodayClassTestModel();
                                studentTodayClassTestModel.setDescription(jsonObject1.getString("created"));

                                studentTodayClassTestModels.add(studentTodayClassTestModel);

                            }
                            studentTodaysClassDateModel.setStudentTodayClassTestModels(studentTodayClassTestModels);


                            studentTodaysClassDateModels.add(studentTodaysClassDateModel);

                        }

                        StudentTodaysClassDateAdapter adapter = new StudentTodaysClassDateAdapter(studentTodaysClassDateModels, StudentTodaysClass.this);
                        studentTodayClassViewBind.recyclerView.setHasFixedSize(true);
                        studentTodayClassViewBind.recyclerView.setLayoutManager(new LinearLayoutManager(StudentTodaysClass.this));
                        studentTodayClassViewBind.recyclerView.setAdapter(adapter);

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
                hashMap.put("class_id","3");
                return hashMap;
            }
        };

        Volley.newRequestQueue(this).add(stringRequest);
    }

}