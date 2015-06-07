package net.appmecha.comcast.wear.moviemates.CinemaServices;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;

import java.lang.reflect.Type;
import java.sql.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

/**
 * Created by Neil on 07/06/2015.
 */
public class FilmDetailDeserializer  implements JsonDeserializer<FilmDetail> {

    @Override
    public FilmDetail deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
        FilmDetail fd=new FilmDetail();

        final JsonObject jsonObject = jsonElement.getAsJsonObject();

        final JsonElement jsonName = jsonObject.get("title");
        final String sName = jsonName.getAsString();
        fd.Name=sName;

        final JsonElement jsonDuration = jsonObject.get("duration");
        final String sDuration = jsonDuration.getAsString();
        fd.Duration=Integer.parseInt(sDuration);

        final JsonElement jsonCertificate = jsonObject.get("certificate");
        final String sCertificate = jsonCertificate.getAsString();
        fd.Certificate=sCertificate;

        final JsonElement jsonDate = jsonObject.get("starttime");
        String str=jsonDate.getAsString();
        DateFormat format=new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
        try {
            final java.util.Date dt = format.parse(str);
            fd.StartTime=dt;
        } catch (ParseException e) {
            e.printStackTrace();
        }



        final JsonElement jsonUrl = jsonObject.get("tickets");
        final String sUrl = jsonUrl.getAsString();
        fd.Cinema=sUrl;



        return fd;
    }
}
