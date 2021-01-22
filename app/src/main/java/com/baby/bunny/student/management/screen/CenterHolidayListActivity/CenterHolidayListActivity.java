package com.baby.bunny.student.management.screen.CenterHolidayListActivity;

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
import com.baby.bunny.student.management.adapter.CerterManagerHolidayListAdapter;
import com.baby.bunny.student.management.model.CerterManagerHolidayListModel;
import com.baby.bunny.student.management.utils.ApplicationConstant;
import com.github.ybq.android.spinkit.sprite.Sprite;
import com.github.ybq.android.spinkit.style.FadingCircle;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CenterHolidayListActivity extends AppCompatActivity {
    CenterHolidayListViewBind centerHolidayListViewBind;
    CenterHolidayListOnClick centerHolidayListOnClick;
    List<CerterManagerHolidayListModel> certerManagerHolidayListModels;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        View view= LayoutInflater.from(this).inflate(R.layout.activity_center_holiday_list,null);
        setContentView(view);
        centerHolidayListViewBind= new CenterHolidayListViewBind(this,view);
        centerHolidayListOnClick=new CenterHolidayListOnClick(this,centerHolidayListViewBind);

        certerManagerHolidayListModels=new ArrayList<>();

        LinearLayoutManager layoutManager = new LinearLayoutManager(CenterHolidayListActivity.this);

        centerHolidayListViewBind. rvidholidaylist.setLayoutManager(layoutManager);

        holyday();
    }

    public  void holyday(){
        ProgressBar progressBar = (ProgressBar)findViewById(R.id.progress);
        centerHolidayListViewBind.progresslvid.setVisibility(View.VISIBLE);
        Sprite doubleBounce = new FadingCircle();
        progressBar.setIndeterminateDrawable(doubleBounce);

        StringRequest stringRequest=new StringRequest(Request.Method.POST, ApplicationConstant.CenterManager_holyday, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Log.d("sunita", "onResponse: "+response);
                progressBar.setVisibility(View.GONE);
                try {
                    JSONObject jsonObject = new JSONObject(response);

                    String    success = jsonObject.getString("success");
                    if (success.equalsIgnoreCase("0")){
                        progressBar.setVisibility(View.GONE);
                        centerHolidayListViewBind.progresslvid.setVisibility(View.GONE);
                        centerHolidayListViewBind.nodatafoundlvid.setVisibility(View.VISIBLE);
                    } else{
                        centerHolidayListViewBind.nodatafoundlvid.setVisibility(View.GONE);
                        progressBar.setVisibility(View.GONE);
                    JSONArray jsonArray = jsonObject.getJSONArray("data");
                    for (int i = 0; i < jsonArray.length(); i++) {

                        JSONObject jsonObject1 = jsonArray.getJSONObject(i);

                        CerterManagerHolidayListModel certerManagerHolidayListModel = new CerterManagerHolidayListModel(
                                jsonObject1.getString("id"),
                                jsonObject1.getString("center_id"),
                                jsonObject1.getString("holyday_details"),
                                jsonObject1.getString("holyday_from"),
                                jsonObject1.getString("holyday_to"),
                                jsonObject1.getString("holyday_year"),
                                jsonObject1.getString("isActive")

                        );
                        certerManagerHolidayListModels.add(certerManagerHolidayListModel);

                    }

                    CerterManagerHolidayListAdapter studentListAdapter = new CerterManagerHolidayListAdapter(CenterHolidayListActivity.this, certerManagerHolidayListModels);
                    centerHolidayListViewBind.rvidholidaylist.setAdapter(studentListAdapter);

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
                hashMap.put("center_id","9");

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