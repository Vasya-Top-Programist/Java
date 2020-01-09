package lab2.io.adapters;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;

import java.io.IOException;
import java.time.LocalDate;
import java.time.Year;
import java.time.format.DateTimeFormatter;

public class YearSerializer extends StdSerializer<Year> {

    public YearSerializer() {
        super(Year.class);
    }

    @Override
    public void serialize(Year year, JsonGenerator gen,
                          SerializerProvider sp) throws IOException {

        gen.writeString(year.toString());

    }

}
