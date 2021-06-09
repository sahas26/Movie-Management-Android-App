package com.example.moviehq;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class CusAdapter extends RecyclerView.Adapter<CusAdapter.MyViewHolder> {

    private Context context;
    private ArrayList movie_id, movie_title, movie_year, movie_director, movie_artist, movie_rating, movie_review;



    CusAdapter(Context context,ArrayList movie_id,
               ArrayList movie_title,
               ArrayList movie_year,
               ArrayList movie_director,
               ArrayList movie_artist,
               ArrayList movie_rating,
               ArrayList movie_review){
        this.context = context;
        this.movie_id = movie_id;
        this.movie_title = movie_title;
        this.movie_year = movie_year;
        this.movie_director = movie_director;
        this.movie_artist = movie_artist;
        this.movie_rating = movie_rating;
        this.movie_review = movie_review;

    }
    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.my_raws,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {


        holder.movie_id_text.setText(String.valueOf(movie_id.get(position)));
        holder.movie_title_txt.setText(String.valueOf(movie_title .get(position)));
        holder.movie_year_txt.setText(String.valueOf(movie_year.get(position)));
        holder.movie_director_txt.setText(String.valueOf(movie_director.get(position)));
        holder.movie_artist_txt.setText(String.valueOf(movie_artist.get(position)));
        holder.movie_rating_txt.setText(String.valueOf(movie_rating.get(position)));
        holder.movie_review_txt.setText(String.valueOf(movie_review.get(position)));
        holder.mainLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent11 = new Intent(context, UpdateActivity.class);
                intent11.putExtra("id", String.valueOf(movie_id.get(position)));
                intent11.putExtra("title", String.valueOf(movie_title.get(position)));
                intent11.putExtra("year", String.valueOf(movie_year.get(position)));
                intent11.putExtra("director", String.valueOf(movie_director.get(position)));
                intent11.putExtra("artist", String.valueOf(movie_artist.get(position)));
                intent11.putExtra("rating", String.valueOf(movie_rating.get(position)));
                intent11.putExtra("review", String.valueOf(movie_review.get(position)));
                context.startActivity(intent11);


            }
        });

    }

    @Override
    public int getItemCount() {
        return movie_id.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        TextView movie_id_text,movie_title_txt, movie_year_txt, movie_director_txt, movie_artist_txt, movie_rating_txt, movie_review_txt;
        LinearLayout mainLayout;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            movie_id_text= itemView.findViewById(R.id.movie_id_text);
            movie_title_txt= itemView.findViewById(R.id.movie_title_txt);
            movie_year_txt= itemView.findViewById(R.id.movie_year_txt);
            movie_director_txt= itemView.findViewById(R.id.movie_director_txt);
            movie_artist_txt= itemView.findViewById(R.id.movie_artist_txt);
            movie_rating_txt= itemView.findViewById(R.id.movie_rating_txt);
            movie_review_txt= itemView.findViewById(R.id.movie_review_txt);
            mainLayout = itemView.findViewById(R.id.mainLayout);
        }
    }
}
