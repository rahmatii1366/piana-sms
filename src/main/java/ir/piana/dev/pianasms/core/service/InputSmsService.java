package ir.piana.dev.pianasms.core.service;

import ir.piana.dev.pianasms.core.exception.NotFoundRelatedException;
import ir.piana.dev.pianasms.core.model.KavenegarSmsModel;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * @author Mohamad Rahmati (rahmatii1366@gmail.com)
 * Date: 8/7/2019 9:41 AM
 **/
@Service
@Scope("singleton")
public class InputSmsService {
//    private List<KavenegarSmsModel> smsModels = new ArrayList<>();
    private Map<String, KavenegarSmsModel> smsMap = new LinkedHashMap<>();
    private Map<String, String> smsIdMap = new LinkedHashMap<>();

    public void saveSmsModel(KavenegarSmsModel model) {
//        smsModels.add(model);
        if(!smsIdMap.containsKey(model.getMessageId())) {
            smsMap.put(model.getFrom(), model);
            smsIdMap.put(model.getMessageId(), model.getFrom());
        }
    }

    public KavenegarSmsModel getByMobileNumber(String mobileNumber) {
        KavenegarSmsModel kavenegarSmsModel = Optional.ofNullable(smsMap.get(mobileNumber))
                .orElseThrow(() -> new NotFoundRelatedException("sms not received. try later!"));
        return smsMap.remove(kavenegarSmsModel.getFrom());
    }

//    public List<KavenegarSmsModel> getSmsModels() {
//        return smsModels;
//    }
}
