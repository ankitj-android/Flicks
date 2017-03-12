package com.ajasuja.codepath.flicks.service.handler;

import com.ajasuja.codepath.flicks.model.Movie;

import java.util.List;

/**
 * Created by ajasuja on 3/11/17.
 */

public interface MovieDBResponseHandler {
    void movies(List<Movie> movies);
    void movie(Movie movie);
    void images(List<String> images);
}
