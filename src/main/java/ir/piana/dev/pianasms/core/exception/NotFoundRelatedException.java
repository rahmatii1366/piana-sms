package ir.piana.dev.pianasms.core.exception;

import org.springframework.http.HttpStatus;

/**
 * @author Mohamad Rahmati (rahmatii1366@gmail.com)
 * Date: 7/22/2019 8:41 AM
 **/
public class NotFoundRelatedException extends PianaHttpException {
    public NotFoundRelatedException(String message) {
        super(message, HttpStatus.NOT_FOUND);
    }
}
