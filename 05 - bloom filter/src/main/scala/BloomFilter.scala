import collection.mutable
import collection.mutable.{ArrayBuffer, BitSet}
import util.MurmurHash

/**
 * User: chris
 * Date: 7/9/12
 * Time: 8:26 PM
 */

class BloomFilter(elems: Int = 1024, k: Int = 3) {
    private val bits = new mutable.BitSet(elems)
    def size: Int = bits.size

    def += (s: String) {
        for(hash <- hash(s)) bits.add(hash)
    }
    
    def contains(s: String): Boolean = {
        for(hash <- hash(s))
            if(!bits(hash)) return false
        true
    }

    def hash(s: String): Array[Int] = {
        val buffer = ArrayBuffer.empty[Int]

        val murmur = new MurmurHash[String](0)
        murmur.apply(s)

        for(i <- 0 until k) {
            val hash = math.abs(murmur.hash % elems)
            murmur.append(hash)
            buffer += hash
        }

        buffer.toArray
    }
}
