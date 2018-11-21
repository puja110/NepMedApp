package com.example.puza.nepmed.adapter;

import android.app.Activity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.puza.nepmed.R;
import com.example.puza.nepmed.model.LatestItems;

import java.util.List;

public class LatestAdapter extends RecyclerView.Adapter<LatestAdapter.MyViewHolder> {

    private List<LatestItems> itemList;
    Activity context;

    public LatestAdapter(Activity context, List<LatestItems> itemList) {
        this.itemList = itemList;
        this.context = context;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        private ImageView image;
        private TextView title, price1, price2, addToCart;


        public MyViewHolder(View view) {
            super(view);

            image = (ImageView) view.findViewById(R.id.image);
            title = (TextView) view.findViewById(R.id.title);
            price1 = (TextView) view.findViewById(R.id.price1);
            price2 = (TextView) view.findViewById(R.id.price2);
            addToCart = (TextView) view.findViewById(R.id.add_to_cart);

        }
    }

    @Override
    public LatestAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_latest, parent, false);
        return new LatestAdapter.MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(LatestAdapter.MyViewHolder holder, final int position) {

        final LatestItems items = itemList.get(position);

        holder.image.setImageResource(items.getImage());
        holder.title.setText(items.getTitle());
        holder.price1.setText(items.getPrice1());
        holder.price2.setText(items.getPrice2());
        holder.addToCart.setText(items.getAddToCart());

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





