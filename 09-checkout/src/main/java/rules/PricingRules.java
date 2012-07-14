package rules;

import item.Item;

/**
 * User: chris
 * Date: 7/13/12
 * Time: 7:54 PM
 */
public class PricingRules {
    RuleFactory factory = new RuleFactory();

    public int applyRules(Item item, int count) {
        return factory.getRule(item).getTotal(count);
    }
}

class RuleFactory {
    public Rule getRule(Item item) {

        if(item.getName().equals("A")) {
            return new RuleforA();
        }
        else if(item.getName().equals("B")) {
            return new RuleForB();
        }
        else if(item.getName().equals("C")) {
            return new RuleForC();
        }
        else if(item.getName().equals("D")) {
            return new RuleForD();
        }
        else
            throw new IllegalArgumentException("No pricing rules for item: " + item);
    }
}
