package com.baby.babybunny.student.management.screen.StudentAttendanceActivity;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.baby.babybunny.student.management.R;

import com.baby.babybunny.student.management.model.StudentPresentDateModel;
import com.baby.babybunny.student.management.utils.CustomAlertDialog;
import com.baby.babybunny.student.management.utils.SessionManager;
import com.github.ybq.android.spinkit.sprite.Sprite;
import com.github.ybq.android.spinkit.style.FadingCircle;



import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.naishadhparmar.zcustomcalendar.CustomCalendar;
import org.naishadhparmar.zcustomcalendar.OnNavigationButtonClickedListener;
import org.naishadhparmar.zcustomcalendar.Property;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.naishadhparmar.zcustomcalendar.CustomCalendar.NEXT;
import static org.naishadhparmar.zcustomcalendar.CustomCalendar.PREVIOUS;

public class StudentAttendanceActivity extends AppCompatActivity  implements OnNavigationButtonClickedListener
       {
    StudentAttendanceViewBind studentAttendanceViewBind;
    StudentAttendanceOnClick studentAttendanceOnClick;
           CustomCalendar customCalendar;
           String ddate,calender_date,currentdate,currret_ddate,part2;
           List<StudentPresentDateModel> studentPresentDateModelList;
           TextView toolname_id,tvid_present,tvid_absent;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        View view= LayoutInflater.from(this).inflate(R.layout.activity_student_attendance,null);
        setContentView(view);
        studentAttendanceViewBind= new StudentAttendanceViewBind(this,view);
        studentAttendanceOnClick=new StudentAttendanceOnClick(this,studentAttendanceViewBind);


        customCalendar = (CustomCalendar) findViewById(R.id.custom_calendar);
        toolname_id=findViewById(R.id.toolname_id);
        tvid_present=findViewById(R.id.tvid_present);
        tvid_absent=findViewById(R.id.tvid_absent);


        toolname_id.setText("Attendences");

        Calendar c = Calendar.getInstance();
        int year = c.get(Calendar.YEAR);
        int month = c.get(Calendar.MONTH);
        int day = c.get(Calendar.DATE);

        currentdate=year+"-"+month+1+"-"+day;


        studentPresentDateModelList=new ArrayList<>();

        customCalendar.setOnNavigationButtonClickedListener(PREVIOUS, this);
        customCalendar.setOnNavigationButtonClickedListener(NEXT, this);



        if (isConnected()) {
            attendence();

        } else {

            CustomAlertDialog.NoInternetAlert(StudentAttendanceActivity.this);
        }

    }

           public boolean isConnected() {
               boolean connected = false;
               try {
                   ConnectivityManager cm = (ConnectivityManager) StudentAttendanceActivity.this.getSystemService(Context.CONNECTIVITY_SERVICE);
                   NetworkInfo nInfo = cm.getActiveNetworkInfo();
                   connected = nInfo != null && nInfo.isAvailable() && nInfo.isConnected();
                   return connected;
               } catch (Exception e) {
                   Log.e("Connectivity Exception", e.getMessage());
               }
               return connected;
           }

           public  void attendence(){
               ProgressBar progressBar = (ProgressBar)findViewById(R.id.progress);
               Sprite doubleBounce = new FadingCircle();
               progressBar.setIndeterminateDrawable(doubleBounce);
               String student_attendence="http://babybunny.in/babybunny/index.php/App/student/attendence";
               StringRequest stringRequest=new StringRequest(Request.Method.POST, student_attendence, new Response.Listener<String>() {
                   @Override
                   public void onResponse(String response) {
                       Log.d("sunita", "onResponse: "+response);
                       progressBar.setVisibility(View.GONE);
                       customCalendar.setVisibility(View.VISIBLE);

                       try {
                           JSONObject jsonObject = new JSONObject(response);
                           String    success = jsonObject.getString("success");
                           if (success.equalsIgnoreCase("0")){

                           } else{

                               JSONArray jsonArray = jsonObject.getJSONArray("data");
                               for (int i = 0; i < jsonArray.length(); i++) {

                                   JSONObject jsonObject1 = jsonArray.getJSONObject(i);



                                   StudentPresentDateModel studentPresentDateModel=new StudentPresentDateModel(
                                           currret_ddate= jsonObject1.getString("ddate")

                                   );

                                   studentPresentDateModelList.add(studentPresentDateModel);
                               }
                               Calendar c = Calendar.getInstance();
                               int year = c.get(Calendar.YEAR);
                               int month = c.get(Calendar.MONTH);
                               int day = c.get(Calendar.DATE);

                               printDatesInMonth(year,month+1);



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
                       hashMap.put("student_id", SessionManager.getidvalue());
                       hashMap.put("date",currentdate);

                       Log.d("hash", "getParams: "+hashMap);

                       return hashMap;
                   }
               };
               Volley.newRequestQueue(this).add(stringRequest);
           }



           public  void printDatesInMonth(int year, int month) {
               SimpleDateFormat fmt = new SimpleDateFormat("yyyy-MM-dd");
               Calendar cal = Calendar.getInstance();
               cal.clear();
               cal.set(year, month - 1, 1);
               int daysInMonth = cal.getActualMaximum(Calendar.DAY_OF_MONTH);

               tvid_present.setText("Present : "+studentPresentDateModelList.size());
               int present=   studentPresentDateModelList.size();
               int Absent= daysInMonth-present;
               tvid_absent.setText("Absent : "+Absent);


               for (int i=0;i<studentPresentDateModelList.size();i++) {
                   // print ArrayList

                   String[] parts = studentPresentDateModelList.get(i).getDate(). split("-");
                   String part1 = parts[0];
                    part2 = parts[1];
                   String part3 = parts[2];

               }

               for (int i = 0; i < daysInMonth; i++) {

                   calender_date=fmt.format(cal.getTime());


                   if (addZeroLeading(month).equalsIgnoreCase(part2)){

                       change_color();

                   }else {

                       HashMap<Object, Property> mapDescToProp = new HashMap<>();

                       Property propDefault = new Property();
                       propDefault.layoutResource = R.layout.default_view;
                       propDefault.dateTextViewResource = R.id.absent_datetextview;
                       mapDescToProp.put("default", propDefault);

                       customCalendar.setMapDescToProp(mapDescToProp);
                   }


                   Log.d("date", "printDatesInMonth: "+fmt.format(cal.getTime()));
                   cal.add(Calendar.DAY_OF_MONTH, 1);
               }



           }
           @Override
           public Map<Integer, Object>[] onNavigationButtonClicked(int whichButton, Calendar newMonth) {
               Map<Integer, Object>[] arr = new Map[2];
               switch(newMonth.get(Calendar.MONTH)) {


                   case Calendar.DECEMBER:

                       String[] yearDECEMBER_January =  customCalendar.getMonthYearTextView().getText().toString().split("January ");
                       String[] yearDECEMBER_November =  customCalendar.getMonthYearTextView().getText().toString().split("November ");

                       if(whichButton == PREVIOUS) {
                           String yearDECEMBER_Januaryone = yearDECEMBER_January[1];
                           String date=yearDECEMBER_Januaryone+"-"+"12"+"-"+"01";
                           int daysInMonth=31;
                           tvid_present.setText("Present : 0");

                           tvid_absent.setText("Absent : 31");


                           change_color( arr, date,daysInMonth);



                       }else  if(whichButton == NEXT){
                           String yearDECEMBER_Novemberone=   yearDECEMBER_November[1];
                           String date=yearDECEMBER_Novemberone+"-"+"12"+"-"+"01";
                           int daysInMonth=31;
                           tvid_present.setText("Present : 0");

                           tvid_absent.setText("Absent : 31");

                           change_color( arr, date,daysInMonth);

                           Log.d("you", "yearJulyone: "+yearDECEMBER_Novemberone);
                       }


                       break;

                   case Calendar.NOVEMBER:

                       String[] yearNOVEMBER_December =  customCalendar.getMonthYearTextView().getText().toString().split("December ");
                       String[] yearNOVEMBER_October =  customCalendar.getMonthYearTextView().getText().toString().split("October ");

                       if(whichButton == PREVIOUS) {
                           String yearNOVEMBER_Decemberone = yearNOVEMBER_December[1];
                           String date=yearNOVEMBER_Decemberone+"-"+"11"+"-"+"01";
                           int daysInMonth=30;
                           tvid_present.setText("Present : 0");

                           tvid_absent.setText("Absent : 30");

                           change_color( arr, date,daysInMonth);



                       }else  if(whichButton == NEXT){
                           String yearNOVEMBER_Octoberone=   yearNOVEMBER_October[1];
                           String date=yearNOVEMBER_Octoberone+"-"+"11"+"-"+"01";
                           int daysInMonth=30;
                           tvid_present.setText("Present : 0");

                           tvid_absent.setText("Absent : 30");

                           change_color( arr, date,daysInMonth);

                           Log.d("you", "yearJulyone: "+yearNOVEMBER_Octoberone);
                       }


                       break;

                   case Calendar.OCTOBER:

                       String[] yearOCTOBER_November =  customCalendar.getMonthYearTextView().getText().toString().split("November ");
                       String[] yearOCTOBER_September =  customCalendar.getMonthYearTextView().getText().toString().split("September ");

                       if(whichButton == PREVIOUS) {
                           String yearOCTOBER_Novemberrone = yearOCTOBER_November[1];
                           String date=yearOCTOBER_Novemberrone+"-"+"10"+"-"+"01";
                           int daysInMonth=31;
                           tvid_present.setText("Present : 0");

                           tvid_absent.setText("Absent : 31");

                           change_color( arr, date,daysInMonth);



                       }else  if(whichButton == NEXT){
                           String yearOCTOBER_Septemberone=   yearOCTOBER_September[1];
                           String date=yearOCTOBER_Septemberone+"-"+"10"+"-"+"01";
                           int daysInMonth=31;
                           tvid_present.setText("Present : 0");

                           tvid_absent.setText("Absent : 31");

                           change_color( arr, date,daysInMonth);

                           Log.d("you", "yearJulyone: "+yearOCTOBER_Septemberone);
                       }


                       break;


                   case Calendar.SEPTEMBER:


                       String[] yearSEPTEMBER_October =  customCalendar.getMonthYearTextView().getText().toString().split("October ");
                       String[] yearSEPTEMBER_August =  customCalendar.getMonthYearTextView().getText().toString().split("August ");

                       if(whichButton == PREVIOUS) {
                           String yearSeptemberone = yearSEPTEMBER_October[1];
                           String date=yearSeptemberone+"-"+"09"+"-"+"01";
                           int daysInMonth=30;
                           tvid_present.setText("Present : 0");

                           tvid_absent.setText("Absent : 30");

                           change_color( arr, date,daysInMonth);



                       }else  if(whichButton == NEXT){
                           String yearJulyone=   yearSEPTEMBER_August[1];
                           String date=yearJulyone+"-"+"09"+"-"+"01";
                           int daysInMonth=30;
                           tvid_present.setText("Present : 0");

                           tvid_absent.setText("Absent : 30");

                           change_color( arr, date,daysInMonth);

                           Log.d("you", "yearJulyone: "+yearJulyone);
                       }


                       break;
                   case Calendar.AUGUST:


                       String[] yearJuly =  customCalendar.getMonthYearTextView().getText().toString().split("July ");
                       String[] yearSeptember =  customCalendar.getMonthYearTextView().getText().toString().split("September ");

                       if(whichButton == PREVIOUS) {
                           String yearSeptemberone = yearSeptember[1];
                           String date=yearSeptemberone+"-"+"08"+"-"+"01";
                           int daysInMonth=31;
                           tvid_present.setText("Present : 0");

                           tvid_absent.setText("Absent : 31");

                           change_color( arr, date,daysInMonth);



                       }else  if(whichButton == NEXT){
                           String yearJulyone=   yearJuly[1];
                           String date=yearJulyone+"-"+"08"+"-"+"01";
                           int daysInMonth=31;
                           tvid_present.setText("Present : 0");

                           tvid_absent.setText("Absent : 31");

                           change_color( arr, date,daysInMonth);

                           Log.d("you", "yearJulyone: "+yearJulyone);
                       }


                       break;

                   case Calendar.JULY:

                       String[] yearJULY_August =  customCalendar.getMonthYearTextView().getText().toString().split("August ");
                       String[] yearJULY_June =  customCalendar.getMonthYearTextView().getText().toString().split("June ");

                       if(whichButton == PREVIOUS) {
                           String yearJULY_Augustone = yearJULY_August[1];
                           String date=yearJULY_Augustone+"-"+"07"+"-"+"01";
                           int daysInMonth=31;
                           Log.d("you", "yearyearJUNE_Julyone: "+yearJULY_Augustone);

                           tvid_present.setText("Present : 0");

                           tvid_absent.setText("Absent : 31");

                           change_color( arr, date,daysInMonth);



                       }else  if(whichButton == NEXT){
                           String yearJULY_Juneone=   yearJULY_June[1];
                           String date=yearJULY_Juneone+"-"+"07"+"-"+"01";
                           Log.d("you", "yearyearJUNE_Mayone: "+yearJULY_Juneone);

                           //  change_color( arr, date);



                           int daysInMonth=31;
                           tvid_present.setText("Present : 0");

                           tvid_absent.setText("Absent : 31");

                           change_color( arr, date,daysInMonth);

                       }

                       break;



                   case Calendar.JUNE:

                       String[] yearJUNE_July =  customCalendar.getMonthYearTextView().getText().toString().split("July ");
                       String[] yearJUNE_May =  customCalendar.getMonthYearTextView().getText().toString().split("May ");

                       if(whichButton == PREVIOUS) {
                           String yearJUNE_Julyone = yearJUNE_July[1];
                           String date=yearJUNE_Julyone+"-"+"06"+"-"+"01";
                           int daysInMonth=30;
                           Log.d("you", "yearyearJUNE_Julyone: "+yearJUNE_Julyone);

                           tvid_present.setText("Present : 0");

                           tvid_absent.setText("Absent : 30");

                           change_color( arr, date,daysInMonth);



                       }else  if(whichButton == NEXT){
                           String yearJUNE_Mayone=   yearJUNE_May[1];
                           String date=yearJUNE_Mayone+"-"+"06"+"-"+"01";
                           Log.d("you", "yearyearJUNE_Mayone: "+yearJUNE_Mayone);

                         //  change_color( arr, date);
                           int daysInMonth=30;

                           tvid_present.setText("Present : 0");

                           tvid_absent.setText("Absent : 30");


                           change_color( arr, date,daysInMonth);

                       }

                       break;

                   case Calendar.MAY:

                       String[] yearMAY_June =  customCalendar.getMonthYearTextView().getText().toString().split("June ");
                       String[] yearMAY_April =  customCalendar.getMonthYearTextView().getText().toString().split("April ");

                       if(whichButton == PREVIOUS) {
                           String yearMAY_Juneone = yearMAY_June[1];
                           String date=yearMAY_Juneone+"-"+"05"+"-"+"01";
                           int daysInMonth=31;
                           Log.d("you", "yearyearJUNE_Julyone: "+yearMAY_Juneone);

                           tvid_present.setText("Present : 0");

                           tvid_absent.setText("Absent : 31");

                           change_color( arr, date,daysInMonth);



                       }else  if(whichButton == NEXT){
                           String yearMAY_Aprilone=   yearMAY_April[1];
                           String date=yearMAY_Aprilone+"-"+"05"+"-"+"01";
                           Log.d("you", "yearyearJUNE_Mayone: "+yearMAY_Aprilone);

                           //  change_color( arr, date);
                           int daysInMonth=31;

                           tvid_present.setText("Present : 0");

                           tvid_absent.setText("Absent : 31");


                           change_color( arr, date,daysInMonth);

                       }

                       break;

                   case Calendar.APRIL:

                       String[] yearAPRIL_May =  customCalendar.getMonthYearTextView().getText().toString().split("May ");
                       String[] yearAPRIL_March =  customCalendar.getMonthYearTextView().getText().toString().split("March ");

                       if(whichButton == PREVIOUS) {
                           String yearAPRIL_Mayone = yearAPRIL_May[1];
                           String date=yearAPRIL_Mayone+"-"+"04"+"-"+"01";
                           int daysInMonth=30;
                           Log.d("you", "yearyearJUNE_Julyone: "+yearAPRIL_Mayone);

                           tvid_present.setText("Present : 0");

                           tvid_absent.setText("Absent : 30");

                           change_color( arr, date,daysInMonth);



                       }else  if(whichButton == NEXT){
                           String yearAPRIL_Marchone=   yearAPRIL_March[1];
                           String date=yearAPRIL_Marchone+"-"+"04"+"-"+"01";
                           Log.d("you", "yearyearJUNE_Mayone: "+yearAPRIL_Marchone);

                           //  change_color( arr, date);
                           int daysInMonth=30;

                           tvid_present.setText("Present : 0");

                           tvid_absent.setText("Absent : 30");


                           change_color( arr, date,daysInMonth);

                       }

                       break;


                   case Calendar.MARCH:
                       String[] yearMARCH_March =  customCalendar.getMonthYearTextView().getText().toString().split(" ");

                       String[] yearMARCH_April =  customCalendar.getMonthYearTextView().getText().toString().split("April ");
                       String[] yearMARCH_February =  customCalendar.getMonthYearTextView().getText().toString().split("February ");
                       if(whichButton == PREVIOUS) {

                          /* String yearMARCH_Aprilone = yearMARCH_April[1];
                           String date=yearMARCH_Aprilone+"-"+"03"+"-"+"01";
                           int daysInMonth=31;
                           Log.d("you", "yearMARCH_Aprilone: "+yearMARCH_Aprilone);

                           tvid_present.setText("Present : 0");

                           tvid_absent.setText("Absent : 31");

                           change_color( arr, date,daysInMonth);*/

                           String yearMARCH_Marchzero = yearMARCH_March[0];



                           if (yearMARCH_Marchzero.equalsIgnoreCase("March")){

                           }else  if (!yearMARCH_Marchzero.equalsIgnoreCase("March")){
                               String yearMARCH_Aprilone = yearMARCH_April[1];
                               String date=yearMARCH_Aprilone+"-"+"03"+"-"+"01";
                               int daysInMonth=31;
                               Log.d("you", "yearMARCH_Aprilone: "+yearMARCH_Aprilone);

                               tvid_present.setText("Present : 0");

                               tvid_absent.setText("Absent : 31");

                               change_color( arr, date,daysInMonth);
                           }


                       }else  if(whichButton == NEXT){
                           String yearMARCH_Februaryone=   yearMARCH_February[1];
                           String date=yearMARCH_Februaryone+"-"+"03"+"-"+"01";
                           Log.d("you", "yearMARCH_Februaryone: "+yearMARCH_Februaryone);

                           //  change_color( arr, date);
                           int daysInMonth=31;

                           tvid_present.setText("Present : 0");

                           tvid_absent.setText("Absent : 31");


                           change_color( arr, date,daysInMonth);

                       }
                       break;


                   case Calendar.FEBRUARY:

                       String[] yearFEBRUARY_April =  customCalendar.getMonthYearTextView().getText().toString().split("March ");
                       String[] yearFEBRUARY_February =  customCalendar.getMonthYearTextView().getText().toString().split("January ");

                       if(whichButton == PREVIOUS) {
                           String yearFEBRUARY_Aprilone = yearFEBRUARY_April[1];

                           if (((Integer.valueOf(yearFEBRUARY_Aprilone)  % 4 == 0) && (Integer.valueOf(yearFEBRUARY_Aprilone) % 100!= 0)) || (Integer.valueOf(yearFEBRUARY_Aprilone)%400 == 0)) {
                               int daysInMonth = 29;
                               String date=yearFEBRUARY_Aprilone+"-"+"02"+"-"+"01";
                               Log.d("you", "yearFEBRUARY_Aprilone: "+yearFEBRUARY_Aprilone);

                               tvid_present.setText("Present : 0");

                               tvid_absent.setText("Absent : 29");

                               change_color( arr, date,daysInMonth);
                           }
                           else {
                               int daysInMonth = 28;
                               String date=yearFEBRUARY_Aprilone+"-"+"02"+"-"+"01";
                               Log.d("you", "yearFEBRUARY_Aprilone: "+yearFEBRUARY_Aprilone);

                               tvid_present.setText("Present : 0");

                               tvid_absent.setText("Absent : 28");

                               change_color( arr, date,daysInMonth);
                           }

                       }else  if(whichButton == NEXT){
                           String yearFEBRUARY_Februaryone=   yearFEBRUARY_February[1];
                           Log.d("you", "yearyearJUNE_Mayone: "+yearFEBRUARY_Februaryone);

                           if (((Integer.valueOf(yearFEBRUARY_Februaryone)  % 4 == 0) && (Integer.valueOf(yearFEBRUARY_Februaryone) % 100!= 0)) || (Integer.valueOf(yearFEBRUARY_Februaryone)%400 == 0)) {
                               int daysInMonth = 29;
                               String date=yearFEBRUARY_Februaryone+"-"+"02"+"-"+"01";
                               Log.d("you", "yearyearJUNE_Julyone: "+yearFEBRUARY_Februaryone);

                               tvid_present.setText("Present : 0");

                               tvid_absent.setText("Absent : 29");

                               change_color( arr, date,daysInMonth);
                           }
                           else {
                               int daysInMonth = 28;
                               String date=yearFEBRUARY_Februaryone+"-"+"02"+"-"+"01";
                               Log.d("you", "yearyearJUNE_Julyone: "+yearFEBRUARY_Februaryone);

                               tvid_present.setText("Present : 0");

                               tvid_absent.setText("Absent : 28");

                               change_color( arr, date,daysInMonth);
                           }

                       }

                       break;


                   case Calendar.JANUARY:
                       String[] yearJANUARY_February =  customCalendar.getMonthYearTextView().getText().toString().split("February ");
                       String[] yearJANUARY_December =  customCalendar.getMonthYearTextView().getText().toString().split("December ");

                       if(whichButton == PREVIOUS) {
                           String yearJANUARY_Februaryone = yearJANUARY_February[1];
                           String date=yearJANUARY_Februaryone+"-"+"01"+"-"+"01";
                           int daysInMonth=31;
                           Log.d("you", "yearyearJUNE_Julyone: "+yearJANUARY_Februaryone);

                           tvid_present.setText("Present : 0");

                           tvid_absent.setText("Absent : 31");

                           change_color( arr, date,daysInMonth);



                       }else  if(whichButton == NEXT){
                           String yearJANUARY_Decemberone=   yearJANUARY_December[1];
                           String date=yearJANUARY_Decemberone+"-"+"01"+"-"+"01";
                           Log.d("you", "yearyearJUNE_Mayone: "+yearJANUARY_Decemberone);

                           //  change_color( arr, date);
                           int daysInMonth=31;

                           tvid_present.setText("Present : 0");

                           tvid_absent.setText("Absent : 31");


                           change_color( arr, date,daysInMonth);

                       }

                       break;
               }
               return arr;
           }

           public void change_color(Map<Integer, Object>[] arrAUGUST,String date,int daysInMonth){

               arrAUGUST[0] = new HashMap<>();

              studentPresentDateModelList.clear();
               String student_attendence="http://babybunny.in/babybunny/index.php/App/student/attendence";
               StringRequest stringRequest=new StringRequest(Request.Method.POST, student_attendence, new Response.Listener<String>() {
                   @Override
                   public void onResponse(String response) {
                       Log.d("sunita", "onResponse: "+response);

                       try {
                           JSONObject jsonObject = new JSONObject(response);
                           String    success = jsonObject.getString("success");
                           if (success.equalsIgnoreCase("0")){

                           } else{

                               JSONArray jsonArray = jsonObject.getJSONArray("data");
                               Log.d("data", "onResponse: "+jsonArray);

                             if (jsonArray.length()==0){

                             }else {
                                 for (int i = 0; i < jsonArray.length(); i++) {

                                     JSONObject jsonObject1 = jsonArray.getJSONObject(i);

                                     StudentPresentDateModel studentPresentDateModel = new StudentPresentDateModel(

                                             ddate = jsonObject1.getString("ddate")

                                     );

                                     studentPresentDateModelList.add(studentPresentDateModel);

                                 }

                                 tvid_present.setText("Present : " + studentPresentDateModelList.size());
                                 int present = studentPresentDateModelList.size();
                                 int Absent = daysInMonth - present;
                                 tvid_absent.setText("Absent : " + Absent);

                                 ArrayList<Integer> presentDate = new ArrayList<>();

                                 for (int i = 0; i < studentPresentDateModelList.size(); i++) {
                                     // print ArrayList

                                     String[] parts = studentPresentDateModelList.get(i).getDate().split("-");
                                     String part1 = parts[0];
                                     String part2 = parts[1];
                                     String part3 = parts[2];

                                     if (part3.equalsIgnoreCase("01") || part3.equalsIgnoreCase("02")||
                                     part3.equalsIgnoreCase("03")||part3.equalsIgnoreCase("04")||
                                     part3.equalsIgnoreCase("05")||part3.equalsIgnoreCase("06")||
                                     part3.equalsIgnoreCase("07")||part3.equalsIgnoreCase("08")||
                                     part3.equalsIgnoreCase("09")){
                                         String[] part4=part3.toString().split("0");
                                         String part5=part4[1];
                                         presentDate.add(Integer.parseInt(part5));

                                     }else {

                                         presentDate.add(Integer.parseInt(part3));
                                     }
                                    // presentDate.add(Integer.parseInt(part3));

                                 }

                                 for (int i = 0; i < presentDate.size(); i++) {

                                     arrAUGUST[0].put(presentDate.get(i), "Present");
                                     Log.d("amii", "onResponse: " + presentDate.get(i));
                                     //   mapDateToDesc.put(15, "DateOnePresent");

                                 }

                                 HashMap<Object, Property> mapDescToProp = new HashMap<>();
                                 Property propDefault = new Property();
                                 propDefault.layoutResource = R.layout.default_view;
                                 propDefault.dateTextViewResource = R.id.absent_datetextview;
                                 mapDescToProp.put("default", propDefault);
                                 Property Present = new Property();
                                 Present.layoutResource = R.layout.present_view;
                                 Present.dateTextViewResource = R.id.present_datetextview;
                                 mapDescToProp.put("Present", Present);

                                 customCalendar.setMapDescToProp(mapDescToProp);


                             }
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
                       hashMap.put("student_id",SessionManager.getidvalue());
                       hashMap.put("date",date);
                       Log.d("hash", "getParams: "+hashMap);
                       return hashMap;
                   }
               };
               Volley.newRequestQueue(this).add(stringRequest);


           }
           public void change_color(){
               HashMap<Object, Property> mapDescToProp = new HashMap<>();

               Property propDefault = new Property();
               propDefault.layoutResource = R.layout.default_view;
               propDefault.dateTextViewResource = R.id.absent_datetextview;
               mapDescToProp.put("default", propDefault);


               Property Present = new Property();
               Present.layoutResource = R.layout.present_view;
               Present.dateTextViewResource = R.id.present_datetextview;
               mapDescToProp.put("Present", Present);






               customCalendar.setMapDescToProp(mapDescToProp);

   /*     // create a ArrayList String type
        gfg = new ArrayList<String>();

        // Initialize an ArrayList with add()

        gfg.add("2021-01-1");
        gfg.add("2021-01-10");
        gfg.add("2021-01-18");
        gfg.add("2021-01-30");
        gfg.add("2021-01-14");
        gfg.add("2021-01-27");*/

               ArrayList<Integer> presentDate=new ArrayList<>();

               for (int i=0;i<studentPresentDateModelList.size();i++) {
                   // print ArrayList

                   String[] parts = studentPresentDateModelList.get(i).getDate().split("-");
                   String part1 = parts[0];
                   String part2 = parts[1];
                   String part3 = parts[2];
                   Log.d("khuku", "change_color: "+part3);

                   if (part3.equalsIgnoreCase("01") || part3.equalsIgnoreCase("02")||
                           part3.equalsIgnoreCase("03")||part3.equalsIgnoreCase("04")||
                           part3.equalsIgnoreCase("05")||part3.equalsIgnoreCase("06")||
                           part3.equalsIgnoreCase("07")||part3.equalsIgnoreCase("08")||
                           part3.equalsIgnoreCase("09")){
                       String[] part4=part3.toString().split("0");
                       String part5=part4[1];
                       presentDate.add(Integer.parseInt(part5));

                   }else {

                       presentDate.add(Integer.parseInt(part3));
                   }
               }



               HashMap<Integer, Object> mapDateToDesc = new HashMap<>();
               Calendar calendar = Calendar.getInstance();




               for (int i=0;i<presentDate.size();i++) {

                   mapDateToDesc.put(presentDate.get(i), "Present");

               }



      /*  for (int i=0;i<presentDate.size();i++) {

            mapDateToDesc.put(presentDate.get(i), "Present");

        }*/

               customCalendar.setDate(calendar, mapDateToDesc);


           }
           public String addZeroLeading(int num){
               if(num<10){
                   String retstr=String.valueOf(num);
                   return  "0"+retstr;
               }
               else
                   return String.valueOf(num);


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

