package ir.piana.dev.pianasms.core.rest;

import ir.piana.dev.pianasms.core.model.InputSmsModel;
import ir.piana.dev.pianasms.core.model.KavenegarSmsModel;
import ir.piana.dev.pianasms.core.service.InputSmsService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * @author Mohamad Rahmati (rahmatii1366@gmail.com)
 * Date: 8/7/2019 9:34 AM
 **/
@RestController
public class KavenegarRest {
    Logger logger = LoggerFactory.getLogger(KavenegarRest.class);

    @Autowired
    private InputSmsService smsService;

    @PostMapping(value = "guest/sms/delivery",
            consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    public ResponseEntity delivery(
            @RequestBody Map smsModel,
            @RequestParam Map<String,String> allRequestParams) {
        logger.info("input sms");
        smsModel.forEach((k, v) -> {
            logger.info(k.toString().concat(" => ").concat(v.toString()));
        });
        logger.info(smsModel.toString());
//        smsService.saveSmsModel(smsModel);
        smsService.save(new InputSmsModel(smsModel));
//        smsService.save(new InputSmsModel(allRequestParams));
        return ResponseEntity.ok(200);
    }

    @GetMapping("guest/sms/all")
    public ResponseEntity<List<KavenegarSmsModel>> allSms() {
        return ResponseEntity.ok(smsService.getSmsModels());
    }

    @GetMapping("guest/sms-param/all")
    public ResponseEntity<List<InputSmsModel>> allSmsParams() {
        return ResponseEntity.ok(smsService.getModels());
    }
}
