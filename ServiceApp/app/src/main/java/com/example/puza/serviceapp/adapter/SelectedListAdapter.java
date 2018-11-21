package com.example.puza.serviceapp.adapter;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.puza.serviceapp.R;
import com.example.puza.serviceapp.model.SelectedListItem;

import java.util.List;

public class SelectedListAdapter extends RecyclerView.Adapter<SelectedListAdapter.MyViewHolder> {

    private List<SelectedListItem> selectedItem;
    Activity context;

    public SelectedListAdapter(List<SelectedListItem> selectedItem, Activity context) {
        this.selectedItem = selectedItem;
        this.context = context;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{

        private ImageView image;
        private TextView name, description, buttonOne, buttonTwo;

        public MyViewHolder(View itemView) {
            super(itemView);

            image = (ImageView)itemView.findViewById(R.id.image);
            name = (TextView)itemView.findViewById(R.id.name);
            description = (TextView)itemView.findViewById(R.id.description);
            buttonOne = (TextView)itemView.findViewById(R.id.buttonOne);
            buttonTwo = (TextView)itemView.findViewById(R.id.buttonTwo);

        }
    }

    @NonNull
    @Override
    public SelectedListAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_selected_list, parent, false);
        return new SelectedListAdapter.MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull SelectedListAdapter.MyViewHolder holder, int position) {

        final SelectedListItem items = selectedItem.get(position);
        holder.image.setImageResource(items.getImage());
        holder.name.setText(items.getName());
        holder.description.setText(items.getDescription());
        holder.buttonOne.setText(items.getButtonOne());
        holder.buttonTwo.setText(items.getButtonTwo());
    }

    @Override
    public int getItemCount() {
        return this.selectedItem.size();
    }

}
