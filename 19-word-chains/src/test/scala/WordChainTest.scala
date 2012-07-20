import org.scalatest.FunSuite
import org.scalatest.matchers.ShouldMatchers

/**
 * User: chris
 * Date: 7/19/12
 * Time: 8:51 PM
 */

class WordChainTest extends FunSuite with ShouldMatchers {
    test("Insert words") {
        val chain = new WordChain("data/words.txt")
        chain.insert("hello")
        chain.insert("help")
        chain.insert("hell")
        chain.insert("he")
        chain.insert("cat")

        chain.contains("hello") should be(true)
        chain.contains("help") should be(true)
        chain.contains("hell") should be(true)
        chain.contains("he") should be(true)
        chain.contains("cat") should be(true)
        chain.contains("cattle") should be (false)
    }

    test("bfs") {
        val chain = new WordChain("data/words.txt")
        for(word <- "this time is now the place is here".split(" "))
            chain.insert(word)

        chain.search()
    }
}
