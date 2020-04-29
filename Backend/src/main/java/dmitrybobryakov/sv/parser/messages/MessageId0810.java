package dmitrybobryakov.sv.parser.messages;

import dmitrybobryakov.sv.parser.elements.*;

import java.math.BigInteger;

public class MessageId0810 implements Message {
    private String bitMapBinary;
    private String bodyRef;

    private String processingCode;
    private String processingCodeDescription;
    private String dateTimeTransmission;
    private String systemsTraceAuditNum;
    private String retreivalReferenceNumber;
    private String responseCode;
    private String responseCodeDescription;
    private String responseCodeCaptureCard;
    private int communicationKeyLength;
    private String communicationKey;
    private String terminalId;
    private String primaryMACData;

    public MessageId0810(String bitMap, String body) {
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
        if (bitMapBinary.charAt(36) == '1') {
            retreivalReferenceNumber = RetrievalReferenceNumber_37.get(bodyRef);
            fields.put("retreivalReferenceNumber", retreivalReferenceNumber);

            bodyRef = bodyRef.substring(12);
        }
        if (bitMapBinary.charAt(38) == '1') {
            responseCode = ResponseCode_39.get(bodyRef);
            responseCodeDescription = ResponseCode_39.getDescription(responseCode);
            responseCodeCaptureCard = ResponseCode_39.getCaptureCard(responseCodeDescription);

            fields.put("responseCode", responseCode);
            fields.put("responseCodeDescription", responseCodeDescription);
            fields.put("responseCodeCaptureCard", responseCodeCaptureCard);

            bodyRef = bodyRef.substring(3);
        }
        if (bitMapBinary.charAt(40) == '1') {
            terminalId = CardAcceptorTerminalIdentification_41.get(bodyRef);
            fields.put("terminalId", terminalId);

            bodyRef = bodyRef.substring(8);
        }
        if (bitMapBinary.charAt(52) == '1') {
            communicationKeyLength = SecurityRelatedControlInformation_53.getLength(bodyRef);
            bodyRef = bodyRef.substring(2);

            communicationKey = SecurityRelatedControlInformation_53.get(communicationKeyLength, bodyRef);
            bodyRef = bodyRef.substring(communicationKeyLength);

            fields.put("communicationKeyLength", String.valueOf(communicationKeyLength));
            fields.put("communicationKey", communicationKey);
        }
        if (bitMapBinary.charAt(63) == '1') {
            primaryMACData = PrimaryMacData_64.get(bodyRef);
            fields.put("primaryMacData", primaryMACData);
        }
    }

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
        System.out.print("Retreival Reference Number: ");
        System.out.println(this.retreivalReferenceNumber);
        System.out.print("Response Code: " + this.responseCodeDescription + " >>all: ");
        System.out.println(this.responseCode);
        System.out.print("Terminal Id: ");
        System.out.println(this.terminalId);
        System.out.print("Communication key length: ");
        System.out.println(this.communicationKeyLength);
        System.out.print("Communication key: ");
        System.out.println(this.communicationKey);
        System.out.print("Primary MAC Data: ");
        System.out.println(this.primaryMACData);
    }
}
