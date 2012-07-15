import org.scalatest.FunSuite

/**
 * User: chris
 * Date: 7/15/12
 * Time: 2:43 PM
 */

class TrigramGeneratorTest extends FunSuite
{
    test("Parse document") {
        val parser = new TrigramGenerator
        parser.loadFile("data/mobydick.txt")
        parser.printTrigram()
    }
}
