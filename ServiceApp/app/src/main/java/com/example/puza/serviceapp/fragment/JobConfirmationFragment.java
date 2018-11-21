package com.example.puza.serviceapp.fragment;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.puza.serviceapp.R;

public class JobConfirmationFragment extends Fragment {

    Button confirm_booking, cancel_booking;
    Dialog dialog;

    public JobConfirmationFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_job_confirmation, container, false);

        confirm_booking = (Button)view.findViewById(R.id.confirm_booking);
        cancel_booking = (Button)view.findViewById(R.id.cancel_booking);

        openConfirmBookingDialogue();
        openServiceDetailDialogue();

        return view;
    }

    public void openConfirmBookingDialogue(){

        // add listener to button
        confirm_booking.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {

                // Create custom dialog object
                dialog = new Dialog(getContext());
                // Include dialog.xml file
                dialog.setContentView(R.layout.fragment_confirm_booking);

                dialog.getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT,ViewGroup.LayoutParams.WRAP_CONTENT);

                // Set dialog title
//                TextView txt1 = (TextView)dialog.findViewById(R.id.txt1);
//                dialog.setTitle("Add New Address");

                // set values for custom dialog components - text, image and button
//                TextView txt2 = (TextView) dialog.findViewById(R.id.txt2);
//                txt2.setText("Why take hassel ? Simply click below and let us take care of the rest!");

//                EditText editText = (EditText)dialog.findViewById(R.id.editTextAddress);

                dialog.show();

//                done = (Button) view.findViewById(R.id.done);
//                done.setOnClickListener(new View.OnClickListener() {
//                    @Override
//                    public void onClick(View v) {
//                    }
//                });

                Button done = (Button) dialog.findViewById(R.id.done);
                // if decline button is clicked, close the custom dialog
                done.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        showToast();

                    }
                });
            }
        });
    }

    /*--------------------------for dialogue-----------------------------------*/

    public void openServiceDetailDialogue(){

        // add listener to button
        cancel_booking.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {

                // Create custom dialog object
                dialog = new Dialog(getContext());
                // Include dialog.xml file
                dialog.setContentView(R.layout.service_detail_dialogue);

                dialog.getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT,ViewGroup.LayoutParams.WRAP_CONTENT);

                // Set dialog title
//                TextView txt1 = (TextView)dialog.findViewById(R.id.txt1);
//                dialog.setTitle("Add New Address");

                // set values for custom dialog components - text, image and button
//                TextView txt2 = (TextView) dialog.findViewById(R.id.txt2);
//                txt2.setText("Why take hassel ? Simply click below and let us take care of the rest!");

//                EditText editText = (EditText)dialog.findViewById(R.id.editTextAddress);

                dialog.show();

                ImageView declineButton = (ImageView) dialog.findViewById(R.id.cancel);
                // if decline button is clicked, close the custom dialog
                declineButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        // Close dialog
                        dialog.dismiss();
                    }
                });
            }
        });
    }

    /*-------------------------------------------------------------------------------------*/

    @Override
    public void onDestroy() {
        super.onDestroy();
        if (dialog != null) {
            dialog.dismiss();
            dialog = null;
        }
    }

    //for toast notification
    public void showToast() {
        LayoutInflater inflater = getLayoutInflater();
        View layout = inflater.inflate(R.layout.custom_toast_notification_success, (ViewGroup) getView().findViewById(R.id.toast_root));

        TextView toastText = layout.findViewById(R.id.toast_text);
        ImageView toastImage = layout.findViewById(R.id.toast_image);

        toastText.setText("You have successfully selected item .");
        toastImage.setImageResource(R.drawable.ic_action_delete);
        toastImage.setColorFilter(Color.WHITE);

        Toast toast = new Toast(getContext());
        toast.setGravity(Gravity.TOP,0 ,0);
        toast.setDuration(Toast.LENGTH_LONG);
        toast.setView(layout);

         //if decline button is clicked, close the custom dialog
//        toastImage.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                // Close dialog
//                dialog.dismiss();
//            }
//        });

        toast.show();
    }
}
