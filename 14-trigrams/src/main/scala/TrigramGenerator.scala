import io.Source
import util.Random

/**
 * User: chris
 * Date: 7/15/12
 * Time: 2:36 PM
 */

class TrigramGenerator(fileName: String) {
  private val map = collection.mutable.Map.empty[String, collection.mutable.Set[String]]

  val pattern = "\\w+'?[a-z,.]?".r
  val text = Source.fromFile(fileName).mkString
  val words = pattern.findAllIn(text).toArray

  for (i <- 2 until words.size) {
    var set = collection.mutable.Set.empty[String]
    val key = (words(i - 2) + " " + words(i - 1))

    if (!map.contains(key))
      map(key) = set
    else
      set = map(key)

    set += words(i)
  }

  def generate(seed: String = randomSeed, length: Int = 100): String = {
    val random = new Random()
    val sb = new StringBuilder

    var word = seed
    var key = seed

    for (i <- 0 until length - 1) {
      sb.append(word)

      if (!map.contains(key))
        return sb.toString()

      sb.append(" ")

      val array = map(key).toArray
      val index = random.nextInt(array.size)

      word = array(index)
      key = (key.split(" ")(1) + " " + word)
    }

    sb.toString()
  }

  private def randomSeed: String = {
    val random = new Random()
    val array = map.keys.toArray
    array(random.nextInt(array.size))
  }
}
