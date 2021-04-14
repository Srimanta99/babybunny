package com.baby.babybunny.student.management.screen.CenterTeacherActivity;

import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.baby.babybunny.student.management.R;
import com.baby.babybunny.student.management.adapter.SelectClassAdapter;
import com.baby.babybunny.student.management.adapter.TeacherListAdapter;
import com.baby.babybunny.student.management.model.SelectClassModel;
import com.baby.babybunny.student.management.model.TeacherListModel;
import com.baby.babybunny.student.management.utils.ApplicationConstant;
import com.baby.babybunny.student.management.utils.CustomAlertDialog;
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

public class CenterTeacherActivity extends AppCompatActivity {
    CenterTeacherViewBind centerTeacherViewBind;
    CenterTeacherOnClick centerTeacherOnClick;
    List<TeacherListModel> teacherListModelList;

    ArrayList<SelectClassModel> selectClassModels;


    String class_name,Class_id;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        View view= LayoutInflater.from(this).inflate(R.layout.activity_center_teacher,null);
        setContentView(view);


        centerTeacherViewBind= new CenterTeacherViewBind(this,view);
        centerTeacherOnClick=new CenterTeacherOnClick(this,centerTeacherViewBind);

        centerTeacherViewBind. actionBarDrawerToggle = new ActionBarDrawerToggle(this,centerTeacherViewBind. drawerLayout, R.string.app_name, R.string.app_name);

        centerTeacherViewBind. drawerLayout.addDrawerListener( centerTeacherViewBind.actionBarDrawerToggle);
        centerTeacherViewBind. actionBarDrawerToggle.syncState();

        findViewById(R.id.img_nav).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                centerTeacherViewBind. drawerLayout.openDrawer(Gravity.RIGHT);

            }
        }); findViewById(R.id.img_navclose).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                centerTeacherViewBind. drawerLayout.closeDrawer(Gravity.RIGHT);

            }
        });

        teacherListModelList=new ArrayList<>();

        selectClassModels=new ArrayList<>();

        LinearLayoutManager layoutManager = new LinearLayoutManager(CenterTeacherActivity.this);

        centerTeacherViewBind. teacherrv.setLayoutManager(layoutManager);

        getAllClass();
        getAllTeacher();


    }
    public  void getAllTeacher(){

        ProgressBar progressBar = (ProgressBar)findViewById(R.id.progress);
        centerTeacherViewBind.progresslvid.setVisibility(View.VISIBLE);
        Sprite doubleBounce = new FadingCircle();
        progressBar.setIndeterminateDrawable(doubleBounce);

        StringRequest stringRequest=new StringRequest(Request.Method.POST, ApplicationConstant.CenterManager_getAllTeacher, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    JSONObject jsonObject = new JSONObject(response);

                    String    success = jsonObject.getString("success");
                    if (success.equalsIgnoreCase("0")){
                        progressBar.setVisibility(View.GONE);
                        centerTeacherViewBind.progresslvid.setVisibility(View.GONE);
                        centerTeacherViewBind.nodatafoundlvid.setVisibility(View.VISIBLE);
                    } else{
                        progressBar.setVisibility(View.GONE);
                        centerTeacherViewBind.nodatafoundlvid.setVisibility(View.GONE);

                        JSONArray jsonArray = jsonObject.getJSONArray("data");
                        for (int i = 0; i < jsonArray.length(); i++) {

                            JSONObject jsonObject1 = jsonArray.getJSONObject(i);

                            TeacherListModel teacherListModel = new TeacherListModel(
                                    jsonObject1.getString("teacher_image"),
                                    jsonObject1.getString("teacher_name"),
                                    jsonObject1.getString("teacher_id"),
                                    jsonObject1.getString("email_id"),
                                    jsonObject1.getString("teacher_mobile"),
                                    jsonObject1.getString("blood_group"),
                                    jsonObject1.getString("dob")

                            );
                            teacherListModelList.add(teacherListModel);

                        }

                        TeacherListAdapter teacherListAdapter = new TeacherListAdapter(CenterTeacherActivity.this, teacherListModelList);
                        centerTeacherViewBind.teacherrv.setAdapter(teacherListAdapter);

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
               // hashMap.put("branch_id","9");
                hashMap.put("branch_id", SessionManager.getCenterManabranch_idvalue());

                return hashMap;
            }
        };
        Volley.newRequestQueue(this).add(stringRequest);
    }


    public  void getAllClass(){

        StringRequest stringRequest=new StringRequest(Request.Method.POST, ApplicationConstant.CenterManager_getAllClass, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {


                try {
                    JSONObject jsonObject=new JSONObject(response);
                    JSONArray jsonArray=jsonObject.getJSONArray("data");

                    selectClassModels.add(new SelectClassModel("Select Class","0"));

                    for (int i=0;i<jsonArray.length();i++){

                        JSONObject jsonObject1=jsonArray.getJSONObject(i);
                        SelectClassModel selectClassModel=new SelectClassModel(
                                class_name= jsonObject1.getString("class_name"),
                                jsonObject1.getString("id")

                        );

                        selectClassModels.add(selectClassModel);

                          SelectClassAdapter selectClassAdapter=new SelectClassAdapter(CenterTeacherActivity.this, selectClassModels);
                          centerTeacherViewBind.select_class_spinnerid.setAdapter(selectClassAdapter);


                    }


                    centerTeacherViewBind.select_class_spinnerid.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                        @Override
                        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                           Class_id= selectClassModels.get(position).getId();
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
                hashMap.put("branch_id",SessionManager.getCenterManabranch_idvalue());

                return hashMap;
            }
        };
        Volley.newRequestQueue(this).add(stringRequest);
    }


    public void classwiseteeacher(String id){

        ProgressDialog pd = new ProgressDialog(this);
        pd.setMessage("loading");
        pd.show();


        StringRequest stringRequest=new StringRequest(Request.Method.POST, ApplicationConstant.CenterManager_classwiseteeacher, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Log.d("sunita", "onResponse: "+response);

                centerTeacherViewBind. drawerLayout.closeDrawer(Gravity.RIGHT);
                pd.dismiss();

                try {
                    JSONObject jsonObject=new JSONObject(response);

                    String    success = jsonObject.getString("success");

                    if (success.equalsIgnoreCase("0")){
                        CustomAlertDialog.NoDataFound(CenterTeacherActivity.this);

                        Toast.makeText(CenterTeacherActivity.this, ""+jsonObject.getString("message"), Toast.LENGTH_SHORT).show();

                    } else {
                        teacherListModelList.clear();
                        JSONArray jsonArray = jsonObject.getJSONArray("data");
                        for (int i = 0; i < jsonArray.length(); i++) {

                            JSONObject jsonObject1 = jsonArray.getJSONObject(i);

                            TeacherListModel teacherListModel = new TeacherListModel(
                                    jsonObject1.getString("teacher_image"),
                                    jsonObject1.getString("teacher_name"),
                                    jsonObject1.getString("teacher_id"),
                                    jsonObject1.getString("email_id"),
                                    jsonObject1.getString("teacher_mobile"),
                                    jsonObject1.getString("blood_group"),
                                    jsonObject1.getString("dob")

                            );
                            teacherListModelList.add(teacherListModel);

                        }
                    }

                    TeacherListAdapter teacherListAdapter=new TeacherListAdapter(CenterTeacherActivity.this,teacherListModelList);
                    centerTeacherViewBind. teacherrv.setAdapter(teacherListAdapter);
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
                hashMap.put("branch_id",SessionManager.getCenterManabranch_idvalue());
                hashMap.put("class_id",id);
                Log.d("hash", "getParams: "+hashMap);
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