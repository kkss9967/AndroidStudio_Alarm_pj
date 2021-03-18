package com.example.alarmproject;

import android.util.TypedValue;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Switch;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.CustomViewHolder> {

    private ArrayList<Dictionary> mList;

    public class CustomViewHolder extends RecyclerView.ViewHolder {
        protected TextView cust_name;
        protected TextView expire_date;
        protected Switch alarm_switch;

        public CustomViewHolder(@NonNull View view) {
            super(view);
            this.cust_name = view.findViewById(R.id.customer_name);
            this.expire_date = view.findViewById(R.id.expire_date);
            this.alarm_switch = view.findViewById(R.id.alarm_switch);
        }
    }

    public CustomAdapter(ArrayList<Dictionary> list){ this.mList = list; }

    @NonNull
    @Override
    public CustomViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.item_list, viewGroup, false);

        CustomViewHolder viewHolder = new CustomViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull CustomViewHolder viewHolder, int position) {
        viewHolder.cust_name.setTextSize(TypedValue.COMPLEX_UNIT_SP, 20);
        viewHolder.expire_date.setTextSize(TypedValue.COMPLEX_UNIT_SP, 16);
        viewHolder.alarm_switch.setChecked(true);

        viewHolder.cust_name.setText(mList.get(position).getCust_name());
        viewHolder.expire_date.setText(mList.get(position).getExpire_date());
      //  viewHolder.alarm_switch.setText((CharSequence) mList.get(position).getAlarm_switch());
    }

    @Override
    public int getItemCount() {
        return (null != mList ? mList.size() : 0);
    }


}
