package com.baby.babybunny.student.management.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.baby.babybunny.student.management.R;
import com.baby.babybunny.student.management.model.TeacherHomeWorkTaskModel;

import java.util.List;

public class TeacherHomeTaskAdapter extends RecyclerView.Adapter<TeacherHomeTaskAdapter.TeacherHomeTaskViewHolder> {
    LayoutInflater layoutInflater;
    Context context;
    List<TeacherHomeWorkTaskModel> teacherHomeWorkTaskModels;

    public TeacherHomeTaskAdapter(Context context, List<TeacherHomeWorkTaskModel> teacherHomeWorkTaskModels) {
        this.context = context;
        this.teacherHomeWorkTaskModels = teacherHomeWorkTaskModels;
    }

    @NonNull
    @Override
    public TeacherHomeTaskViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view=layoutInflater.from(context).inflate(R.layout.sampletodays_classlist,parent,false);
        TeacherHomeTaskViewHolder teacherHomeTaskViewHolder=new TeacherHomeTaskViewHolder(view);

        return teacherHomeTaskViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull TeacherHomeTaskViewHolder holder, int position) {
        TeacherHomeWorkTaskModel teacherTodayClassTaskModelpos=teacherHomeWorkTaskModels.get(position);

        holder.tv_teacher_name.setText(teacherTodayClassTaskModelpos.getTeacher_name());
        holder.tv_subject.setText(teacherTodayClassTaskModelpos.getHomework_for());
        holder.tv_content.setText(teacherTodayClassTaskModelpos.getHomework_details());
        holder.tv_ddate.setText(teacherTodayClassTaskModelpos.getDdate());
    }

    @Override
    public int getItemCount() {
        return teacherHomeWorkTaskModels.size();
    }

    public class TeacherHomeTaskViewHolder extends RecyclerView.ViewHolder{
        TextView tv_teacher_name,tv_subject,tv_content,tv_ddate;
        public TeacherHomeTaskViewHolder(@NonNull View itemView) {
            super(itemView);
            tv_teacher_name=itemView.findViewById(R.id.tv_teacher_name);
            tv_subject=itemView.findViewById(R.id.tv_subject);
            tv_content=itemView.findViewById(R.id.tv_content);
            tv_ddate=itemView.findViewById(R.id.tv_ddate);

        }
    }
}
