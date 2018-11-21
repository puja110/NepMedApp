package com.example.puza.nepmed.adapter;

import android.app.Activity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.puza.nepmed.R;
import com.example.puza.nepmed.model.AddItems;

import java.util.List;

public class AddAdapter extends RecyclerView.Adapter<AddAdapter.MyViewHolder> {

    private List<AddItems> itemList;
    Activity context;

    public AddAdapter(Activity context, List<AddItems> itemList) {
        this.itemList = itemList;
        this.context = context;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        private TextView name;
        private ImageView image;


        public MyViewHolder(View view) {
            super(view);

            name = (TextView) view.findViewById(R.id.name);
            image = (ImageView) view.findViewById(R.id.image);

        }
    }

    @Override
    public AddAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_add, parent, false);
        return new AddAdapter.MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(AddAdapter.MyViewHolder holder, final int position) {

        final AddItems items = itemList.get(position);
        holder.image.setImageResource(items.getImage());

//        holder.cardView.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//                transport("card");
//            }
//        });
    }

    @Override
    public int getItemCount() {
        return this.itemList.size();
    }
}

