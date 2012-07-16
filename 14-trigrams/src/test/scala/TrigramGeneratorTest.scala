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
        val s = generator.generate(length=200)
        s.split(" ").length should equal(200)
        println(s)
    }

    test("Expected results") {
        val generator = new TrigramGenerator("data/trigram-data.txt")
        val s = generator.generate("He thrusts")
        s should equal("He thrusts his fists against the posts And still insists he sees the ghosts.")
        println(s)
    }
}
