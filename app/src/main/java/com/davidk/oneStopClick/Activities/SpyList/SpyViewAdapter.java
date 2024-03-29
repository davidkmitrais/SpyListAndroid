package com.davidk.oneStopClick.Activities.SpyList;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.davidk.oneStopClick.Helpers.CustomItemClickListener;
import com.davidk.oneStopClick.ModelLayer.DTOs.SpyDTO;
import com.davidk.oneStopClick.R;

import java.util.ArrayList;
import java.util.List;

public class SpyViewAdapter extends RecyclerView.Adapter<SpyViewHolder> {

    List<SpyDTO> spies = new ArrayList<>();
    CustomItemClickListener listener;

    public SpyViewAdapter(CustomItemClickListener listener) {
        this.listener = listener;
    }

    @Override
    public SpyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View spyView = LayoutInflater.from(parent.getContext()).inflate(R.layout.spy_cell, parent, false);

        final SpyViewHolder spyViewHolder = new SpyViewHolder(spyView);

        spyView.setOnClickListener(v -> listener.onItemClick(v, spyViewHolder.getAdapterPosition()));

        return spyViewHolder;
    }

    @Override
    public void onBindViewHolder(SpyViewHolder holder, int index) {
        SpyDTO spy = spies.get(index);
        holder.configureWith(spy);
    }

    @Override
    public int getItemCount() {
        return spies.size();
    }

    public void setSpies(List<SpyDTO> spies){
        this.spies = spies;
        notifyDataSetChanged();
    }

}
