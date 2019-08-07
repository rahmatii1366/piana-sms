package ir.piana.dev.pianasms.core.rest;

import ir.piana.dev.pianasms.core.model.KavenegarSmsModel;
import ir.piana.dev.pianasms.core.model.MobileDto;
import ir.piana.dev.pianasms.core.service.InputSmsService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author Mohamad Rahmati (rahmatii1366@gmail.com)
 * Date: 8/7/2019 9:34 AM
 **/
@RestController
public class KavenegarRest {
    Logger logger = LoggerFactory.getLogger(KavenegarRest.class);

    @Autowired
    private InputSmsService smsService;

    @RequestMapping(value = "guest/sms/delivery",
            method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    public ResponseEntity delivery(
            @RequestParam("from") String from, @RequestParam("to") String to,
            @RequestParam("message") String message, @RequestParam("messageid") String messageId) {
        smsService.saveSmsModel(new KavenegarSmsModel(from, to, message, messageId));
        return ResponseEntity.ok(200);
    }

    @PostMapping("user/sms/received")
    public ResponseEntity<KavenegarSmsModel> getSmsByMobileNumber(@RequestBody MobileDto mobileDto) {
        return ResponseEntity.ok(smsService.getByMobileNumber(mobileDto.getMobile()));
    }
}
