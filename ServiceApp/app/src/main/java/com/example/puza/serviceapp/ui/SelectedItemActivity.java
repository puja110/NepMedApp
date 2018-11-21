package com.example.puza.serviceapp.ui;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import android.view.View;
import android.widget.Button;

import com.example.puza.serviceapp.BookActivity;
import com.example.puza.serviceapp.R;

public class SelectedItemActivity extends Activity {

    Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_selected_item);

        Button book_request = (Button) findViewById(R.id.book_request);
        book_request.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i = new Intent(SelectedItemActivity.this, BookActivity.class);
                startActivity(i);
            }

        });
    }
}