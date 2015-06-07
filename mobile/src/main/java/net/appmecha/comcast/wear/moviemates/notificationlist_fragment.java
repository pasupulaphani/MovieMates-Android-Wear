package net.appmecha.comcast.wear.moviemates;

import android.app.Activity;
import android.app.ListFragment;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.Toast;

import net.appmecha.comcast.wear.moviemates.CinemaServices.FilmDetail;
import net.appmecha.comcast.wear.moviemates.CinemaServices.IFilmServices;
import net.appmecha.comcast.wear.moviemates.CinemaServices.SpoofFilmServices;

import java.util.List;
import java.util.ArrayList;
/**
 * Created by Neil on 06/06/2015.
 */
public class notificationlist_fragment extends ListFragment {

    private List<FilmDetail> mItems;

        @Override
        public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // initialize the items list
        mItems = new ArrayList<FilmDetail>();

        IFilmServices spoofFilms=new SpoofFilmServices();

        mItems=spoofFilms.GetFilms(0L, 0L);

        setListAdapter(new NotificationListAdapter(getActivity(), mItems));
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
