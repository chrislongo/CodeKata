import org.scalatest.FunSuite

/**
 * User: chris
 * Date: 7/9/12
 * Time: 9:59 PM
 */

class BloomFilterTest extends FunSuite {
  test("bloom filter contains strings") {
    val filter: BloomFilter = new BloomFilter()

    filter.add("One")
    filter.add("Two")
    filter.add("Three")

    assert(filter.contains("One"))
    assert(filter.contains("Two"))
    assert(filter.contains("Three"))
  }

  test("bloom filter does not contain strings") {
    val filter: BloomFilter = new BloomFilter()

    filter.add("One")
    filter.add("Two")
    filter.add("Three")

    assert(!filter.contains("Four"))
    assert(!filter.contains("Five"))
    assert(!filter.contains("Six"))
  }
}
