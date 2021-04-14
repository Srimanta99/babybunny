package com.baby.babybunny.student.management.screen.Fragment.ParentsZone;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.baby.babybunny.student.management.R;
import com.baby.babybunny.student.management.screen.StudentHomeActivity.StuHomeActivityViewBind;

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


        super.onViewCreated(view, savedInstanceState);
    }
}