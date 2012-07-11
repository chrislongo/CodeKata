import org.scalatest.FunSuite

/**
 * User: chris
 * Date: 7/11/12
 * Time: 6:32 AM
 */

class AnagramTest extends FunSuite {
    test("print ananagrams") {
        val a: Anagram = new Anagram
        assert(a.create("cat").sameElements(Array("cat", "cta", "act", "atc", "tca", "tac")))
    }
}
