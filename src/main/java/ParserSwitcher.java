import messages.MessageId0800;
import messages.MessageId0810;
import messages.Message;

public class ParserSwitcher {
    private String message;
    private String messageHeader;
    private char[] bitMap = new char[16];
    private char[] body = new char[100];

    public ParserSwitcher(String message) {
        this.message = message;
        String header = String.valueOf(message.charAt(0)) +
                String.valueOf(message.charAt(1)) +
                String.valueOf(message.charAt(2)) +
                String.valueOf(message.charAt(3));
        this.messageHeader = header;
        System.out.println("Message Header: " + this.messageHeader);
        message.getChars(4, 20, this.bitMap, 0);
        System.out.print("BitMap: ");
        for (int i = 0; i < this.bitMap.length; i++) {
            System.out.print(this.bitMap[i]);
        }
        message.getChars(20, message.length(), this.body, 0);
        /*System.out.println();*/
        /*System.out.println("this.body: ");
        for (int i = 0; i < this.body.length; i++) {
            System.out.print(this.body[i]);
        }*/
        System.out.println();
    }

    public Message getMessage() {
        switch (this.messageHeader) {
            case "0800":
                return new MessageId0800(this.bitMap, this.body);
            case "0810":
                return new MessageId0810(this.bitMap, this.body);
            default:
                return null;
        }
    }

}
