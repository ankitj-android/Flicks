package com.ajasuja.codepath.flicks;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ListView;

import com.ajasuja.codepath.flicks.adapter.MoviesAdapter;
import com.ajasuja.codepath.flicks.model.Movie;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.JsonHttpResponseHandler;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import cz.msebera.android.httpclient.Header;

import static com.ajasuja.codepath.flicks.model.Movie.fromJsonArray;

public class MoviesActivity extends AppCompatActivity {

    //data
    private List<Movie> movies;

    //adapter
    private MoviesAdapter moviesAdapter;

    //view
    private ListView moviesListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movies);

        // init data
        this.movies = new ArrayList<>();
        fetchMovies();

        // init view
        moviesListView = (ListView) findViewById(R.id.listViewMovies);

        // init adapter
        moviesAdapter = new MoviesAdapter(this, movies);

        // attach data & view via adapter
        moviesListView.setAdapter(moviesAdapter);
    }

    private void fetchMovies() {
        AsyncHttpClient asyncHttpClient = new AsyncHttpClient();
        String moviesUrl= "https://api.themoviedb.org/3/movie/now_playing?api_key=a07e22bc18f5cb106bfe4cc1f83ad8ed";
        asyncHttpClient.get(moviesUrl, new JsonHttpResponseHandler(){
            @Override
            public void onSuccess(int statusCode, Header[] headers, JSONObject response) {
                super.onSuccess(statusCode, headers, response);
                JSONArray moviesJsonArray = null;
                try {
                    moviesJsonArray = response.getJSONArray("results");
                    movies.addAll(fromJsonArray(moviesJsonArray));
                    moviesAdapter.notifyDataSetChanged();
                    Log.d("DEBUG", moviesJsonArray.toString());
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure(int statusCode, Header[] headers, Throwable throwable, JSONObject errorResponse) {
                super.onFailure(statusCode, headers, throwable, errorResponse);
            }
        });

    }
}
