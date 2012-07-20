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

    def contains(word: String): Boolean = {
        var current = root

        for(ch <- word) {
            current.child(ch) match {
                case Some(node) => current = node
                case None => false
            }
        }

        current.isWord
    }
}

class Node(ch: Char = '\0') {
    private val children = mutable.MutableList.empty[Node]

    def char = ch

    def addChild(ch: Char): Node = {
        val node = new Node(ch)
        children += node
        node
    }

    def hasChild(ch: Char): Boolean = children.contains(ch)

    def child(ch: Char): Option[Node] = children.find(p => p == ch).headOption

    def isWord: Boolean = children.contains(Node.terminator)

    def terminate() { children += Node.terminator }

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


