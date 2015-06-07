package net.appmecha.comcast.wear.moviemates;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.gms.wearable.Asset;

/**
 * Created by Neil on 07/06/2015.
 */
public class NotificationActivity extends Activity {
    private TextView tvFilmName;
    private TextView tvFilmCinema;
    private TextView tvFilmStart;

    private static final String EXTRA_EVENT_ID = "extra_event_id";
    private static final String EXTRA_EVENT_FILM = "extra_event_film";
    private static final String EXTRA_EVENT_START = "extra_event_start";
    private static final String EXTRA_EVENT_CINEMA = "extra_event_cinema";


    //See: http://possiblemobile.com/2014/07/create-custom-ongoing-notification-android-wear/
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notification);


        tvFilmName = (TextView) findViewById(R.id.film_name);
        tvFilmCinema = (TextView) findViewById(R.id.film_cinema);
        tvFilmStart = (TextView) findViewById(R.id.film_start);

        Intent intent = getIntent();
        if (intent != null) {
            tvFilmName.setText(intent.getStringExtra(EXTRA_EVENT_FILM));
            tvFilmCinema.setText(intent.getStringExtra(EXTRA_EVENT_CINEMA));
            tvFilmStart.setText(intent.getStringExtra(EXTRA_EVENT_START));

//            final Asset asset = intent.getParcelableExtra(EXTRA_IMAGE);
//            loadBitmapFromAsset(this, asset, mImageView);
        }
    }
}
