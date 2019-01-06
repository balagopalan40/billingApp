package com.billing.common;

import java.io.IOException;
import java.text.DecimalFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;

public class LocalDateAsMonthSerializer extends StdSerializer<LocalDate>{

  private static final long serialVersionUID = 1L;
  protected static final DecimalFormat TIME_DECIMAL_FORMATTER = new DecimalFormat("#,###.00");
  protected static final DecimalFormat TIME_FORMATTER = new DecimalFormat("#,###");
  private static final int DATE_STRING_LENGTH = 12;
  private static final LocalDate BASELINE_DATE = LocalDate.of(1990, 1, 1);
  private static final int DATE_STRING_WITH_NO_DAY_LENGTH = 7;
  private static final DateTimeFormatter FORMATTER_DATETIME_ISO = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss'Z'");
  private static final DateTimeFormatter FORMATTER_DATETIME = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
  private static final DateTimeFormatter FORMATTER_FILE_NAME_COMPATIBLE_DATETIME = DateTimeFormatter.ofPattern("yyyy-MM-dd_HH-mm-ss");
  private static final DateTimeFormatter FORMATTER_DAY = DateTimeFormatter.ofPattern("yyyy-MM-dd");
  private static final DateTimeFormatter FORMATTER_MONTH = DateTimeFormatter.ofPattern("yyyy-MM");
  
  public LocalDateAsMonthSerializer() {
    super(LocalDate.class);
  }

  @Override
  public void serialize(final LocalDate value, final JsonGenerator generator, final SerializerProvider serializer) throws IOException {
    generator.writeString(monthToString(value));
  }

  public static String monthToString(final LocalDate input) {
    if (input == null) {
      return null;
    }
    return input.format(FORMATTER_MONTH);
  }
}
