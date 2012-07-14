package rules;

/**
* User: chris
* Date: 7/13/12
* Time: 8:03 PM
*/
public class RuleforA implements Rule {
    @Override
    public int getTotal(int count) {
        int discountedPrice = count / 3 * 130;
        int regularPrice = count % 3 * 50;

        return (discountedPrice + regularPrice);
    }
}
