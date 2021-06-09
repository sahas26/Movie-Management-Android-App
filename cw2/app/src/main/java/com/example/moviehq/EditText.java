package com.example.moviehq;

        import androidx.appcompat.app.AppCompatActivity;
        import androidx.recyclerview.widget.LinearLayoutManager;
        import androidx.recyclerview.widget.RecyclerView;

        import android.database.Cursor;
        import android.os.Bundle;
        import android.widget.Toast;

        import java.util.ArrayList;

public class EditText extends AppCompatActivity {

    RecyclerView recyclerView;

    MyDatabaseMovie myDB;
    ArrayList<String> movie_id, movie_title,movie_year, movie_director, movie_artist, movie_rating, movie_review;
    CusAdapter customAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_text);

        recyclerView = findViewById(R.id.recyclerView);


        myDB = new MyDatabaseMovie(EditText.this);
        movie_id = new ArrayList<>();
        movie_title = new ArrayList<>();
        movie_year = new ArrayList<>();
        movie_director = new ArrayList<>();
        movie_artist = new ArrayList<>();
        movie_rating = new ArrayList<>();
        movie_review = new ArrayList<>();

        displayDataArray();
        customAdapter=new CusAdapter(EditText.this, movie_id, movie_title, movie_year,movie_director, movie_artist, movie_rating, movie_review);
        recyclerView.setAdapter(customAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(EditText.this));


    }
    void displayDataArray(){
        Cursor cursor = myDB.readAllData();
        if(cursor.getCount() == 0){
            Toast.makeText(this,"No Data",Toast.LENGTH_SHORT).show();
        }else {
            while (cursor.moveToNext()){
                movie_id.add(cursor.getString(0));
                movie_title.add(cursor.getString(1));
                movie_year.add(cursor.getString(2));
                movie_director.add(cursor.getString(3));
                movie_artist.add(cursor.getString(4));
                movie_rating.add(cursor.getString(5));
                movie_review.add(cursor.getString(6));
            }
        }
    }
}