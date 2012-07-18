import org.scalatest.{BeforeAndAfter, FunSuite}
import org.scalatest.matchers.ShouldMatchers

/**
 * User: clongo
 * Date: 7/18/12
 * Time: 1:32 PM
 */

class DependenciesTest extends FunSuite with ShouldMatchers with BeforeAndAfter
{
    var deps: Dependencies = _

    before {
        deps = new Dependencies
    }

    test("List dependencies") {
        add("ABC")
        add("BCE")
        add("CG")
        add("DAF")
        add("EF")
        add("FH")

        dependenciesOf("A") should equal("BCEFGH")
        dependenciesOf("B") should equal("CEFGH")
        dependenciesOf("C") should equal("G")
        dependenciesOf("D") should equal("ABCEFGH")
        dependenciesOf("E") should equal("FH")
        dependenciesOf("F") should equal("H")
    }

    test("Cyclical relationships") {
        add("AB")
        add("BC")
        add("CA")

        dependenciesOf("A") should equal("BC")
        dependenciesOf("B") should equal("AC")
        dependenciesOf("C") should equal("AB")
    }

    def add(elems: String) {
        val item = elems.substring(0, 1)
        for(i <- 1 until elems.size)
            deps.addDirect(item, elems.substring(i, i + 1))
    }

    def dependenciesOf(item: String): String = {
        val builder = new StringBuilder

        for(s <- deps.of(item))
            builder.append(s)

        builder.toString().sorted
    }
}
