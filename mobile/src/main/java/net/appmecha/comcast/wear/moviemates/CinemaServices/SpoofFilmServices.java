package net.appmecha.comcast.wear.moviemates.CinemaServices;

import net.appmecha.comcast.wear.moviemates.Utils;

import java.util.ArrayList;
import java.util.Date;

/**
 * Created by Neil on 07/06/2015.
 */
public class SpoofFilmServices implements IFilmServices {


    public ArrayList<FilmDetail> GetFilms(double longitude,double latitude){
        ArrayList<FilmDetail> fl=new ArrayList<FilmDetail>();
        int loop=Utils.randInt(1,6);

        fl.add(new FilmDetail("Spy","15",0.21,CreateGenres(),120,CreateFilmTimes(),"http://www.cineworld.com"));
        fl.add(new FilmDetail("Insidious:Chapter 3","15",0.21,CreateGenres(),98,CreateFilmTimes(),"http://www.cineworld.com"));
        fl.add(new FilmDetail("Pitch Perfect 2","12A",0.21,CreateGenres(),115,CreateFilmTimes(),"http://www.cineworld.com"));


        return fl;
    }

    private FilmDetail CreateFilm() {
        //String n, String cert, double dist, ArrayList<String> gen, int dur,ArrayList<FilmTime> filmTimes
        String title="The Number "+ Utils.randInt(1,999);
        int dur=Utils.randInt(70,220);
        String cinema="Hoyts";
        FilmDetail fd=new FilmDetail(title,"18",0.21,CreateGenres(),dur,CreateFilmTimes(),cinema);
        return fd;
    }

    private ArrayList<String> CreateGenres() {
        ArrayList<String> st=new ArrayList<String>();
        st.add("Action");
        return st;
    }

    private ArrayList<FilmTime> CreateFilmTimes(){
        ArrayList<FilmTime> fts=new ArrayList<FilmTime>();

        fts.add(CreateFilmTime());
        fts.add(CreateFilmTime());
        return fts;
    }
    private FilmTime CreateFilmTime(){
        FilmTime ft=new FilmTime();
        ft.StartTime=new Date();
        ft.EndTime=new Date();
        ft.TicketUrl="";
        return ft;

    }

}
