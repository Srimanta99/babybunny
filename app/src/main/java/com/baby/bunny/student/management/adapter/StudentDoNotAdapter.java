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

public class StudentDoNotAdapter extends RecyclerView.Adapter<StudentDoNotAdapter.StudentDoNotViewHolder> {

    List<StudentTodayClassTestModel> studentTodayClassTestModels;
    Context context;

    LayoutInflater layoutInflater;

    public StudentDoNotAdapter(List<StudentTodayClassTestModel> studentTodayClassTestModels, Context context) {
        this.studentTodayClassTestModels = studentTodayClassTestModels;
        this.context = context;
    }

    @NonNull
    @Override
    public StudentDoNotViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view=layoutInflater.from(context).inflate(R.layout.sample_student_donots,parent,false);
        StudentDoNotViewHolder studentDoNotViewHolder=new StudentDoNotViewHolder(view);
        return studentDoNotViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull StudentDoNotViewHolder holder, int position) {
        StudentTodayClassTestModel studentTodayClassTestModelposition=studentTodayClassTestModels.get(position);

        holder.testtvid.setText(studentTodayClassTestModelposition.getDescription());
    }

    @Override
    public int getItemCount() {
        return studentTodayClassTestModels.size();
    }

    public class StudentDoNotViewHolder extends RecyclerView.ViewHolder{
        TextView testtvid;
        public StudentDoNotViewHolder(@NonNull View itemView) {
            super(itemView);
            testtvid=itemView.findViewById(R.id.testtvid);
        }
    }
}
