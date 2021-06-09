package com.example.moviehq;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class UpdateActivity extends AppCompatActivity {

    EditText title_in, year_in, director_in, artist_in,rating_in,review_in;
    Button update_bt;

    String id, title, year, director, artist, rating, review;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update);

        title_in = findViewById(R.id.txt1_2);
        year_in = findViewById(R.id.txt2_2);
        director_in = findViewById(R.id.txt3_2);
        artist_in = findViewById(R.id.txt4_2);
        rating_in = findViewById(R.id.txt5_2);
        review_in = findViewById(R.id.txt6_2);
        update_bt = findViewById(R.id.update);
        update_bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        getAndSetIntentData();


    }
    void getAndSetIntentData(){
        if (getIntent().hasExtra("id") && getIntent().hasExtra("title") && getIntent().hasExtra("year")
            && getIntent().hasExtra("director") && getIntent().hasExtra("artist") && getIntent().hasExtra("rating")
            && getIntent().hasExtra("review")){

            //getting a data from intent
            id=getIntent().getStringExtra("id");
            title=getIntent().getStringExtra("title");
            year=getIntent().getStringExtra("year");
            director=getIntent().getStringExtra("director");
            artist=getIntent().getStringExtra("artist");
            rating=getIntent().getStringExtra("rating");
            review=getIntent().getStringExtra("review");

            //setting intent data
            title_in.setText(title);
            year_in.setText(year);
            director_in.setText(director);
            artist_in.setText(artist);
            rating_in.setText(rating);
            review_in.setText(review);


        }else {
            Toast.makeText(this,"No data",Toast.LENGTH_SHORT).show();
        }
    }
}