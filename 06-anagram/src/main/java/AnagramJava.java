/**
 * User: clongo
 * Date: 7/13/12
 * Time: 9:46 AM
 */
public class AnagramJava
{
    public void find(String word)
    {
        find("", word);
    }

    public void find(String prefix, String word)
    {
        if(word.length() <= 1)
        {
            System.out.println(prefix + word);
        }
        else
        {
            for(int i = 0; i < word.length(); i++)
            {
                find(prefix + word.substring(i, i + 1),
                    word.substring(0, i) + word.substring(i + 1));
            }
        }
    }
}
