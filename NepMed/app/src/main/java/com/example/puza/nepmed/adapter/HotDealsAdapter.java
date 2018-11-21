package com.example.puza.nepmed.adapter;

import android.app.Activity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.puza.nepmed.R;
import com.example.puza.nepmed.model.HotDealsItems;
import com.example.puza.nepmed.model.LatestItems;

import java.util.List;

public class HotDealsAdapter extends RecyclerView.Adapter<HotDealsAdapter.MyViewHolder> {

private List<HotDealsItems> itemList;
        Activity context;

public HotDealsAdapter(Activity context, List<HotDealsItems> itemList) {
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
    public HotDealsAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_hot_deals, parent, false);
        return new HotDealsAdapter.MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(HotDealsAdapter.MyViewHolder holder, final int position) {

        final HotDealsItems items = itemList.get(position);

        holder.image.setImageResource(items.gethImage());
        holder.title.setText(items.gethTitle());
        holder.price1.setText(items.gethPrice1());
        holder.price2.setText(items.gethPrice2());
        holder.addToCart.setText(items.getHAddToCart());

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





