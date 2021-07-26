package com.example.asynctask_project;

import android.os.AsyncTask;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.StringWriter;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class DataLoadClass extends AsyncTask<ListView, Integer,List<String>> {
    ListView lv;
    @Override
    protected List<String> doInBackground(ListView... listViews) {
        lv = listViews[0];
        List<String> list = new ArrayList<>();
        try{
            URL url = new URL("https://jsonplaceholder.typicode.com/todos");
            InputStream in = url.openConnection().getInputStream();
            int n = 0;
            char[] buffer = new char[1024*4];
            InputStreamReader reader = new InputStreamReader(in ,"UTF-8");
            StringWriter writer = new StringWriter();
            while(-1 !=(n=reader.read(buffer))){
                writer.write(buffer,0,n);
            }

            String text = writer.toString();
            System.out.println("Result ......................"+text );
            JSONArray objects = new JSONArray(text);
            for(int i = 0;i<objects.length();i++){
                JSONObject obj = objects.getJSONObject(i);
                String title = obj.getString("title");
                //Boolean complete = obj.getBoolean("completed");
                String complete = obj.getString("completed");
                list.add(title);
                list.add(complete);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return list;
    }

    @Override
    protected void onPostExecute(List<String> stringList) {
        int layout = android.R.layout.simple_list_item_1;
        ArrayAdapter adapter = new ArrayAdapter(lv.getContext(), layout, stringList);
        lv.setAdapter(adapter);
    }
}
