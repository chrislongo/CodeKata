import collection.mutable
import Node._

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
                case None => return false
            }
        }

        current.isWord
    }

    def search() {
        val queue = mutable.Queue[Node](root)

        while(!queue.isEmpty) {
            val node = queue.dequeue()
            for(child <- node.children) {
                if(!child.isEmpty) {
                    queue += child
                    print(child + " ")
                }
            }
        }
    }
}

class Node(ch: Char = '\0') {
    private val children0 = mutable.MutableList.empty[Node]

    def letter = ch

    def addChild(char: Char): Node = {
        val node = new Node(char)
        children0 += node
        node
    }

    def hasChild(ch: Char): Boolean = children0.contains(ch)
    def child(ch: Char): Option[Node] = children0.find(p => p == ch).headOption
    def children = children0.toList
    def isWord: Boolean = children0.contains(terminator)
    def isEmpty: Boolean = ch == '\0'
    def terminate() { children0 += terminator }

    override def equals(that: Any) = {
        that match {
            case node: Node => node.letter == letter
            case ch: Char => ch == letter
            case _ => false
        }
    }

    override def toString = letter.toString
}

object Node {
    def terminator = new Node('\0')
}


