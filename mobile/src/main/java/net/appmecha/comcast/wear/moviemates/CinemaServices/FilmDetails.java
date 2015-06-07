package net.appmecha.comcast.wear.moviemates.CinemaServices;

import java.util.ArrayList;

/**
 * Created by Neil on 07/06/2015.
 */
public class FilmDetails {
    private ArrayList<FilmDetail> Items;
    public ArrayList<FilmDetail> getItems(){
        return Items;
    }
    public void setItems(ArrayList<FilmDetail> d){
        Items=d;
    }
}
