package syberry.hackathon.bank.service.impl;

import org.springframework.stereotype.Service;
import syberry.hackathon.bank.banksModels.AlphaModel;
import syberry.hackathon.bank.service.BankService;
import syberry.hackathon.bank.templateService.TemplateService;

import java.time.temporal.TemporalAccessor;
import java.util.Arrays;
import java.util.List;

@Service
public class AlfaBankServiceImpl implements BankService {


    @Override
    public String getAllCurrencies() {

        TemplateService templateService = new TemplateService();

        List<AlphaModel> listOfModels = templateService.getAlphaValues("https://developerhub.alfabank.by:8273/partner/1.0.1/public/rates");

        StringBuilder resultString = new StringBuilder();

        for(AlphaModel model : listOfModels){

            if(model.getName() != null) {
                resultString.append(model.getName());
                resultString.append(", ");

            }

        }
        return resultString.toString();

    }
}
