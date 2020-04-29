package dmitrybobryakov.sv.parser.service;

import dmitrybobryakov.sv.parser.messages.*;

public class ParserSwitcher {
    private String messageHeader;
    private String bitMap;
    private String body;

    public ParserSwitcher(String message) {
        messageHeader = message.substring(0, 4);
        System.out.println("Message Header: " + this.messageHeader);
        bitMap = message.substring(4, 20);
        System.out.print("BitMap: " + bitMap);
        body = message.substring(20);
        System.out.println();
    }

    public Message getMessage() {
        switch (this.messageHeader) {
            case "0800":
                return new MessageId0800(bitMap, body);
            case "0810":
                return new MessageId0810(bitMap, body);
            case "0100":
                return new MessageId0100(bitMap, body);
            case "0110":
                return new MessageId0110(bitMap, body);
            default:
                return null;
        }
    }

}
