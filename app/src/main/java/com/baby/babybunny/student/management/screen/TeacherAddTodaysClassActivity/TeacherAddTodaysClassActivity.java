package com.baby.babybunny.student.management.screen.TeacherAddTodaysClassActivity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.Spinner;
import android.widget.TextView;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.baby.babybunny.student.management.R;
import com.baby.babybunny.student.management.adapter.TeachetGetAllClassAdapter;
import com.baby.babybunny.student.management.model.TeachetGetAllClassModel;
import com.baby.babybunny.student.management.screen.TeacherTodaysClass.TeacherTodaysClass;
import com.baby.babybunny.student.management.utils.ApplicationConstant;
import com.baby.babybunny.student.management.utils.MyToast;
import com.baby.babybunny.student.management.utils.SessionManager;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class TeacherAddTodaysClassActivity extends AppCompatActivity implements View.OnClickListener {
TextView toolname_id,tvsubmmitid;
ImageView back_icon;
EditText etn_sub_details,etn_subject;
    ArrayList<TeachetGetAllClassModel> teachetGetAllClassModels;
    String class_name,Class_id;
    Spinner select_class_spinnerid;
    ProgressBar progress_bar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teacher_add_todays_class);
        toolname_id=findViewById(R.id.toolname_id) ;
        back_icon=findViewById(R.id.back_icon) ;
        tvsubmmitid=findViewById(R.id.tvsubmmitid) ;
        etn_sub_details=findViewById(R.id.etn_sub_details);
        etn_subject=findViewById(R.id.etn_subject);
        select_class_spinnerid=findViewById(R.id.select_class_spinnerid);
        progress_bar=findViewById(R.id.progress_bar);
        toolname_id.setText("Add Today's Class");

        back_icon.setOnClickListener(this);
        tvsubmmitid.setOnClickListener(this);

        teachetGetAllClassModels=new ArrayList<>();

        getAllClass();
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.back_icon:{
                // Toast.makeText(mainActivity,"hello",Toast.LENGTH_LONG).show();
               onBackPressed();

            }
            break;
            case R.id.tvsubmmitid:{
                // Toast.makeText(mainActivity,"hello",Toast.LENGTH_LONG).show();

                if (Class_id.equalsIgnoreCase("0")){
                    MyToast.show(TeacherAddTodaysClassActivity.this,"Please select class",true);

                }else if (etn_subject.getText().toString().isEmpty()){
                    MyToast.show(TeacherAddTodaysClassActivity.this,"Please enter subject",true);

                }else if (etn_sub_details.getText().toString().isEmpty()){
                    MyToast.show(TeacherAddTodaysClassActivity.this,"Please enter content",true);

                }else {
                    apicallForinserttdclass(Class_id);
                }

            }
            break;
        }
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

                        TeachetGetAllClassAdapter selectClassAdapter=new TeachetGetAllClassAdapter(TeacherAddTodaysClassActivity.this, teachetGetAllClassModels);
                      select_class_spinnerid.setAdapter(selectClassAdapter);


                    }


                   select_class_spinnerid.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
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
               // hashMap.put("branch_id", SessionManager.getTeacher_branch_idvalue());
                hashMap.put("branch_id", SessionManager.getTeacher_branch_idvalue());

                return hashMap;
            }
        };
        Volley.newRequestQueue(this).add(stringRequest);
    }
    public void apicallForinserttdclass(String Class_id){
       /* ProgressDialog pd = new ProgressDialog(this);
        pd.setMessage("loading");
        pd.setCancelable(false);
        pd.show();*/

        tvsubmmitid.setVisibility(View.GONE);
       progress_bar.setVisibility(View.VISIBLE);
        progress_bar.getProgress();

        StringRequest stringRequest=new StringRequest(Request.Method.POST, ApplicationConstant.Teacherurl_inserttdclass, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Log.d("sunita", "onResponse: "+response);
             //   pd.dismiss();
                try {
                    JSONObject jsonObject=new JSONObject(response);
                    String    success = jsonObject.getString("success");
                    String message=jsonObject.getString("message");
                    if (success.equalsIgnoreCase("0")){
                        MyToast.show(TeacherAddTodaysClassActivity.this,""+message,true);

                    }else {
                        tvsubmmitid.setVisibility(View.VISIBLE);
                       progress_bar.setVisibility(View.GONE);
                        MyToast.show(TeacherAddTodaysClassActivity.this,""+message,true);
                        Intent intent=new Intent(TeacherAddTodaysClassActivity.this, TeacherTodaysClass.class);
                       startActivity(intent);

                        //  Toast.makeText(TeacherAddTodaysClassActivity.this, ""+message, Toast.LENGTH_SHORT).show();
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
              //  hashMap.put("teacher_id", SessionManager.getTeacheridvalue());
                hashMap.put("teacher_id", SessionManager.getTeacheridvalue());
                hashMap.put("class_id",Class_id);
                hashMap.put("subject",etn_subject.getText().toString());
                hashMap.put("sub_details",etn_sub_details.getText().toString());
                Log.d("hashmap", "getParams: "+hashMap);
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