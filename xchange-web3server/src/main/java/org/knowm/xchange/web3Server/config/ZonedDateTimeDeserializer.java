package org.knowm.xchange.web3Server.config;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

import java.io.IOException;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;


public class ZonedDateTimeDeserializer extends JsonDeserializer<ZonedDateTime> {
    public static final String ZONED_DATE_TIME_FORMAT = "yyyy-MM-dd'T'HH:mm:ss.SSSz";
//    private static final String ZONED_DATE_TIME_FORMAT = "yyyy-MM-dd HH:mm:ss";
    /**
     * Custom {@link ZonedDateTime} deserializer.
     *
     * @param jsonParser             for extracting the date in {@link String} format.
     * @param deserializationContext for the process of deserialization a single root-level value.
     * @return {@link ZonedDateTime} object of the date.
     * @throws IOException throws I/O exceptions.
     */
    @Override
    public ZonedDateTime deserialize(JsonParser jsonParser, DeserializationContext deserializationContext)
            throws IOException {

        return ZonedDateTime.parse(jsonParser.getText(), DateTimeFormatter.ofPattern(ZONED_DATE_TIME_FORMAT));
    }
}
