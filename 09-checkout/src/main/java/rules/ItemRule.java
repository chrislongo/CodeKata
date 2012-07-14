package rules;

/**
 * User: chris
 * Date: 7/14/12
 * Time: 10:21 AM
 */
public class ItemRule implements Rule
{
    private int price;
    private int discountCount;
    private int discountPrice;

    public ItemRule(int price, int discountCount, int discountPrice)
    {
        this.price = price;
        this.discountCount = discountCount;
        this.discountPrice = discountPrice;
    }

    @Override
    public int getTotal(int count)
    {
        int total;

        if(discountCount > 0 && count >= discountCount) {
            int discount = count / discountCount * discountPrice;
            int regular = count % discountCount * price;
            total = (discount + regular);
        }
        else {
            total = count * price;
        }

        return total;
    }
}
