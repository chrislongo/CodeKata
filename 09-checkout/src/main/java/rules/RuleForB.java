package rules;

/**
 * User: chris
 * Date: 7/14/12
 * Time: 8:35 AM
 */
public class RuleForB implements Rule{
    @Override
    public int getTotal(int count) {
        int discountedPrice = count / 2 * 45;
        int regularPrice = count % 2 * 30;
        return (discountedPrice + regularPrice);
    }
}
