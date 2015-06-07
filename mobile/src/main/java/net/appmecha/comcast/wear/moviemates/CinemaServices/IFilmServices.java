package net.appmecha.comcast.wear.moviemates.CinemaServices;

import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by Neil on 07/06/2015.
 */
public interface IFilmServices {
    ArrayList<FilmDetail> GetFilms(long longitude,long latitude);
}
