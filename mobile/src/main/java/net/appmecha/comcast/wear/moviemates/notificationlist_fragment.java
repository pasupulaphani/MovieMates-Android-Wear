package net.appmecha.comcast.wear.moviemates;

import android.app.Activity;
import android.app.ListFragment;
import android.content.Context;
import android.content.res.Resources;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.Toast;

import net.appmecha.comcast.wear.moviemates.CinemaServices.FilmDetail;
import net.appmecha.comcast.wear.moviemates.CinemaServices.IFilmServices;
import net.appmecha.comcast.wear.moviemates.CinemaServices.RealtimeFilmApi;
import net.appmecha.comcast.wear.moviemates.CinemaServices.SpoofFilmServices;

import java.util.List;
import java.util.ArrayList;
/**
 * Created by Neil on 06/06/2015.
 */
public class notificationlist_fragment extends ListFragment implements LocationListener {
    protected LocationManager locationManager;
    protected LocationListener locationListener;
    private List<FilmDetail> mItems;
    protected Context context;

        @Override
        public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // initialize the items list
        mItems = new ArrayList<FilmDetail>();

        IFilmServices spoofFilms=new SpoofFilmServices();
//
        mItems=spoofFilms.GetFilms(0, 0);

//            locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
//            locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 0, 0, this);

//            IFilmServices spoofFilms1=new RealtimeFilmApi(this);
//
//        double lat = 51.5033630;
//        double lon = -0.1276250;
//        spoofFilms1.GetFilms(lon, lat);

        setListAdapter(new NotificationListAdapter(getActivity(), mItems));
    }

    @Override
    public void onLocationChanged(Location location) {

    }

    @Override
    public void onStatusChanged(String provider, int status, Bundle extras) {

    }

    @Override
    public void onProviderEnabled(String provider) {

    }

    @Override
    public void onProviderDisabled(String provider) {

    }

    public void setItems(ArrayList<FilmDetail> items) {
       mItems = items;
    }

    public interface OnItemSelectedListener {
        public void onNotificationItemSelected(FilmDetail film);
    }

    private OnItemSelectedListener listener;

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        if (activity instanceof OnItemSelectedListener) {
            listener = (OnItemSelectedListener) activity;
        } else {
            throw new ClassCastException(activity.toString() + " must implemenet MyListFragment.OnItemSelectedListener");
        }
    }

    @Override
        public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
                // remove the dividers from the ListView of the ListFragment
                getListView().setDivider(null);
           }

    @Override
        public void onListItemClick(ListView l, View v, int position, long id) {
            // retrieve theListView item
            FilmDetail item = mItems.get(position);
            // do something
            listener.onNotificationItemSelected(item);

        }







}
