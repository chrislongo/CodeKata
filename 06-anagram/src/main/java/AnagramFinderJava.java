import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeSet;

/**
 * User: clongo
 * Date: 7/11/12
 * Time: 10:07 AM
 */
public class AnagramFinderJava
{
    private Map<String, TreeSet<String>> map = new HashMap<String, TreeSet<String>>();

    public static void main(String[] args) throws Exception
    {
        long start = System.currentTimeMillis();

        AnagramFinderJava finder = new AnagramFinderJava();
        finder.loadWords();
        int count = finder.find();

        long end = System.currentTimeMillis();

        System.out.println("Sets: " + count);
        System.out.println("Time: " + (end - start));
    }

    public void loadWords() throws IOException
    {
        BufferedReader reader = new BufferedReader(new FileReader("data/words.txt"));

        while(reader.ready())
        {
            String word = reader.readLine().toLowerCase();
            String key = sortString(word);

            if(!map.containsKey(key))
                map.put(key, new TreeSet<String>());

            map.get(key).add(word);
        }
    }

    public int find()
    {
        int count = 0;

        for(TreeSet<String> set : map.values())
            if(set.size() > 1)
                count++;

        return count;
    }

    private String sortString(String s)
    {
        char[] chars = s.toCharArray();
        Arrays.sort(chars);
        return new String(chars);
    }
}
