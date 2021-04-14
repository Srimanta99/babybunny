package com.baby.babybunny.student.management.screen.DoAndDontsActivity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ProgressBar;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.baby.babybunny.student.management.R;
import com.baby.babybunny.student.management.adapter.StudentDoAdapter;
import com.baby.babybunny.student.management.model.StudentTodayClassTestModel;
import com.baby.babybunny.student.management.model.StudentTodaysClassDateModel;
import com.github.ybq.android.spinkit.sprite.Sprite;
import com.github.ybq.android.spinkit.style.FadingCircle;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class DoAndDoNotsActivity extends AppCompatActivity {
    DoAndDoNotsViewBind doAndDoNotsViewBind;
    DoAndDoNotsOnClick doAndDoNotsOnClick;

    List<StudentTodaysClassDateModel> studentTodaysClassDateModels;
    List<StudentTodayClassTestModel> studentTodayClassTestModels;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        View view= LayoutInflater.from(this).inflate(R.layout.activity_do_and_do_nots,null);
        setContentView(view);
        doAndDoNotsViewBind= new DoAndDoNotsViewBind(this,view);
        doAndDoNotsOnClick=new DoAndDoNotsOnClick(this,doAndDoNotsViewBind);

        doAndDoNotsViewBind. toolname_id.setText("Do's and Dont's    ");

        studentTodaysClassDateModels=new ArrayList<>();

        //loaddata();
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

        String url="https://desitik.in/API/index.php?p=allSounds";

        ProgressBar progressBar = (ProgressBar)findViewById(R.id.progress);
        doAndDoNotsViewBind.progresslvid.setVisibility(View.VISIBLE);
        Sprite doubleBounce = new FadingCircle();
        progressBar.setIndeterminateDrawable(doubleBounce);
        StringRequest stringRequest=new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                progressBar.setVisibility(View.GONE);


                try {
                    JSONObject jsonObject=new JSONObject(response);
                  //  String    success = jsonObject.getString("success");
                 /*   if (success.equalsIgnoreCase("0")){
                        progressBar.setVisibility(View.GONE);
                        doAndDoNotsViewBind .progresslvid.setVisibility(View.GONE);
                        doAndDoNotsViewBind.nodatafoundlvid.setVisibility(View.VISIBLE);
                    } else {*/
                        doAndDoNotsViewBind.nodatafoundlvid.setVisibility(View.GONE);
                        progressBar.setVisibility(View.GONE);
                        JSONArray jsonArray = jsonObject.getJSONArray("msg");

                        for (int i = 0; i < jsonArray.length(); i++) {
                            JSONObject obj = jsonArray.getJSONObject(i);

                            studentTodayClassTestModels = new ArrayList<>();

                            StudentTodaysClassDateModel studentTodaysClassDateModel = new StudentTodaysClassDateModel();

                            studentTodaysClassDateModel.setTdate(obj.getString("section_name"));

                            JSONArray jsonArray1 = obj.getJSONArray("sections_sounds");


                            for (int j = 0; j < jsonArray1.length(); j++) {

                                JSONObject jsonObject1 = jsonArray1.getJSONObject(j);

                                StudentTodayClassTestModel studentTodayClassTestModel = new StudentTodayClassTestModel();
                                studentTodayClassTestModel.setDescription(jsonObject1.getString("created"));

                                studentTodayClassTestModels.add(studentTodayClassTestModel);

                            }
                            studentTodaysClassDateModel.setStudentTodayClassTestModels(studentTodayClassTestModels);


                            studentTodaysClassDateModels.add(studentTodaysClassDateModel);

                        }

                        StudentDoAdapter adapter = new StudentDoAdapter(studentTodaysClassDateModels, DoAndDoNotsActivity.this);
                        doAndDoNotsViewBind.recyclerView.setHasFixedSize(true);
                        doAndDoNotsViewBind.recyclerView.setLayoutManager(new LinearLayoutManager(DoAndDoNotsActivity.this));
                        doAndDoNotsViewBind.recyclerView.setAdapter(adapter);
                  //  }

                } catch (JSONException e) {
                    e.printStackTrace();


                }



           /*     StudentTodaysClassDateAdapter adapter = new StudentTodaysClassDateAdapter(studentTodaysClassDateModels, StudentTodaysClass.this);
                studentTodayClassViewBind.recyclerView.setHasFixedSize(true);
                studentTodayClassViewBind.recyclerView.setLayoutManager(new LinearLayoutManager( StudentTodaysClass.this));
                studentTodayClassViewBind.recyclerView.setAdapter(adapter);*/
            }



        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.d("amrdadurki", "onResponse: "+error.getMessage());

            }
        });

        Volley.newRequestQueue(this).add(stringRequest);
    }
}