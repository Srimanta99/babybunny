package com.baby.bunny.student.management.screen.CenterStudentActivity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ProgressBar;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.baby.bunny.student.management.R;
import com.baby.bunny.student.management.adapter.StudentListAdapter;
import com.baby.bunny.student.management.model.StudentsListModel;
import com.baby.bunny.student.management.screen.main.MainActivityOnClick;
import com.baby.bunny.student.management.screen.main.MainActivityViewBind;
import com.baby.bunny.student.management.utils.ApplicationConstant;
import com.github.ybq.android.spinkit.sprite.Sprite;
import com.github.ybq.android.spinkit.style.Circle;
import com.github.ybq.android.spinkit.style.DoubleBounce;
import com.github.ybq.android.spinkit.style.FadingCircle;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.baby.bunny.student.management.utils.ApplicationConstant.centermanagerurl;

public class CenterStudentActivity extends AppCompatActivity {
    CenterStudentViewBind centerStudentViewBind;
    CenterStudentOnClick centerStudentOnClick;
   List<StudentsListModel>studentsListModelList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        View view= LayoutInflater.from(this).inflate(R.layout.activity_center_student,null);
        setContentView(view);
        centerStudentViewBind= new CenterStudentViewBind(this,view);
        centerStudentOnClick=new CenterStudentOnClick(this,centerStudentViewBind);

        studentsListModelList=new ArrayList<>();

        LinearLayoutManager layoutManager = new LinearLayoutManager(CenterStudentActivity.this);

       centerStudentViewBind. studentrv.setLayoutManager(layoutManager);

        getAllStudent();
    }

    public  void getAllStudent(){
        ProgressBar progressBar = (ProgressBar)findViewById(R.id.progress);
        Sprite doubleBounce = new FadingCircle();
        progressBar.setIndeterminateDrawable(doubleBounce);

        StringRequest stringRequest=new StringRequest(Request.Method.POST, ApplicationConstant.CenterManager_getAllStudent, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Log.d("sunita", "onResponse: "+response);
                progressBar.setVisibility(View.GONE);


                try {
                    JSONObject jsonObject=new JSONObject(response);


                    JSONArray jsonArray=jsonObject.getJSONArray("data");
                    for (int i=0;i<jsonArray.length();i++){

                        JSONObject jsonObject1=jsonArray.getJSONObject(i);

                        StudentsListModel studentsListModel=new StudentsListModel(
                                jsonObject1.getString("student_image"),
                                jsonObject1.getString("student_name"),
                                jsonObject1.getString("student_id"),
                                jsonObject1.getString("guardian_name"),
                                jsonObject1.getString("email_id"),
                                jsonObject1.getString("mobile_no"),
                                jsonObject1.getString("class_name"),
                                jsonObject1.getString("blood_group"),
                                jsonObject1.getString("dob"),
                                jsonObject1.getString("id")
                        );
                        studentsListModelList.add(studentsListModel);

                    }

                    StudentListAdapter studentListAdapter=new StudentListAdapter(CenterStudentActivity.this,studentsListModelList);
                    centerStudentViewBind.studentrv.setAdapter(studentListAdapter);
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

    @Override
    public void onBackPressed() {
        if (getFragmentManager().getBackStackEntryCount() > 0) {
            getFragmentManager().popBackStack();
        } else {
            super.onBackPressed();
        }
    }
}