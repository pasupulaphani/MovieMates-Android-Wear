package net.appmecha.comcast.wear.moviemates;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import net.appmecha.comcast.wear.moviemates.CinemaServices.FilmDetail;
import net.appmecha.comcast.wear.moviemates.CinemaServices.FilmTime;

import java.util.Date;
import java.util.List;

/**
 * Created by Neil on 06/06/2015.
 */
public class NotificationListAdapter extends ArrayAdapter<FilmDetail> {

    public NotificationListAdapter(Context context, List<FilmDetail> items) {
                super(context, R.layout.notification_item, items);

            }

    @Override
        public View getView(int position, View convertView, ViewGroup parent) {
                ViewHolder viewHolder;

                if(convertView == null) {
                        // inflate the GridView item layout
                        LayoutInflater inflater = LayoutInflater.from(getContext());
                        convertView = inflater.inflate(R.layout.notification_item, parent, false);

                        // initialize the view holder
                        viewHolder = new ViewHolder();
                    viewHolder.tvTitle = (TextView) convertView.findViewById(R.id.tvTitle);
                    viewHolder.tvStartTime = (TextView) convertView.findViewById(R.id.tvStartTime);
                    viewHolder.tvDuration = (TextView) convertView.findViewById(R.id.tvDuration);
                    viewHolder.tvCertification = (TextView) convertView.findViewById(R.id.tvCertification);

                    convertView.setTag(viewHolder);
                    } else {
                       // recycle the already inflated view
                       viewHolder = (ViewHolder) convertView.getTag();
                    }
                       // update the item view
               FilmDetail item = getItem(position);
                FilmTime firstTime=((FilmTime) item.Times.get(0));

                viewHolder.tvTitle.setText(item.Name);
                viewHolder.tvStartTime.setText(firstTime.StartTime.toString());
                viewHolder.tvDuration.setText(String.valueOf(item.Duration));
                //viewHolder.tvDistance.setText("");

                return convertView;
           }


    private static class ViewHolder {
        TextView tvDistance;
         TextView tvTitle;
        TextView tvCertification;
        TextView tvStartTime;
        TextView tvDuration;

    }

}
