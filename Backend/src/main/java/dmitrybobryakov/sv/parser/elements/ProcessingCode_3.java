package dmitrybobryakov.sv.parser.elements;

public class ProcessingCode_3 {
    public static String get(String body) {
        return body.substring(0, 6);
    }

    public static String getDescription(String processingCode) {
        String processingCodeDescription = "";

        String firstTwoInProcessingCode = processingCode.substring(0, 2);
        String secondTwoInProcessingCode = processingCode.substring(2, 4);
        String thirdTwoInProcessingCode = processingCode.substring(4, 6);

        switch (firstTwoInProcessingCode) {
            case "00":
                processingCodeDescription += "Purchase ";
                break;
            case "01":
                processingCodeDescription += "Cash Advance ";
                break;
            case "09":
                processingCodeDescription += "Purchase with cash distbursement ";
                break;
            case "17":
                processingCodeDescription += "Loyalty Purchase ";
                break;
            case "20":
                processingCodeDescription += "Return or Refund ";
                break;
            case "21":
                processingCodeDescription += "Cash deposit ";
                break;
            case "31":
                processingCodeDescription += "Balance Inquiry ";
                break;
            case "37":
                processingCodeDescription += "Check Card ";
                break;
            case "50":
                processingCodeDescription += "Utility Payment";
                break;
            case "79":
                processingCodeDescription += "PIN Change ";
                break;
            case "90":
                processingCodeDescription += "Merchant Log-On ";
                break;
            case "91":
                processingCodeDescription += "Settlement Trailer";
                break;
            case "92":
                processingCodeDescription += "Merchant Log-Off ";
                break;
            case "93":
                processingCodeDescription += "Pre-autorization ";
                break;
            case "94":
                processingCodeDescription += "Pre-autorization Completion ";
                break;
            case "99":
                processingCodeDescription += "Network Management ";
                break;
        }
        switch (secondTwoInProcessingCode) {
            case "00":
                processingCodeDescription += " Default-unspecified";
                break;
            case "10":
                processingCodeDescription += " Savings account";
                break;
            case "20":
                processingCodeDescription += " Checking account 1";
                break;
            case "21":
                processingCodeDescription += " Checking account 2";
                break;
            case "22":
                processingCodeDescription += " Checking account 3";
                break;
            case "30":
                processingCodeDescription += " Credit account";
                break;
            case "60":
                processingCodeDescription += " Loyalty account";
                break;
            case "91":
                processingCodeDescription += " Loyalty account 1";
                break;
            case "92":
                processingCodeDescription += " Loyalty account 2";
                break;
        }
        switch (thirdTwoInProcessingCode) {
            case "00":
                processingCodeDescription += " Default-unspecified";
                break;
            case "10":
                processingCodeDescription += " Savings account";
                break;
            case "20":
                processingCodeDescription += " Checking account 1";
                break;
            case "21":
                processingCodeDescription += " Checking account 2";
                break;
            case "22":
                processingCodeDescription += " Checking account 3";
                break;
            case "30":
                processingCodeDescription += " Credit account";
                break;
            case "60":
                processingCodeDescription += " Loyalty account";
                break;
            case "91":
                processingCodeDescription += " Loyalty account 1";
                break;
            case "92":
                processingCodeDescription += " Loyalty account 2";
                break;
        }
        return processingCodeDescription;
    }
}
