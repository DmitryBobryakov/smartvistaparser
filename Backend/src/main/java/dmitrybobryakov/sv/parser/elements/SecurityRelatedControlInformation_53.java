package dmitrybobryakov.sv.parser.elements;

public class SecurityRelatedControlInformation_53 {
    public static int getLength(String body) {
        return Integer.parseInt(body.substring(0, 2));
    }

    public static String get(int length, String body) {
        return body.substring(length);
    }
}
