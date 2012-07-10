import collection.mutable.{ArrayBuffer, BitSet}
import util.MurmurHash

/**
 * User: chris
 * Date: 7/9/12
 * Time: 8:26 PM
 */

class BloomFilter(elems: Int = 1024) {
    private val bits = new BitSet(elems)

    def add(s: String) {
        for(hash <- hash(s)) bits.add(hash)
    }
    
    def contains(s: String): Boolean = {
        for(hash <- hash(s))
            if(!bits(hash)) return false
        true
    }

    def size: Int = {
        bits.size
    }
    
    def hash(s: String): Array[Int] = {
        val buffer = ArrayBuffer.empty[Int]

        val murmur = new MurmurHash[String](0)
        murmur.apply(s)

        for(i <- 0 until 5) {
            val hash = math.abs(murmur.hash % elems)
            buffer += hash
            murmur.append(hash)
        }

        buffer.toArray
    }
}
