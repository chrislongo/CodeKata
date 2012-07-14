import checkout.CheckOut;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import rules.PricingRules;
import item.Item;

import static junit.framework.Assert.assertEquals;

/**
 * User: chris
 * Date: 7/14/12
 * Time: 8:30 AM
 */
public class CheckOutTest {
    @Test
    public void testTotal() throws Exception {
        assertEquals(0, price(""));
        assertEquals(50, price("A"));
        assertEquals(80, price("AB"));
        assertEquals(115, price("CDBA"));

        assertEquals(100, price("AA"));
        assertEquals(130, price("AAA"));
        assertEquals(180, price("AAAA"));
        assertEquals(230, price("AAAAA"));
        assertEquals(260, price("AAAAAA"));

        assertEquals(160, price("AAAB"));
        assertEquals(175, price("AAABB"));
        assertEquals(190, price("AAABBD"));
        assertEquals(190, price("DABABA"));
    }

    @Test
    public void testIncremental() throws Exception {
        CheckOut checkOut = new CheckOut(new PricingRules());

        assertEquals(0, checkOut.total());
        checkOut.scan(new Item("A"));
        assertEquals(50, checkOut.total());
        checkOut.scan(new Item("B"));
        assertEquals(80, checkOut.total());
        checkOut.scan(new Item("A"));
        assertEquals(130, checkOut.total());
        checkOut.scan(new Item("A"));
        assertEquals(160, checkOut.total());
        checkOut.scan(new Item("B"));
        assertEquals(175, checkOut.total());
    }

    @Test(expected=IllegalArgumentException.class)
    public void testBadItem() throws Exception
    {
        CheckOut checkOut = new CheckOut(new PricingRules());
        Item item = new Item("X");
        checkOut.scan(item);
        checkOut.total();
    }

    public int price(String itemList) {
        CheckOut checkOut = new CheckOut(new PricingRules());

        for (int i = 0; i < itemList.length(); i++) {
            String itemName = itemList.substring(i, i + 1);
            Item item = new Item(itemName);
            checkOut.scan(item);
        }

        return checkOut.total();
    }
}
