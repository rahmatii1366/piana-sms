package ir.piana.dev.pianasms.core.model;

import java.util.Map;

/**
 * @author Mohamad Rahmati (rahmatii1366@gmail.com)
 * Date: 8/7/2019 9:42 AM
 **/
public class InputSmsModel {
    private Map<String, String> message;

    public InputSmsModel(Map<String, String> message) {
        this.message = message;
    }

    public Map<String, String> getMessage() {
        return message;
    }

    public void setMessage(Map<String, String> message) {
        this.message = message;
    }
}
