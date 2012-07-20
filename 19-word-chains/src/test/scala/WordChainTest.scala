import org.scalatest.FunSuite
import org.scalatest.matchers.ShouldMatchers

/**
 * User: chris
 * Date: 7/19/12
 * Time: 8:51 PM
 */

class WordChainTest extends FunSuite with ShouldMatchers {
    test("Insert words") {
        val chain: WordChain = new WordChain("data/words.txt")
        chain.insert("Hello")
        chain.insert("Help")
        chain.insert("Hell")
        chain.insert("He")
        chain.insert("Cat")

        chain.contains("Hello") should be(true)
        chain.contains("Help") should be(true)
        chain.contains("Hell") should be(true)
        chain.contains("He") should be(true)
        chain.contains("Cat") should be(true)
    }
}
