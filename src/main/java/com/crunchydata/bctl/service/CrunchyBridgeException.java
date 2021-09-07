package com.crunchydata.bctl.service;

public class CrunchyBridgeException extends RuntimeException{
    private int errorCode;

    public CrunchyBridgeException(ErrorResponse error) {
        super(getMessage(error.message));
        this.errorCode = error.error_code;
    }

    public int getErrorCode() {
        return errorCode;
    }

    private static String getMessage(String originalMessage) {
        String message = originalMessage.replaceAll("\\n", System.lineSeparator());
        message = message.replaceAll("\\nYou can also find the above list of errors at the endpoint `\\/connector-plugins\\/\\{connectorType\\}\\/config\\/validate`",
                "");
        return message;
    }
}
