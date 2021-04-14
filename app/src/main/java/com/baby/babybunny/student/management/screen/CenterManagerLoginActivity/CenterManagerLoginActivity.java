package com.baby.babybunny.student.management.screen.CenterManagerLoginActivity;

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
import com.baby.babybunny.student.management.screen.CenterManagerHomeActivity.CenterManagerHomeActivity;
import com.baby.babybunny.student.management.screen.CenterManagerOtpActivity.CenterManagerOtpActivity;
import com.baby.babybunny.student.management.screen.main.MainActivity;
import com.baby.babybunny.student.management.utils.ApplicationConstant;
import com.baby.babybunny.student.management.utils.SessionManager;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class CenterManagerLoginActivity extends AppCompatActivity {
    CenterManagerLoginViewBind centerManagerLoginViewBind;
    CenterManagerLoginOnClick centerManagerLoginOnClick;

    boolean saveCenterManagerlogin;
    String otp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        View view= LayoutInflater.from(this).inflate(R.layout.activity_center_manager_login,null);
        setContentView(view);
        centerManagerLoginViewBind= new CenterManagerLoginViewBind(this,view);
        centerManagerLoginOnClick=new CenterManagerLoginOnClick(this,centerManagerLoginViewBind);

        saveCenterManagerlogin= SessionManager.getCenterManageridboolean();

        otp=SessionManager.getCenterManagerotp();

    }

    public void loadsubmit(){
         final ProgressDialog pd = new ProgressDialog(this);
          pd.setMessage("loading");
          pd.show();
        StringRequest stringRequest=new StringRequest(Request.Method.POST, ApplicationConstant.centermanager_usercheck, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                    pd.dismiss();
                try {
                    JSONObject jsonObject=new JSONObject(response);
                    String   success=   jsonObject.getString("success");
                    String   message= jsonObject.getString("message");


                    if (saveCenterManagerlogin){

                        if (success.equalsIgnoreCase("1")) {

                            centerManagerLoginViewBind. cardpasswordid.setVisibility(View.VISIBLE);

                            centerManagerLoginViewBind.tvsubmitid.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View view) {

                                    loadsubmit(centerManagerLoginViewBind.etphnoid.getText().toString(),centerManagerLoginViewBind.etpasswordid.getText().toString());

                                }
                            });
                        }else if (success.equalsIgnoreCase("0")) {
                            Toast.makeText(CenterManagerLoginActivity.this, "" + message, Toast.LENGTH_SHORT).show();
                        }
                    }else {
                        if (success.equalsIgnoreCase("1") || success.equalsIgnoreCase("2")) {

                            Intent mainIntent = new Intent(CenterManagerLoginActivity.this,CenterManagerOtpActivity.class);
                           // Intent mainIntent = new Intent(CenterManagerLoginActivity.this,CenterManagerHomeActivity.class);

                            mainIntent.putExtra("stuphno",  centerManagerLoginViewBind.etphnoid.getText().toString());

                            startActivity(mainIntent);
                            finish();


                        } else if (success.equalsIgnoreCase("0")){

                            Toast.makeText(CenterManagerLoginActivity.this, "" + message, Toast.LENGTH_SHORT).show();
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
                hashMap.put("phone_number", centerManagerLoginViewBind.etphnoid.getText().toString());

                return hashMap;
            }
        };

        Volley.newRequestQueue(this).add(stringRequest);
    }


    public void loadsubmit(String phno,String password){
        final ProgressDialog pd = new ProgressDialog(this);
        pd.setMessage("loading");
        pd.show();
       StringRequest stringRequest=new StringRequest(Request.Method.POST, ApplicationConstant.centermanager_login, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                pd.dismiss();
                try {
                    JSONObject jsonObject=new JSONObject(response);
                    String      success=  jsonObject.getString("success");
                    JSONArray jsonArray=jsonObject.getJSONArray("data");
                    JSONObject jsonObject1=jsonArray.getJSONObject(0);


                    if (success.equalsIgnoreCase("1")){

                        SessionManager.setCenterManagerLogged(true);

                        Intent intent = new Intent(CenterManagerLoginActivity.this, CenterManagerHomeActivity.class);
                        // intent.putExtra("id",id);
                        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                        startActivity(intent);
                        finish();
                    }else {
                        Toast.makeText(CenterManagerLoginActivity.this, "please enter vaild password", Toast.LENGTH_SHORT).show();
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
                hashMap.put("phone_number", centerManagerLoginViewBind. etphnoid.getText().toString());
                hashMap.put("password",password);
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