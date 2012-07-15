import io.Source
import util.Random

/**
 * User: chris
 * Date: 7/15/12
 * Time: 2:36 PM
 */

class TrigramGenerator
{
    private val map = collection.mutable.Map.empty[String, collection.mutable.Set[String]]

    def loadFile(fileName: String) {
        val pattern = "\\w+'?[a-z]?".r
        val text = Source.fromFile(fileName).mkString
        val words = pattern.findAllIn(text).toArray

        for(i <- 2 until words.size) {
            var set = collection.mutable.Set.empty[String]
            val key = (words(i - 2) + " " + words(i - 1)).toLowerCase

            if(!map.contains(key))
                map(key) = set
            else
                set = map(key)

            set += words(i)
        }
    }

    def printTrigram() {
        val random = new Random()

        var seed = randomSeed
        var word = seed

        for(i <- 0 until 100) {
            print(word + " ")

            if(i > 0 && i % 10 == 0)
                println()

            val set = map(seed)
            val array = set.toArray
            val index = random.nextInt(array.size)
            val s = seed.split(" ")(1)

            word = array(index)
            seed = (s + " " + word).toLowerCase
        }
    }

    private def randomSeed: String = {
       val random = new Random()
       val array = map.keys.toArray
       array(random.nextInt(array.size))
    }
}
