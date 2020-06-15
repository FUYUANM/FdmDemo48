package com.fdm48.fdmdemo48.lect07intent;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.TextView;

import com.fdm48.fdmdemo48.R;

public class MyWebActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_web);
        Intent intent=getIntent();
        Uri data=intent.getData();
        TextView webTV=findViewById(R.id.txt_web);
        webTV.setText(data.toString());
    }
}

