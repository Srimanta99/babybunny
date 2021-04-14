package com.baby.babybunny.student.management.adapter;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.baby.babybunny.student.management.Interface.TeacherGetAllStudentInterface;
import com.baby.babybunny.student.management.R;
import com.baby.babybunny.student.management.model.Attendance_status_Model;
import com.baby.babybunny.student.management.model.StudentID_Model;
import com.baby.babybunny.student.management.model.TeacherGetAllStudentModel;
import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class TeacherGetAllStudentAdapter extends RecyclerView.Adapter<TeacherGetAllStudentAdapter.TeacherGetAllStudentViewHolder> {
    LayoutInflater layoutInflater;
    Context context;
    List<TeacherGetAllStudentModel> teacherGetAllStudentModels;
    List<StudentID_Model> studentID_models;
    List<Attendance_status_Model> attendance_status_model;
    TeacherGetAllStudentInterface teacherGetAllStudentInterface;
    ArrayList attendance_status_array=new  ArrayList<String>();
    ArrayList studentID_array=new  ArrayList<String>();
    String attendance_status;

    public TeacherGetAllStudentAdapter(Context context, List<TeacherGetAllStudentModel> teacherGetAllStudentModels, TeacherGetAllStudentInterface teacherGetAllStudentInterface) {
        this.context = context;
        this.teacherGetAllStudentModels = teacherGetAllStudentModels;
        this.teacherGetAllStudentInterface = teacherGetAllStudentInterface;
    }

    @NonNull
    @Override
    public TeacherGetAllStudentViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view=layoutInflater.from(context).inflate(R.layout.sample_student_list,parent,false);
        TeacherGetAllStudentViewHolder teacherGetAllStudentViewHolder=new TeacherGetAllStudentViewHolder(view);
        return teacherGetAllStudentViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull TeacherGetAllStudentViewHolder holder, int position) {
        TeacherGetAllStudentModel teacherListModelposition=teacherGetAllStudentModels.get(position);


        holder.teacher_name.setText("  "+teacherListModelposition.getStudent_name());
        holder.teacher_id.setText("  "+"("+teacherListModelposition.getStudent_id()+")");


       holder.lv_absent.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               holder.tv_absent.setTextColor(Color.parseColor("#EF0D0D"));
               holder.tv_present.setTextColor(Color.parseColor("#827f94"));

               String  student_id=  teacherListModelposition.getId();

               attendance_status="0";



                         if (studentID_array.contains(student_id)) {

                             attendance_status_array.set(studentID_array.indexOf(student_id),attendance_status);
                            //  Toast.makeText(context, studentID_array+" "+attendance_status_array, Toast.LENGTH_SHORT).show();

                         } else {


                             attendance_status_array.add(attendance_status);
                             studentID_array.add(student_id);


                             teacherGetAllStudentInterface.teacherGetAllStudentInterface(position, attendance_status_array, studentID_array);
                           // Toast.makeText(context, studentID_array + " " + attendance_status_array, Toast.LENGTH_SHORT).show();

                         }




           }
       });
        holder.lv_present.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                holder.tv_present.setTextColor(Color.parseColor("#4BBF50"));
                holder.tv_absent.setTextColor(Color.parseColor("#827f94"));

                String  student_id=  teacherListModelposition.getId();
                attendance_status="1";

                if (studentID_array.contains(student_id)) {

                    attendance_status_array.set(studentID_array.indexOf(student_id),attendance_status);
                     //Toast.makeText(context, studentID_array+" "+attendance_status_array, Toast.LENGTH_SHORT).show();

                } else {


                    attendance_status_array.add(attendance_status);
                    studentID_array.add(student_id);

                    teacherGetAllStudentInterface.teacherGetAllStudentInterface(position, attendance_status_array, studentID_array);
                    // Toast.makeText(context, studentID_array + " " + attendance_status_array, Toast.LENGTH_SHORT).show();

                }



            }
        });


        Glide.with(context).
                load(teacherListModelposition.getStudent_image())
                .placeholder(R.drawable.ic_launcher_background).
                into(holder.teacher_image);
    }

    @Override
    public int getItemCount() {
        return teacherGetAllStudentModels.size();
    }

    public class TeacherGetAllStudentViewHolder extends RecyclerView.ViewHolder{
        CircleImageView teacher_image;
        LinearLayout lv_present,lv_absent;
        TextView teacher_name,teacher_id,tv_absent,tv_present,blood_group,dob;
        public TeacherGetAllStudentViewHolder(@NonNull View itemView) {
            super(itemView);
            teacher_image=itemView.findViewById(R.id.teacher_image);

            teacher_name=itemView.findViewById(R.id.teacher_name);
            teacher_id=itemView.findViewById(R.id.teacher_id);

            lv_present=itemView.findViewById(R.id.lv_present);
            lv_absent=itemView.findViewById(R.id.lv_absent);
            tv_present=itemView.findViewById(R.id.tv_present);
            tv_absent=itemView.findViewById(R.id.tv_absent);
        }
    }
}
