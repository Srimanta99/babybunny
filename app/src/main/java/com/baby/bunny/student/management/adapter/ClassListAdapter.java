package com.baby.bunny.student.management.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.baby.bunny.student.management.R;
import com.baby.bunny.student.management.model.ClassListModel;
import com.baby.bunny.student.management.model.TeacherListModel;

import java.util.List;

public class ClassListAdapter extends RecyclerView.Adapter<ClassListAdapter.ClassListViewHolder> {
    LayoutInflater layoutInflater;
    Context context;
    List<ClassListModel> classListModels;

    public ClassListAdapter(Context context, List<ClassListModel> classListModels) {
        this.context = context;
        this.classListModels = classListModels;
    }

    @NonNull
    @Override
    public ClassListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view=layoutInflater.from(context).inflate(R.layout.sampleclasslist,parent,false);
        ClassListViewHolder classListViewHolder=new ClassListViewHolder(view);

        return classListViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ClassListViewHolder holder, int position) {
        ClassListModel classListModelposition=classListModels.get(position);


        holder.class_name.setText(classListModelposition.getClass_name());
        holder.admission_fees.setText(classListModelposition.getAdmission_fees());
        holder.monthly_fees.setText(classListModelposition.getMonthly_fees());

    }

    @Override
    public int getItemCount() {
        return classListModels.size();
    }

    public class ClassListViewHolder extends RecyclerView.ViewHolder{

        TextView class_name,admission_fees,monthly_fees;
        public ClassListViewHolder(@NonNull View itemView) {
            super(itemView);

            class_name=itemView.findViewById(R.id.class_name);
            admission_fees=itemView.findViewById(R.id.admission_fees);
            monthly_fees=itemView.findViewById(R.id.monthly_fees);
        }
    }
}
