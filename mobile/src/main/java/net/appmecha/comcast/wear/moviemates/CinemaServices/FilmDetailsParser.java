package net.appmecha.comcast.wear.moviemates.CinemaServices;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.ArrayList;

/**
 * Created by Neil on 07/06/2015.
 */
public class FilmDetailsParser {
    public ArrayList<FilmDetail> Parse(String inJSON){
        ArrayList<FilmDetail> films=new ArrayList<FilmDetail>();
        GsonBuilder gsonB = new GsonBuilder();
        gsonB.setDateFormat("yyyy-MM-dd'T'HH:mm:ss");
        gsonB.registerTypeAdapter(FilmDetail.class, new FilmDetailDeserializer());
        gsonB.registerTypeAdapter(FilmTime.class, new FilmTimeDeserializer());
        gsonB.registerTypeAdapter(FilmDetails.class, new FilmDetailsDeserializer());

        Gson gson=gsonB.create();
        films.add(gson.fromJson(inJSON, FilmDetail.class));
        return films;
    }
}
