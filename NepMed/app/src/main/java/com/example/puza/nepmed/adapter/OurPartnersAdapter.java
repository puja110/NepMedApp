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
import com.example.puza.nepmed.model.OurPartnersItems;

import java.util.List;

public class OurPartnersAdapter extends RecyclerView.Adapter<OurPartnersAdapter.MyViewHolder> {

    private List<OurPartnersItems> itemList;
    Activity context;

    public OurPartnersAdapter(Activity context, List<OurPartnersItems> itemList) {
        this.itemList = itemList;
        this.context = context;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        private ImageView opImage;
        private TextView opId, opLink;


        public MyViewHolder(View view) {
            super(view);

            opImage = (ImageView) view.findViewById(R.id.image);
//            opId = (TextView) view.findViewById(R.id.opId);
//            opLink = (TextView) view.findViewById(R.id.opLink);

        }
    }

    @Override
    public OurPartnersAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_our_partners, parent, false);
        return new OurPartnersAdapter.MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(OurPartnersAdapter.MyViewHolder holder, final int position) {

        final OurPartnersItems items = itemList.get(position);

        holder.opImage.setImageResource(items.getImage());

//        holder.opId.setText(items.getOpId());
//        holder.opLink.setText(items.getOpLink());

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






