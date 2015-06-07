package net.appmecha.comcast.wear.moviemates.CinemaServices;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;

import java.lang.reflect.Type;
import java.util.ArrayList;

/**
 * Created by Neil on 07/06/2015.
 */
public class FilmDetailsDeserializer implements JsonDeserializer<FilmDetails> {
    @Override
    public FilmDetails deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
        FilmDetails details=new FilmDetails();

        final JsonObject jsonObject = jsonElement.getAsJsonObject();

        final JsonElement jsonEntries = jsonObject.get("Entries");

        FilmDetail[] fda=jsonDeserializationContext.deserialize(jsonEntries, FilmDetail[].class);

        ArrayList<FilmDetail> fd=new ArrayList<FilmDetail>();

        for(int i=0;i<fda.length-1;i++){
            if(fda[i]!=null){
                fd.add(fda[i]);
            }
        }
        details.setItems(fd);
        return details;
    }
}
