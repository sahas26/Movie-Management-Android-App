package com.example.moviehq;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import androidx.annotation.Nullable;

class MyDatabaseMovie extends SQLiteOpenHelper {

    private Context context;
    private static final String DATABASE_NAME = "Movie_Hq.db";
    private static final int DATABASE_VERSION =1;

    private static final String TABLE_NAME ="movie_library";
    private static final String COLUMN_ID ="id";
    private static final String COLUMN_TITLE="movie_title";
    private static final String COLUMN_YEAR= "movie_year";
    private static final String COLUMN_DIRECTOR = "movie_director";
    private static final String COLUMN_ARTIST = "movie_artist";
    private static final String COLUMN_RATINGS = "movie_rating";
    private static final String COLUMN_REVIEW ="movie_review";



    public MyDatabaseMovie(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        this.context =context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String query= "CREATE TABLE " + TABLE_NAME +
                        " (" + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                        COLUMN_TITLE + " TEXT, " +
                        COLUMN_YEAR + " INTEGER, " +
                        COLUMN_DIRECTOR + " TEXT, " +
                        COLUMN_ARTIST + " TEXT, " +
                        COLUMN_RATINGS + " INTEGER, " +
                        COLUMN_REVIEW + " TEXT);";
        db.execSQL(query);


    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);

    }

    void addMovie(String title,int year,String director,String artist,int rating,String review){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();

        cv.put(COLUMN_TITLE,title);
        cv.put(COLUMN_YEAR,year);
        cv.put(COLUMN_DIRECTOR,director);
        cv.put(COLUMN_ARTIST,artist);
        cv.put(COLUMN_RATINGS,rating);
        cv.put(COLUMN_REVIEW,review);
        long result = db.insert(TABLE_NAME,null, cv);
        if (result == -1){
            Toast.makeText(context, "Failed", Toast.LENGTH_LONG).show();

        }else {
            Toast.makeText(context, "Added successfully...!", Toast.LENGTH_LONG).show();
        }
    }


    Cursor readAllData(){
        String query = "SELECT * FROM " + TABLE_NAME;
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = null;
        if(db != null){
            cursor = db.rawQuery(query, null);
        }
        return cursor;
    }

}
