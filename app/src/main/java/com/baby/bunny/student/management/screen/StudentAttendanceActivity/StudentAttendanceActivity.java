package com.baby.bunny.student.management.screen.StudentAttendanceActivity;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.text.style.ForegroundColorSpan;
import android.text.style.RelativeSizeSpan;
import android.text.style.StyleSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.CalendarView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.baby.bunny.student.management.R;
import com.baby.bunny.student.management.screen.StudentCompanyAchievmentActivity.CompanyAchievementViewBind;
import com.baby.bunny.student.management.screen.StudentCompanyAchievmentActivity.CompanyAchievmentOnClick;
import com.prolificinteractive.materialcalendarview.CalendarDay;
import com.prolificinteractive.materialcalendarview.CalendarMode;
import com.prolificinteractive.materialcalendarview.DayViewDecorator;
import com.prolificinteractive.materialcalendarview.DayViewFacade;
import com.prolificinteractive.materialcalendarview.MaterialCalendarView;
import com.prolificinteractive.materialcalendarview.OnDateSelectedListener;


import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.HashSet;
import java.util.Map;

public class StudentAttendanceActivity extends AppCompatActivity
       {
    StudentAttendanceViewBind studentAttendanceViewBind;
    StudentAttendanceOnClick studentAttendanceOnClick;
MaterialCalendarView calendarid;
int year,month,day;

    boolean selected;

    private static final DateFormat FORMATTER = SimpleDateFormat.getDateInstance();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        View view= LayoutInflater.from(this).inflate(R.layout.activity_student_attendance,null);
        setContentView(view);
        studentAttendanceViewBind= new StudentAttendanceViewBind(this,view);
        studentAttendanceOnClick=new StudentAttendanceOnClick(this,studentAttendanceViewBind);

         calendarid = findViewById(R.id.calendarid);

        calendarid.state().edit()
                .setFirstDayOfWeek(Calendar.MONDAY)
                .setMinimumDate(CalendarDay.from(1900, 1, 1))
                .setMaximumDate(CalendarDay.from(2100, 12, 31))
                .setCalendarDisplayMode(CalendarMode.MONTHS)

                .commit();


        calendarid.setOnDateChangedListener(new OnDateSelectedListener() {
            @Override
            public void onDateSelected(@NonNull MaterialCalendarView widget, @NonNull CalendarDay date, boolean selected) {


                final String text = String.format( FORMATTER.format(date.getDate()));
                Toast.makeText(StudentAttendanceActivity.this, text, Toast.LENGTH_SHORT).show();

           //   String date1=  calendarid.getSelectedDates().toString();
            //   Toast.makeText(StudentAttendanceActivity.this,""+date, Toast.LENGTH_SHORT).show();


            }
        });

    //    calendarid.setOnDateChangeListener( this);



    }



    @Override
    public void onBackPressed() {
        if (getFragmentManager().getBackStackEntryCount() > 0) {
            getFragmentManager().popBackStack();
        } else {
            super.onBackPressed();
        }
    }





    public void categorydata(){
        String url="";
            StringRequest stringRequest=new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
                @Override
                public void onResponse(String response) {

                }
            }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {

                }
            }){
                @Override
                protected Map<String, String> getParams() throws AuthFailureError {
                    return super.getParams();
                }
            };
            Volley.newRequestQueue(this).add(stringRequest);
    }





}

