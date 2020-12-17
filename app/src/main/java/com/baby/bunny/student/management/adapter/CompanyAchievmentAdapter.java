package com.baby.bunny.student.management.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.baby.bunny.student.management.R;
import com.baby.bunny.student.management.model.CompanyAchievmentModel;

import java.util.List;

public class CompanyAchievmentAdapter extends RecyclerView.Adapter {
    List<CompanyAchievmentModel> companyAchievmentModels;
    Context context;
    LayoutInflater layoutInflater;

    public CompanyAchievmentAdapter(List<CompanyAchievmentModel> companyAchievmentModels, Context context) {
        this.companyAchievmentModels = companyAchievmentModels;
        this.context = context;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view=layoutInflater.from(context).inflate(R.layout.sample_company_achievement_view,null);
        CompanyAchievmentViewHolder companyAchievmentViewHolder=new CompanyAchievmentViewHolder(view);
        return companyAchievmentViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        CompanyAchievmentModel companyAchievmentModelposition=companyAchievmentModels.get(position);

    }

    @Override
    public int getItemCount() {
        return companyAchievmentModels.size();
    }
}

    class CompanyAchievmentViewHolder extends  RecyclerView.ViewHolder{

        public CompanyAchievmentViewHolder(@NonNull View itemView) {
        super(itemView);
    }

}
