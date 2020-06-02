package com.example.experiment7;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    DatabaseHelper myDB;
    Button btnAdd,btnView;
    EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editText = (EditText) findViewById(R.id.Text);
        btnAdd = (Button) findViewById(R.id.Add);
        btnView = (Button) findViewById(R.id.View);
        myDB = new DatabaseHelper(this);

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String newEntry = editText.getText().toString();
                if(editText.length()!=0){
                    AddData(newEntry);
                    editText.setText("");
                }
                else{
                    Toast.makeText(MainActivity.this, "No Input in text Field! ",Toast.LENGTH_LONG).show();
                }
            }
        });

        btnView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, List.class);
                startActivity(intent);
            }
        });
    }
    public void AddData(String newEntry){
        boolean insertData = myDB.addData(newEntry);

        if(insertData == true){
            Toast.makeText(this, "Data Successfully Inserted :)",Toast.LENGTH_LONG).show();
        }
        else{
            Toast.makeText(this, "Something went wrong :(", Toast.LENGTH_LONG).show();
        }
    }
}
