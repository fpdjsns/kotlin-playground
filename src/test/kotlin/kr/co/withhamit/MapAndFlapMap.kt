package kr.co.withhamit

import kr.co.withhamit.model.Notice
import kr.co.withhamit.model.NoticeDisplay
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

/**
 * @author fpdjsns
 */
class MapAndFlapMap {
  @Test
  fun test() {

    val notice1 = Notice(1, "hello", "hello content")
    val notice2 = Notice(2, "world", "world content")

    val notices = listOf(notice1, notice2)

    /* map */
    notices.map(Notice::title).let { noticeTitles ->

      // [title 1, title 2]
      println(noticeTitles)

      noticeTitles.forEachIndexed { idx, title ->
        assertEquals(notices[idx].title, title)
      }
    }

    notices.map { NoticeDisplay(it) }.let { noticeDisplays ->

      // [NoticeDisplay(title=title 1, content=content 2), NoticeDisplay(title=title 2, content=content 2)]
      println(noticeDisplays)

      noticeDisplays.forEachIndexed { idx, noticeDisplay ->
        assertEquals(NoticeDisplay(notices[idx]), noticeDisplay)
      }
    }

    /*
     * flatMap vs map
     */
    notices.map(Notice::title).let { titleList ->

      // [hello, world]
      println(titleList)

      // [[h, e, l, l, o], [w, o, r, l, d]]
      println(titleList.map { it.toList() })

      // [h, e, l, l, o, w, o, r, l, d]
      println(titleList.flatMap { it.toList() })

      // [[hello], [world]]
      println(titleList.map { listOf(it) })

      // [hello, world]
      println(titleList.flatMap { listOf(it) })
    }
  }
}