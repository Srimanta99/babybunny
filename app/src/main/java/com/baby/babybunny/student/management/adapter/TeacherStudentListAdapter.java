package com.baby.babybunny.student.management.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.baby.babybunny.student.management.R;
import com.baby.babybunny.student.management.model.TeacherStudentsListModel;
import com.bumptech.glide.Glide;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class TeacherStudentListAdapter extends RecyclerView.Adapter<TeacherStudentListAdapter.TeacherStudentListViewHolder> {
    LayoutInflater layoutInflater;
    Context context;
    List<TeacherStudentsListModel> teacherStudentsListModels;
    String date;

    public TeacherStudentListAdapter(Context context, List<TeacherStudentsListModel> teacherStudentsListModels) {
        this.context = context;
        this.teacherStudentsListModels = teacherStudentsListModels;
    }

    @NonNull
    @Override
    public TeacherStudentListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view=layoutInflater.from(context).inflate(R.layout.sampleteacherstudentlist,parent,false);
        TeacherStudentListViewHolder studentListViewHolder=new TeacherStudentListViewHolder(view);

        return studentListViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull TeacherStudentListViewHolder holder, int position) {
        TeacherStudentsListModel studentsListModelposition=teacherStudentsListModels.get(position);

        holder.student_name.setText(studentsListModelposition.getStudent_name());
        holder.student_id.setText("("+studentsListModelposition.getStudent_id()+")");

        studentsListModelposition.getGuardian_name();

        if (studentsListModelposition.getGuardian_name().equalsIgnoreCase("null")){
            holder.guardian_name.setText("");
        }else {
            holder.guardian_name.setText(studentsListModelposition.getGuardian_name());
        }


        holder.email_id.setText(studentsListModelposition.getEmail_id());
        holder.mobile_no.setText(studentsListModelposition.getMobile_no());

        holder.blood_group.setText(studentsListModelposition.getBlood_group());
        date= studentsListModelposition.getDob();
        holder.dob.setText(studentsListModelposition.getDob());

        SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");
        date = sdf.format(new Date());
        holder.dob.setText(date);
        Glide.with(context).
                load(studentsListModelposition.getStudent_image())
                .placeholder(R.drawable.ic_launcher_background).
                into(holder.student_image);
    }

    @Override
    public int getItemCount() {
        return teacherStudentsListModels.size();
    }

    public class TeacherStudentListViewHolder extends RecyclerView.ViewHolder{
        CircleImageView student_image;
        TextView student_name,student_id,guardian_name,email_id,mobile_no,blood_group,dob;
        public TeacherStudentListViewHolder(@NonNull View itemView) {
            super(itemView);
            student_image=itemView.findViewById(R.id.student_image);

            student_name=itemView.findViewById(R.id.student_name);
            student_id=itemView.findViewById(R.id.student_id);
            guardian_name=itemView.findViewById(R.id.guardian_name);
            email_id=itemView.findViewById(R.id.email_id);
            mobile_no=itemView.findViewById(R.id.mobile_no);

            blood_group=itemView.findViewById(R.id.blood_group);
            dob=itemView.findViewById(R.id.dob);

        }
    }
}
