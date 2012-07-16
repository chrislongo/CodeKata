import org.scalatest.FunSuite
import org.scalatest.matchers.ShouldMatchers

/**
 * User: chris
 * Date: 7/15/12
 * Time: 2:43 PM
 */

class TrigramGeneratorTest extends FunSuite with ShouldMatchers
{
    test("Parse large document") {
        val generator = new TrigramGenerator("data/mobydick.txt")
        val s = generator.generate(25)
        s.split(" ").length should equal(25)
        println(s)
    }
}
