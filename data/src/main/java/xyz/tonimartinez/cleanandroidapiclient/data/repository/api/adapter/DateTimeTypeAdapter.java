package xyz.tonimartinez.cleanandroidapiclient.data.repository.api.adapter;

import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;

import java.io.IOException;
import java.util.Date;

/**
 * Created by Toni Martinez on 2/12/15.
 * toni.martinez.carballo@gmail.com
 */
public class DateTimeTypeAdapter extends TypeAdapter<Date> {

    public DateTimeTypeAdapter() {
    }

    @Override
    public void write(JsonWriter out, Date value) throws IOException {
        if (value == null) {
            out.nullValue();
        } else {
            out.value(value.getTime());
        }
    }

    @Override
    public Date read(JsonReader in) throws IOException {
        JsonToken peek = in.peek();
        switch (peek) {
            case NULL:
                in.nextNull();
                return null;
            case NUMBER:
                return new Date(in.nextLong());
            default:
                throw new IllegalStateException("Expected NUMBER but was " + peek);
        }

    }
}