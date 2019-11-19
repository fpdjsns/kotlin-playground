package model

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

data class File(val no: Long,
                val name: String,
                val noticeNo: Long)

data class NoticeWithFiles(val no: Long,
                           val title: String,
                           val files: List<File>)