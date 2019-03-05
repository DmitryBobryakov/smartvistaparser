import messages.Message;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.Reader;

public class Front {
    public static void main(String[] args) throws Exception {
        System.out.println("Input new command: ");
        Reader reader = new BufferedReader(new InputStreamReader(System.in));
        String readed = ((BufferedReader) reader).readLine();

        /* System.out.println(readed + " " + readed.length());*/

        ParserSwitcher parserSwitcher = new ParserSwitcher(readed);

        Message message = parserSwitcher.getMessage();
        message.parse();
        message.display();

        reader.close();
    }
}
