package com.baby.babybunny.student.management.screen.StudentOTPActivity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.IntentCompat;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.ComponentName;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.inputmethod.InputMethodManager;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.baby.babybunny.student.management.R;
import com.baby.babybunny.student.management.screen.StudentHomeActivity.StudentHomeActivity;
import com.baby.babybunny.student.management.utils.ApplicationConstant;
import com.baby.babybunny.student.management.utils.SessionManager;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class StudentOTPActivity extends AppCompatActivity {
    StudentOTPViewBind studentOTP_viewBind;
    StudentOTPOnClick studentOTP_onClick;
     ProgressDialog pd;
    String   message,otp,stuphno,id,success,name,email,phno,image;
    static StudentOTPActivity INSTANCE;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        pd = new ProgressDialog(this);
        View view= LayoutInflater.from(this).inflate(R.layout.activity_stu_o_t_p_,null);
        setContentView(view);
        studentOTP_viewBind= new StudentOTPViewBind(this,view);
        studentOTP_onClick=new StudentOTPOnClick(this,studentOTP_viewBind);
        INSTANCE=this;

        stuphno = getIntent().getStringExtra("stuphno");



        loadotp();
        setupOtpLayout();



    }

    private void setupOtpLayout() {

        StringBuilder sb=new StringBuilder();

       studentOTP_viewBind.etotpno1id.requestFocus();
        studentOTP_viewBind. etotpno1id.setCursorVisible(true);

        studentOTP_viewBind. etotpno1id.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) { }
            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if(  studentOTP_viewBind. etotpno1id.length()==1)
                { sb.append(charSequence);
                    studentOTP_viewBind.  etotpno2id.clearFocus();
                    studentOTP_viewBind.  etotpno2id.requestFocus();
                    studentOTP_viewBind.etotpno2id.setCursorVisible(true);
                }
            }
            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
        studentOTP_viewBind.etotpno2id.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) { }
            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if(  studentOTP_viewBind.etotpno2id.length()==1)
                { sb.append(charSequence);
                    studentOTP_viewBind. etotpno3id.clearFocus();
                    studentOTP_viewBind. etotpno3id.requestFocus();
                    studentOTP_viewBind. etotpno3id.setCursorVisible(true);
                }
                else if (  studentOTP_viewBind.etotpno2id.length()==0){
                    studentOTP_viewBind. etotpno2id.clearFocus();
                    studentOTP_viewBind. etotpno1id.requestFocus();
                    studentOTP_viewBind. etotpno1id.setCursorVisible(true);
                }
            }
            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

        studentOTP_viewBind. etotpno3id.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) { }
            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if(  studentOTP_viewBind.etotpno3id.length()==1)
                { sb.append(charSequence);
                    studentOTP_viewBind. etotpno4id.clearFocus();
                    studentOTP_viewBind.  etotpno4id.requestFocus();
                    studentOTP_viewBind. etotpno4id.setCursorVisible(true);
                }
                else if (  studentOTP_viewBind.etotpno3id.length()==0){
                    studentOTP_viewBind.etotpno3id.clearFocus();
                    studentOTP_viewBind. etotpno2id.requestFocus();
                    studentOTP_viewBind. etotpno2id.setCursorVisible(true);
                }
            }
            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

        studentOTP_viewBind.etotpno4id.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) { }
            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if(  studentOTP_viewBind.etotpno4id.length()==1)
                { sb.append(charSequence);
                    studentOTP_viewBind.etotpno5id.clearFocus();
                    studentOTP_viewBind. etotpno5id.requestFocus();
                    studentOTP_viewBind.etotpno5id.setCursorVisible(true);
                }
                else if (  studentOTP_viewBind.etotpno4id.length()==0){
                    studentOTP_viewBind. etotpno4id.clearFocus();
                    studentOTP_viewBind.etotpno3id.requestFocus();
                    studentOTP_viewBind.etotpno3id.setCursorVisible(true);
                }
            }
            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

        studentOTP_viewBind. etotpno5id.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) { }
            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if(  studentOTP_viewBind.etotpno5id.length()==1)
                { sb.append(charSequence);
                    studentOTP_viewBind. etotpno6id.clearFocus();
                    studentOTP_viewBind. etotpno6id.requestFocus();
                    studentOTP_viewBind.etotpno6id.setCursorVisible(true);
                }
                else if (  studentOTP_viewBind.etotpno5id.length()==0){
                    studentOTP_viewBind.etotpno5id.clearFocus();
                    studentOTP_viewBind.etotpno4id.requestFocus();
                    studentOTP_viewBind.etotpno4id.setCursorVisible(true);
                }

            }
            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
        studentOTP_viewBind.etotpno6id.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) { }
            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if(  studentOTP_viewBind.etotpno6id.length()==1)
                {hideKeyboard(StudentOTPActivity.this);
                }
                else if (  studentOTP_viewBind.etotpno6id.length()==0){
                    studentOTP_viewBind.etotpno6id.clearFocus();
                    studentOTP_viewBind. etotpno5id.requestFocus();
                    studentOTP_viewBind.etotpno5id.setCursorVisible(true);
                }

            }
            @Override
            public void afterTextChanged(Editable editable) {

            }
        });




    }

    public static void hideKeyboard(Activity activity) {
        InputMethodManager imm = (InputMethodManager) activity.getSystemService(Activity.INPUT_METHOD_SERVICE);
        //Find the currently focused view, so we can grab the correct window token from it.
        View view = activity.getCurrentFocus();
        //If no view currently has focus, create a new one, just so we can grab a window token from it
        if (view == null) {
            view = new View(activity);
        }
        imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
    }


    private void loadotp(){

        StringRequest stringRequest=new StringRequest(Request.Method.POST, ApplicationConstant.studentotpurl, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

                Log.d("reeee", "onResponse: "+response);
                try {
                    JSONObject jsonObject=new JSONObject(response);
                     success=   jsonObject.getString("success");


                      message= jsonObject.getString("message");
                    JSONArray jsonArray=jsonObject.getJSONArray("data");
                    JSONObject jsonObject1=jsonArray.getJSONObject(0);
                     otp=   jsonObject1.getString("otp");
                    Log.d("otp", "onResponse: "+otp);


                    SessionManager.setotpenable(true);
                    SessionManager.setotp(otp);

                    Log.d("otp", "onResponse: "+otp);

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
                hashMap.put("phone_number",stuphno);
                Log.d("sunita", "getParams: "+hashMap);
                return hashMap;
            }
        };

        Volley.newRequestQueue(this).add(stringRequest);
    }
    public void loadsubmit(String otp){
        pd = new ProgressDialog(this);
        pd.setMessage("loading");
        pd.show();
        StringRequest stringRequest=new StringRequest(Request.Method.POST, ApplicationConstant.studentOTP_Passwordurl, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Log.d("sunita", "onResponse: "+response);
             pd.dismiss();

                try {
                    JSONObject jsonObject=new JSONObject(response);
               JSONArray jsonArray=jsonObject.getJSONArray("data");
                JSONObject jsonObject1=jsonArray.getJSONObject(0);
                  id= jsonObject1.getString("id");
                  name=jsonObject1.getString("student_name");
                  email=jsonObject1.getString("email_id");
                  phno= jsonObject1.getString("mobile_no");
                  image=jsonObject1.getString("student_image");

                    SessionManager.setidvalue(id);
                    SessionManager.setnamevalue(name);
                    SessionManager.setemailidvalue(email);
                    SessionManager.setphnovalue(phno);
                    SessionManager.setimagevalue(image);


                    Log.d("id", "onResponse: " +id);

                    Intent mainIntent = new Intent(StudentOTPActivity.this, StudentHomeActivity.class);
                    SessionManager.setidboolean(true);

                    SessionManager.setLogged(true);

               /*     mainIntent.setFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP |
                            Intent.FLAG_ACTIVITY_CLEAR_TASK |
                            Intent.FLAG_ACTIVITY_NEW_TASK);*/
                //    mainIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);


                    startActivity(mainIntent);

                  //  finish();
                    finishAffinity();

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
                hashMap.put("phone_number",stuphno);
                hashMap.put("password","");
                hashMap.put("otp",otp);

                Log.d("sunita", "getParams: "+hashMap);
                return hashMap;
            }
        };

        Volley.newRequestQueue(this).add(stringRequest);
    }

    public static StudentOTPActivity getActivityInstance()
    {
        return INSTANCE;
    }

    public String sendToHomaeFrag() {

        return id;
    }
}