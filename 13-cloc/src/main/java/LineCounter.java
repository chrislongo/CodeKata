import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * User: chris
 * Date: 7/15/12
 * Time: 12:21 PM
 */
public class LineCounter {
    public static int count(String file) throws IOException {
        int count = 0;

        BufferedReader reader = new BufferedReader(new FileReader(file));
        boolean inComment = false;

        while(reader.ready()) {
            String line = reader.readLine();
            line = line.trim();

            if(line.length() > 0) {
                boolean inString = false;
                boolean startsWithComment =
                    line.startsWith("//") || line.startsWith("/*");

                if(line.length() > 0 && !startsWithComment && !inComment)
                    count++;

                for(int i = 0; i < line.length(); i++) {
                    char a = (i > 0) ? line.charAt(i - 1) : 0;
                    char b = line.charAt(i);

                    if(!inString && !inComment && a == '/' && b == '*')
                        inComment = true;
                    else if(!inString && inComment && a == '*' && b == '/')
                        inComment = false;
                    else if(b == '"')
                        inString = !inString;
                }
            }
        }

        return count;
    }
}
