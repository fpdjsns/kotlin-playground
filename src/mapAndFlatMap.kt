import kotlin.test.assertEquals

/**
 * @author fpdjsns
 */
data class Notice(val no: Long,
                  val title: String,
                  val content: String)

data class NoticeDisplay(val title: String,
                         val content: String) {
  constructor(notice: Notice) : this(notice.title, notice.content)
}

fun main(args: Array<String>) {

  val notice1 = Notice(1, "hello", "hello content")
  val notice2 = Notice(2, "world", "world content")

  val notices = listOf(notice1, notice2)

  /* map */
  notices.map(Notice::title).let { noticeTitles ->

    println(noticeTitles)
    // [title 1, title 2]

    noticeTitles.forEachIndexed { idx, title ->
      assertEquals(notices[idx].title, title)
    }
  }

  notices.map { NoticeDisplay(it) }.let { noticeDisplays ->

    println(noticeDisplays)
    // [NoticeDisplay(title=title 1, content=content 2), NoticeDisplay(title=title 2, content=content 2)]

    noticeDisplays.forEachIndexed { idx, noticeDisplay ->
      assertEquals(NoticeDisplay(notices[idx]), noticeDisplay)
    }
  }

  /*
   * flatMap vs map
   */
  notices.map(Notice::title).let { titleList ->
    println(titleList)
    // [hello, world]

    titleList.map { it.toList() }.let {
      println(it)
      // [[h, e, l, l, o], [w, o, r, l, d]]
    }

    titleList.flatMap { it.toList() }.let {
      println(it)
      // [h, e, l, l, o, w, o, r, l, d]
    }

    titleList.map { listOf(it) }.let {
      println(it)
      // [[hello], [world]]
    }

    titleList.flatMap { listOf(it) }.let {
      println(it)
      // [hello, world]
    }
  }
}