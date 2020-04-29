package dmitrybobryakov.sv.parser.elements;

public class EmvData_55 {
    public static int getLength(String body) {
        return Integer.parseInt(body.substring(0, 4));
    }

    public static String get(String body, int length) {
        return body.substring(length);
    }
}
