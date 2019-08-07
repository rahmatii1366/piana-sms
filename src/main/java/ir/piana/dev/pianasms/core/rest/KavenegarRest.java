package ir.piana.dev.pianasms.core.rest;

import ir.piana.dev.pianasms.core.model.InputSmsModel;
import ir.piana.dev.pianasms.core.model.KavenegarSmsModel;
import ir.piana.dev.pianasms.core.service.InputSmsService;
import org.springframework.beans.factory.annotation.Autowired;
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
    @Autowired
    private InputSmsService smsService;

    @PostMapping("guest/sms/delivery")
    public ResponseEntity delivery(
            @RequestBody KavenegarSmsModel smsModel,
            @RequestParam Map<String,String> allRequestParams) {
        smsService.saveSmsModel(smsModel);
        smsService.save(new InputSmsModel(allRequestParams));
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
