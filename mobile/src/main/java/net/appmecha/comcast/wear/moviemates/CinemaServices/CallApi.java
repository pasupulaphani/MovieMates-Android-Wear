package net.appmecha.comcast.wear.moviemates.CinemaServices;

import android.content.Context;
import android.os.AsyncTask;

import net.appmecha.comcast.wear.moviemates.Globals;
import net.appmecha.comcast.wear.moviemates.notificationlist_fragment;

import org.apache.http.util.EntityUtils;

import java.io.BufferedInputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;

/**
 * Created by phani on 07/06/2015.
 */
public class CallApi extends AsyncTask<String, String, String> {
    private notificationlist_fragment _con;
    public CallApi(notificationlist_fragment con){
        _con=con;
    }
    @Override
    protected String doInBackground(String... params) {

        String urlString=params[0]; // URL to call

        String resultToDisplay = "";

        InputStream in = null;

        // HTTP Get
        try {

            URL url = new URL(urlString);

            HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();

            in = new BufferedInputStream(urlConnection.getInputStream());

        } catch (Exception e ) {

            System.out.println(e.getMessage());

            return e.getMessage();

        }

        return resultToDisplay;
    }

    protected void onPostExecute(String result) {

        //parse here
        FilmDetailsParser fdp=new FilmDetailsParser();
        ArrayList<FilmDetail> fd= fdp.Parse(result);


        _con.setItems(fd);
    }

}
