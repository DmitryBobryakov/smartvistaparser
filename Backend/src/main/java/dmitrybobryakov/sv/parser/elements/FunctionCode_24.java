package dmitrybobryakov.sv.parser.elements;

public class FunctionCode_24 {
    public static String get(String body) {
        return body.substring(0, 3);
    }

    public static String getDescription(String functionCode) {
        String functionCodeDescription = "";

        switch (functionCode) {
            case "100":
                functionCodeDescription = "Original Authorization request / advice";
                break;
            case "200":
                functionCodeDescription = "Original Financial request / advice";
                break;
            case "400":
                functionCodeDescription = "Reversal, transaction did not complete as approved";
                break;
            case "504":
                functionCodeDescription = "Request for reconciliation totals ";
                break;
            case "801":
                functionCodeDescription = "Sign-on";
                break;
            case "802":
                functionCodeDescription = "Sign-off";
                break;
            case "811":
                functionCodeDescription = "Key Change";
                break;
            case "815":
                functionCodeDescription = "Mac Key Change";
                break;
            case "821":
                functionCodeDescription = "Cutover";
                break;
            case "831":
                functionCodeDescription = "Echo Test";
                break;
        }
        return functionCodeDescription;
    }
}
