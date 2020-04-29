package dmitrybobryakov.sv.parser.elements;

public class PointOfServiceConditionCode_25 {
    public static String get(String body) {
        return body.substring(0, 2);
    }

    public static String getDescription(String code) {
        String description = "";
        switch (code) {
            case "00":
                description += "Attendant terminal";
                break;
            case "02":
                description += "Unattendant terminal";
                break;
            default:
                description += "Error: unsupported code,  must be 00 or 02 ";
                break;
        }
        return description;
    }
}
