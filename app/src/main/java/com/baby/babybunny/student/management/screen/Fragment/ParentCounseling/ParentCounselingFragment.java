package com.baby.babybunny.student.management.screen.Fragment.ParentCounseling;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.baby.babybunny.student.management.R;

/**
 * A simple {@link Fragment} subclass.

 * create an instance of this fragment.
 */
public class ParentCounselingFragment extends Fragment {
    ParentCounselingViewBind parentCounselingViewBind;
    ParentCounselingOnClick parentCounselingOnClick;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_parent_counseling, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {

        parentCounselingViewBind= new ParentCounselingViewBind(this,view);
        parentCounselingOnClick=new ParentCounselingOnClick(this,parentCounselingViewBind);
        super.onViewCreated(view, savedInstanceState);
    }
}