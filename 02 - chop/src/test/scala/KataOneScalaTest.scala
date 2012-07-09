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
        kata.recursiveChop(1, array) should equal(0)
    }

    test("Found number 2 in array") {
        val array: Array[Int] = Array(1, 2, 3, 4, 5)
        kata.recursiveChop(2, array) should equal(1)
    }

    test("Found number 3 in array") {
        val array: Array[Int] = Array(1, 2, 3, 4, 5)
        kata.recursiveChop(3, array) should equal(2)
    }

    test("Found number 4 in array") {
        val array: Array[Int] = Array(1, 2, 3, 4, 5)
        kata.recursiveChop(4, array) should equal(3)
    }

    test("Found number 5 in array") {
        val array: Array[Int] = Array(1, 2, 3, 4, 5)
        kata.recursiveChop(5, array) should equal(4)
    }

    test("Number 0 not in array") {
        val array: Array[Int] = Array(1, 2, 3, 4, 5)
        kata.recursiveChop(0, array) should equal(-1)
    }

    test("Number 6 not in array") {
        val array: Array[Int] = Array(1, 2, 3, 4, 5)
        kata.recursiveChop(6, array) should equal(-1)
    }

    test("Null array returns -1") {
        kata.recursiveChop(1, null) should equal(-1)
    }

    test("Zero length array returns -1") {
        val array: Array[Int] = Array()
        kata.recursiveChop(1, array) should equal(-1)
    }

    test("Found number 1 in array (functional)") {
        val array: Array[Int] = Array(1, 2, 3, 4, 5)
        kata.functionalChop(1, array) should equal(0)
    }

    test("Found number 2 in array (functional)") {
        val array: Array[Int] = Array(1, 2, 3, 4, 5)
        kata.functionalChop(2, array) should equal(1)
    }

    test("Found number 3 in array (functional)") {
        val array: Array[Int] = Array(1, 2, 3, 4, 5)
        kata.functionalChop(3, array) should equal(2)
    }

    test("Found number 4 in array (functional)") {
        val array: Array[Int] = Array(1, 2, 3, 4, 5)
        kata.functionalChop(4, array) should equal(3)
    }

    test("Found number 5 in array (functional)") {
        val array: Array[Int] = Array(1, 2, 3, 4, 5)
        kata.functionalChop(5, array) should equal(4)
    }

    test("Number 0 not in array (functional)") {
        val array: Array[Int] = Array(1, 2, 3, 4, 5)
        kata.functionalChop(0, array) should equal(-1)
    }

    test("Number 6 not in array (functional)") {
        val array: Array[Int] = Array(1, 2, 3, 4, 5)
        kata.functionalChop(6, array) should equal(-1)
    }

    test("Null array returns -1 (functional)") {
        kata.functionalChop(1, null) should equal(-1)
    }

    test("Zero length array returns -1 (functional)") {
        val array: Array[Int] = Array()
        kata.functionalChop(1, array) should equal(-1)
    }

    test("Found number 1 in array (iterartive)") {
        val array: Array[Int] = Array(1, 2, 3, 4, 5)
        kata.iterativeChop(1, array) should equal(0)
    }

    test("Found number 2 in array (iterartive)") {
        val array: Array[Int] = Array(1, 2, 3, 4, 5)
        kata.iterativeChop(2, array) should equal(1)
    }

    test("Found number 3 in array (iterartive)") {
        val array: Array[Int] = Array(1, 2, 3, 4, 5)
        kata.iterativeChop(3, array) should equal(2)
    }

    test("Found number 4 in array (iterartive)") {
        val array: Array[Int] = Array(1, 2, 3, 4, 5)
        kata.iterativeChop(4, array) should equal(3)
    }

    test("Found number 5 in array (iterartive)") {
        val array: Array[Int] = Array(1, 2, 3, 4, 5)
        kata.iterativeChop(5, array) should equal(4)
    }

    test("Number 0 not in array (iterartive)") {
        val array: Array[Int] = Array(1, 2, 3, 4, 5)
        kata.iterativeChop(0, array) should equal(-1)
    }

    test("Number 6 not in array (iterartive)") {
        val array: Array[Int] = Array(1, 2, 3, 4, 5)
        kata.iterativeChop(6, array) should equal(-1)
    }

    test("Null array returns -1 (iterartive)") {
        kata.iterativeChop(1, null) should equal(-1)
    }

    test("Zero length array returns -1 (iterartive)") {
        val array: Array[Int] = Array()
        kata.iterativeChop(1, array) should equal(-1)
    }
}
