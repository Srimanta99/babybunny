package com.baby.babybunny.student.management.screen.TeacherFragment.TeacherHomeFragment;

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
public class TeacherHomeFragment extends Fragment {

    TeacherHomeFragmentViewBind teacherHomeFragmentViewBind;
    TeacherHomeFragmentOnclick teacherHomeFragmentOnclick;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_teacher_home, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        teacherHomeFragmentViewBind= new TeacherHomeFragmentViewBind(this,view);
        teacherHomeFragmentOnclick=new TeacherHomeFragmentOnclick(this,teacherHomeFragmentViewBind);
        super.onViewCreated(view, savedInstanceState);
    }
}