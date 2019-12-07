package kr.co.withhamit

import kr.co.withhamit.model.File
import kr.co.withhamit.model.Notice
import kr.co.withhamit.model.NoticeWithFiles

/**
 * @author fpdjsns
 */
object GroupBy {
  fun createNoticeWithFiles(notices: List<Notice>, files: List<File>): List<NoticeWithFiles> {

    val fileMap = files.groupBy { it.noticeNo }

    return notices.map { notice ->
      NoticeWithFiles(notice.no, notice.title,
          fileMap.getOrElse(notice.no, { emptyList() }))
    }
  }
}