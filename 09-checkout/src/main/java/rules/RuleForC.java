package rules;

/**
* User: chris
* Date: 7/14/12
* Time: 8:37 AM
*/
public class RuleForC implements Rule {
    @Override
    public int getTotal(int count) {
        return count * 20;
    }
}
