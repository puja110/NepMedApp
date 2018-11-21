package com.example.puza.nepmed.adapter;

import android.app.Activity;
import android.app.ProgressDialog;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.puza.nepmed.R;
import com.example.puza.nepmed.model.LatestActivityItems;
import com.example.puza.nepmed.model.PopularItems;

import java.util.List;

public class LatestActivityAdapter extends RecyclerView.Adapter<LatestActivityAdapter.MyViewHolder> {

    ProgressDialog progressDialog;

    Activity context;
    private List<LatestActivityItems> itemList;

    public LatestActivityAdapter(Activity context, List<LatestActivityItems> itemList) {
        this.context = context;
        this.itemList = itemList;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        private ImageView latestActivityImage1;
        private ImageView latestActivityImage2;
        private TextView latestActivityName, latestActivityNumber, latestActivityTime;
        private CardView latestActivityCard;

        public MyViewHolder(View view) {
            super(view);

            latestActivityImage1 = (ImageView) view.findViewById(R.id.latestActivityImage1);
            latestActivityImage2 = (ImageView) view.findViewById(R.id.latestActivityImage2);
            latestActivityName = (TextView) view.findViewById(R.id.latestActivityName);
            latestActivityNumber = (TextView) view.findViewById(R.id.latestActivityNumber);
            latestActivityCard = (CardView) view.findViewById(R.id.latestActivityCard);

            latestActivityCard.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    progressDialog = new ProgressDialog(context);
                    progressDialog.setMessage("Loading..."); // Setting Message
                    progressDialog.setTitle("Please wait"); // Setting Title
                    progressDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER); // Progress Dialog Style Spinner
                    progressDialog.show(); // Display Progress Dialog
                    progressDialog.setCancelable(false);
                    new Thread(new Runnable() {
                        public void run() {
                            try {
                                Thread.sleep(1000);
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                            progressDialog.dismiss();
//
//                            ServiceDetailFragment fragment = new ServiceDetailFragment();
//                            FragmentTransaction transaction = ((FragmentActivity) context).getSupportFragmentManager().beginTransaction();
//                            transaction.replace(R.id.frame_container, fragment);
//                            transaction.addToBackStack(null);
//                            transaction.commit();
                        }
                    }).start();
                }
            });
        }
    }

    @Override
    public LatestActivityAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.items_latest_activity, parent, false);
        return new LatestActivityAdapter.MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(LatestActivityAdapter.MyViewHolder holder, final int position) {

        final LatestActivityItems items = itemList.get(position);
        holder.latestActivityImage1.setImageResource(items.getLatestActivityImage1());
        holder.latestActivityImage2.setImageResource(items.getLatestActivityImage2());
        holder.latestActivityName.setText(items.getLatestActivityName());
        holder.latestActivityNumber.setText(items.getLatestActivityNumber());

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


