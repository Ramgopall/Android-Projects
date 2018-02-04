package com.example.amit.recyclerview1;

import android.support.v7.widget.RecyclerView;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;
import java.util.zip.Inflater;

/**
 * Created by Amit on 6/7/2017.
 */

public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.Myviewholder> {

 public List<Movie> movieList;

    public class Myviewholder extends RecyclerView.ViewHolder{
       public TextView title,genre,year;

        public Myviewholder(View view) {
            super(view);
            title = (TextView) view.findViewById(R.id.title);
            genre = (TextView) view.findViewById(R.id.genre);
            year = (TextView) view.findViewById(R.id.year);

        }
    }

    public MovieAdapter(List<Movie> moviesList) {
        this.movieList = moviesList;
    }
    @Override
    public Myviewholder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.movie_list_row,parent,false);

        return new Myviewholder(view);
    }


    public void onBindViewHolder(Myviewholder holder, int position) {

        Movie movie = movieList.get(position);
        holder.title.setText(movie.getTitle());
        holder.genre.setText(movie.getGenre());
        holder.year.setText(movie.getYear());
    }

    @Override
    public int getItemCount() {
        return movieList.size();
    }
}
