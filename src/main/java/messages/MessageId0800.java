package messages;

import java.util.Arrays;

public class MessageId0800 implements Message {

    private char[] bitMap;
    private char[] body;

    private char[] processingCode = new char[6];
    private char[] firstTwoInProcessingCode = new char[2];
    private char[] secondTwoInProcessingCode = new char[2];
    private char[] thirdTwoInProcessingCode = new char[2];
    private String processingCodeDescription = "";
    private char[] dateTimeTransmission = new char[10];
    private char[] systemsTraceAuditNum = new char[6];
    private char[] functionCode = new char[3];
    private String functionCodeDescription;
    private char[] terminalId = new char[8];
    private char[] merchantId = new char[15];

    public MessageId0800(char[] bitMap, char[] body) {
        this.bitMap = bitMap;
        this.body = body;
    }

    @Override
    public void parse() {
        this.processingCode = Arrays.copyOfRange(this.body, 0, 6);
        this.dateTimeTransmission = Arrays.copyOfRange(this.body, 6, 16);
        this.systemsTraceAuditNum = Arrays.copyOfRange(this.body, 16, 22);
        this.functionCode = Arrays.copyOfRange(this.body, 22, 25);
        this.terminalId = Arrays.copyOfRange(this.body, 25, 33);
        this.merchantId = Arrays.copyOfRange(this.body, 33, 48);

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
        switch (String.valueOf(this.functionCode[0]) +
                String.valueOf(this.functionCode[1]) +
                String.valueOf(this.functionCode[2])) {
            case "100":
                this.functionCodeDescription = "Original Authorization request / advice";
                break;
            case "200":
                this.functionCodeDescription = "Original Financial request / advice";
                break;
            case "400":
                this.functionCodeDescription = "Reversal, transaction did not complete as approved";
                break;
            case "504":
                this.functionCodeDescription = "Request for reconciliation totals ";
                break;
            case "801":
                this.functionCodeDescription = "Sign-on";
                break;
            case "802":
                this.functionCodeDescription = "Sign-off";
                break;
            case "811":
                this.functionCodeDescription = "Key Change";
                break;
            case "815":
                this.functionCodeDescription = "Mac Key Change";
                break;
            case "821":
                this.functionCodeDescription = "Cutover";
                break;
            case "831":
                this.functionCodeDescription = "Echo Test";
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
        System.out.print("Function Code: " + this.functionCodeDescription + " >>all: ");
        System.out.println(this.functionCode);
        System.out.print("Terminal Id: ");
        System.out.println(this.terminalId);
        System.out.print("Merchant Id: ");
        System.out.println(this.merchantId);

    }
}
