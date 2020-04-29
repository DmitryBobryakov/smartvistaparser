package dmitrybobryakov.sv.parser.messages;

import dmitrybobryakov.sv.parser.elements.*;

import java.math.BigInteger;

public class MessageId0110 implements Message {
    private String bitMapBinary;
    private String bodyRef;
    private int panLength;
    private String pan;
    private String processingCode;
    private String processingCodeDescription;
    private String retreivalReferenceNumber;
    private String approvalCode;
    private String amountTransaction;
    private String dateTimeTransmission;
    private String systemsTraceAuditNum;
    private String dateTimeLocalTXN;
    private String terminalId;
    private String currencyCode;
    private String responseCode;
    private String responseCodeDescription;
    private String responseCodeCaptureCard;
    private int emvDataLength;
    private String emvData;
    private String additionalDataPrivate;
    private String customerDefinedResponse;
    private String privateData;
    private String primaryMACData;

    public MessageId0110(String bitMap, String body) {
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
        if (bitMapBinary.charAt(1) == '1') {
            panLength = Integer.parseInt(PrimaryAccountNumber_2.getLength(bodyRef));
            bodyRef = bodyRef.substring(2);

            pan = PrimaryAccountNumber_2.get(bodyRef, panLength);
            bodyRef = bodyRef.substring(panLength);

            fields.put("panLength", String.valueOf(panLength));
            fields.put("pan", pan);
        }
        if (bitMapBinary.charAt(2) == '1') {
            processingCode = ProcessingCode_3.get(bodyRef);
            processingCodeDescription = ProcessingCode_3.getDescription(processingCode);
            fields.put("processingCode", processingCode);
            fields.put("processingCodeDescription", processingCodeDescription);

            bodyRef = bodyRef.substring(6);
        }
        if (bitMapBinary.charAt(3) == '1') {
            amountTransaction = AmountTransaction_4.get(bodyRef);
            fields.put("amountTransaction", amountTransaction);

            bodyRef = bodyRef.substring(12);
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
        if (bitMapBinary.charAt(11) == '1') {
            dateTimeLocalTXN = TimeLocalOfTransaction_12.get(bodyRef);
            fields.put("dateTimeLocalTXN", dateTimeLocalTXN);

            bodyRef = bodyRef.substring(12);
        }
        if (bitMapBinary.charAt(36) == '1') {
            retreivalReferenceNumber = RetrievalReferenceNumber_37.get(bodyRef);
            fields.put("retreivalReferenceNumber", retreivalReferenceNumber);

            bodyRef = bodyRef.substring(12);
        }
        if (bitMapBinary.charAt(37) == '1') {
            approvalCode = ApprovalCode_38.get(bodyRef);
            fields.put("approvalCode", approvalCode);

            bodyRef = bodyRef.substring(6);
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
        if (bitMapBinary.charAt(47) == '1') {
            additionalDataPrivate = AdditionalDataPrivate_48.get(bodyRef);
            fields.put("additionalDataPrivate", additionalDataPrivate);

            bodyRef = bodyRef.substring(999);
        }
        if (bitMapBinary.charAt(48) == '1') {
            currencyCode = CurrencyCodeTransaction_49.get(bodyRef);
            fields.put("currencyCode", currencyCode);

            bodyRef = bodyRef.substring(3);
        }
        if (bitMapBinary.charAt(54) == '1') {
            emvDataLength = EmvData_55.getLength(bodyRef);
            fields.put("emvDataLength", String.valueOf(emvDataLength));
            bodyRef = bodyRef.substring(4);

            emvData = EmvData_55.get(bodyRef, emvDataLength);
            fields.put("emvData", emvData);
            bodyRef = bodyRef.substring(emvDataLength);
        }
        if (bitMapBinary.charAt(61) == '1') {
            customerDefinedResponse = CustomerDefinedResponse_62.get(bodyRef);
            fields.put("customerDefinedResponse", customerDefinedResponse);
            bodyRef = bodyRef.substring(999);
        }
        if (bitMapBinary.charAt(62) == '1') {
            privateData = PrivateData_63.get(bodyRef);
            fields.put("privateData", privateData);
            bodyRef = bodyRef.substring(999);
        }
        if (bitMapBinary.charAt(63) == '1') {
            primaryMACData = PrimaryMacData_64.get(bodyRef);
            fields.put("primaryMacData", primaryMACData);
        }
    }

    @Override
    public void display() {
        System.out.print("PAN length: ");
        System.out.println(this.panLength);
        System.out.print("Primary account number: ");
        System.out.println(this.pan);
        System.out.print("Processing Code: " + this.processingCodeDescription + " >>all: ");
        System.out.println(this.processingCode);
    }
}
