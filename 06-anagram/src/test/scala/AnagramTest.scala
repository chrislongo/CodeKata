import org.scalatest.FunSuite
import org.scalatest.matchers.ShouldMatchers

/**
 * User: chris
 * Date: 7/11/12
 * Time: 6:32 AM
 */

class AnagramTest extends FunSuite with ShouldMatchers {
  test("generate ananagrams") {
    val a: Anagram = new Anagram
    assert(a.create("cat").sameElements(Array("cat", "cta", "act", "atc", "tca", "tac")))
  }
}
