package dmitrybobryakov.sv.parser.elements;

public class PrimaryAccountNumber_2 {
    public static String getLength(String body) {
        return body.substring(0, 2);
    }

    public static String get(String body, int length) {
        return body.substring(0, length);
    }
}
