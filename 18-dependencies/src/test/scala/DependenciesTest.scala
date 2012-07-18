import org.scalatest.FunSuite
import org.scalatest.matchers.ShouldMatchers

/**
 * User: clongo
 * Date: 7/18/12
 * Time: 1:32 PM
 */

class DependenciesTest extends FunSuite with ShouldMatchers
{
    var deps = new  Dependencies

    test("List dependencies") {
        add("ABC")
        add("BCE")
        add("CG")
        add("DAF")
        add("EF")
        add("FH")

        dependencies("A") should equal("ABCEFGH")
        dependencies("B") should equal("BCEFGH")
        dependencies("C") should equal("CG")
        dependencies("D") should equal("ABCDEFGH")
        dependencies("E") should equal("EFH")
        dependencies("F") should equal("FH")
    }

    def add(elems: String) {
        val item = elems.substring(0, 1)
        for(i <- 1 until elems.size)
            deps.addDirect(item, elems.substring(i, i + 1))
    }

    def dependencies(item: String): String = {
        val builder = new StringBuilder

        for(s <- deps.of(item))
            builder.append(s)

        builder.toString().sorted
    }
}
