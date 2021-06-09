package com.example.moviehq;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button register,display,editdata;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //////Register Movie

        register=findViewById(R.id.button);
        display=findViewById(R.id.button2);
        editdata=findViewById(R.id.button4);


        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1=new Intent(MainActivity.this,Register.class);
                startActivity(intent1);
            }
        });

        /////Display Movie


        display.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent2=new Intent(MainActivity.this,DisplayData.class);
                startActivity(intent2);
            }
        });



        ////////Edit Movie

        editdata.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent3=new Intent(MainActivity.this,EditText.class);
                startActivity(intent3);
            }
        });
    }
}