package net.appmecha.comcast.wear.moviemates.CinemaServices;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;

import java.lang.reflect.Type;

/**
 * Created by Neil on 07/06/2015.
 */
public class FilmTimeDeserializer implements JsonDeserializer<FilmTime> {
    @Override
    public FilmTime deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
        FilmTime ft=new FilmTime();

        return ft;
    }
}
