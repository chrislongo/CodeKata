import collection.mutable

/**
 * User: chris
 * Date: 7/19/12
 * Time: 8:33 PM
 */

class WordChain(wordsFile: String) {
    private val root: Node = new Node()

    def insert(word: String) {
        var current = root

        for(ch <- word) {
            current.child(ch) match {
                case Some(node) => current = node
                case None => current = current.addChild(ch)
            }
        }

        current.terminate()
    }

    def search() {
        val queue = mutable.Queue.empty[Node]

        queue += root
        root.visited = true

        while(!queue.isEmpty) {
            val node = queue.dequeue()
            for(child <- node.children.filter(p => p.visited == false)) {
                child.visited = true
                queue += child
            }
        }
    }

    def contains(word: String): Boolean = {
        var current = root

        for(ch <- word) {
            current.child(ch) match {
                case Some(node) => current = node
                case None => return false
            }
        }

        current.isWord
    }
}

class Node(ch: Char = '\0') {
    private val children_ = mutable.MutableList.empty[Node]
    var visited = false

    def char = ch

    def addChild(ch: Char): Node = {
        val node = new Node(ch)
        children_ += node
        node
    }

    def hasChild(ch: Char): Boolean = children_.contains(ch)

    def child(ch: Char): Option[Node] = children_.find(p => p == ch).headOption

    def children = children_.toList

    def isWord: Boolean = children_.contains(Node.terminator)

    def terminate() { children_ += Node.terminator }

    override def equals(that: Any) = {
        that match {
            case node: Node => node.char == char
            case ch: Char => ch == char
            case _ => false
        }
    }

    override def toString = ch.toString
}

object Node {
    def terminator = new Node('\0')
}


