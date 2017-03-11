package com.ajasuja.codepath.flicks.model;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ajasuja on 3/10/17.
 */

public class Movie {

    private static final String POSTER_IMAGE_ROOT_PATH = "https://image.tmdb.org/t/p/w342";

    private String posterPath;
    private String title;
    private String overview;

    private Movie(JSONObject jsonObject) throws JSONException {
        this.posterPath = jsonObject.getString("poster_path");
        this.title = jsonObject.getString("original_title");
        this.overview = jsonObject.getString("overview");
    }


    public String getPosterPath() {
        return POSTER_IMAGE_ROOT_PATH + posterPath;
    }

    public String getTitle() {
        return title;
    }

    public String getOverview() {
        return overview;
    }

    public static List<Movie> fromJsonArray(JSONArray movieJsonArray) throws JSONException {
        List<Movie> movies = new ArrayList<>();
        for (int i=0; i< movieJsonArray.length(); i++) {
            movies.add(new Movie(movieJsonArray.getJSONObject(i)));
        }
        return movies;
    }

    @Override
    public String toString() {
        return title;
    }
}
