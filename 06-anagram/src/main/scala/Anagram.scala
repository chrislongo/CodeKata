import collection.mutable.ArrayBuffer

/**
 * User: chris
 * Date: 7/10/12
 * Time: 8:08 PM
 */

class Anagram {
    def create(word: String): Array[String] = {
        val buffer = ArrayBuffer.empty[String]

        def recursive(prefix: String, word: String) {
            if(word.length() <= 1) {
                buffer += (prefix + word)
                println(prefix + " " + word)
            }
            else {
                for(i <- 0 until word.length()) {
                    val current = word.substring(i, i + 1)
                    val before = word.substring(0, i)
                    val after = word.substring(i + 1)
                    recursive(prefix + current, before + after)
                }
            }
        }

        recursive("", word);
        buffer.toArray
    }
}