import collection.mutable.Buffer
import io.Source
import util.Random

/**
 * User: chris
 * Date: 7/9/12
 * Time: 10:26 PM
 */

object BloomFilterStats extends App {
    val words = Buffer[String]()
    val filter = new BloomFilter(131072)
    var hits: Int = 0
    var falsePositives: Int = 0
    
    for(word <- Source.fromFile("words.txt").getLines()) {
        filter.add(word)
        words += word
    }

    for (i <- 0 until 1024) {
        val word: String = randomWord()

        if(filter.contains(word)) {
            if(!words.contains(word))
                falsePositives += 1
            else
                hits += 1
        }
    }

    println("Size: " + filter.size)
    println("Hits: " + hits)
    println("False positives: " + falsePositives + " (" + math.round(falsePositives / 1024.0 * 100) + "%)")

    def randomWord(length: Int = 5): String = {
        val letters = "abcdefghijklmnopqrstuvwxyz"
        val rand: Random = new Random
        val sb: StringBuilder = new StringBuilder
        
        for (i <- 0 until 5)
            sb.append(letters.charAt(math.abs(rand.nextInt()) % letters.length()))
        
        sb.toString()
    }
}
