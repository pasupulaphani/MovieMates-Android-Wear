package net.appmecha.comcast.wear.moviemates.CinemaServices;

import android.os.Parcel;

import java.util.ArrayList;
import java.util.Date;

/**
 * Created by Neil on 07/06/2015.
 */
public class FilmDetail {
    public String Name;
    public double Distance;
    public ArrayList<String> Genres;
    public String Certificate;
    public int Duration;
    public ArrayList<FilmTime> Times;
    public String Cinema;
    public Date StartTime;

    public FilmDetail(String n, String cert, double dist, ArrayList<String> gen, int dur,ArrayList<FilmTime> filmTimes,String cin) {
        this.Name=n;
        this.Certificate=cert;
        this.Distance=dist;
        this.Genres=gen;
        this.Duration=dur;
        this.Times=filmTimes;
        this.Cinema=cin;
    }

    public FilmDetail(Parcel in) {
        //TODO recreate detail from parcel
    }

    public FilmDetail() {

    }
}
