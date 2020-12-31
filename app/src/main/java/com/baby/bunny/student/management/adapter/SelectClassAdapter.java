package com.baby.bunny.student.management.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.SpinnerAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.baby.bunny.student.management.R;
import com.baby.bunny.student.management.model.SelectClassModel;

import java.util.ArrayList;
import java.util.List;

public class SelectClassAdapter extends BaseAdapter {

    Context context;

    LayoutInflater layoutInflater;
    ArrayList<SelectClassModel> selectClassModels;

    public SelectClassAdapter(Context context, ArrayList<SelectClassModel> selectClassModels) {
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


       class_name.setText(selectClassModels.get(i).getClass_name());



        return view;
    }


}
