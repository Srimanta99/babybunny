package com.baby.babybunny.student.management.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.baby.babybunny.student.management.R;
import com.baby.babybunny.student.management.model.CerterManagerHolidayListModel;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class CerterManagerHolidayListAdapter extends RecyclerView.Adapter<CerterManagerHolidayListAdapter.CerterManagerHolidayListViewHolder> {
    Context context;
    List<CerterManagerHolidayListModel> certerManagerHolidayListModels;
    LayoutInflater layoutInflater;
    String  date;

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


        date= certerManagerHolidayListModelpos.getHolyday_from();
        holder.holyday_from.setText(certerManagerHolidayListModelpos.getHolyday_from());

        try{
            SimpleDateFormat sdf = new SimpleDateFormat("dd, MMM yyyy");
            date = sdf.format(new Date());
            holder.holyday_from.setText(date);
        }catch (Exception e){
            e.printStackTrace();
        }

        holder.holyday_from.setText(date);
    //  holder.holyday_from.setText(certerManagerHolidayListModelpos.getHolyday_from());

      if (position % 3 == 0){
          holder.bglvid.setBackgroundResource(R.drawable.barred);
      }else if (position % 3 == 1){
          holder.bglvid.setBackgroundResource(R.drawable.barblue);
      }else if (position % 3 == 2){
          holder.bglvid.setBackgroundResource(R.drawable.baryellow);
      }

    }

    @Override
    public int getItemCount() {
        return certerManagerHolidayListModels.size();
    }

    public class CerterManagerHolidayListViewHolder extends RecyclerView.ViewHolder{
TextView holyday_details,holyday_from;
LinearLayout bglvid;

        public CerterManagerHolidayListViewHolder(@NonNull View itemView) {
            super(itemView);
            holyday_details=itemView.findViewById(R.id.holyday_details);
            holyday_from=itemView.findViewById(R.id.holyday_from);
            bglvid=itemView.findViewById(R.id.bglvid);
        }
    }
}
