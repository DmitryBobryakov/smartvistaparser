package dmitrybobryakov.sv.parser.messages;

import dmitrybobryakov.sv.parser.elements.*;

import java.math.BigInteger;

public class MessageId0100 implements Message {
    private String bitMapBinary;
    private String bodyRef;
    private int panLength;
    private String pan;
    private String processingCode;
    private String processingCodeDescription;
    private String amountTransaction;
    private String dateTimeTransmission;
    private String systemsTraceAuditNum;
    private String dateTimeLocalTXN;
    private String dateExpiration;
    private String posEntryMode;
    private String posEntryModeDescription;
    private String functionCode;
    private String functionCodeDescription;
    private String posConditionCode;
    private String posConditionCodeDescription;
    private int track2DataLength;
    private String track2Data;
    private String terminalId;
    private String merchantId;
    private String currencyCode;
    private String pinBlockEncrypted;
    private int emvDataLength;
    private String emvData;
    private String primaryMACData;

    public MessageId0100(String bitMap, String body) {
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
        if (bitMapBinary.charAt(13) == '1') {
            dateExpiration = DateExpiration_14.get(bodyRef);
            fields.put("dateExpiration", dateExpiration);

            bodyRef = bodyRef.substring(6);
        }
        if (bitMapBinary.charAt(21) == '1') {
            posEntryMode = PointOfServiceDataCode_22.get(bodyRef);
            fields.put("posEntryMode", posEntryMode);
            bodyRef = bodyRef.substring(3);

            posEntryModeDescription = PointOfServiceDataCode_22.getDescription(posEntryMode);
            fields.put("posEntryModeDescription", posEntryModeDescription);
        }
        if (bitMapBinary.charAt(23) == '1') {
            functionCode = FunctionCode_24.get(bodyRef);
            functionCodeDescription = FunctionCode_24.getDescription(functionCode);
            fields.put("functionCode", functionCode);
            fields.put("functionCodeDescription", functionCodeDescription);

            bodyRef = bodyRef.substring(3);
        }
        if (bitMapBinary.charAt(24) == '1') {
            posConditionCode = PointOfServiceConditionCode_25.get(bodyRef);
            bodyRef = bodyRef.substring(2);
            fields.put("posConditionCode", posConditionCode);

            posConditionCodeDescription = PointOfServiceConditionCode_25.getDescription(posConditionCode);
            fields.put("posConditionCodeDescription", posConditionCodeDescription);
        }
        if (bitMapBinary.charAt(34) == '1') {
            track2DataLength = Track2Data_35.getLength(bodyRef);
            bodyRef = bodyRef.substring(2);
            fields.put("track2DataLength", String.valueOf(track2DataLength));

            track2Data = Track2Data_35.get(bodyRef, track2DataLength);
            bodyRef = bodyRef.substring(track2DataLength);
            fields.put("track2Data", track2Data);
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
        if (bitMapBinary.charAt(48) == '1') {
            currencyCode = CurrencyCodeTransaction_49.get(bodyRef);
            fields.put("currencyCode", currencyCode);

            bodyRef = bodyRef.substring(3);
        }
        if (bitMapBinary.charAt(51) == '1') {
            pinBlockEncrypted = PersonalIdentificationData_52.get(bodyRef);
            fields.put("pinBlockEncrypted", pinBlockEncrypted);

            bodyRef = bodyRef.substring(16);
        }
        if (bitMapBinary.charAt(54) == '1') {
            emvDataLength = EmvData_55.getLength(bodyRef);
            fields.put("emvDataLength", String.valueOf(emvDataLength));
            bodyRef = bodyRef.substring(4);

            emvData = EmvData_55.get(bodyRef, emvDataLength);
            fields.put("emvData", emvData);
            bodyRef = bodyRef.substring(emvDataLength);
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
