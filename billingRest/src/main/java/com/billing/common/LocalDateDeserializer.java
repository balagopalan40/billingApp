package com.billing.common;

import java.io.IOException;
import java.text.DecimalFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;

public class LocalDateDeserializer extends StdDeserializer<LocalDate> {

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

  protected LocalDateDeserializer() {
    super(LocalDate.class);
  }

  @Override
  public LocalDate deserialize(JsonParser parser, DeserializationContext ctxt) throws IOException {
    return stringToDate(parser.readValueAs(String.class));
  }
  
  /**
   * Converts a date formatted to ISO-8601 standard into a LocalDate object
   *
   * @param input YYYY-MM-dd
   * @return the equivalent LocalDate
   */
  public static LocalDate stringToDate(final String input) {
    if (input == null) {
      return null;
    }
    String flat;
    if (input.length() <= DATE_STRING_WITH_NO_DAY_LENGTH) {
      // if we have less than 7 chars, no day part is included, we default it to first day of the month
      flat = input + "-01";
    } else {
      flat = input;
    }
    return LocalDate.parse(flat, FORMATTER_DAY);
  }

}

