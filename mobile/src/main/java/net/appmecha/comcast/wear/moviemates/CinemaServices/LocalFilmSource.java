package net.appmecha.comcast.wear.moviemates.CinemaServices;

import android.content.res.Resources;

import net.appmecha.comcast.wear.moviemates.R;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.StringWriter;
import java.io.UnsupportedEncodingException;
import java.io.Writer;
import java.util.ArrayList;

/**
 * Created by Neil on 07/06/2015.
 */
public class LocalFilmSource implements IFilmServices {

    Resources res;

    public LocalFilmSource(Resources r){
        res=r;
    }


    @Override
    public ArrayList<FilmDetail> GetFilms(double longitude, double latitude) {
        String sJson= null;
        try {
            sJson = loadJSONFromResource(res);
        } catch (IOException e) {
            e.printStackTrace();
        }
        ArrayList<FilmDetail> fds=Parse(sJson);



        return fds;
    }

    private ArrayList<FilmDetail> Parse(String sJson) {
        ArrayList<FilmDetail> fds=new ArrayList<FilmDetail>();

        return fds;
    }

    public String loadJSONFromResource(Resources resources) throws IOException {

        InputStream is = resources.openRawResource(R.raw.films);
        Writer writer = new StringWriter();
        char[] buffer = new char[1024];
        try {
            Reader reader = new BufferedReader(new InputStreamReader(is, "UTF-8"));
            int n;
            while ((n = reader.read(buffer)) != -1) {
                writer.write(buffer, 0, n);
            }
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            is.close();
        }

        String jsonString = writer.toString();
        return jsonString;
    }

}
