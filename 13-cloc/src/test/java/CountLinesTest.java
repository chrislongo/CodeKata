import org.junit.Test;

/**
* User: chris
* Date: 7/15/12
* Time: 12:29 PM
*/
public class CountLinesTest {
    @Test
    public void testCount() throws Exception {
        assert (LineCounter.count("data/cloc-data1.txt") == 3);
        assert (LineCounter.count("data/cloc-data2.txt") == 5);
        assert (LineCounter.count("data/cloc-data3.txt") == 7);
    }
}
