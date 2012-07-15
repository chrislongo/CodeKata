import org.scalatest.FunSuite
import org.scalatest.matchers.ShouldMatchers

/**
 * User: chris
 * Date: 7/14/12
 * Time: 9:54 PM
 */

class SortCharsTest extends FunSuite with ShouldMatchers
{
    test("Sorted getSortedMessage matches expected ordering") {
        val sc = new SortChars
        sc.sort("When not studying nuclear physics, Bambi likes to play beach volleyball.")
        sc.sortedMessage should equal("aaaaabbbbcccdeeeeeghhhiiiiklllllllmnnnnooopprsssstttuuvwyyyy")
    }
}
