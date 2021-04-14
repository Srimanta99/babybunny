package com.baby.babybunny.student.management.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.baby.babybunny.student.management.R;
import com.baby.babybunny.student.management.model.StudentTodaysClassDateModel;

import java.util.List;

public class StudentDoAdapter extends RecyclerView.Adapter<StudentDoAdapter.StudentDoViewHolder> {
    List<StudentTodaysClassDateModel> studentTodaysClassDateModels;
    Context context;
    LayoutInflater layoutInflater;

    public StudentDoAdapter(List<StudentTodaysClassDateModel> studentTodaysClassDateModels, Context context) {
        this.studentTodaysClassDateModels = studentTodaysClassDateModels;
        this.context = context;
    }
    @NonNull
    @Override
    public StudentDoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view=layoutInflater.from(context).inflate(R.layout.sample_student_do,parent,false);
        StudentDoViewHolder studentDoViewHolder=new StudentDoViewHolder(view);
        return studentDoViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull StudentDoViewHolder holder, int position) {
        StudentTodaysClassDateModel studentTodaysClassDateModelposition=studentTodaysClassDateModels.get(position);

        holder.datetvid.setText(studentTodaysClassDateModelposition.getTdate());

        boolean isexpanded=studentTodaysClassDateModels.get(position).isExpanded();
        holder.expandeblervid.setVisibility(isexpanded ? View.VISIBLE : View.GONE);

        StudentDoNotAdapter  adapter = new StudentDoNotAdapter(studentTodaysClassDateModels.get(position).getStudentTodayClassTestModels(),context);
        holder.expandeblervid.setHasFixedSize(false);
        holder.expandeblervid.setLayoutManager(new LinearLayoutManager( context));
        holder.expandeblervid.setAdapter(adapter);

    }

    @Override
    public int getItemCount() {
        return studentTodaysClassDateModels.size();
    }

   public class StudentDoViewHolder extends RecyclerView.ViewHolder{
        LinearLayout linearLayoutid;
        TextView datetvid,testtvid;
        RecyclerView expandeblervid;


        public StudentDoViewHolder(@NonNull View itemView) {
            super(itemView);

            expandeblervid=itemView.findViewById(R.id.expandeblervid);
            linearLayoutid=itemView.findViewById(R.id.linearLayoutid);
            datetvid=itemView.findViewById(R.id.datetvid);


            datetvid.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {



                    StudentTodaysClassDateModel curriculamModel=studentTodaysClassDateModels.get(getAdapterPosition());
                    curriculamModel.setExpanded(!curriculamModel.isExpanded());
                    notifyItemChanged(getAdapterPosition());
                }
            });

        }
    }
}



