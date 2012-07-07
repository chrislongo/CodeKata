import org.scalatest.FunSuite
import org.scalatest.matchers.ShouldMatchers

/**
 * User: chris
 * Date: 7/7/12
 * Time: 8:15 AM
 */

class KataOneScalaTest extends FunSuite with ShouldMatchers {
    val kata: KataOneScala = new KataOneScala

    test("Found number 1 in array") {
        val array: Array[Int] = Array(1, 2, 3, 4, 5)
        kata.chop(1, array) should equal(0)
    }

    test("Found number 2 in array") {
        val array: Array[Int] = Array(1, 2, 3, 4, 5)
        kata.chop(2, array) should equal(1)
    }

    test("Found number 3 in array") {
        val array: Array[Int] = Array(1, 2, 3, 4, 5)
        kata.chop(3, array) should equal(2)
    }

    test("Found number 4 in array") {
        val array: Array[Int] = Array(1, 2, 3, 4, 5)
        kata.chop(4, array) should equal(3)
    }

    test("Found number 5 in array") {
        val array: Array[Int] = Array(1, 2, 3, 4, 5)
        kata.chop(5, array) should equal(4)
    }

    test("Number 0 not in array") {
        val array: Array[Int] = Array(1, 2, 3, 4, 5)
        kata.chop(0, array) should equal(-1)
    }

    test("Number 6 not in array") {
        val array: Array[Int] = Array(1, 2, 3, 4, 5)
        kata.chop(6, array) should equal(-1)
    }

    test("Null array returns -1") {
        kata.chop(1, null) should equal(-1)
    }

    test("Zero length array returns -1") {
        val array: Array[Int] = Array()
        kata.chop(1, array) should equal(-1)
    }

    test("Found number 1 in array (functional)") {
        val array: Array[Int] = Array(1, 2, 3, 4, 5)
        kata.chopFunctional(1, array) should equal(0)
    }
}
