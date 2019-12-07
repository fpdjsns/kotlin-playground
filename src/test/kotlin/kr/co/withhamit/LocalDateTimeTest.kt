package kr.co.withhamit

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import java.time.LocalDateTime
import java.time.temporal.ChronoUnit
import kotlin.test.assertNotEquals
import kotlin.test.assertNull

/**
 * @author Hyunsu Bae
 */
class LocalDateTimeTest {

  @Test
  fun test() {

    // expect
    assertEquals(LocalDateTime.of(2019, 12, 4, 12, 3, 12), "2019-12-04 12:03:12".toLocalDateTime())
    assertEquals(LocalDateTime.of(2019, 12, 4, 12, 3), "2019-12-04 12:03".toLocalDateTime())
    assertEquals(LocalDateTime.of(2019, 12, 4, 12, 3, 12, 100000000), "2019-12-04 12:03:12.1".toLocalDateTime())

    assertEquals(LocalDateTime.of(2019, 12, 4, 12, 3),
        "2019-12-04 12:03:12".toLocalDateTime()?.withSecond(0))
    assertNotEquals(LocalDateTime.of(2019, 12, 4, 12, 3),
        "2019-12-04 12:03:12.1".toLocalDateTime()?.withSecond(0))
    assertEquals(LocalDateTime.of(2019, 12, 4, 12, 3),
        "2019-12-04 12:03:12.1".toLocalDateTime()?.truncatedTo(ChronoUnit.MINUTES))

    assertNull("2019-12-04 12".toLocalDateTime())
  }
}