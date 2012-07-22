/**
 * User: chris
 * Date: 7/6/12
 * Time: 7:38 PM
 */
public class KataOne {
    public int recursiveChop(int find, int[] array) {
        if(array == null || array.length == 0)
            return -1;
        else
            return recursiveChop(find, array, 0, array.length - 1);
    }

    public int recursiveChop(int find, int[] array, int start, int end) {
        if(start > end) return -1;

        int mid = (start + end) / 2;

        if(array[mid] > find)
            return recursiveChop(find, array, start, mid - 1);
        else if(array[mid] < find)
            return recursiveChop(find, array, mid + 1, end);
        else
            return mid;
    }

    public int iterativeChop(int find, int[] array) {
        if(array == null || array.length == 0) return -1;
        else {
            int start = 0;
            int end = array.length - 1;

            while(start <= end) {
                int mid = (start + end) / 2;

                if(array[mid] > find)
                    end = mid - 1;
                else if(array[mid] < find)
                    start = mid + 1;
                else
                    return mid;
            }
        }

        return -1;
    }
}
