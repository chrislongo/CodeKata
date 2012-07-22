import org.junit.Test;

import static junit.framework.Assert.assertEquals;

/**
 * User: chris
 * Date: 7/6/12
 * Time: 7:39 PM
 */
public class KataOneTest {
    @Test
    public void testRecursiveChop() throws Exception {
        int[] array = new int[]{1, 2, 3, 4, 5};
        KataOne kata = new KataOne();

        assertEquals(kata.recursiveChop(1, array), 0);
        assertEquals(kata.recursiveChop(2, array), 1);
        assertEquals(kata.recursiveChop(3, array), 2);
        assertEquals(kata.recursiveChop(4, array), 3);
        assertEquals(kata.recursiveChop(5, array), 4);
        assertEquals(kata.recursiveChop(6, array), -1);
        assertEquals(kata.recursiveChop(0, array), -1);
        assertEquals(kata.recursiveChop(1, new int[]{}), -1);
        assertEquals(kata.recursiveChop(1, null), -1);
        assertEquals(kata.recursiveChop(-1, null), -1);
    }

    @Test
    public void testIterativeChop() throws Exception {
        int[] array = new int[]{1, 2, 3, 4, 5};
        KataOne kata = new KataOne();

        assertEquals(kata.iterativeChop(1, array), 0);
        assertEquals(kata.iterativeChop(2, array), 1);
        assertEquals(kata.iterativeChop(3, array), 2);
        assertEquals(kata.iterativeChop(4, array), 3);
        assertEquals(kata.iterativeChop(5, array), 4);
        assertEquals(kata.iterativeChop(6, array), -1);
        assertEquals(kata.iterativeChop(0, array), -1);
        assertEquals(kata.iterativeChop(1, new int[]{}), -1);
        assertEquals(kata.iterativeChop(1, null), -1);
        assertEquals(kata.iterativeChop(-1, null), -1);
    }
}
