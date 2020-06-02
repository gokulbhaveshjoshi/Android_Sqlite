package com.example.experiment7;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class List extends AppCompatActivity {
    DatabaseHelper myDB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        ListView listView = (ListView) findViewById(R.id.list);
        myDB = new DatabaseHelper(this);

        ArrayList<String> thelist = new ArrayList<>();
        Cursor data = myDB.getListContents();
        if(data.getCount() == 0){
            Toast.makeText(this, "There are no contents in this list!", Toast.LENGTH_LONG).show();
        }else{
            while(data.moveToNext()){
                thelist.add(data.getString(1));
                ListAdapter listAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, thelist);
                listView.setAdapter(listAdapter);
            }
        }
    }
}
