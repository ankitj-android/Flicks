package com.ajasuja.codepath.flicks.service;

import android.util.Log;

import com.ajasuja.codepath.flicks.service.handler.MovieDBResponseHandler;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.JsonHttpResponseHandler;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import cz.msebera.android.httpclient.Header;

import static com.ajasuja.codepath.flicks.model.Movie.fromJsonArray;

/**
 * Created by ajasuja on 3/11/17.
 */

public class MovieDBClient {

    public static void nowPlayingMovies(final MovieDBResponseHandler movieDBResponseHandler) {
        AsyncHttpClient asyncHttpClient = new AsyncHttpClient();
        String moviesUrl= "https://api.themoviedb.org/3/movie/now_playing?api_key=a07e22bc18f5cb106bfe4cc1f83ad8ed";
        asyncHttpClient.get(moviesUrl, new JsonHttpResponseHandler(){
            @Override
            public void onSuccess(int statusCode, Header[] headers, JSONObject response) {
                super.onSuccess(statusCode, headers, response);
                JSONArray moviesJsonArray = null;
                try {
                    moviesJsonArray = response.getJSONArray("results");
                    movieDBResponseHandler.movies(fromJsonArray(moviesJsonArray));
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

    public static void movieById(String movieId, final MovieDBResponseHandler movieDBResponseHandler) {
        AsyncHttpClient asyncHttpClient = new AsyncHttpClient();
        String movieByIdUrl = String.format("https://api.themoviedb.org/3/movie/%s?api_key=a07e22bc18f5cb106bfe4cc1f83ad8ed", movieId);
        asyncHttpClient.get(movieByIdUrl, new JsonHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, Header[] headers, JSONObject response) {
                super.onSuccess(statusCode, headers, response);
            }

            @Override
            public void onFailure(int statusCode, Header[] headers, Throwable throwable, JSONObject errorResponse) {
                super.onFailure(statusCode, headers, throwable, errorResponse);
            }
        });
    }

    public static void images(String movieId, final MovieDBResponseHandler movieDBResponseHandler) {
        AsyncHttpClient asyncHttpClient = new AsyncHttpClient();
        String movieImagesUrl = String.format("https://api.themoviedb.org/3/movie/%s/images?api_key=a07e22bc18f5cb106bfe4cc1f83ad8ed", movieId);
        asyncHttpClient.get(movieImagesUrl, new JsonHttpResponseHandler(){
            @Override
            public void onSuccess(int statusCode, Header[] headers, JSONObject response) {
                super.onSuccess(statusCode, headers, response);
            }

            @Override
            public void onFailure(int statusCode, Header[] headers, Throwable throwable, JSONObject errorResponse) {
                super.onFailure(statusCode, headers, throwable, errorResponse);
            }
        });
    }
}
