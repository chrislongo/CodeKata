package rules;

/**
* User: chris
* Date: 7/14/12
* Time: 8:37 AM
*/
public class RuleForD implements Rule {
    @Override
    public int getTotal(int count) {
       return count * 15;
    }
}
