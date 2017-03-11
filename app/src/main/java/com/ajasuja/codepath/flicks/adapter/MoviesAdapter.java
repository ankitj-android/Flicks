package com.ajasuja.codepath.flicks.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.ajasuja.codepath.flicks.R;
import com.ajasuja.codepath.flicks.model.Movie;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by ajasuja on 3/10/17.
 */

public class MoviesAdapter extends ArrayAdapter<Movie> {

    public MoviesAdapter(Context context, List<Movie> movies) {
        super(context, android.R.layout.simple_list_item_1, movies);
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        //
        Movie movie = getItem(position);

        if (convertView == null) {
            LayoutInflater inflater = LayoutInflater.from(getContext());
            convertView = inflater.inflate(R.layout.item_movie, parent, false);
        }

        ImageView imageViewPosterImage = (ImageView) convertView.findViewById(R.id.imageViewPosterImage);
        imageViewPosterImage.setImageResource(0); // clear out image from convertview

        
        Picasso.with(getContext()).load(movie.getPosterPath()).into(imageViewPosterImage);
        TextView textViewMovieTitle = (TextView) convertView.findViewById(R.id.textViewMovieTitle);
        TextView textViewMovieOverview = (TextView) convertView.findViewById(R.id.textViewMovieOverview);

        textViewMovieTitle.setText(movie.getTitle());
        textViewMovieOverview.setText(movie.getOverview());

        return convertView;
    }
}
