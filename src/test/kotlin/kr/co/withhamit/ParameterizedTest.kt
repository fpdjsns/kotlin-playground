package kr.co.withhamit

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertNull
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import org.junit.jupiter.params.provider.NullAndEmptySource
import org.junit.jupiter.params.provider.ValueSource
import java.util.stream.Stream

/**
 * @author fpdjsns
 */
class ParameterizedTest {

  companion object {
    @JvmStatic
    private fun stringToLocalDateTimeTestCase() = Stream.of(
        Arguments.of(-1, "-1"),
        Arguments.of(0, "0"),
        Arguments.of(1, "1")
    )
  }

  @ParameterizedTest
  @MethodSource("stringToLocalDateTimeTestCase")
  fun convertToLocalDateTime_successTest(expected: Int, str: String) {
    assertEquals(expected, str.toIntOrNull())
  }
 
  @ParameterizedTest
  @ValueSource(strings = ["ab", "csd", "12!"])
  @NullAndEmptySource
  fun convertToLocalDateTime_nullTest(str: String?) {
    assertNull(str.toIntOrNull())
  }

  private fun String?.toIntOrNull(): Int? {
    return if (this.isNullOrEmpty()) null
    else try {
      this.toInt()
    } catch (e: NumberFormatException) {
      null
    }
  }
}