package com.baby.bunny.student.management.screen.StudentLoginActivity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.app.ProgressDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
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
import com.baby.bunny.student.management.R;
import com.baby.bunny.student.management.screen.StudentOTPActivity.StudentOTPActivity;
import com.baby.bunny.student.management.screen.StudentHomeActivity.StudentHomeActivity;
import com.baby.bunny.student.management.utils.ApplicationConstant;
import com.baby.bunny.student.management.utils.SessionManager;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class StudentLoginActivity extends AppCompatActivity {
    StuloginwithphnoViewBind stuloginwithphnoViewBind;
    StuloginwithphnoOnClick stuloginwithphnoOnClick;

   SharedPreferences sharedpreferences;
   boolean savelogin;
   String otp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        View view= LayoutInflater.from(this).inflate(R.layout.activity_stuloginwithphno,null);
        setContentView(view);
       stuloginwithphnoViewBind= new StuloginwithphnoViewBind(this,view);
      stuloginwithphnoOnClick=new StuloginwithphnoOnClick(this,stuloginwithphnoViewBind);

        savelogin=SessionManager.getidboolean();

         otp=SessionManager.getotp();


        ActivityCompat.requestPermissions( StudentLoginActivity.this, new String[]{Manifest.permission.READ_SMS}, PackageManager.PERMISSION_GRANTED);

    }
    public void loadsubmit(){
        final ProgressDialog pd = new ProgressDialog(this);
        pd.setMessage("loading");
        pd.show();
        StringRequest stringRequest=new StringRequest(Request.Method.POST, ApplicationConstant.loginwithphnourl, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                pd.dismiss();
                try {
                    JSONObject jsonObject=new JSONObject(response);
                    String   success=   jsonObject.getString("success");
                    String   message= jsonObject.getString("message");


                  if (savelogin){
                      if (success.equalsIgnoreCase("1")) {

                         stuloginwithphnoViewBind. cardpasswordid.setVisibility(View.VISIBLE);

                          stuloginwithphnoViewBind.tvsubmitid.setOnClickListener(new View.OnClickListener() {
                              @Override
                              public void onClick(View view) {

                                  loadsubmit(otp,stuloginwithphnoViewBind.etpasswordid.getText().toString());

                              }
                          });
                      }else if (success.equalsIgnoreCase("0")) {
                          Toast.makeText(StudentLoginActivity.this, "" + message, Toast.LENGTH_SHORT).show();
                      }
                    }else {

                      if (success.equalsIgnoreCase("1")) {

                       //   SessionManager.setLogged(true);


                          Intent mainIntent = new Intent(StudentLoginActivity.this, StudentOTPActivity.class);
                          mainIntent.putExtra("stuphno",  stuloginwithphnoViewBind.etphnoid.getText().toString());
                          startActivity(mainIntent);
                          finish();


                      } else if (success.equalsIgnoreCase("0")) {
                          Toast.makeText(StudentLoginActivity.this, "" + message, Toast.LENGTH_SHORT).show();
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
                hashMap.put("phone_number", stuloginwithphnoViewBind. etphnoid.getText().toString());
                return hashMap;
            }
        };

        Volley.newRequestQueue(this).add(stringRequest);
    }


    public void loadsubmit(String otp,String password){
        final ProgressDialog pd = new ProgressDialog(this);
        pd.setMessage("loading");
        pd.show();
        StringRequest stringRequest=new StringRequest(Request.Method.POST, ApplicationConstant.studentOTP_Passwordurl, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                pd.dismiss();
                try {
                    JSONObject jsonObject=new JSONObject(response);
                   String      success=  jsonObject.getString("success");
                    JSONArray jsonArray=jsonObject.getJSONArray("data");
                    JSONObject jsonObject1=jsonArray.getJSONObject(0);


                    if (success.equalsIgnoreCase("1")){

                        SessionManager.setLogged(true);

                        Intent intent = new Intent(StudentLoginActivity.this, StudentHomeActivity.class);
                        // intent.putExtra("id",id);
                        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
                        startActivity(intent);
                        finish();
                    }else {
                        Toast.makeText(StudentLoginActivity.this, "please enter vaild password", Toast.LENGTH_SHORT).show();
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
                hashMap.put("phone_number", stuloginwithphnoViewBind. etphnoid.getText().toString());
                hashMap.put("password",password);
                hashMap.put("otp",otp);
                return hashMap;
            }
        };

        Volley.newRequestQueue(this).add(stringRequest);
    }

}