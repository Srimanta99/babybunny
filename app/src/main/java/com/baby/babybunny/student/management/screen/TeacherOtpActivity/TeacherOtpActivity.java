package com.baby.babybunny.student.management.screen.TeacherOtpActivity;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.baby.babybunny.student.management.R;
import com.baby.babybunny.student.management.screen.TeacherHomeActivity.TeacherHomeActivity;
import com.baby.babybunny.student.management.utils.ApplicationConstant;
import com.baby.babybunny.student.management.utils.SessionManager;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class TeacherOtpActivity extends AppCompatActivity {
    TeacherOtpViewBind teacherOtpViewBind;
    TeacherOtpOnClick teacherOtpOnClick;
    ProgressDialog pd;
    String   message,otp,stuphno,id,success,name,email,phno,image,branch_id;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        pd = new ProgressDialog(this);
        View view= LayoutInflater.from(this).inflate(R.layout.activity_teacher_otp,null);
        setContentView(view);
        teacherOtpViewBind= new TeacherOtpViewBind(this,view);
        teacherOtpOnClick=new TeacherOtpOnClick(this,teacherOtpViewBind);

        stuphno = getIntent().getStringExtra("stuphno");

        loadotp();
        setupOtpLayout();
    }

    private void setupOtpLayout() {

        StringBuilder sb=new StringBuilder();

        teacherOtpViewBind.etotpno1id.requestFocus();
        teacherOtpViewBind. etotpno1id.setCursorVisible(true);

        teacherOtpViewBind. etotpno1id.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) { }
            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if(  teacherOtpViewBind. etotpno1id.length()==1)
                { sb.append(charSequence);
                    teacherOtpViewBind.  etotpno2id.clearFocus();
                    teacherOtpViewBind.  etotpno2id.requestFocus();
                    teacherOtpViewBind.etotpno2id.setCursorVisible(true);
                }
            }
            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
        teacherOtpViewBind.etotpno2id.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) { }
            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if(  teacherOtpViewBind.etotpno2id.length()==1)
                { sb.append(charSequence);
                    teacherOtpViewBind. etotpno3id.clearFocus();
                    teacherOtpViewBind. etotpno3id.requestFocus();
                    teacherOtpViewBind. etotpno3id.setCursorVisible(true);
                }
                else if (  teacherOtpViewBind.etotpno2id.length()==0){
                    teacherOtpViewBind. etotpno2id.clearFocus();
                    teacherOtpViewBind. etotpno1id.requestFocus();
                    teacherOtpViewBind. etotpno1id.setCursorVisible(true);
                }
            }
            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

        teacherOtpViewBind. etotpno3id.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) { }
            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if(  teacherOtpViewBind.etotpno3id.length()==1)
                { sb.append(charSequence);
                    teacherOtpViewBind. etotpno4id.clearFocus();
                    teacherOtpViewBind.  etotpno4id.requestFocus();
                    teacherOtpViewBind. etotpno4id.setCursorVisible(true);
                }
                else if (  teacherOtpViewBind.etotpno3id.length()==0){
                    teacherOtpViewBind.etotpno3id.clearFocus();
                    teacherOtpViewBind. etotpno2id.requestFocus();
                    teacherOtpViewBind. etotpno2id.setCursorVisible(true);
                }
            }
            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

        teacherOtpViewBind.etotpno4id.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) { }
            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if(  teacherOtpViewBind.etotpno4id.length()==1)
                { sb.append(charSequence);
                    teacherOtpViewBind.etotpno5id.clearFocus();
                    teacherOtpViewBind. etotpno5id.requestFocus();
                    teacherOtpViewBind.etotpno5id.setCursorVisible(true);
                }
                else if (  teacherOtpViewBind.etotpno4id.length()==0){
                    teacherOtpViewBind. etotpno4id.clearFocus();
                    teacherOtpViewBind.etotpno3id.requestFocus();
                    teacherOtpViewBind.etotpno3id.setCursorVisible(true);
                }
            }
            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

        teacherOtpViewBind. etotpno5id.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) { }
            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if(  teacherOtpViewBind.etotpno5id.length()==1)
                { sb.append(charSequence);
                    teacherOtpViewBind. etotpno6id.clearFocus();
                    teacherOtpViewBind. etotpno6id.requestFocus();
                    teacherOtpViewBind.etotpno6id.setCursorVisible(true);
                }
                else if (  teacherOtpViewBind.etotpno5id.length()==0){
                    teacherOtpViewBind.etotpno5id.clearFocus();
                    teacherOtpViewBind.etotpno4id.requestFocus();
                    teacherOtpViewBind.etotpno4id.setCursorVisible(true);
                }

            }
            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
        teacherOtpViewBind.etotpno6id.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) { }
            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if(  teacherOtpViewBind.etotpno6id.length()==1)
                {hideKeyboard(TeacherOtpActivity.this);
                }
                else if (  teacherOtpViewBind.etotpno6id.length()==0){
                    teacherOtpViewBind.etotpno6id.clearFocus();
                    teacherOtpViewBind. etotpno5id.requestFocus();
                    teacherOtpViewBind.etotpno5id.setCursorVisible(true);
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
        StringRequest stringRequest=new StringRequest(Request.Method.POST, ApplicationConstant.Teacherurl_getotp, new Response.Listener<String>() {
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


                    SessionManager.setTeacherotpenable(true);
                    SessionManager.setTeacherotp(otp);

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

                return hashMap;
            }
        };

        Volley.newRequestQueue(this).add(stringRequest);
    }
    public void loadsubmit(String otp){
          pd = new ProgressDialog(this);
        pd.setMessage("loading");
        pd.show();
        StringRequest stringRequest=new StringRequest(Request.Method.POST, ApplicationConstant.Teacherurl_login, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Log.d("sunita", "onResponse: "+response);
                pd.dismiss();


                try {
                    JSONObject jsonObject = new JSONObject(response);
                    String    success = jsonObject.getString("success");
                    if (success.equalsIgnoreCase("0")){

                        String message=jsonObject.getString("message");
                        Toast.makeText(TeacherOtpActivity.this, ""+message, Toast.LENGTH_SHORT).show();

                    } else{

                        JSONArray jsonArray = jsonObject.getJSONArray("data");
                        JSONObject jsonObject1 = jsonArray.getJSONObject(0);
                        id = jsonObject1.getString("id");
                        branch_id=jsonObject1.getString("branch_id");
                        name = jsonObject1.getString("teacher_name");
                        email = jsonObject1.getString("email_id");
                        SessionManager.setTeachernamevalue(name);
                        SessionManager.setTeacheremailvalue(email);
                      /*  name = jsonObject1.getString("student_name");
                        email = jsonObject1.getString("email_id");
                        phno = jsonObject1.getString("mobile_no");
                        image = jsonObject1.getString("student_image");*/

                    /*SessionManager.setCenterManageridboolean(true);
                    Toast.makeText(CenterManagerOtpActivity.this, "true", Toast.LENGTH_SHORT).show();*/
                        SessionManager.setTeacheridvalue(id);
                        SessionManager.setTeacher_branch_idvalue(branch_id);


                        Log.d("id", "onResponse: " + id);




                        Intent mainIntent = new Intent(TeacherOtpActivity.this, TeacherHomeActivity.class);
                        SessionManager.setTeacheridboolean(true);

                        SessionManager.setTeacherLogged(true);


                       startActivity(mainIntent);
                      // finish();

                        finishAffinity();
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
                hashMap.put("phone_number",stuphno);
                hashMap.put("password","123456");
                hashMap.put("otp",otp);
                Log.d("hashMap", "getParams: "+hashMap);

                return hashMap;
            }
        };

        Volley.newRequestQueue(this).add(stringRequest);
    }
}