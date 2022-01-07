package com.example.weusthem_test.contactadd;
import androidx.recyclerview.widget.RecyclerView;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;

import java.util.ArrayList;
public class CustomAdaptor extends RecyclerView.Adapter<CustomViewHolder>
{
    private ArrayList<CustomData> data;
    private LayoutInflater inflater;
    public CustomAdaptor(Context context, ArrayList<CustomData> data){
        inflater = LayoutInflater.from(context);
        this.data = data;
    }

    @NonNull
    @Override
    public CustomViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int customViewID) {
        View customView = inflater.inflate(customViewID, parent, false);
        CustomViewHolder customViewHolder = new CustomViewHolder(customView);
        return customViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull CustomViewHolder holder, int position) {
        holder.bind(data.get(position));
    }

    @Override
    public int getItemCount() {
        return data.size();
    }
    @Override
    public int getItemViewType(int position) {
        return data.get(position).getCustomView();

    }
}
