package ir.piana.dev.pianasms.core.model;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author Mohamad Rahmati (rahmatii1366@gmail.com)
 * Date: 8/7/2019 9:54 AM
 **/
public class KavenegarSmsModel {
    private String from;
    private String to;
    private String message;
    private String messageId;

    public KavenegarSmsModel() {
    }

    @JsonProperty("from")
    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    @JsonProperty("to")
    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    @JsonProperty("message")
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @JsonProperty("messageid")
    public String getMessageId() {
        return messageId;
    }

    public void setMessageId(String messageId) {
        this.messageId = messageId;
    }
}
