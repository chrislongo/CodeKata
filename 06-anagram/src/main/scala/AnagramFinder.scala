import collection.mutable
import io.Source

/**
 * User: chris
 * Date: 7/11/12
 * Time: 6:52 AM
 */

object AnagramFinder extends App {
  val anagram = new Anagram
  var map = Map.empty[String, mutable.Set[String]]

  benchmark()

  def benchmark() {
    val start = System.currentTimeMillis()

    loadWords()
    val count = find()

    val stop = System.currentTimeMillis()

    println("Sets: " + count)
    println("Time: " + (stop - start) + "ms")
  }

  def loadWords() {
    for (line <- Source.fromFile("data/words.txt").getLines()) {
      val word = line.toLowerCase
      val key = word.sorted
      if (!(map contains key)) {
        map += (key -> mutable.Set.empty)
      }
      map(key) += word
    }
  }

  def find(): Int = {
    var count = 0

    for (key <- map.keys)
      if (map(key).size > 1)
        count += 1

    count
  }
}
