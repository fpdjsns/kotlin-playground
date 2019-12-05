import model.File
import model.Notice
import model.NoticeWithFiles
import kotlin.test.assertEquals

/**
 * @author fpdjsns
 */
fun main(args: Array<String>) {
  val notices = listOf(Notice(1L, "1", "1"), Notice(2L, "2", "2"), Notice(3L, "3", "3"))
  val files = listOf(File(1L, "1", noticeNo = 1),
      File(2L, "2", noticeNo = 1),
      File(3L, "3", noticeNo = 1),
      File(4L, "4", noticeNo = 2))

  val fileMap = files.groupBy { it.noticeNo }
  println(fileMap)

  val noticeWithFiles: List<NoticeWithFiles> = notices.map { notice ->
    NoticeWithFiles(notice.no, notice.title, fileMap.getOrDefault(notice.no, emptyList()))
  }

  assertEquals(3, noticeWithFiles[0].files.size)
  assertEquals(1, noticeWithFiles[1].files.size)
  assertEquals(0, noticeWithFiles[2].files.size)

  noticeWithFiles.forEach {
    println(it)
  }
}