package messages;

import java.util.Arrays;

public class MerchantLogOnRequest0800 implements Message {

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
    private char[] terminalId = new char[8];
    private char[] merchantId = new char[15];

    public MerchantLogOnRequest0800(char[] bitMap, char[] body) {
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
            case "90":
                this.processingCodeDescription += "Merchant Log-On ";
                break;

        }
        switch (String.valueOf(this.secondTwoInProcessingCode[0]) +
                String.valueOf(this.secondTwoInProcessingCode[1])) {
            case "00":
                this.processingCodeDescription += " Default-unspecified";
                break;

        }
        switch (String.valueOf(this.thirdTwoInProcessingCode[0]) +
                String.valueOf(this.thirdTwoInProcessingCode[1])) {
            case "00":
                this.processingCodeDescription += " Default-unspecified";
                break;

        }

    }

    @Override
    public void display() {
        System.out.print("Processing Code: " + this.processingCodeDescription + " ");
        System.out.println(this.processingCode);
        System.out.print("Date, Time, Transmission: ");
        System.out.println(this.dateTimeTransmission);
        System.out.print("Systems Trace Audit Num: ");
        System.out.println(this.systemsTraceAuditNum);
        System.out.print("Function Code: ");
        System.out.println(this.functionCode);
        System.out.print("Terminal Id: ");
        System.out.println(this.terminalId);
        System.out.print("Merchant Id: ");
        System.out.println(this.merchantId);

    }
}
