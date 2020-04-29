package dmitrybobryakov.sv.parser.service;

import dmitrybobryakov.sv.parser.messages.Message;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class SvParserService {
    public Map<String, String> getMessageFields(String message) {
        System.out.println(message + " |" + message.length());

        ParserSwitcher parserSwitcher = new ParserSwitcher(message.trim());

        Message messageStruct = parserSwitcher.getMessage();
        messageStruct.parse();
        messageStruct.display();

        return messageStruct.fields;
    }
}
