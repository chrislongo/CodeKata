import io.Source

/**
 * User: chris
 * Date: 7/11/12
 * Time: 6:52 AM
 */

object AnagramFinder extends App {
    val anagram = new Anagram

    loadWords()
    find()

    def loadWords() {
        for (word <- Source.fromFile("data/words.txt").getLines()) {
        }
    }
    
    def find() {
        for(key <- map.keys) {
        }
    }
}
