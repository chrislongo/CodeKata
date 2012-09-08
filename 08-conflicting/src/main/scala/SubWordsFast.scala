import collection.mutable
import io.Source

/**
 * User: chris
 * Date: 7/11/12
 * Time: 9:02 PM
 */

object SubWordsFast extends App {
  private val set = mutable.Set.empty[String]

  benchmark()

  def benchmark() {
    val start = System.currentTimeMillis()
    loadWords()
    val count = countWords()
    val stop = System.currentTimeMillis()

    println("Count: " + count)
    println("Time: " + (stop - start) + "ms")
  }

  def loadWords() {
    for (line <- Source.fromFile("data/words.txt").getLines().filter(s => s.length() <= 6)) {
      set += line.toLowerCase
    }
  }

  def countWords(): Int = {
    var count = 0

    for (word <- set.filter(s => s.length == 6)) {
      for (i <- 1 until word.length) {

        val sub1 = word.substring(0, i)
        val sub2 = word.substring(i)

        if (set.contains(sub1) && set.contains(sub2))
          count += 1
      }
    }
    count
  }
}
