package kr.co.withhamit

import java.time.LocalDateTime
import java.time.format.DateTimeFormatterBuilder
import java.time.format.DateTimeParseException
import java.time.temporal.ChronoField

/**
 * @author fpdjsns
 */
fun String.toLocalDateTime(): LocalDateTime? {
  if (this.isNullOrBlank()) return null

  return try {
    val formatter = DateTimeFormatterBuilder()
        .appendPattern("yyyy-MM-dd HH:mm[:ss]")
        .appendFraction(ChronoField.MILLI_OF_SECOND, 0, 9, true)
        .toFormatter()

    return LocalDateTime.parse(this, formatter)
  } catch (e: DateTimeParseException) {
    null
  }
}