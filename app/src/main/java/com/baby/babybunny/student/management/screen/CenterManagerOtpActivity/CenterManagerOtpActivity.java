package com.baby.babybunny.student.management.screen.CenterManagerOtpActivity;

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
import com.baby.babybunny.student.management.screen.CenterManagerHomeActivity.CenterManagerHomeActivity;
import com.baby.babybunny.student.management.utils.ApplicationConstant;
import com.baby.babybunny.student.management.utils.SessionManager;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class CenterManagerOtpActivity extends AppCompatActivity {
    CenterManagerOtpViewBind centerManagerOtpViewBind;
    CenterManagerOtpOnClick centerManagerOtpOnClick;
    ProgressDialog pd;
    String   message,otp,stuphno,id,success,name,email,phno,image,branch_id;
    static CenterManagerOtpActivity INSTANCE;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       pd = new ProgressDialog(this);
        View view= LayoutInflater.from(this).inflate(R.layout.activity_center_manager_otp,null);
        setContentView(view);
        centerManagerOtpViewBind= new CenterManagerOtpViewBind(this,view);
        centerManagerOtpOnClick=new CenterManagerOtpOnClick(this,centerManagerOtpViewBind);
        INSTANCE=this;

        stuphno = getIntent().getStringExtra("stuphno");

        loadotp();
        setupOtpLayout();

    }


    private void setupOtpLayout() {

        StringBuilder sb=new StringBuilder();

        centerManagerOtpViewBind.etotpno1id.requestFocus();
        centerManagerOtpViewBind. etotpno1id.setCursorVisible(true);

        centerManagerOtpViewBind. etotpno1id.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) { }
            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if(  centerManagerOtpViewBind. etotpno1id.length()==1)
                { sb.append(charSequence);
                    centerManagerOtpViewBind.  etotpno2id.clearFocus();
                    centerManagerOtpViewBind.  etotpno2id.requestFocus();
                    centerManagerOtpViewBind.etotpno2id.setCursorVisible(true);
                }
            }
            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
        centerManagerOtpViewBind.etotpno2id.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) { }
            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if(  centerManagerOtpViewBind.etotpno2id.length()==1)
                { sb.append(charSequence);
                    centerManagerOtpViewBind. etotpno3id.clearFocus();
                    centerManagerOtpViewBind. etotpno3id.requestFocus();
                    centerManagerOtpViewBind. etotpno3id.setCursorVisible(true);
                }
                else if (  centerManagerOtpViewBind.etotpno2id.length()==0){
                    centerManagerOtpViewBind. etotpno2id.clearFocus();
                    centerManagerOtpViewBind. etotpno1id.requestFocus();
                    centerManagerOtpViewBind. etotpno1id.setCursorVisible(true);
                }
            }
            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

        centerManagerOtpViewBind. etotpno3id.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) { }
            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if(  centerManagerOtpViewBind.etotpno3id.length()==1)
                { sb.append(charSequence);
                    centerManagerOtpViewBind. etotpno4id.clearFocus();
                    centerManagerOtpViewBind.  etotpno4id.requestFocus();
                    centerManagerOtpViewBind. etotpno4id.setCursorVisible(true);
                }
                else if (  centerManagerOtpViewBind.etotpno3id.length()==0){
                    centerManagerOtpViewBind.etotpno3id.clearFocus();
                    centerManagerOtpViewBind. etotpno2id.requestFocus();
                    centerManagerOtpViewBind. etotpno2id.setCursorVisible(true);
                }
            }
            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

        centerManagerOtpViewBind.etotpno4id.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) { }
            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if(  centerManagerOtpViewBind.etotpno4id.length()==1)
                { sb.append(charSequence);
                    centerManagerOtpViewBind.etotpno5id.clearFocus();
                    centerManagerOtpViewBind. etotpno5id.requestFocus();
                    centerManagerOtpViewBind.etotpno5id.setCursorVisible(true);
                }
                else if (  centerManagerOtpViewBind.etotpno4id.length()==0){
                    centerManagerOtpViewBind. etotpno4id.clearFocus();
                    centerManagerOtpViewBind.etotpno3id.requestFocus();
                    centerManagerOtpViewBind.etotpno3id.setCursorVisible(true);
                }
            }
            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

        centerManagerOtpViewBind. etotpno5id.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) { }
            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if(  centerManagerOtpViewBind.etotpno5id.length()==1)
                { sb.append(charSequence);
                    centerManagerOtpViewBind. etotpno6id.clearFocus();
                    centerManagerOtpViewBind. etotpno6id.requestFocus();
                    centerManagerOtpViewBind.etotpno6id.setCursorVisible(true);
                }
                else if (  centerManagerOtpViewBind.etotpno5id.length()==0){
                    centerManagerOtpViewBind.etotpno5id.clearFocus();
                    centerManagerOtpViewBind.etotpno4id.requestFocus();
                    centerManagerOtpViewBind.etotpno4id.setCursorVisible(true);
                }

            }
            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
        centerManagerOtpViewBind.etotpno6id.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) { }
            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if(  centerManagerOtpViewBind.etotpno6id.length()==1)
                {hideKeyboard(CenterManagerOtpActivity.this);
                }
                else if (  centerManagerOtpViewBind.etotpno6id.length()==0){
                    centerManagerOtpViewBind.etotpno6id.clearFocus();
                    centerManagerOtpViewBind. etotpno5id.requestFocus();
                    centerManagerOtpViewBind.etotpno5id.setCursorVisible(true);
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
        StringRequest stringRequest=new StringRequest(Request.Method.POST, ApplicationConstant.centermanager_getotp, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

                Log.d("reeee", "onResponse: "+response);
                try {
                    JSONObject jsonObject=new JSONObject(response);
                    success=   jsonObject.getString("success");


                    if (success.equalsIgnoreCase("0")){
                        String message=jsonObject.getString("message");
                        Toast.makeText(CenterManagerOtpActivity.this, ""+message, Toast.LENGTH_SHORT).show();
                    } else {

                        JSONArray jsonArray = jsonObject.getJSONArray("data");
                        JSONObject jsonObject1 = jsonArray.getJSONObject(0);
                        otp = jsonObject1.getString("otp");
                        Log.d("otp", "onResponse: " + otp);


                        SessionManager.setCenterManagerotpenable(true);
                        SessionManager.setCenterManagerotp(otp);

                        Log.d("otp", "onResponse: " + otp);
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
        StringRequest stringRequest=new StringRequest(Request.Method.POST, ApplicationConstant.centermanager_login, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                    pd.dismiss();

                try {
                    JSONObject jsonObject = new JSONObject(response);

                    Log.d("sunita", "onResponse: "+jsonObject);
                    String    success = jsonObject.getString("success");
                    if (success.equalsIgnoreCase("0")){
                        String message=jsonObject.getString("message");
                        Toast.makeText(CenterManagerOtpActivity.this, ""+message, Toast.LENGTH_SHORT).show();
                    } else{
                      
                    JSONArray jsonArray = jsonObject.getJSONArray("data");
                    JSONObject jsonObject1 = jsonArray.getJSONObject(0);

                    id = jsonObject1.getString("id");
                    branch_id= jsonObject1.getString("branch_id");

                        name = jsonObject1.getString("prop_name");
                        email = jsonObject1.getString("email_id");

                        SessionManager.setCenterManagernamevalue(name);
                        SessionManager.setCenterManageremailvalue(email);

                   /* name = jsonObject1.getString("student_name");
                    email = jsonObject1.getString("email_id");
                    phno = jsonObject1.getString("mobile_no");
                    image = jsonObject1.getString("student_image");*/

                    /*SessionManager.setCenterManageridboolean(true);
                    Toast.makeText(CenterManagerOtpActivity.this, "true", Toast.LENGTH_SHORT).show();*/
                    SessionManager.setCenterManageridvalue(id);

                    Log.d("id", "onResponse: " + id);


                        Intent mainIntent = new Intent(CenterManagerOtpActivity.this, CenterManagerHomeActivity.class);


                        SessionManager.setCenterManageridboolean(true);

                        SessionManager.setCenterManagerLogged(true);

                      /*  mainIntent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP |
                                Intent.FLAG_ACTIVITY_CLEAR_TASK |
                                Intent.FLAG_ACTIVITY_NEW_TASK);*/
                        startActivity(mainIntent);
                      //  finish();
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
                hashMap.put("otp",otp);

                return hashMap;
            }
        };

        Volley.newRequestQueue(this).add(stringRequest);
    }

    public static CenterManagerOtpActivity getActivityInstance()
    {
        return INSTANCE;
    }

    public String sendToHomaeFrag() {

        return id;
    }
}