package net.appmecha.comcast.wear.moviemates;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.RemoteInput;
import android.util.Log;

/**
 * Created by phani on 07/06/2015.
 */
public class NotificationIntentReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {

        if (true) {String message =
                intent.getStringExtra(MainActivity.EXTRA_MESSAGE);
            Log.v("MyTag", "Extra message from intent = " + message);
            Bundle remoteInput = RemoteInput.getResultsFromIntent(intent);
            CharSequence reply = remoteInput.getCharSequence(MainActivity.EXTRA_VOICE_REPLY);
            Log.v("MyTag", "User reply from wearable: " + reply);
        }
    }
}
