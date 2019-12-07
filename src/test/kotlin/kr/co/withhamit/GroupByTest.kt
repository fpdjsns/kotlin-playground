package kr.co.withhamit

import kr.co.withhamit.model.File
import kr.co.withhamit.model.Notice
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

/**
 * @author fpdjsns
 */
class GroupByTest {
  @Test
  fun test() {
    // given
    val notices = listOf(Notice(1L, "1", "1"),
        Notice(2L, "2", "2"),
        Notice(3L, "3", "3"))
    val files = listOf(File(1L, "1", noticeNo = 1),
        File(2L, "2", noticeNo = 1),
        File(3L, "3", noticeNo = 1),
        File(4L, "4", noticeNo = 2))

    // when
    val actual = GroupBy.createNoticeWithFiles(notices, files)

    // then
    assertEquals(3, actual[0].files.size)
    assertEquals(1, actual[1].files.size)
    assertEquals(0, actual[2].files.size)

    actual.forEach {
      println(it)
    }
  }
}