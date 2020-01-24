package com.example.madar.adapters;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.madar.R;
import com.example.madar.data.SavedData;

import java.util.List;

public class RVAdapter extends RecyclerView.Adapter<RVAdapter.RVHolder> {

    public class RVHolder extends RecyclerView.ViewHolder {
        private final TextView nameView;
        private final TextView ageView;
        private final TextView jobTitleView;
        private final TextView genderView;

        private RVHolder(View itemView) {
            super(itemView);
            nameView = itemView.findViewById(R.id.nameView);
            ageView = itemView.findViewById(R.id.ageView);
            jobTitleView = itemView.findViewById(R.id.titleView);
            genderView = itemView.findViewById(R.id.genderView);
        }
    }

    private final LayoutInflater mInflater;
    private List<SavedData> mSavedData;

    public RVAdapter(Context context) { mInflater = LayoutInflater.from(context); }

    @Override
    public RVHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = mInflater.inflate(R.layout.recyclerview_item, parent, false);
        return new RVHolder(itemView);
    }

    @Override
    public void onBindViewHolder(RVHolder holder, int position) {
        if (mSavedData != null) {
            SavedData current = mSavedData.get(position);
            holder.nameView.setText(current.getName());
            holder.ageView.setText(String.valueOf(current.getAge()));
            holder.jobTitleView.setText(current.getJobTitle());
            holder.genderView.setText(current.getGender());
        } else {
            holder.nameView.setText("No Word");
        }
    }

    public void setSavedData(List<SavedData> data){
        mSavedData = data;
        notifyDataSetChanged();
    }
    @Override
    public int getItemCount() {
        if (mSavedData != null)
            return mSavedData.size();
        else return 0;
    }
}
