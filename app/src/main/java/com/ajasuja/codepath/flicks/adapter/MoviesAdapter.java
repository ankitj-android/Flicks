package com.ajasuja.codepath.flicks.adapter;

import android.content.Context;
import android.content.res.Configuration;
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

import static com.ajasuja.codepath.flicks.R.id.textViewMovieOverview;
import static com.ajasuja.codepath.flicks.R.id.textViewMovieTitle;

/**
 * Created by ajasuja on 3/10/17.
 */

public class MoviesAdapter extends ArrayAdapter<Movie> {

    private boolean isLandscape = false;

    private static class ViewHolder {
        private ImageView imageViewMovieImage;
        private TextView textViewMovieTitle;
        private TextView textViewMovieOverview;
    }

    public MoviesAdapter(Context context, List<Movie> movies) {
        super(context, android.R.layout.simple_list_item_1, movies);
        checkOrientation();
    }

    private void checkOrientation() {
        int orientation = getContext().getResources().getConfiguration().orientation;
        if (orientation == Configuration.ORIENTATION_PORTRAIT) {
            isLandscape = false;
        } else if (orientation == Configuration.ORIENTATION_LANDSCAPE) {
            isLandscape = true;
        }
    }


    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Movie movie = getItem(position);
        ViewHolder viewHolder;

        if (convertView == null) {
            LayoutInflater inflater = LayoutInflater.from(getContext());
            convertView = inflater.inflate(R.layout.item_movie, parent, false);

            viewHolder = new ViewHolder();
            viewHolder.imageViewMovieImage = (ImageView) convertView.findViewById(R.id.imageViewMovieImage);
            viewHolder.textViewMovieTitle = (TextView) convertView.findViewById(textViewMovieTitle);
            viewHolder.textViewMovieOverview = (TextView) convertView.findViewById(textViewMovieOverview);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        viewHolder.imageViewMovieImage.setImageResource(0); // clear out image from convertview
        if (isLandscape) {
            Picasso.with(getContext()).load(movie.getBackdropPath()).into(viewHolder.imageViewMovieImage);
        } else {
            Picasso.with(getContext()).load(movie.getPosterPath()).into(viewHolder.imageViewMovieImage);
        }
        viewHolder.textViewMovieTitle.setText(movie.getTitle());
        viewHolder.textViewMovieOverview.setText(movie.getOverview());

        return convertView;
    }
}
