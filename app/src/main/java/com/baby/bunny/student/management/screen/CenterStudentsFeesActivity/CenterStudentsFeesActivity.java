package com.baby.bunny.student.management.screen.CenterStudentsFeesActivity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.app.DatePickerDialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.baby.bunny.student.management.R;
import com.baby.bunny.student.management.adapter.CenterStudentFeesListAdapter;
import com.baby.bunny.student.management.adapter.SelectClassAdapter;
import com.baby.bunny.student.management.model.SelectClassModel;
import com.baby.bunny.student.management.model.StudentFeesListModel;
import com.baby.bunny.student.management.model.StudentsListModel;
import com.baby.bunny.student.management.screen.NoDataFound.NoDataFound;
import com.baby.bunny.student.management.utils.ApplicationConstant;

import com.github.dewinjm.monthyearpicker.MonthYearPickerDialog;
import com.github.dewinjm.monthyearpicker.MonthYearPickerDialogFragment;
import com.github.ybq.android.spinkit.sprite.Sprite;
import com.github.ybq.android.spinkit.style.FadingCircle;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CenterStudentsFeesActivity extends AppCompatActivity {
    CenterStudentsFeesViewBind centerStudentsFeesViewBind;
    CenterStudentsFeesOnClick centerStudentsFeesOnClick;
    List<StudentFeesListModel> studentFeesListModels;
    List<StudentsListModel>studentsListModelList;

    DatePickerDialog  StartTime;

    ArrayList<SelectClassModel> selectClassModels;

    String class_name,Class_id;
    String value;
    String student_id,cal_date="2020-09-28",dayOfMonth="2",month, year,currentdate;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        View view= LayoutInflater.from(this).inflate(R.layout.activity_center_students_fees,null);
        setContentView(view);


        centerStudentsFeesViewBind= new CenterStudentsFeesViewBind(this,view);
        centerStudentsFeesOnClick=new CenterStudentsFeesOnClick(this,centerStudentsFeesViewBind);



        centerStudentsFeesViewBind. actionBarDrawerToggle = new ActionBarDrawerToggle(this,centerStudentsFeesViewBind. drawerLayout, R.string.app_name, R.string.app_name);

        centerStudentsFeesViewBind. drawerLayout.addDrawerListener( centerStudentsFeesViewBind.actionBarDrawerToggle);
        centerStudentsFeesViewBind. actionBarDrawerToggle.syncState();

        findViewById(R.id.img_nav).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                centerStudentsFeesViewBind. drawerLayout.openDrawer(Gravity.RIGHT);

            }
        }); findViewById(R.id.img_navclose).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                centerStudentsFeesViewBind. drawerLayout.closeDrawer(Gravity.RIGHT);

            }
        });

        studentFeesListModels=new ArrayList<>();
        selectClassModels=new ArrayList<>();
        studentsListModelList=new ArrayList<>();

        ArrayList<String> Sp_list= new ArrayList<>();
        Sp_list.clear();
        Sp_list.add("Select Type");
         Sp_list.add("Monthly");
         Sp_list.add("Admission");
        CustomAdapter adapter=new CustomAdapter( CenterStudentsFeesActivity.this,Sp_list);
       centerStudentsFeesViewBind.select_type_spinnerid.setAdapter(adapter);



        LinearLayoutManager layoutManager = new LinearLayoutManager(CenterStudentsFeesActivity.this);

        centerStudentsFeesViewBind.studentsfeesrv .setLayoutManager(layoutManager);


        Calendar newCalendar = Calendar.getInstance();
          StartTime = new DatePickerDialog(CenterStudentsFeesActivity.this, new DatePickerDialog.OnDateSetListener() {
            public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                Calendar newDate = Calendar.getInstance();
                newDate.set(year, monthOfYear, dayOfMonth);

               //  cal_date=year+"/"+ String.format("%02d", monthOfYear + 1)+"/"+ String.format("%02d",dayOfMonth);
                cal_date=year+"/"+addZeroLeading(monthOfYear + 1)+"/"+ String.format("%02d",dayOfMonth);

                centerStudentsFeesViewBind. select_calender.setText(String.format("%02d",dayOfMonth) + " / "+ String.format("%02d", monthOfYear + 1) + " / "
                        + year);

            }

        }, newCalendar.get(Calendar.YEAR), newCalendar.get(Calendar.MONTH), newCalendar.get(Calendar.DAY_OF_MONTH));

        currentdate();
        getAllStudent();
        getAllClass();
        getStudentFees();
    }

    private void currentdate() {
        Calendar cal = Calendar.getInstance();
        int dayOfmonth = cal.get(Calendar.DAY_OF_MONTH);
        dayOfMonth = addZeroLeading(dayOfmonth);
        month=String.valueOf(cal.get(Calendar.MONTH))+1;
        year=String.valueOf(cal.get(Calendar.YEAR));

        currentdate=year+"-"+month+"-"+ dayOfMonth;

    }

     public String addZeroLeading(int num){
            if(num<10){
                String retstr=String.valueOf(num);
                return  "0"+retstr;
            }
            else
                return String.valueOf(num);


     }


    public  void getAllStudent(){

        StringRequest stringRequest=new StringRequest(Request.Method.POST, ApplicationConstant.CenterManager_getAllStudent, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Log.d("sunita", "onResponse: "+response);
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

                    LinearLayoutManager layoutManager = new LinearLayoutManager(CenterStudentsFeesActivity.this);

                    centerStudentsFeesViewBind.select_student_rv.setLayoutManager(layoutManager);

                    StudentAdapter studentListAdapter=new StudentAdapter(CenterStudentsFeesActivity.this,studentsListModelList);
                    centerStudentsFeesViewBind.select_student_rv.setAdapter(studentListAdapter);
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
    public  void getStudentFees(){

        ProgressBar progressBar = (ProgressBar)findViewById(R.id.progress);
        centerStudentsFeesViewBind.progresslvid.setVisibility(View.VISIBLE);
        Sprite doubleBounce = new FadingCircle();
        progressBar.setIndeterminateDrawable(doubleBounce);

        StringRequest stringRequest=new StringRequest(Request.Method.POST, ApplicationConstant.CenterManager_getStudentFees, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Log.d("sunita", "onResponse: "+response);
                progressBar.setVisibility(View.GONE);
                try {
                    JSONObject jsonObject = new JSONObject(response);

                    String    success = jsonObject.getString("success");
                    if (success.equalsIgnoreCase("0")){
                        progressBar.setVisibility(View.GONE);
                        centerStudentsFeesViewBind.progresslvid.setVisibility(View.GONE);
                        centerStudentsFeesViewBind.nodatafoundlvid.setVisibility(View.VISIBLE);
                    } else{
                        centerStudentsFeesViewBind.nodatafoundlvid.setVisibility(View.GONE);
                        progressBar.setVisibility(View.GONE);
                    JSONArray jsonArray = jsonObject.getJSONArray("data");
                    for (int i = 0; i < jsonArray.length(); i++) {

                        JSONObject jsonObject1 = jsonArray.getJSONObject(i);

                        StudentFeesListModel studentFeesListModel = new StudentFeesListModel(
                                jsonObject1.getString("id"),
                                jsonObject1.getString("student_id"),
                                jsonObject1.getString("branch_id"),
                                jsonObject1.getString("fees_for"),
                                jsonObject1.getString("fees_date"),
                                jsonObject1.getString("fees"),
                                jsonObject1.getString("year"),
                                jsonObject1.getString("is_paid"),
                                jsonObject1.getString("student_name"),
                                jsonObject1.getString("student_code"),
                                jsonObject1.getString("student_class_id"),
                                jsonObject1.getString("type_name"),
                                jsonObject1.getString("class_name"),
                                jsonObject1.getString("student_image")

                        );


                        studentFeesListModels.add(studentFeesListModel);

                    }

                    CenterStudentFeesListAdapter teacherListAdapter = new CenterStudentFeesListAdapter(CenterStudentsFeesActivity.this, studentFeesListModels);
                    centerStudentsFeesViewBind.studentsfeesrv.setAdapter(teacherListAdapter);

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
                hashMap.put("fees_type_id","");
                hashMap.put("student_id","");
             //   hashMap.put("fees_yearmonth","2020-09-28");
                hashMap.put("fees_yearmonth",currentdate);
                hashMap.put("class_id","");

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

         centerStudentsFeesViewBind.select_type_spinnerid.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

                    view1.setVisibility(View.GONE);


                }

                @Override
                public void onNothingSelected(AdapterView<?> adapterView) {

                }
            });

            return view;
        }
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

                        SelectClassAdapter selectClassAdapter=new SelectClassAdapter(CenterStudentsFeesActivity.this,selectClassModels);
                        centerStudentsFeesViewBind.select_class_spinnerid.setAdapter(selectClassAdapter);
                        centerStudentsFeesViewBind.select_class_spinnerid.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
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

    public void calender(){

        int yearSelected;
        int monthSelected;

//Set default values
        Calendar calendar = Calendar.getInstance();
        yearSelected = calendar.get(Calendar.YEAR);
        monthSelected = calendar.get(Calendar.MONTH);

        MonthYearPickerDialogFragment dialogFragment = MonthYearPickerDialogFragment
                .getInstance(monthSelected, yearSelected);

        dialogFragment.show(getSupportFragmentManager(), null);

        dialogFragment.setOnDateSetListener(new MonthYearPickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(int year, int monthOfYear) {
                cal_date=String.valueOf(year)+"/"+ addZeroLeading(monthOfYear + 1)+"/"+dayOfMonth;
                try {
                    DateFormat inputFormat = new SimpleDateFormat("yyyy/MM/dd");
                    DateFormat outputFormat = new SimpleDateFormat("MMM yyyy");
                    String inputDateStr=cal_date;
                    Date date = inputFormat.parse(inputDateStr);
                    String outputDateStr = outputFormat.format(date);
                    centerStudentsFeesViewBind. select_calender.setText(outputDateStr);
                }catch (Exception e){
                    e.printStackTrace();
                }

             /*   centerStudentsFeesViewBind. select_calender.setText(dayOfMonth + " / " +"0"+ (monthOfYear + 1) + " / "
                        + year);
*/
              //  centerStudentsFeesViewBind. select_calender.setText(String.valueOf(year)+"/"+ String.format("%02d", String.valueOf(monthOfYear + 1)) + " / "
                       // +String.format("%02d",dayOfMonth) );
            }
        });
        // StartTime.show();
    }




    public class StudentAdapter extends RecyclerView.Adapter<StudentAdapter.StudentViewHolder>{

        Context context;
        List<StudentsListModel> studentsListModels;
        LayoutInflater layoutInflater;
        public StudentAdapter(Context context, List<StudentsListModel> studentsListModels) {
            this.context = context;
            this.studentsListModels = studentsListModels;
        }

        @NonNull
        @Override
        public StudentViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View view=layoutInflater.from(context).inflate(R.layout.sample_student_name,parent,false);
            StudentViewHolder studentViewHolder=new StudentViewHolder(view);
            return studentViewHolder;
        }

        @Override
        public void onBindViewHolder(@NonNull StudentViewHolder holder, int position) {
            StudentsListModel studentsListModelpos=studentsListModels.get(position);
            holder.student_name.setText(studentsListModelpos.getStudent_name());
            holder.item_check.setChecked(studentsListModelpos.getIschceked());

            holder.item_check.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    student_id=studentsListModelpos.getId();

                    for (int i=0;i<studentsListModels.size();i++){
                        if (studentsListModels.get(i).getIschceked()){

                                if (i==position){
                                    studentsListModelpos.setIschceked(false);
                                    notifyDataSetChanged();
                                }else {
                                    studentsListModels.get(i).setIschceked(false);
                                    studentsListModels.get(position).setIschceked(true);
                                    notifyDataSetChanged();
                                }


                        } else  if (!studentsListModelpos.getIschceked()){
                            studentsListModelpos.setIschceked(true);
                            notifyDataSetChanged();
                        }
                    }


                  /*  for (int i=0;i<selectClassModels.size();i++){
                        if (studentsListModelpos.getIschceked() == true){
                            studentsListModelpos.setIschceked(true);
                            notifyDataSetChanged();
                        }else {
                            studentsListModelpos.setIschceked(false);
                            notifyDataSetChanged();
                        }
                    }*/



                /*   if (studentsListModelpos.getIschceked()){
                       studentsListModelpos.setIschceked(false);
                       notifyDataSetChanged();
                   }else {
                       studentsListModelpos.setIschceked(true);
                       notifyDataSetChanged();
                   }*/

                }
            });


          /*  holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                     student_id=studentsListModelpos.getId();


                }
            });
*/
        }

        @Override
        public int getItemCount() {
            return studentsListModels.size();
        }

        public class StudentViewHolder extends RecyclerView.ViewHolder{
          TextView student_name;
          CheckBox item_check;
            public StudentViewHolder(@NonNull View itemView) {
                super(itemView);

                student_name=itemView.findViewById(R.id.student_name);

                item_check=itemView.findViewById(R.id.item_check);
            }
        }
    }


    public void getStudentFees_Searchbtn(String id,String cal_date1,String student_id,String value){

        ProgressDialog pd = new ProgressDialog(this);
        pd.setMessage("loading");
        pd.setCancelable(false);
        pd.show();

        StringRequest stringRequest=new StringRequest(Request.Method.POST, ApplicationConstant.CenterManager_getStudentFees, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Log.d("sunita", "onResponse: "+response);

                centerStudentsFeesViewBind. drawerLayout.closeDrawer(Gravity.RIGHT);

                pd.dismiss();

                try {
                    JSONObject jsonObject=new JSONObject(response);
                    String    success = jsonObject.getString("success");

                    if (success.equalsIgnoreCase("0")){


                        Intent intent=new Intent(CenterStudentsFeesActivity.this, NoDataFound.class);
                        startActivity(intent);

                        Toast.makeText(CenterStudentsFeesActivity.this, ""+jsonObject.getString("message"), Toast.LENGTH_SHORT).show();

                    } else {
                        studentFeesListModels.clear();
                        JSONArray jsonArray = jsonObject.getJSONArray("data");
                        for (int i = 0; i < jsonArray.length(); i++) {

                            JSONObject jsonObject1 = jsonArray.getJSONObject(i);

                            StudentFeesListModel studentFeesListModel = new StudentFeesListModel(
                                    jsonObject1.getString("id"),
                                    jsonObject1.getString("student_id"),
                                    jsonObject1.getString("branch_id"),
                                    jsonObject1.getString("fees_for"),
                                    jsonObject1.getString("fees_date"),
                                    jsonObject1.getString("fees"),
                                    jsonObject1.getString("year"),
                                    jsonObject1.getString("is_paid"),
                                    jsonObject1.getString("student_name"),
                                    jsonObject1.getString("student_code"),
                                    jsonObject1.getString("student_class_id"),
                                    jsonObject1.getString("type_name"),
                                    jsonObject1.getString("class_name"),
                                    jsonObject1.getString("student_image")

                            );


                            studentFeesListModels.add(studentFeesListModel);

                        }

                        CenterStudentFeesListAdapter teacherListAdapter = new CenterStudentFeesListAdapter(CenterStudentsFeesActivity.this, studentFeesListModels);
                        centerStudentsFeesViewBind.studentsfeesrv.setAdapter(teacherListAdapter);

                    }


                } catch (JSONException e) {
                    e.printStackTrace();
                    pd.dismiss();
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
                hashMap.put("branch_id","15");
                hashMap.put("fees_type_id",value);
                hashMap.put("student_id",student_id);
                hashMap.put("fees_yearmonth",cal_date);
                hashMap.put("class_id",Class_id);


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