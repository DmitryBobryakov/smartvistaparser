package messages;

import java.util.Arrays;

public class MessageId0810 implements Message {
    private char[] bitMap;
    private char[] body;

    private char[] processingCode = new char[6];
    private char[] firstTwoInProcessingCode = new char[2];
    private char[] secondTwoInProcessingCode = new char[2];
    private char[] thirdTwoInProcessingCode = new char[2];
    private String processingCodeDescription = "";
    private char[] dateTimeTransmission = new char[10];
    private char[] systemsTraceAuditNum = new char[6];
    private char[] retreivalReferenceNumber = new char[12];
    private char[] responseCode = new char[3];
    private String responseCodeDescription;
    private char[] terminalId = new char[8];

    public MessageId0810(char[] bitMap, char[] body) {
        this.bitMap = bitMap;
        this.body = body;
    }

    @Override
    public void parse() {
        this.processingCode = Arrays.copyOfRange(this.body, 0, 6);
        this.dateTimeTransmission = Arrays.copyOfRange(this.body, 6, 16);
        this.systemsTraceAuditNum = Arrays.copyOfRange(this.body, 16, 22);
        this.retreivalReferenceNumber = Arrays.copyOfRange(this.body, 22, 34);
        this.responseCode = Arrays.copyOfRange(this.body, 34, 37);
        this.terminalId = Arrays.copyOfRange(this.body, 37, 45);

        this.firstTwoInProcessingCode = Arrays.copyOfRange(this.processingCode, 0, 2);
        this.secondTwoInProcessingCode = Arrays.copyOfRange(this.processingCode, 2, 4);
        this.thirdTwoInProcessingCode = Arrays.copyOfRange(this.processingCode, 4, 6);

        switch (String.valueOf(this.firstTwoInProcessingCode[0]) +
                String.valueOf(this.firstTwoInProcessingCode[1])) {
            case "00":
                this.processingCodeDescription += "Purchase ";
                break;
            case "01":
                this.processingCodeDescription += "Cash Advance ";
                break;
            case "09":
                this.processingCodeDescription += "Purchase with cash distbursement ";
                break;
            case "17":
                this.processingCodeDescription += "Loyalty Purchase ";
                break;
            case "20":
                this.processingCodeDescription += "Return or Refund ";
                break;
            case "21":
                this.processingCodeDescription += "Cash deposit ";
                break;
            case "31":
                this.processingCodeDescription += "Balance Inquiry ";
                break;
            case "37":
                this.processingCodeDescription += "Check Card ";
                break;
            case "50":
                this.processingCodeDescription += "Utility Payment";
                break;
            case "79":
                this.processingCodeDescription += "PIN Change ";
                break;
            case "90":
                this.processingCodeDescription += "Merchant Log-On ";
                break;
            case "91":
                this.processingCodeDescription += "Settlement Trailer";
                break;
            case "92":
                this.processingCodeDescription += "Merchant Log-Off ";
                break;
            case "93":
                this.processingCodeDescription += "Pre-autorization ";
                break;
            case "94":
                this.processingCodeDescription += "Pre-autorization Completion ";
                break;
            case "99":
                this.processingCodeDescription += "Network Management ";
                break;
        }
        switch (String.valueOf(this.secondTwoInProcessingCode[0]) +
                String.valueOf(this.secondTwoInProcessingCode[1])) {
            case "00":
                this.processingCodeDescription += " Default-unspecified";
                break;
            case "10":
                this.processingCodeDescription += " Savings account";
                break;
            case "20":
                this.processingCodeDescription += " Checking account 1";
                break;
            case "21":
                this.processingCodeDescription += " Checking account 2";
                break;
            case "22":
                this.processingCodeDescription += " Checking account 3";
                break;
            case "30":
                this.processingCodeDescription += " Credit account";
                break;
            case "60":
                this.processingCodeDescription += " Loyalty account";
                break;
            case "91":
                this.processingCodeDescription += " Loyalty account 1";
                break;
            case "92":
                this.processingCodeDescription += " Loyalty account 2";
                break;
        }
        switch (String.valueOf(this.thirdTwoInProcessingCode[0]) +
                String.valueOf(this.thirdTwoInProcessingCode[1])) {
            case "00":
                this.processingCodeDescription += " Default-unspecified";
                break;
            case "10":
                this.processingCodeDescription += " Savings account";
                break;
            case "20":
                this.processingCodeDescription += " Checking account 1";
                break;
            case "21":
                this.processingCodeDescription += " Checking account 2";
                break;
            case "22":
                this.processingCodeDescription += " Checking account 3";
                break;
            case "30":
                this.processingCodeDescription += " Credit account";
                break;
            case "60":
                this.processingCodeDescription += " Loyalty account";
                break;
            case "91":
                this.processingCodeDescription += " Loyalty account 1";
                break;
            case "92":
                this.processingCodeDescription += " Loyalty account 2";
                break;
        }
        switch (String.valueOf(this.responseCode[0]) +
                String.valueOf(this.responseCode[1]) +
                String.valueOf(this.responseCode[2])) {
            case "000":
                this.responseCodeDescription = "Successful transaction";
                break;
            case "001":
                this.responseCodeDescription = "Approve with ID . If transaction was Success , but MCC these is in next list 6010, 4829,\n" +
                        "6051, 7995, 7511 – then reason code changes on 001\n";
                break;
            case "003":
                this.responseCodeDescription = "Successful transaction";
                break;
            case "005":
                this.responseCodeDescription = "System Error";
                break;
            case "020":
                this.responseCodeDescription = "Successful transaction; used to indicate a negative balance in Field 4 on a Balance Inquiry";
                break;
            case "095":
                this.responseCodeDescription = "Reconcile Error";
                break;
            case "100":
                this.responseCodeDescription = "Do not honor transaction";
                break;
            case "101":
                this.responseCodeDescription = "Expired Card";
                break;
            case "103":
                this.responseCodeDescription = "Call Issuer";
                break;
            case "104":
                this.responseCodeDescription = "Card is restricted";
                break;
            case "105":
                this.responseCodeDescription = "Call security";
                break;
            case "106":
                this.responseCodeDescription = "Excessive pin failures";
                break;
            case "107":
                this.responseCodeDescription = "Call Issuern";
                break;
            case "109":
                this.responseCodeDescription = "Invalid merchant ID";
                break;
            case "110":
                this.responseCodeDescription = "Cannot process amount";
                break;
            case "111":
                this.responseCodeDescription = "Invalid account – retry";
                break;
            case "116":
                this.responseCodeDescription = "Insufficient funds – retry";
                break;
            case "117":
                this.responseCodeDescription = "Incorrect Pin";
                break;
            case "118":
                this.responseCodeDescription = "Forced post, no account on file";
                break;
            case "119":
                this.responseCodeDescription = "Transaction not permitted by law";
                break;
            case "120":
                this.responseCodeDescription = "Not permitted";
                break;
            case "121":
                this.responseCodeDescription = "Account limit exceeded";
                break;
            case "123":
                this.responseCodeDescription = "Card limit exceeded";
                break;
            case "125":
                this.responseCodeDescription = "Bad Card";
                break;
            case "126":
                this.responseCodeDescription = "Pin processing error";
                break;
            case "200":
                this.responseCodeDescription = "Invalid card";
                break;
            case "201":
                this.responseCodeDescription = "Card expired";
                break;
            case "202":
                this.responseCodeDescription = "Invalid card";
                break;
            case "203":
                this.responseCodeDescription = "Call security";
                break;
            case "204":
                this.responseCodeDescription = "Account restricted";
                break;
            case "206":
                this.responseCodeDescription = "Invalid Pin";
                break;
            case "208":
                this.responseCodeDescription = "Lost Card";
                break;
            case "209":
                this.responseCodeDescription = "Stolen Card";
                break;
            case "901":
                this.responseCodeDescription = "Invalid payment parameters";
                break;
            case "902":
                this.responseCodeDescription = "Invalid transaction – retry";
                break;
            case "903":
                this.responseCodeDescription = "Transaction needs to be entered again";
                break;
            case "904":
                this.responseCodeDescription = "The message received was not within standards";
                break;
            case "905":
                this.responseCodeDescription = "Issuing institution is unknown";
                break;
            case "907":
                this.responseCodeDescription = "Issuer inoperative";
                break;
            case "909":
                this.responseCodeDescription = "System malfunction";
                break;
            case "910":
                this.responseCodeDescription = "Issuer inoperative";
                break;
            case "911":
                this.responseCodeDescription = "SmartVista FE has no knowledge of any attempt to either authorize or deny the transaction.";
                break;
            case "912":
                this.responseCodeDescription = "Time out waiting for response";
                break;
            case "913":
                this.responseCodeDescription = "Duplicate transaction received";
                break;
            case "914":
                this.responseCodeDescription = "Could not find the original transaction";
                break;
            case "915":
                this.responseCodeDescription = "Amount being reversed is greater than original, or no amount being reversed";
                break;
            case "920":
                this.responseCodeDescription = "Pin processing error";
                break;
            case "923":
                this.responseCodeDescription = "Request in progress";
                break;
            case "940":
                this.responseCodeDescription = "Pick up card, special condition";
                break;
            case "941":
                this.responseCodeDescription = "Failed currency conversion";
                break;
        }
    }

    @Override
    public void display() {
        System.out.print("Processing Code: " + this.processingCodeDescription + " >>all: ");
        System.out.println(this.processingCode);
        System.out.print("Date, Time, Transmission: " +
                " MM: " + this.dateTimeTransmission[0] + this.dateTimeTransmission[1] +
                " DD: " + this.dateTimeTransmission[2] + this.dateTimeTransmission[3] +
                " hh: " + this.dateTimeTransmission[4] + this.dateTimeTransmission[5] +
                " mm: " + this.dateTimeTransmission[6] + this.dateTimeTransmission[7] +
                " ss: " + this.dateTimeTransmission[8] + this.dateTimeTransmission[9] + " >>all: ");
        System.out.println(this.dateTimeTransmission);
        System.out.print("Systems Trace Audit Num: ");
        System.out.println(this.systemsTraceAuditNum);
        System.out.print("Retreival Reference Number: ");
        System.out.println(this.retreivalReferenceNumber);
        System.out.print("Response Code: " + this.responseCodeDescription + " >>all: ");
        System.out.println(this.responseCode);
        System.out.print("Terminal Id: ");
        System.out.println(this.terminalId);

    }
}
