package com.baby.bunny.student.management.screen.CenterTodayActivity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.baby.bunny.student.management.R;
import com.baby.bunny.student.management.adapter.CenterTodayinovationAdapter;
import com.baby.bunny.student.management.adapter.ClassListAdapter;
import com.baby.bunny.student.management.model.CenterTodayinovationModel;
import com.baby.bunny.student.management.model.ClassListModel;
import com.baby.bunny.student.management.screen.CenterClassActivity.CenterClassActivity;
import com.baby.bunny.student.management.screen.main.MainActivityOnClick;
import com.baby.bunny.student.management.screen.main.MainActivityViewBind;
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
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CenterTodayActivity extends AppCompatActivity {
    CenterTodayViewBind centerTodayViewBind;
    CenterTodayOnClick centerTodayOnClick;
    List<CenterTodayinovationModel> centerTodayinovationModels;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        View view= LayoutInflater.from(this).inflate(R.layout.activity_center_today,null);
        setContentView(view);
        centerTodayViewBind= new CenterTodayViewBind(this,view);
        centerTodayOnClick=new CenterTodayOnClick(this,centerTodayViewBind);

        centerTodayinovationModels=new ArrayList<>();
        todayinovation();

    }

    public void todayinovation(){
        ProgressBar progressBar = (ProgressBar)findViewById(R.id.progress);
        centerTodayViewBind.progresslvid.setVisibility(View.VISIBLE);
        Sprite doubleBounce = new FadingCircle();

        progressBar.setIndeterminateDrawable(doubleBounce);

        StringRequest stringRequest=new StringRequest(Request.Method.POST, ApplicationConstant.centermanager_todayinnovation, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

                progressBar.setVisibility(View.GONE);


                try {
                    JSONObject jsonObject = new JSONObject(response);

                    String    success = jsonObject.getString("success");
                    if (success.equalsIgnoreCase("0")){
                        progressBar.setVisibility(View.GONE);
                        centerTodayViewBind.progresslvid.setVisibility(View.GONE);
                        centerTodayViewBind.nodatafoundlvid.setVisibility(View.VISIBLE);
                    } else{
                        centerTodayViewBind.nodatafoundlvid.setVisibility(View.GONE);
                        progressBar.setVisibility(View.GONE);
                        JSONArray jsonArray = jsonObject.getJSONArray("data");
                        for (int i = 0; i < jsonArray.length(); i++) {

                            JSONObject jsonObject1 = jsonArray.getJSONObject(i);

                            CenterTodayinovationModel centerTodayinovationModel = new CenterTodayinovationModel(

                                    jsonObject1.getString("id"),
                                    jsonObject1.getString("teacher_id"),
                                    jsonObject1.getString("teacher_class_id"),
                                    jsonObject1.getString("branch_id"),
                                    jsonObject1.getString("subject"),
                                    jsonObject1.getString("details"),
                                    jsonObject1.getString("video"),
                                    jsonObject1.getString("is_active"),
                                    jsonObject1.getString("ddate"),
                                    jsonObject1.getString("teacher_name"),
                                    jsonObject1.getString("class_name"),
                                    getYoutubeThumbnailUrlFromVideoUrl( jsonObject1.getString("final_video_URL")),
                                    jsonObject1.getString("final_video_URL")
                            );

                            centerTodayinovationModels.add(centerTodayinovationModel);

                        }

                        CenterTodayinovationAdapter classListAdapter = new CenterTodayinovationAdapter(CenterTodayActivity.this, centerTodayinovationModels);
                        centerTodayViewBind.todayinnovationrv.setAdapter(classListAdapter);
                        LinearLayoutManager layoutManager = new LinearLayoutManager(CenterTodayActivity.this);

                        centerTodayViewBind.todayinnovationrv.setLayoutManager(layoutManager);

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

    public static String getYoutubeThumbnailUrlFromVideoUrl(String videoUrl) {
        return "http://img.youtube.com/vi/"+getYoutubeVideoIdFromUrl(videoUrl) + "/0.jpg";
    }

    public static String getYoutubeVideoIdFromUrl(String inUrl) {
        inUrl = inUrl.replace("&feature=youtu.be", "");
        if (inUrl.toLowerCase().contains("youtu.be")) {
            return inUrl.substring(inUrl.lastIndexOf("/") + 1);
        }
        String pattern = "(?<=watch\\?v=|/videos/|embed\\/)[^#\\&\\?]*";
        Pattern compiledPattern = Pattern.compile(pattern);
        Matcher matcher = compiledPattern.matcher(inUrl);
        if (matcher.find()) {
            return matcher.group();
        }
        return null;
    }
}