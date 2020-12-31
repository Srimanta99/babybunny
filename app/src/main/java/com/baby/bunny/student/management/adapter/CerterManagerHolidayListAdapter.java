package com.baby.bunny.student.management.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.baby.bunny.student.management.R;
import com.baby.bunny.student.management.model.CerterManagerHolidayListModel;

import java.util.List;

public class CerterManagerHolidayListAdapter extends RecyclerView.Adapter<CerterManagerHolidayListAdapter.CerterManagerHolidayListViewHolder> {
    Context context;
    List<CerterManagerHolidayListModel> certerManagerHolidayListModels;
    LayoutInflater layoutInflater;

    public CerterManagerHolidayListAdapter(Context context, List<CerterManagerHolidayListModel> certerManagerHolidayListModels) {
        this.context = context;
        this.certerManagerHolidayListModels = certerManagerHolidayListModels;
    }

    @NonNull
    @Override
    public CerterManagerHolidayListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view=layoutInflater.from(context).inflate(R.layout.sample_centermanager_holidaylist,parent,false);
        CerterManagerHolidayListViewHolder certerManagerHolidayListViewHolder=new CerterManagerHolidayListViewHolder(view);
        return certerManagerHolidayListViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull CerterManagerHolidayListViewHolder holder, int position) {
        CerterManagerHolidayListModel certerManagerHolidayListModelpos=certerManagerHolidayListModels.get(position);
      holder.holyday_details.setText(certerManagerHolidayListModelpos.getHolyday_details());
    }

    @Override
    public int getItemCount() {
        return certerManagerHolidayListModels.size();
    }

    public class CerterManagerHolidayListViewHolder extends RecyclerView.ViewHolder{
TextView holyday_details;

        public CerterManagerHolidayListViewHolder(@NonNull View itemView) {
            super(itemView);
            holyday_details=itemView.findViewById(R.id.holyday_details);
        }
    }
}
