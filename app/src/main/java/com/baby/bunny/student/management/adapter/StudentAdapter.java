package com.baby.bunny.student.management.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.baby.bunny.student.management.Interface.StudentIdInterface;
import com.baby.bunny.student.management.R;
import com.baby.bunny.student.management.model.StudentsListModel;

import java.util.List;

public class StudentAdapter extends RecyclerView.Adapter<StudentAdapter.StudentViewHolder>{

    Context context;
    List<StudentsListModel> studentsListModels;
    String student_id;
    LayoutInflater layoutInflater;
    StudentIdInterface studentIdInterface;

    public StudentAdapter(Context context, List<StudentsListModel> studentsListModels, StudentIdInterface studentIdInterface) {
        this.context = context;
        this.studentsListModels = studentsListModels;
        this.studentIdInterface = studentIdInterface;
    }

    @NonNull
    @Override
    public StudentViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view=layoutInflater.from(context).inflate(R.layout.sample_student_name,parent,false);
        StudentViewHolder studentViewHolder=new StudentViewHolder(view);
        return studentViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull StudentViewHolder holder, int position) {
        StudentsListModel studentsListModelpos=studentsListModels.get(position);
        holder.student_name.setText(studentsListModelpos.getStudent_name());
        holder.item_check.setChecked(studentsListModelpos.getIschceked());

        holder.item_check.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                student_id=studentsListModelpos.getId();

                studentIdInterface.Student_id(position);

                for (int i=0;i<studentsListModels.size();i++){
                    if (studentsListModels.get(i).getIschceked()){

                        if (i==position){
                            studentsListModelpos.setIschceked(false);
                            notifyDataSetChanged();
                        }else {
                            studentsListModels.get(i).setIschceked(false);
                            studentsListModels.get(position).setIschceked(true);
                            notifyDataSetChanged();
                        }


                    } else  if (!studentsListModelpos.getIschceked()){
                        studentsListModelpos.setIschceked(true);
                        notifyDataSetChanged();
                    }
                }


                  /*  for (int i=0;i<selectClassModels.size();i++){
                        if (studentsListModelpos.getIschceked() == true){
                            studentsListModelpos.setIschceked(true);
                            notifyDataSetChanged();
                        }else {
                            studentsListModelpos.setIschceked(false);
                            notifyDataSetChanged();
                        }
                    }*/



                /*   if (studentsListModelpos.getIschceked()){
                       studentsListModelpos.setIschceked(false);
                       notifyDataSetChanged();
                   }else {
                       studentsListModelpos.setIschceked(true);
                       notifyDataSetChanged();
                   }*/

            }
        });


          /*  holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                     student_id=studentsListModelpos.getId();


                }
            });
*/
    }

    @Override
    public int getItemCount() {
        return studentsListModels.size();
    }

    public class StudentViewHolder extends RecyclerView.ViewHolder{
        TextView student_name;
        CheckBox item_check;
        public StudentViewHolder(@NonNull View itemView) {
            super(itemView);

            student_name=itemView.findViewById(R.id.student_name);

            item_check=itemView.findViewById(R.id.item_check);
        }
    }
}
