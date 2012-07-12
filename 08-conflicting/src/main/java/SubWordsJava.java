import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Set;
import java.util.TreeSet;

/**
 * User: clongo
 * Date: 7/12/12
 * Time: 3:47 PM
 */
public class SubWordsJava
{
    private Set<String> set = new TreeSet<String>();

    public static void main(String[] args) throws Exception
    {
        long start = System.currentTimeMillis();

        SubWordsJava sub = new SubWordsJava();
        sub.loadWords();
        int count = sub.countWords();

        long end = System.currentTimeMillis();

        System.out.println("Count:  " + count);
        System.out.println("Time: " + (end - start) + "ms");
    }

    public void loadWords() throws IOException
    {
        BufferedReader reader = new BufferedReader(new FileReader("data/words.txt"));

        while(reader.ready())
        {
            String word = reader.readLine().toLowerCase();

            if(word.length() <= 6)
                set.add(word);
        }
    }

    public int countWords()
    {
        int count = 0;

        for(String word : set)
        {
            if(word.length() == 6)
            {
                for(int i = 1; i < word.length(); i++)
                {
                    String sub1 = word.substring(0, i);
                    String sub2 = word.substring(i);

                    if(set.contains(sub1) && set.contains(sub2))
                        count++;
                }
            }
        }

        return count;
    }
}
