package com.baby.bunny.student.management.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.baby.bunny.student.management.R;
import com.baby.bunny.student.management.model.StudentFeesListModel;
import com.baby.bunny.student.management.model.StudentsListModel;
import com.bumptech.glide.Glide;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class CenterStudentFeesListAdapter extends RecyclerView.Adapter<CenterStudentFeesListAdapter.CenterStudentFeesListViewHolder> {
  Context context;
  List<StudentFeesListModel> studentFeesListModels;
 LayoutInflater layoutInflater;
String fees_date;

    public CenterStudentFeesListAdapter(Context context, List<StudentFeesListModel> studentFeesListModels) {
        this.context = context;
        this.studentFeesListModels = studentFeesListModels;
    }

    @NonNull
    @Override
    public CenterStudentFeesListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view=layoutInflater.from(context).inflate(R.layout.sample_studentfees_list,parent,false);
        CenterStudentFeesListViewHolder centerStudentFeesListViewHolder=new CenterStudentFeesListViewHolder(view);
        return centerStudentFeesListViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull CenterStudentFeesListViewHolder holder, int position) {
        StudentFeesListModel studentFeesListModelpos=studentFeesListModels.get(position);


        holder.student_name.setText(studentFeesListModelpos.getStudent_name());
        holder.student_code.setText("("+studentFeesListModelpos.getStudent_code()+")");
        holder.type_name.setText(studentFeesListModelpos.getType_name());
        holder.fees.setText("\u20B9"+studentFeesListModelpos.getFees());
        fees_date= studentFeesListModelpos.getFees_date();
        holder.fees_date.setText(studentFeesListModelpos.getFees_date());

        SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");
        fees_date = sdf.format(new Date());
        holder.fees_date.setText(fees_date);
        holder.class_name.setText(studentFeesListModelpos.getClass_name());

        Glide.with(context).load(studentFeesListModelpos.getStudent_image()).into(holder.student_image);

    }

    @Override
    public int getItemCount() {
        return studentFeesListModels.size();
    }

    public class CenterStudentFeesListViewHolder extends RecyclerView.ViewHolder{

        CircleImageView student_image;

        TextView student_name,student_code,type_name,fees,fees_date,class_name;

        public CenterStudentFeesListViewHolder(@NonNull View itemView) {
            super(itemView);

            student_name=itemView.findViewById(R.id.student_name);
            student_code=itemView.findViewById(R.id.student_code);
            type_name=itemView.findViewById(R.id.type_name);
            fees=itemView.findViewById(R.id.fees);
            fees_date=itemView.findViewById(R.id.fees_date);
            class_name=itemView.findViewById(R.id.class_name);
            student_image=itemView.findViewById(R.id.student_image);
        }
    }
}
