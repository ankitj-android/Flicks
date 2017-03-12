package com.ajasuja.codepath.flicks.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

import com.ajasuja.codepath.flicks.R;
import com.ajasuja.codepath.flicks.model.Movie;
import com.squareup.picasso.Picasso;

import org.parceler.Parcels;

/**
 * Created by ajasuja on 3/11/17.
 */

public class MovieDetailsActivity extends AppCompatActivity {

    //data
    private Movie movie;

    //view
    private ImageView imageViewMovieImage;
    private TextView textViewMovieTitle;
    private TextView textViewMovieOverview;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_details);

        //data
        movie = Parcels.unwrap(getIntent().getParcelableExtra("movie"));

        //load views
        imageViewMovieImage = (ImageView)findViewById(R.id.imageViewMovieImage);
        textViewMovieTitle = (TextView) findViewById(R.id.textViewMovieTitle);
        textViewMovieOverview = (TextView) findViewById(R.id.textViewMovieOverview);

        Picasso.with(getApplicationContext())
                .load(movie.getBackdropPath("w1280"))
//                    .placeholder(R.drawable.loading)
                .into(imageViewMovieImage);
        textViewMovieTitle.setText(movie.getTitle());
        textViewMovieOverview.setText(movie.getOverview());

        System.out.println("inside details activity ... " + movie);
    }
}
