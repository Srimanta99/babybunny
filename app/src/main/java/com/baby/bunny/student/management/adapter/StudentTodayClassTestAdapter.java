package com.baby.bunny.student.management.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.baby.bunny.student.management.R;
import com.baby.bunny.student.management.model.StudentTodayClassTestModel;

import java.util.List;


public class StudentTodayClassTestAdapter extends RecyclerView.Adapter<StudentTodayClassTestViewHolder>{

    List<StudentTodayClassTestModel>  studentTodayClassTestModels;
    Context context;

    LayoutInflater layoutInflater;


    public StudentTodayClassTestAdapter(List<StudentTodayClassTestModel> studentTodayClassTestModels, Context context) {
        this.studentTodayClassTestModels = studentTodayClassTestModels;
        this.context = context;
    }

    @NonNull
    @Override
    public StudentTodayClassTestViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view=layoutInflater.from(context).inflate(R.layout.sample_today_class_test,parent,false);
        StudentTodayClassTestViewHolder studentTodayClassTestViewHolder=new StudentTodayClassTestViewHolder(view);
        return studentTodayClassTestViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull StudentTodayClassTestViewHolder holder, int position) {
       StudentTodayClassTestModel studentTodayClassTestModelposition=studentTodayClassTestModels.get(position);

       holder.testtvid.setText(studentTodayClassTestModelposition.getDescription());
    }

    @Override
    public int getItemCount() {
        return studentTodayClassTestModels.size();
    }
}

class  StudentTodayClassTestViewHolder extends RecyclerView.ViewHolder{
TextView testtvid;
    public StudentTodayClassTestViewHolder(@NonNull View itemView) {
        super(itemView);

        testtvid=itemView.findViewById(R.id.testtvid);
    }
}