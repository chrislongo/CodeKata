import collection.mutable
import collection.mutable.ArrayBuffer

/**
 * User: clongo
 * Date: 7/18/12
 * Time: 12:41 PM
 */

class Dependencies
{
    private val matrix = ArrayBuffer.fill(64, 64)(0)
    private val items = mutable.MutableList.empty[String]

    def addDirect(item: String, vertex: String) {
        if(!(items contains item))
            items += item

        if(!(items contains vertex))
            items += vertex

        matrix(items.indexOf(item))(items.indexOf(vertex)) = 1
    }

    def of(item: String): Array[String] = {
        var visited = ArrayBuffer.empty[String]

        def visit(item: String) {
            val index = items.indexOf(item)
            visited += item

            for(i <- 0 until items.size) {
                if(matrix(index)(i) == 1 && !visited.contains(items(i))) {
                    visit(items(i))
                }
            }
        }

        visit(item)

        visited.toArray.drop(1)
    }
}
