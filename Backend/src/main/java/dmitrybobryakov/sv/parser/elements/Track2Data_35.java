package dmitrybobryakov.sv.parser.elements;

public class Track2Data_35 {
    public static int getLength(String body) {
        return Integer.parseInt(body.substring(0, 2));
    }

    public static String get(String body, int length) {
        return body.substring(0, length);
    }
}
