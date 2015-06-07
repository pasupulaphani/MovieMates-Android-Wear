package net.appmecha.comcast.wear.moviemates;

import android.app.Notification;
import android.app.PendingIntent;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.v4.app.NotificationManagerCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.app.NotificationCompat;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import net.appmecha.comcast.wear.moviemates.CinemaServices.FilmDetail;
import net.appmecha.comcast.wear.moviemates.CinemaServices.IFilmServices;
import net.appmecha.comcast.wear.moviemates.CinemaServices.SpoofFilmServices;

import java.io.Serializable;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements notificationlist_fragment.OnItemSelectedListener {

    private static final String EXTRA_EVENT_ID = "extra_event_id";
    private static final String EXTRA_EVENT_FILM = "extra_event_film";
    private static final String EXTRA_EVENT_START = "extra_event_start";
    private static final String EXTRA_EVENT_CINEMA = "extra_event_cinema";


    private int notificationId = 0;
    private int eventId = 0;

    IFilmServices filmServ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //filmServ=new SpoofFilmServices();//use spoof filmservices
        //setContentView(R.layout.activity_main);
        ShowList();

        //SendBigNotification();
    }

    private void ShowList() {
        // Create the list fragment and add it as our sole content.
        if (getFragmentManager().findFragmentById(android.R.id.content) == null) {
            notificationlist_fragment list = new notificationlist_fragment();
            getFragmentManager().beginTransaction().add(android.R.id.content, list).commit();
        }


    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    private void sendNotificationToWearable(FilmDetail film){


    }

    private void SendBigNotification(){
        String eventDescription="Film showing soon!";
        String eventTitle="Mad Max 4";
        String eventLocation="Odeon, Leicester Square";

        int notificationId = 001;
// Build intent for notification content
        Intent viewIntent = new Intent(this, ViewEventActivity.class);
        viewIntent.putExtra(EXTRA_EVENT_ID, eventId);
        PendingIntent viewPendingIntent =
                PendingIntent.getActivity(this, 0, viewIntent, 0);

        // Specify the 'big view' content to display the long
// event description that may not fit the normal content text.
        android.support.v4.app.NotificationCompat.BigTextStyle bigStyle = new NotificationCompat.BigTextStyle();
        bigStyle.bigText(eventDescription);

        NotificationCompat.Builder notificationBuilder =
                (NotificationCompat.Builder) new NotificationCompat.Builder(this)
                        .setSmallIcon(R.drawable.common_signin_btn_icon_pressed_light)
                        .setLargeIcon(BitmapFactory.decodeResource(
                                getResources(), R.drawable.cast_ic_notification_0))
                        .setContentTitle(eventTitle)
                        .setContentText(eventLocation)
                        .setContentIntent(viewPendingIntent)
                        .addAction(R.drawable.ic_media_play,
                                getString(R.string.play), viewPendingIntent)
                        .setStyle(bigStyle);
    }

    // this is used to regenerate your object. All Parcelables must have a CREATOR that implements these two methods
    public static final Parcelable.Creator<FilmDetail> CREATOR = new Parcelable.Creator<FilmDetail>() {
        public FilmDetail createFromParcel(Parcel in) {
            return new FilmDetail(in);
        }

        public FilmDetail[] newArray(int size) {
            return new FilmDetail[size];
        }
    };

    private void sendNotification(FilmDetail film) {
        //TODO Hook into wearable
        //https://developer.android.com/training/wearables/notifications/creating.html
        Intent viewIntent = new Intent(this, MainActivity.class);
        viewIntent.putExtra(EXTRA_EVENT_ID, 17);
        viewIntent.putExtra(EXTRA_EVENT_FILM, film.Name);
        viewIntent.putExtra(EXTRA_EVENT_START,  film.Times.get(0).StartTime);
        viewIntent.putExtra(EXTRA_EVENT_CINEMA, film.Cinema);

        PendingIntent viewPendingIntent = PendingIntent.getActivity(this, 0, viewIntent, 0);
        Notification notification = new NotificationCompat.Builder(this)
                .setSmallIcon(R.drawable.ic_play_light)
                .setContentTitle(String.format(film.Name))
                .setContentText("This film is starting soon!")
                .setContentIntent(viewPendingIntent)
                .build();

        NotificationManagerCompat notificationManager = NotificationManagerCompat.from(this);
        notificationManager.notify(notificationId++, notification);
    }

    @Override
    public void onNotificationItemSelected(FilmDetail film) {
        sendNotification(film);
        Toast.makeText(this, film.Name, Toast.LENGTH_SHORT).show();
    }
}
