package ir.piana.dev.pianasms.core.service;

import ir.piana.dev.pianasms.core.model.InputSmsModel;
import ir.piana.dev.pianasms.core.model.KavenegarSmsModel;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Mohamad Rahmati (rahmatii1366@gmail.com)
 * Date: 8/7/2019 9:41 AM
 **/
@Service
@Scope("singleton")
public class InputSmsService {
    private List<InputSmsModel> models = new ArrayList<>();
    private List<KavenegarSmsModel> smsModels = new ArrayList<>();

    public void saveSmsModel(KavenegarSmsModel model) {
        smsModels.add(model);
    }

    public List<KavenegarSmsModel> getSmsModels() {
        return smsModels;
    }

    public void save(InputSmsModel model) {
        models.add(model);
    }

    public List<InputSmsModel> getModels() {
        return models;
    }
}
