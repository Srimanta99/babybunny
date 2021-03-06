package com.baby.babybunny.student.management.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.baby.babybunny.student.management.R;
import com.baby.babybunny.student.management.model.TeachetGetAllClassModel;

import java.util.ArrayList;

public class TeachetGetAllClassAdapter extends BaseAdapter {

    Context context;

    LayoutInflater layoutInflater;
    ArrayList<TeachetGetAllClassModel> selectClassModels;

    public TeachetGetAllClassAdapter(Context context, ArrayList<TeachetGetAllClassModel> selectClassModels) {
        this.context = context;
        this.selectClassModels = selectClassModels;
    }

    @Override
    public int getCount() {

        return selectClassModels.size();

    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        view=layoutInflater.from(context). inflate(R.layout.simple_spinner_item,null);

        TextView class_name=view.findViewById(R.id.class_name);




       /* if (i == 0){

            class_name.setTextColor(Color.parseColor("#f1f0f6"));
        }else {
            class_name.setText(selectClassModels.get(i).getClass_name());
        }*/
        class_name.setText(selectClassModels.get(i).getClass_name());



        return view;
    }


}
