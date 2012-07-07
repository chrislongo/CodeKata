/**
 * User: chris
 * Date: 7/6/12
 * Time: 9:14 PM
 */

class KataOneScala
{
    def chop(find: Int, array: Array[Int]): Int = {
        def recursive(start: Int, end: Int): Int = {
            if(start > end) -1 else {
                val mid = (start + end) / 2

                if(array(mid) < find)
                    recursive(mid + 1, end)
                else if(array(mid) > find)
                    recursive(start, mid - 1)
                else
                    mid
            }
        }

        array match {
            case null => -1
            case _ => recursive(0, array.size - 1)
        }
    }

    def chopFunctional(find: Int, array: Array[Int]): Int = {
        def recursive(start: Int, end: Int): Int = (start + end) / 2 match {
            case _ if start > end => -1
            case mid if array(mid) > find => recursive(start, mid - 1)
            case mid if array(mid) < find => recursive(mid + 1, end)
            case mid => mid
        }

        array match {
            case null => -1
            case _ => recursive(0, array.size - 1)
        }
    }
}