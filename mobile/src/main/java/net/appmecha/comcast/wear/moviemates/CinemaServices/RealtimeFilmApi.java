package net.appmecha.comcast.wear.moviemates.CinemaServices;

import android.os.AsyncTask;
import android.util.Log;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;

/**
 * Created by phani on 07/06/2015.
 */
public class RealtimeFilmApi implements IFilmServices {

    private static final String FILMS_API = "https://moviemates-api.herokuapp.com/";

    @Override
    public ArrayList<FilmDetail> GetFilms(double longitude, double latitude) {
        String output="";
        String url = FILMS_API + "films?lon=" + String.valueOf(longitude) + "&lat=" + String.valueOf(latitude);
        new CallApi().execute(url);
        return null;
    }

}
