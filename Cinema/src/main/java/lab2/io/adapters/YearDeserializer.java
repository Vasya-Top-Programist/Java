package lab2.io.adapters;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;

import java.io.IOException;
import java.time.LocalDate;
import java.time.Year;

public class YearDeserializer extends StdDeserializer<Year> {

    public YearDeserializer() {
        super(Year.class);
    }

    @Override
    public Year deserialize(JsonParser jsonParser, DeserializationContext context)
            throws IOException {

        return Year.parse(jsonParser.readValueAs(String.class));
    }

}
