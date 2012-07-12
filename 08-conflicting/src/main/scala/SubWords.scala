import collection.mutable
import io.Source

/**
 * User: chris
 * Date: 7/11/12
 * Time: 9:02 PM
 */

object SubWords extends App {
    val set = mutable.Set.empty[String]

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
        for(line <- Source.fromFile("data/words.txt").getLines())
            set += line.toLowerCase
    }
    
    def countWords(): Int = {
        var count = 0

        for(word <- set) {
            for(i <- 0 until word.length()) {
                val sub1 = word.substring(0, i)
                val sub2 = word.substring(i + 1)
                
                if(set.contains(sub1) && set.contains(sub2))
                    count += 1
            }
        }
        count
    }
}
