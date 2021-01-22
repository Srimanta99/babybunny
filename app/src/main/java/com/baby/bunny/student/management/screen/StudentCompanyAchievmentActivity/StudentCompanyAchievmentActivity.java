package com.baby.bunny.student.management.screen.StudentCompanyAchievmentActivity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.baby.bunny.student.management.R;
import com.baby.bunny.student.management.adapter.CompanyAchievmentAdapter;
import com.baby.bunny.student.management.model.CompanyAchievmentModel;
import com.baby.bunny.student.management.screen.main.MainActivityOnClick;
import com.baby.bunny.student.management.screen.main.MainActivityViewBind;

import java.util.ArrayList;
import java.util.List;

public class StudentCompanyAchievmentActivity extends AppCompatActivity {
    CompanyAchievementViewBind companyAchievementViewBind;
    CompanyAchievmentOnClick companyAchievmentOnClick;
    List<CompanyAchievmentModel> companyAchievmentModels;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        View view= LayoutInflater.from(this).inflate(R.layout.activity_student_company_achievment,null);
        setContentView(view);
        companyAchievementViewBind= new CompanyAchievementViewBind(this,view);
        companyAchievmentOnClick=new CompanyAchievmentOnClick(this,companyAchievementViewBind);

        companyAchievmentModels=new ArrayList<>();

        loaddata();
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
        String url="";
        StringRequest stringRequest=new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                CompanyAchievmentAdapter adapter = new CompanyAchievmentAdapter(companyAchievmentModels,StudentCompanyAchievmentActivity.this);
               companyAchievementViewBind.recyclerView.setHasFixedSize(true);
                companyAchievementViewBind.recyclerView.setLayoutManager(new LinearLayoutManager( StudentCompanyAchievmentActivity.this));
                companyAchievementViewBind.recyclerView.setAdapter(adapter);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });

        Volley.newRequestQueue(this).add(stringRequest);
    }
}