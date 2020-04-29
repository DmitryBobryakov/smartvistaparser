package dmitrybobryakov.sv.parser.messages;

import java.util.HashMap;
import java.util.Map;

public interface Message {
    public Map<String, String> fields = new HashMap<>();

    public void display();

    public void parse();
}
