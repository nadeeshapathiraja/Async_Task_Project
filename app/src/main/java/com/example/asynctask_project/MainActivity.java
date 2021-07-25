package com.example.asynctask_project;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void load(View v){
        //Create AsyncTask Object and Call
        ImageLoadTask ilt = new ImageLoadTask();
        ImageView image = findViewById(R.id.imageview);
        ilt.execute(image);
    }
}