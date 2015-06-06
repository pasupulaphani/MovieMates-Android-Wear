package net.appmecha.comcast.wear.moviemates;

import android.app.ListFragment;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.Toast;

import java.util.List;
import java.util.ArrayList;
/**
 * Created by Neil on 06/06/2015.
 */
public class notificationlist_fragment extends ListFragment {
    private List<NotificationItem> mItems;

        @Override
        public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // initialize the items list
        mItems = new ArrayList<NotificationItem>();
        Resources resources = getResources();

        mItems.add(new NotificationItem( getString(R.string.odeon_cinema), getString(R.string.odeon_cinema_desc)));

        setListAdapter(new NotificationListAdapter(getActivity(), mItems));
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
            NotificationItem item = mItems.get(position);
            // do something

            Toast.makeText(getActivity(), item.title, Toast.LENGTH_SHORT).show();
        }







}
