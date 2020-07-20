package com.upai.smartrefresh.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.upai.smartrefresh.R;

import java.util.ArrayList;
import java.util.List;

public class MainAdapter extends RecyclerView.Adapter<MainAdapter.Holder> {

    private List<String> stringList = new ArrayList<>();

    static class Holder extends RecyclerView.ViewHolder {

        TextView tvTitle;

        Holder(@NonNull View itemView) {
            super(itemView);
            tvTitle = itemView.findViewById(R.id.tv_title);
        }
    }

    @NonNull
    @Override
    public MainAdapter.Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).
                inflate(R.layout.rv_item, parent, false);
        return new Holder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MainAdapter.Holder holder, int position) {
        String s = stringList.get(position);
        holder.tvTitle.setText(s);
    }

    @Override
    public int getItemCount() {
        return stringList.size();
    }

    public void updateList(List<String> list) {
        stringList = list;
        notifyDataSetChanged();
    }

}
