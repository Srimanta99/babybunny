package com.baby.bunny.student.management.screen.Fragment.ParentsZone;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.baby.bunny.student.management.R;
import com.baby.bunny.student.management.screen.CenterManagerHomeActivity.CenterManagerHomeActivity;
import com.baby.bunny.student.management.screen.StudentHomeActivity.StuHomeActivityOnClick;
import com.baby.bunny.student.management.screen.StudentHomeActivity.StuHomeActivityViewBind;
import com.baby.bunny.student.management.screen.StudentHomeActivity.StudentHomeActivity;
import com.baby.bunny.student.management.screen.main.MainActivity;
import com.baby.bunny.student.management.screen.splash.SplashActivity;

/**
 * A simple {@link Fragment} subclass.

 * create an instance of this fragment.
 */
public class ParentsZoneFragment extends Fragment {
    Context context;
    ParentZoneViewBind parentZoneViewBind;
    ParentsZoneOnclick parentsZoneOnclick;


    //  LinearLayout lvidattendance,lvidholidaylist,lvidquery;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        return inflater.inflate(R.layout.fragment_parents_zone, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {


        parentZoneViewBind= new ParentZoneViewBind(this,view);
        parentsZoneOnclick=new ParentsZoneOnclick(this,parentZoneViewBind);
        StuHomeActivityViewBind.parentzoneid.setText("Parent's Zone");
        StuHomeActivityViewBind.menuIcon.setImageResource(R.drawable.menuiconwithoutshadow);




     /*   lvidattendance=view.findViewById(R.id.lvidattendance);
        lvidholidaylist=view.findViewById(R.id.lvidholidaylist);
        lvidquery=view.findViewById(R.id.lvidquery);*/



       /* lvidholidaylist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getActivity(), Student_HolidayList_Activity.class);
                getActivity().startActivity(intent);
            }
        });

        lvidquery.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getActivity(), Student_Query_Activity.class);
                getActivity().startActivity(intent);
            }
        });*/



        super.onViewCreated(view, savedInstanceState);
    }
}