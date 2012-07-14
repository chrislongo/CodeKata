import rules.PricingRules;
import item.Item;

import java.util.HashMap;
import java.util.Map;

/**
 * User: chris
 * Date: 7/13/12
 * Time: 7:49 PM
 */
public class CheckOut {
    private Map<Item, Integer> map = new HashMap<Item, Integer>();
    private PricingRules rules;

    public CheckOut(PricingRules rules) {
        this.rules = rules;
    }

    public void scan(Item item) {
        if(!map.containsKey(item)) {
            map.put(item, 1);
        }
        else {
            int count = map.get(item);
            map.put(item, ++count);
        }
    }

    public int total() {
        int total = 0;

        for(Item item : map.keySet()) {
            int count = map.get(item);
            total += rules.applyRules(item, count);
        }

        return total;
    }
}
