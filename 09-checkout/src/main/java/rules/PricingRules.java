package rules;

import exception.DataParsingException;
import item.Item;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * User: chris
 * Date: 7/13/12
 * Time: 7:54 PM
 */
public class PricingRules {
    private Map<Item, Rule> map = new HashMap<Item, Rule>();

    public PricingRules(String rulesFile) throws IOException, DataParsingException {
        BufferedReader reader = new BufferedReader(new FileReader(rulesFile));

        while(reader.ready()) {

            String rule = null;

            try {
                rule = reader.readLine();

                String[] items = rule.split(",");
                String name = items[0];

                int price = Integer.parseInt(items[1]);
                int discountCount = 0;
                int discountPrice = 0;

                if(items.length > 2) {
                    String[] discount = items[2].split("->");
                    discountCount = Integer.parseInt(discount[0]);
                    discountPrice = Integer.parseInt(discount[1]);
                }

                map.put(
                    new Item(name),
                    new ItemRule(price, discountCount, discountPrice));
            }
            catch(NumberFormatException e) {
                throw new DataParsingException("Bad data in rules file: " + rule);
            }
        }
    }

    public int applyRules(Item item, int count) {
        Rule rule = map.get(item);

        if(rule == null)
            throw new IllegalArgumentException("Unknown item: " + item);

        return rule.getTotal(count);
    }
}