import tree.Tree

/**
 * User: chris
 * Date: 7/15/12
 * Time: 11:16 AM
 */

class SortBalls {
  val tree: Tree = new Tree

  def add(value: Int) {
    tree.add(value)
  }

  def balls = {
    tree.elements
  }
}
