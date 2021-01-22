package com.baby.bunny.student.management.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.baby.bunny.student.management.R;
import com.baby.bunny.student.management.model.CenterHomeTaskModel;
import com.baby.bunny.student.management.model.TeacherListModel;
import com.bumptech.glide.Glide;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class CenterHomeTaskAdapter extends RecyclerView.Adapter<CenterHomeTaskAdapter.CenterHomeTaskViewHolder> {
Context context;
List<CenterHomeTaskModel> centerHomeTaskModels;
LayoutInflater layoutInflater;

    public CenterHomeTaskAdapter(Context context, List<CenterHomeTaskModel> centerHomeTaskModels) {
        this.context = context;
        this.centerHomeTaskModels = centerHomeTaskModels;
    }

    @NonNull
    @Override
    public CenterHomeTaskViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view=layoutInflater.from(context).inflate(R.layout.sample_home_task,parent,false);
        CenterHomeTaskViewHolder centerHomeTaskViewHolder=new CenterHomeTaskViewHolder(view);
        return centerHomeTaskViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull CenterHomeTaskViewHolder holder, int position) {

        CenterHomeTaskModel centerHomeTaskModelpos=centerHomeTaskModels.get(position);
       // TeacherListModel teacherListModelposition=teacherListModels.get(position);


        holder.class_name.setText(centerHomeTaskModelpos.getClass_name());
        holder.teacher_id.setText("("+centerHomeTaskModelpos.getTeacher_id()+")");
        holder.teacher_name.setText(centerHomeTaskModelpos.getTeacher_name());

        holder.homework_details.setText(centerHomeTaskModelpos.getHomework_details());
        holder.homework_for.setText(centerHomeTaskModelpos.getHomework_for());

        Glide.with(context).load(centerHomeTaskModelpos.getTeacher_image()).
                placeholder(R.drawable.placeholder).into(holder.teacher_image);

    }

    @Override
    public int getItemCount() {
        return centerHomeTaskModels.size();
    }

    public class CenterHomeTaskViewHolder extends RecyclerView.ViewHolder{
        TextView class_name,homework_for,homework_details,teacher_name,teacher_id;
        CircleImageView teacher_image;
        public CenterHomeTaskViewHolder(@NonNull View itemView) {
            super(itemView);

            class_name=itemView.findViewById(R.id.class_name);
            homework_for=itemView.findViewById(R.id.homework_for);
            homework_details=itemView.findViewById(R.id.homework_details);
            teacher_name=itemView.findViewById(R.id.teacher_name);
            teacher_id=itemView.findViewById(R.id.teacher_id);
            teacher_image=itemView.findViewById(R.id.teacher_image);
        }
    }
}
