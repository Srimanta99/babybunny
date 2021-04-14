package com.baby.babybunny.student.management.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.baby.babybunny.student.management.R;
import com.baby.babybunny.student.management.model.TeacherListModel;
import com.bumptech.glide.Glide;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class TeacherListAdapter extends RecyclerView.Adapter<TeacherListAdapter.TeacherListHolder> {
    LayoutInflater layoutInflater;
    Context context;
    List<TeacherListModel> teacherListModels;
    String date;

    public TeacherListAdapter(Context context, List<TeacherListModel> teacherListModels) {
        this.context = context;
        this.teacherListModels = teacherListModels;
    }

    @NonNull
    @Override
    public TeacherListHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view=layoutInflater.from(context).inflate(R.layout.sampleteacherlist,parent,false);
        TeacherListHolder studentListViewHolder=new TeacherListHolder(view);

        return studentListViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull TeacherListHolder holder, int position) {
        TeacherListModel teacherListModelposition=teacherListModels.get(position);


        holder.teacher_name.setText("  "+teacherListModelposition.getTeacher_name());
        holder.teacher_id.setText("  "+"("+teacherListModelposition.getTeacher_id()+")");
        holder.blood_group.setText(teacherListModelposition.getBlood_group());
        holder.email_id.setText(" "+teacherListModelposition.getEmail_id());
        holder.teacher_mobile.setText(" "+teacherListModelposition.getTeacher_mobile());

        date= teacherListModelposition.getDob();
        holder.dob.setText(teacherListModelposition.getDob());

        SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");
         date = sdf.format(new Date());
        holder.dob.setText(date);

        Glide.with(context).
                load(teacherListModelposition.getTeacher_image())
                .placeholder(R.drawable.placeholder).
                into(holder.teacher_image);
    }

    @Override
    public int getItemCount() {
        return teacherListModels.size();
    }

    public class TeacherListHolder extends RecyclerView.ViewHolder{
        CircleImageView teacher_image;
        TextView teacher_name,teacher_id,email_id,teacher_mobile,blood_group,dob;
        public TeacherListHolder(@NonNull View itemView) {
            super(itemView);

            teacher_image=itemView.findViewById(R.id.teacher_image);

            teacher_name=itemView.findViewById(R.id.teacher_name);
            teacher_id=itemView.findViewById(R.id.teacher_id);
            email_id=itemView.findViewById(R.id.email_id);
            teacher_mobile=itemView.findViewById(R.id.teacher_mobile);
            blood_group=itemView.findViewById(R.id.blood_group);
            dob=itemView.findViewById(R.id.dob);
        }
    }
}
