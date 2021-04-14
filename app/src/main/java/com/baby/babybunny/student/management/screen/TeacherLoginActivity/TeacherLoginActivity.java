package com.baby.babybunny.student.management.screen.TeacherLoginActivity;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.baby.babybunny.student.management.R;
import com.baby.babybunny.student.management.screen.TeacherHomeActivity.TeacherHomeActivity;
import com.baby.babybunny.student.management.screen.TeacherOtpActivity.TeacherOtpActivity;
import com.baby.babybunny.student.management.screen.main.MainActivity;
import com.baby.babybunny.student.management.utils.ApplicationConstant;
import com.baby.babybunny.student.management.utils.SessionManager;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class TeacherLoginActivity extends AppCompatActivity {
    TeacherLoginViewBind teacherLoginViewBind;
    TeacherLoginOnClick teacherLoginOnClick;

    boolean saveCenterManagerlogin;
    String otp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        View view= LayoutInflater.from(this).inflate(R.layout.activity_teacher_login,null);
        setContentView(view);
        teacherLoginViewBind= new TeacherLoginViewBind(this,view);
        teacherLoginOnClick=new TeacherLoginOnClick(this,teacherLoginViewBind);

        saveCenterManagerlogin= SessionManager.getTeacheridboolean();

        otp=SessionManager.getTeacherotp();
    }

    public void loadsubmit(){
        final ProgressDialog pd = new ProgressDialog(this);
        pd.setMessage("loading");
        pd.show();
        StringRequest stringRequest=new StringRequest(Request.Method.POST, ApplicationConstant.Teacherurl_usercheck, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                pd.dismiss();
                try {
                    JSONObject jsonObject=new JSONObject(response);
                    String   success=   jsonObject.getString("success");
                    String   message= jsonObject.getString("message");


                    if (saveCenterManagerlogin){

                        if (success.equalsIgnoreCase("1")) {

                            teacherLoginViewBind. cardpasswordid.setVisibility(View.VISIBLE);

                            teacherLoginViewBind.tvsubmitid.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View view) {

                                    loadsubmit(teacherLoginViewBind.etphnoid.getText().toString(),teacherLoginViewBind.etpasswordid.getText().toString());

                                }
                            });
                        }else if (success.equalsIgnoreCase("0")) {
                            Toast.makeText(TeacherLoginActivity.this, "" + message, Toast.LENGTH_SHORT).show();
                        }
                    }else {
                        if (success.equalsIgnoreCase("1") || success.equalsIgnoreCase("2")) {

                           Intent mainIntent = new Intent(TeacherLoginActivity.this, TeacherOtpActivity.class);
                           // Intent mainIntent = new Intent(TeacherLoginActivity.this, TeacherHomeActivity.class);

                            mainIntent.putExtra("stuphno",  teacherLoginViewBind.etphnoid.getText().toString());

                            startActivity(mainIntent);
                            finish();


                        } else if (success.equalsIgnoreCase("0")){

                            Toast.makeText(TeacherLoginActivity.this, "" + message, Toast.LENGTH_SHORT).show();
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
                hashMap.put("phone_number", teacherLoginViewBind. etphnoid.getText().toString());

                return hashMap;
            }
        };

        Volley.newRequestQueue(this).add(stringRequest);
    }


    public void loadsubmit(String phno,String password){
        final ProgressDialog pd = new ProgressDialog(this);
        pd.setMessage("loading");
        pd.show();
        StringRequest stringRequest=new StringRequest(Request.Method.POST, ApplicationConstant.Teacherurl_login, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                pd.dismiss();
                try {
                    JSONObject jsonObject=new JSONObject(response);
                    String      success=  jsonObject.getString("success");
                    JSONArray jsonArray=jsonObject.getJSONArray("data");
                    JSONObject jsonObject1=jsonArray.getJSONObject(0);


                    if (success.equalsIgnoreCase("1")){

                        SessionManager.setTeacherLogged(true);

                        Intent intent = new Intent(TeacherLoginActivity.this, TeacherHomeActivity.class);
                        // intent.putExtra("id",id);
                        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                        startActivity(intent);
                        finish();
                    }else {
                        Toast.makeText(TeacherLoginActivity.this, ""+ jsonObject.getString("message"), Toast.LENGTH_SHORT).show();
                    }

                } catch (JSONException e) {
                    e.printStackTrace();
                }

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                pd.dismiss();
            }
        }){
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                HashMap<String,String> hashMap=new HashMap<>();
                hashMap.put("secret_key","D32B55F2853AF98C9732D74942F4A");
                hashMap.put("token_key","1D555E491ED458AB22858516998CF");
                hashMap.put("phone_number", teacherLoginViewBind. etphnoid.getText().toString());
                hashMap.put("password",password);
                hashMap.put("otp","");
                return hashMap;
            }
        };

        Volley.newRequestQueue(this).add(stringRequest);
    }


    @Override
    public void onBackPressed() {
        Intent intent=new Intent(this, MainActivity.class);

        startActivity(intent);
        finish();
        super.onBackPressed();
    }
}