/**
 * User: chris
 * Date: 7/14/12
 * Time: 9:22 PM
 */

class SortChars(message: String) {
  private val chars = new Array[Int](26)

  for (ch <- message) {
    val c = ch.toLower
    if (c >= 'a' && c <= 'z')
      chars(c - 'a') += 1
  }

  def sortedMessage: String = {
    val sb = new StringBuilder

    for (i <- 0 until chars.size) {
      for (j <- 0 until chars(i)) {
        sb.append((i + 'a').toChar)
      }
    }

    sb.toString()
  }
}
