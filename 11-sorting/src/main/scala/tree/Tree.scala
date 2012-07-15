package tree

import collection.mutable.ArrayBuffer

/**
 * User: chris
 * Date: 7/15/12
 * Time: 8:58 AM
 */

class Tree {
    var root: tree.Node = null

    def add(value: Int) {
        val node: tree.Node = new tree.Node(value)
        var current = this.root
        var parent: Node = null

        while(true) {
            parent = current

            if(current == null) {
                this.root = node
                return
            }
            else if(value < current.data) {
                current = current.left

                if(current == null) {
                    parent.left = node
                    return
                }
            }
            else if(value > current.data) {
                current = current.right

                if(current == null) {
                    parent.right = node
                    return
                }
            }
        }
    }

    def elements: Array[Int] = {
        val buffer = ArrayBuffer.empty[Int]

        def recursive(node: Node) {
            if(node != null) {
                recursive(node.left)
                buffer += node.data
                recursive(node.right)
            }
        }

        recursive(this.root)
        buffer.toArray
    }
}
