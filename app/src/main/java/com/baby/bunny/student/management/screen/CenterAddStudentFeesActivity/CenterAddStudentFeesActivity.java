package com.baby.bunny.student.management.screen.CenterAddStudentFeesActivity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.annotation.SuppressLint;
import android.app.ProgressDialog;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.baby.bunny.student.management.Interface.StudentIdInterface;
import com.baby.bunny.student.management.R;
import com.baby.bunny.student.management.adapter.SelectClassAdapter;
import com.baby.bunny.student.management.adapter.StudentAdapter;
import com.baby.bunny.student.management.model.SelectClassModel;
import com.baby.bunny.student.management.model.StudentsListModel;
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

public class CenterAddStudentFeesActivity extends AppCompatActivity {
    CenterAddStudentFeesViewBind centerAddStudentFeesViewBind;
    CenterAddStudentFeesOnClick centerAddStudentFeesOnClick;

    ArrayList<SelectClassModel> selectClassModels;
    List<StudentsListModel> studentsListModelList;


    String class_name,Class_id,value,fees_type,student_id;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        View view= LayoutInflater.from(this).inflate(R.layout.activity_center_add_student_fees,null);
        setContentView(view);
        centerAddStudentFeesViewBind= new CenterAddStudentFeesViewBind(this,view);
        centerAddStudentFeesOnClick=new CenterAddStudentFeesOnClick(this,centerAddStudentFeesViewBind);

        selectClassModels=new ArrayList<>();
        studentsListModelList=new ArrayList<>();
        getAllClass();

        getAllStudent();
        ArrayList<String> Sp_list= new ArrayList<>();
        Sp_list.clear();
        Sp_list.add("Select Type");
        Sp_list.add("Monthly");
        Sp_list.add("Admission");
        CustomAdapter customAdapter=new CustomAdapter(CenterAddStudentFeesActivity.this,Sp_list);
        centerAddStudentFeesViewBind.select_type_spinnerid.setAdapter(customAdapter);


    }

    public  void getAllClass(){


        StringRequest stringRequest=new StringRequest(Request.Method.POST, ApplicationConstant.CenterManager_getAllClass, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {


                try {
                    JSONObject jsonObject=new JSONObject(response);
                    JSONArray jsonArray=jsonObject.getJSONArray("data");
                    selectClassModels.add(new SelectClassModel("Select Class","0"));
                    for (int i=0;i<jsonArray.length();i++){

                        JSONObject jsonObject1=jsonArray.getJSONObject(i);
                        SelectClassModel selectClassModel=new SelectClassModel(
                                class_name= jsonObject1.getString("class_name"),
                                   jsonObject1.getString("id")
                        );

                        selectClassModels.add(selectClassModel);

                        SelectClassAdapter selectClassAdapter=new SelectClassAdapter(CenterAddStudentFeesActivity.this,selectClassModels);
                        centerAddStudentFeesViewBind.select_class_spinnerid.setAdapter(selectClassAdapter);

                        centerAddStudentFeesViewBind.select_class_spinnerid.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                            @Override
                            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                                Class_id= selectClassModels.get(position).getId();
                            }

                            @Override
                            public void onNothingSelected(AdapterView<?> parent) {

                            }
                        });



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

    public class CustomAdapter extends BaseAdapter {
        Context context;
        ArrayList<String> extraList;
        LayoutInflater inflter;

        public CustomAdapter(Context applicationContext, ArrayList<String> extraList) {
            this.context = applicationContext;
            this.extraList = extraList;
            inflter = (LayoutInflater.from(applicationContext));
        }

        @Override
        public int getCount() {
            return extraList.size();
        }

        @Override
        public Object getItem(int i) {
            return null;
        }

        @Override
        public long getItemId(int i) {
            return 0;
        }

        @SuppressLint("SetTextI18n")
        @Override
        public View getView(int i, View view, ViewGroup viewGroup) {

            view = inflter.inflate(R.layout.lyt_spinner_item, null);
            TextView txt_item = view.findViewById(R.id.txt_item);


            View view1 = view.findViewById(R.id.view);
            //   TextView price = view.findViewById(R.id.txtprice)
            //
            //  ;
            if (i==0){
                view1.setVisibility(View.GONE);
            }
            txt_item.setText(extraList.get(i));



            if (extraList.get(i)=="Monthly"){
                value="1";


            }else if (extraList.get(i)=="Admission"){
                value="2";

            }

            centerAddStudentFeesViewBind.select_type_spinnerid.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

                    view1.setVisibility(View.GONE);
                 fees_type=   value;

                }

                @Override
                public void onNothingSelected(AdapterView<?> adapterView) {

                }
            });

            return view;
        }
    }

    public  void getAllStudent(){
        ProgressBar progressBar = (ProgressBar)findViewById(R.id.progre);
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

                    LinearLayoutManager layoutManager = new LinearLayoutManager(CenterAddStudentFeesActivity.this);

                    centerAddStudentFeesViewBind.select_student_rv.setLayoutManager(layoutManager);
                    StudentAdapter studentListAdapter=new StudentAdapter(CenterAddStudentFeesActivity.this, studentsListModelList, new StudentIdInterface() {
                        @Override
                        public void Student_id(int Student_id) {
                            student_id=      studentsListModelList.get(Student_id).getId();
                        }
                    });

                    centerAddStudentFeesViewBind.select_student_rv.setAdapter(studentListAdapter);
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


    public  void addstudentFees(){
        ProgressDialog pd = new ProgressDialog(this);
        pd.setMessage("loading");
        pd.setCancelable(false);
        pd.show();

        StringRequest stringRequest=new StringRequest(Request.Method.POST, ApplicationConstant.CenterManager_addstudentFees, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Log.d("sunita", "onResponse: "+response);
                  pd.dismiss();
                try {
                    JSONObject jsonObject=new JSONObject(response);
                    String    success = jsonObject.getString("success");
                    String message=jsonObject.getString("message");
                    if (success.equalsIgnoreCase("0")){
                      
                    }else {
                        Toast.makeText(CenterAddStudentFeesActivity.this, "Submit Successfully", Toast.LENGTH_SHORT).show();
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
                hashMap.put("branch_id","15");
                hashMap.put("fees_type",fees_type);
                hashMap.put("total_fees",centerAddStudentFeesViewBind.Amountet.getText().toString());
                hashMap.put("student_id",student_id);
                Log.d("hashmap", "getParams: "+hashMap);
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