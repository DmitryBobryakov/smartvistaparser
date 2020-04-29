package dmitrybobryakov.sv.parser.elements;

public class ResponseCode_39 {
    public static String get(String body) {
        return body.substring(0, 6);
    }

    public static String getDescription(String responseCode) {
        String description = "";
        switch (responseCode) {
            case "000":
                description = "Successful transaction";
                break;
            case "001":
                description = "Approve with ID . If transaction was Success , but MCC these is in next list 6010, 4829,\n" +
                        "6051, 7995, 7511 – then reason code changes on 001\n";
                break;
            case "003":
                description = "Successful transaction";
                break;
            case "005":
                description = "System Error";
                break;
            case "020":
                description = "Successful transaction; used to indicate a negative balance in Field 4 on a Balance Inquiry";
                break;
            case "095":
                description = "Reconcile Error";
                break;
            case "100":
                description = "Do not honor transaction";
                break;
            case "101":
                description = "Expired Card";
                break;
            case "103":
                description = "Call Issuer";
                break;
            case "104":
                description = "Card is restricted";
                break;
            case "105":
                description = "Call security";
                break;
            case "106":
                description = "Excessive pin failures";
                break;
            case "107":
                description = "Call Issuern";
                break;
            case "109":
                description = "Invalid merchant ID";
                break;
            case "110":
                description = "Cannot process amount";
                break;
            case "111":
                description = "Invalid account – retry";
                break;
            case "116":
                description = "Insufficient funds – retry";
                break;
            case "117":
                description = "Incorrect Pin";
                break;
            case "118":
                description = "Forced post, no account on file";
                break;
            case "119":
                description = "Transaction not permitted by law";
                break;
            case "120":
                description = "Not permitted";
                break;
            case "121":
                description = "Account limit exceeded";
                break;
            case "123":
                description = "Card limit exceeded";
                break;
            case "125":
                description = "Bad Card";
                break;
            case "126":
                description = "Pin processing error";
                break;
            case "200":
                description = "Invalid card";
                break;
            case "201":
                description = "Card expired";
                break;
            case "202":
                description = "Invalid card";
                break;
            case "203":
                description = "Call security";
                break;
            case "204":
                description = "Account restricted";
                break;
            case "206":
                description = "Invalid Pin";
                break;
            case "208":
                description = "Lost Card";
                break;
            case "209":
                description = "Stolen Card";
                break;
            case "901":
                description = "Invalid payment parameters";
                break;
            case "902":
                description = "Invalid transaction – retry";
                break;
            case "903":
                description = "Transaction needs to be entered again";
                break;
            case "904":
                description = "The message received was not within standards";
                break;
            case "905":
                description = "Issuing institution is unknown";
                break;
            case "907":
                description = "Issuer inoperative";
                break;
            case "909":
                description = "System malfunction";
                break;
            case "910":
                description = "Issuer inoperative";
                break;
            case "911":
                description = "SmartVista FE has no knowledge of any attempt to either authorize or deny the transaction.";
                break;
            case "912":
                description = "Time out waiting for response";
                break;
            case "913":
                description = "Duplicate transaction received";
                break;
            case "914":
                description = "Could not find the original transaction";
                break;
            case "915":
                description = "Amount being reversed is greater than original, or no amount being reversed";
                break;
            case "920":
                description = "Pin processing error";
                break;
            case "923":
                description = "Request in progress";
                break;
            case "940":
                description = "Pick up card, special condition";
                break;
            case "941":
                description = "Failed currency conversion";
                break;
        }

        return description;
    }

    public static String getCaptureCard(String responseCodeDescription) {
        int code = Integer.parseInt(responseCodeDescription);

        if (code >= 200 && code <= 209) {
            return "Yes";
        }
        return "No";
    }
}
