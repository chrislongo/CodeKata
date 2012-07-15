/**
 * User: chris
 * Date: 7/14/12
 * Time: 9:22 PM
 */

class SortChars
{
    private val chars = new Array[Int](26)

    def sort(message: String) {
        for(ch <- message.toLowerCase) {
            if(ch >= 'a' && ch <= 'z')
                chars(ch - 'a') += 1
        }
    }

    def sortedMessage: String = {
        val sb = new StringBuilder

        for(i <- 0 until chars.size) {
            for(j <- 0 until chars(i)) {
                sb.append((i + 'a').toChar)
            }
        }

        sb.toString()
    }
}
