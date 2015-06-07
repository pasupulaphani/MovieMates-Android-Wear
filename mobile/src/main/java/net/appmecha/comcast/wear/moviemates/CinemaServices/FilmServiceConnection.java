package net.appmecha.comcast.wear.moviemates.CinemaServices;

import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by Neil on 07/06/2015.
 */
public class FilmServiceConnection extends AsyncTask<String,Void,ArrayList<FilmDetail>> {


    private Context _context;

    private ArrayList<FilmDetail> _films;
    public ArrayList<FilmDetail> getFilms(){
        return _films;
    }
    public void setPolls(ArrayList<FilmDetail> val){
        _films=val;
    }

    public FilmServiceConnection(Context con){
        _context=con;

    }


    @Override
    protected ArrayList<FilmDetail> doInBackground(String... url) {

        return connectFilmService(url[0]);
    }


    @Override
    protected void onPostExecute(ArrayList<FilmDetail> fd){
        _films=fd;
    }

    private ArrayList<FilmDetail> connectFilmService(String url) {

        try {
            DefaultHttpClient client = new DefaultHttpClient();
            HttpGet request = new HttpGet(url);
            HttpResponse response = client.execute(request);

            FilmDetailsParser fdp=new FilmDetailsParser();
            String responseStr = EntityUtils.toString(response.getEntity());
            return fdp.Parse(responseStr);

        } catch (ClientProtocolException e) {
            Log.d("HTTPCLIENT", e.getLocalizedMessage());
        } catch (IOException e) {
            Log.d("IOException:HTTPCLIENT", e.getLocalizedMessage());
        }
        return null;
    }

}

