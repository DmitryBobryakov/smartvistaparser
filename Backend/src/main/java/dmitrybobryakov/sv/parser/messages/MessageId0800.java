package dmitrybobryakov.sv.parser.messages;

import dmitrybobryakov.sv.parser.elements.*;

import java.math.BigInteger;

public class MessageId0800 implements Message {
    private String bitMapBinary;
    private String bodyRef;

    private String processingCode;
    private String processingCodeDescription;
    private String dateTimeTransmission;
    private String systemsTraceAuditNum;
    private String functionCode;
    private String functionCodeDescription;
    private String terminalId;
    private String merchantId;
    private String primaryMACData;

    public MessageId0800(String bitMap, String body) {
        bitMapBinary = new BigInteger(bitMap, 16)
                .toString(2);
        int lengthDif = 64 - bitMapBinary.length();
        for (int i = 0; i < lengthDif; i++) {
            bitMapBinary = "0".concat(bitMapBinary);
        }

        bodyRef = body;
        fields.put("body", body.trim());

        System.out.println("this.bitMapBinary: " + bitMapBinary);
        fields.put("bitMapBinary", bitMapBinary);
    }

    @Override
    public void parse() {
        if (bitMapBinary.charAt(2) == '1') {
            processingCode = ProcessingCode_3.get(bodyRef);
            processingCodeDescription = ProcessingCode_3.getDescription(processingCode);
            fields.put("processingCode", processingCode);
            fields.put("processingCodeDescription", processingCodeDescription);

            bodyRef = bodyRef.substring(6);
        }
        if (bitMapBinary.charAt(6) == '1') {
            dateTimeTransmission = DateTimeOfTransmission_7.get(bodyRef);
            fields.put("dateTimeTransmission", dateTimeTransmission);

            bodyRef = bodyRef.substring(10);
        }
        if (bitMapBinary.charAt(10) == '1') {
            systemsTraceAuditNum = SystemsTraceAuditNumber_11.get(bodyRef);
            fields.put("systemsTraceAuditNum", systemsTraceAuditNum);

            bodyRef = bodyRef.substring(6);
        }
        if (bitMapBinary.charAt(23) == '1') {
            functionCode = FunctionCode_24.get(bodyRef);
            functionCodeDescription = FunctionCode_24.getDescription(functionCode);
            fields.put("functionCode", functionCode);
            fields.put("functionCodeDescription", functionCodeDescription);

            bodyRef = bodyRef.substring(3);
        }
        if (bitMapBinary.charAt(40) == '1') {
            terminalId = CardAcceptorTerminalIdentification_41.get(bodyRef);
            fields.put("terminalId", terminalId);

            bodyRef = bodyRef.substring(8);
        }
        if (bitMapBinary.charAt(41) == '1') {
            merchantId = MerchantIdentification_42.get(bodyRef);
            fields.put("merchantId", merchantId);

            bodyRef = bodyRef.substring(3);
        }
        if (bitMapBinary.charAt(63) == '1') {
            primaryMACData = PrimaryMacData_64.get(bodyRef);
            fields.put("primaryMacData", primaryMACData);
        }
    }

    // remove method
    @Override
    public void display() {
        System.out.print("Processing Code: " + this.processingCodeDescription + " >>all: ");
        System.out.println(this.processingCode);
        System.out.print("Date, Time, Transmission: " +
                " MM: " + dateTimeTransmission.substring(0, 1) +
                " DD: " + dateTimeTransmission.substring(2, 3) +
                " hh: " + dateTimeTransmission.substring(4, 5) +
                " mm: " + dateTimeTransmission.substring(6, 7) +
                " ss: " + dateTimeTransmission.substring(8, 9) + " >>all: ");
        System.out.println(this.dateTimeTransmission);
        System.out.print("Systems Trace Audit Num: ");
        System.out.println(this.systemsTraceAuditNum);
        System.out.print("Function Code: " + this.functionCodeDescription + " >>all: ");
        System.out.println(this.functionCode);
        System.out.print("Terminal Id: ");
        System.out.println(this.terminalId);
        System.out.print("Merchant Id: ");
        System.out.println(this.merchantId);
        System.out.print("Primary MAC Data: ");
        System.out.println(this.primaryMACData);

    }
}
