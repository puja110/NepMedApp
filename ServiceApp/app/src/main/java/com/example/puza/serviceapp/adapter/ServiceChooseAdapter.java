package com.example.puza.serviceapp.adapter;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.puza.serviceapp.R;
import com.example.puza.serviceapp.ui.SelectedItemActivity;
import com.example.puza.serviceapp.model.Service;

import java.util.List;

public class ServiceChooseAdapter extends RecyclerView.Adapter<ServiceChooseAdapter.MyViewHolder> {

    private Context context;
    ProgressDialog progressDialog;
    private List<Service> albumList;

    public class MyViewHolder extends RecyclerView.ViewHolder{

        public TextView title;
        public ImageView thumbnail;

        public MyViewHolder(final View itemView) {
            super(itemView);
            title =(TextView) itemView.findViewById(R.id.title);
            thumbnail = (ImageView) itemView.findViewById(R.id.thumbnail);
            thumbnail.setOnClickListener(new View.OnClickListener() {
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
//                            SelectedServiceFragment fragment = new SelectedServiceFragment();
//                            FragmentTransaction transaction = ((FragmentActivity) context).getSupportFragmentManager().beginTransaction();
//                            transaction.replace(R.id.frame_container, fragment);
//                            transaction.addToBackStack(null);
//                            transaction.commit();

                            Intent i = new Intent(context, SelectedItemActivity.class);
                            itemView.getContext().startActivity(i);
                        }
                    }).start();
                }
            });
        }
    }

    public ServiceChooseAdapter(Context mContext, List<Service> albumList) {
        this.context = mContext;
        this.albumList = albumList;
    }

    @Override
    public ServiceChooseAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemview = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_service_grid, parent, false);
        return new ServiceChooseAdapter.MyViewHolder(itemview);
    }

    @Override
    public void onBindViewHolder(final ServiceChooseAdapter.MyViewHolder holder, int position) {
        Service album = albumList.get(position);
        holder.title.setText(album.getName());

        //locating album cover using glide library
        Glide.with(context).load(album.getThumbnail()).into(holder.thumbnail);
    }

    @Override
    public int getItemCount() {
        return albumList.size();
    }
}
