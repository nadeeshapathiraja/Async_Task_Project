package com.example.asynctask_project;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ListView;

public class NextActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_next);
    }
    public void load(View v){
        //Data load task Create
        DataLoadClass dlt = new DataLoadClass();
        ListView lv = findViewById(R.id.list);
        dlt.execute(lv);
    }
}