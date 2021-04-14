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

public class StudentTodaysClassDateAdapter extends RecyclerView.Adapter<StudentTodaysClassDateAdapter.StudentTodayClassViewHolder> {

    List<StudentTodaysClassDateModel> studentTodaysClassDateModels;
    Context context;
    LayoutInflater layoutInflater;
    private static int currentPosition = 0;

    public StudentTodaysClassDateAdapter(List<StudentTodaysClassDateModel> studentTodaysClassDateModels, Context context) {
        this.studentTodaysClassDateModels = studentTodaysClassDateModels;
        this.context = context;
    }

    @NonNull
    @Override
    public StudentTodayClassViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view=layoutInflater.from(context).inflate(R.layout.sample_today_class_date,parent,false);
        StudentTodayClassViewHolder studentTodayClassViewHolder=new StudentTodayClassViewHolder(view);
        return studentTodayClassViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull StudentTodayClassViewHolder holder, int position) {
        StudentTodaysClassDateModel studentTodaysClassDateModelposition=studentTodaysClassDateModels.get(position);

        holder.datetvid.setText(studentTodaysClassDateModelposition.getTdate());

        boolean isexpanded=studentTodaysClassDateModels.get(position).isExpanded();
        holder.expandeblervid.setVisibility(isexpanded ? View.VISIBLE : View.GONE);

        StudentTodayClassTestAdapter  adapter = new StudentTodayClassTestAdapter(studentTodaysClassDateModels.get(position).getStudentTodayClassTestModels(),context);
        holder.expandeblervid.setHasFixedSize(false);
        holder.expandeblervid.setLayoutManager(new LinearLayoutManager( context));
        holder.expandeblervid.setAdapter(adapter);

    }

    @Override
    public int getItemCount() {
        return studentTodaysClassDateModels.size();
    }

    public  class StudentTodayClassViewHolder extends RecyclerView.ViewHolder{
        LinearLayout linearLayoutid;
        TextView datetvid,testtvid;
        RecyclerView expandeblervid;

        public StudentTodayClassViewHolder(@NonNull View itemView) {
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
