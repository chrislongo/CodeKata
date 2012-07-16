import org.scalatest.FunSuite
import org.scalatest.matchers.ShouldMatchers

/**
 * User: chris
 * Date: 7/15/12
 * Time: 11:01 AM
 */

class SortBallsTest extends FunSuite with ShouldMatchers
{
    test("Results are in order")
    {
        val sb = new SortBalls
        sb.balls should equal(Array())
        sb.add(20)
        sb.balls should equal(Array(20))
        sb.add(10)
        sb.balls should equal(Array(10, 20))
        sb.add(30)
        sb.balls should equal(Array(10, 20, 30))
    }
}