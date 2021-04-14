package com.baby.babybunny.student.management.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.baby.babybunny.student.management.R;
import com.baby.babybunny.student.management.model.TeacherTodayClassTaskModel;

import java.util.List;

public class TeacherTodayClassTaskAdapter extends RecyclerView.Adapter<TeacherTodayClassTaskAdapter.TeacherTodayClassTaskViewHolder> {
    LayoutInflater layoutInflater;
    Context context;
    List<TeacherTodayClassTaskModel> teacherTodayClassTaskModels;

    public TeacherTodayClassTaskAdapter(Context context, List<TeacherTodayClassTaskModel> teacherTodayClassTaskModels) {
        this.context = context;
        this.teacherTodayClassTaskModels = teacherTodayClassTaskModels;
    }

    @NonNull
    @Override
    public TeacherTodayClassTaskViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view=layoutInflater.from(context).inflate(R.layout.sampletodays_classlist,parent,false);
        TeacherTodayClassTaskViewHolder teacherTodayClassTaskViewHolder=new TeacherTodayClassTaskViewHolder(view);

        return teacherTodayClassTaskViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull TeacherTodayClassTaskViewHolder holder, int position) {
        TeacherTodayClassTaskModel teacherTodayClassTaskModelpos=teacherTodayClassTaskModels.get(position);

        holder.tv_teacher_name.setText(teacherTodayClassTaskModelpos.getTeacher_name());
        holder.tv_subject.setText(teacherTodayClassTaskModelpos.getSubject());
        holder.tv_content.setText(teacherTodayClassTaskModelpos.getContent());
        holder.tv_ddate.setText(teacherTodayClassTaskModelpos.getDdate());

    }

    @Override
    public int getItemCount() {
        return teacherTodayClassTaskModels.size();
    }

    public class TeacherTodayClassTaskViewHolder extends RecyclerView.ViewHolder{
TextView tv_teacher_name,tv_subject,tv_content,tv_ddate;
        public TeacherTodayClassTaskViewHolder(@NonNull View itemView) {
            super(itemView);
            tv_teacher_name=itemView.findViewById(R.id.tv_teacher_name);
            tv_subject=itemView.findViewById(R.id.tv_subject);
            tv_content=itemView.findViewById(R.id.tv_content);
            tv_ddate=itemView.findViewById(R.id.tv_ddate);

        }
    }
}
