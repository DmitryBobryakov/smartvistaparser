package dmitrybobryakov.sv.parser.elements;

public class PointOfServiceDataCode_22 {
    public static String get(String body) {
        return body.substring(0, 3);
    }

    public static String getDescription(String code) {
        String firstCode = code.substring(0, 2);
        String secondCode = code.substring(2, 3);
        String result = "";
        switch (firstCode) {
            case "01":
                result += "Manual ";
                break;
            case "06":
                result += "Manual ";
                break;
            case "02":
                result += "Magnetic stripe read ";
            case "05":
                result += "Integrated circuit card read; CVV data reliable ";
                break;
            case "07":
                result += "Proximity transaction originated using ICC data rules ";
                break;
            case "08":
                result += "Magnetic stripe even though it is ICC capable ";
                break;
            case "91":
                result += "Proximity transaction originated using " +
                        "magnetic  stripe data rules; CVV " +
                        "check is possible ";
                break;
        }
        switch (secondCode) {
            case "0":
                result += "Not authenticated ";
                break;
            case "1":
                result += "PIN ";
                break;
            case "9":
                result += "Terminal accept Off-line PINs (for EMV cards) ";
                break;
        }

        return result;
    }
}
