import org.scalatest.FunSuite

/**
 * User: chris
 * Date: 7/15/12
 * Time: 2:43 PM
 */

class DocumentParserTest extends FunSuite
{
    test("Parse document") {
        val parser = new DocumentParser
        parser.loadFile("data/mobydick.txt")
        parser.printTrigram()
    }
}
