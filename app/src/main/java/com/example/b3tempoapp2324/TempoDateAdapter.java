package com.example.b3tempoapp2324;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.helper.widget.Layer;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class TempoDateAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private List<TempoDate> tempoDates;

    /*
     * CTor
     */
    public TempoDateAdapter(List<TempoDate> tempoDates) {
        this.tempoDates = tempoDates;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.tempo_date_item,parent,false);
        return new TempoDateViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return tempoDates.size();
    }

    public class TempoDateViewHolder extends RecyclerView.ViewHolder {

        TextView dateTv;
        FrameLayout colorFl;

        public TempoDateViewHolder(@NonNull View itemView) {
            super(itemView);
            dateTv = itemView.findViewById(R.id.date_tv);
            colorFl = itemView.findViewById(R.id.color_fl);
        }
    }
}