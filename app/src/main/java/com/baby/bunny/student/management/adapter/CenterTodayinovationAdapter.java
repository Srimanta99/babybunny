package com.baby.bunny.student.management.adapter;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.baby.bunny.student.management.R;
import com.baby.bunny.student.management.model.CenterTodayinovationModel;
import com.bumptech.glide.Glide;

import java.util.List;

public class CenterTodayinovationAdapter extends RecyclerView.Adapter<CenterTodayinovationAdapter.CenterTodayinovationViewHolder> {

    Context context;
    List<CenterTodayinovationModel> centerTodayinovationModels;
    LayoutInflater layoutInflater;


    public CenterTodayinovationAdapter(Context context, List<CenterTodayinovationModel> centerTodayinovationModels) {
        this.context = context;
        this.centerTodayinovationModels = centerTodayinovationModels;
    }

    @NonNull
    @Override
    public CenterTodayinovationViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view=layoutInflater.from(context).inflate(R.layout.sample_center_today_innovation,parent,false);
        CenterTodayinovationViewHolder centerTodayinovationViewHolder=new CenterTodayinovationViewHolder(view);
        return centerTodayinovationViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull CenterTodayinovationViewHolder holder, int position) {
        CenterTodayinovationModel centerTodayinovationModelpos=centerTodayinovationModels.get(position);
        Glide.with(context).
                load(centerTodayinovationModelpos.getFinal_video_URLthamnil()).into(holder.final_video_URL);

        holder.btnPlayPause.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (centerTodayinovationModelpos.getFinal_video_URL().isEmpty()) {
                    Toast.makeText(context, "video not found", Toast.LENGTH_SHORT).show();
                } else{
                    context.startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse(centerTodayinovationModelpos.getFinal_video_URL())));
            }
            }
        });


        holder.subject.setText(centerTodayinovationModelpos.getSubject());


    }

    @Override
    public int getItemCount() {
        return centerTodayinovationModels.size();
    }

    public class CenterTodayinovationViewHolder extends RecyclerView.ViewHolder{
ImageView final_video_URL;
        ImageView btnPlayPause;
        TextView subject;
        public CenterTodayinovationViewHolder(@NonNull View itemView) {
            super(itemView);
            final_video_URL=itemView.findViewById(R.id.final_video_URL);
            btnPlayPause=itemView.findViewById(R.id.btnPlayPause);
            subject=itemView.findViewById(R.id.subject);
        }
    }
}
