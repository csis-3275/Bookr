package com.Bookr.Utilities;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.expression.ParseException;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

public class DateAndTimeDeserialize extends JsonDeserializer<Date> {
	
    private SimpleDateFormat dateFormat = new SimpleDateFormat(
            "yyyy-MM-dd HH:mm:ss");

	@Override
	public Date deserialize(JsonParser paramJsonParser, DeserializationContext paramDeserializationContext) throws IOException, JsonProcessingException {
		String str = paramJsonParser.getText().trim();
            try {
				return dateFormat.parse(str);
			} catch (java.text.ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        return paramDeserializationContext.parseDate(str);
	}

}
