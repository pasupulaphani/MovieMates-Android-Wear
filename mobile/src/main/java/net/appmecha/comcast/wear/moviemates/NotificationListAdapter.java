package net.appmecha.comcast.wear.moviemates;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Neil on 06/06/2015.
 */
public class NotificationListAdapter extends ArrayAdapter<NotificationItem> {

    public NotificationListAdapter(Context context, List<NotificationItem> items) {
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
                        viewHolder.tvDescription = (TextView) convertView.findViewById(R.id.tvDesc);
                        convertView.setTag(viewHolder);
                    } else {
                       // recycle the already inflated view
                       viewHolder = (ViewHolder) convertView.getTag();
                    }
                       // update the item view
               NotificationItem item = getItem(position);

               viewHolder.tvTitle.setText(item.title);
               viewHolder.tvDescription.setText(item.description);

               return convertView;
           }


    private static class ViewHolder {
        ImageView ivIcon;
        TextView tvTitle;
        TextView tvDescription;
    }

}
