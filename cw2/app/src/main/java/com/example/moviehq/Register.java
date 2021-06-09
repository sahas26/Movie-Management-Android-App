package com.example.moviehq;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Register extends AppCompatActivity {

    EditText title,year,director,artist,ratings,review;
    Button bt1;
    


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);




        ////edit text
        title = findViewById(R.id.txt1);
        year = findViewById(R.id.txt2);
        director = findViewById(R.id.txt3);
        artist = findViewById(R.id.txt4);
        ratings = findViewById(R.id.txt5);
        review = findViewById(R.id.txt6);

        ////button
        bt1=findViewById(R.id.saveDate);





        bt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              MyDatabaseMovie myDB = new MyDatabaseMovie(Register.this);
              myDB.addMovie(title.getText().toString().trim(),
                      Integer.valueOf(year.getText().toString().trim()),
                      director.getText().toString().trim(),
                      artist.getText().toString().trim(),
                      Integer.valueOf(ratings.getText().toString().trim()),
                      review.getText().toString().trim());


            }
        });

    }


}