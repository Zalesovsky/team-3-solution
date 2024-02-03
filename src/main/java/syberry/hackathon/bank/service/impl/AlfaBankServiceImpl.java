package syberry.hackathon.bank.service.impl;

import org.springframework.stereotype.Service;
import syberry.hackathon.bank.banksModels.AlphaModel;
import syberry.hackathon.bank.banksModels.NrbModel;
import syberry.hackathon.bank.service.BankService;
import syberry.hackathon.bank.templateService.TemplateService;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.Set;

@Service
public class AlfaBankServiceImpl implements BankService {


    @Override
    public Set<String> getAllCurrencies() {
        return Set.of("евро", "доллар", "российский рубль");

    }

    public String getRateForDate(String date){
        TemplateService templateService = new TemplateService();
        StringBuilder dateString = new StringBuilder();
        dateString.append("https://developerhub.alfabank.by:8273/partner/1.0.1/public/rates");
        List<AlphaModel> alphaModel = templateService.getAlphaValues(dateString.toString());

        StringBuilder resultString = new StringBuilder();



        for(AlphaModel model : alphaModel) {
            if(model.name != null){
            resultString.append(model.name);
            resultString.append("  ");
            resultString.append(model.rate);
                resultString.append(", ");
            }
        }


        return resultString.toString();

    }

    public String getRateForDateUSD(String date){
        TemplateService templateService = new TemplateService();
        StringBuilder dateString = new StringBuilder();
        dateString.append("https://developerhub.alfabank.by:8273/partner/1.0.1/public/rates");
        List<AlphaModel> alphaModel = templateService.getAlphaValues(dateString.toString());

        StringBuilder resultString = new StringBuilder();



        for(AlphaModel model : alphaModel) {
            if(Objects.equals(model.name, "доллар США")){
                resultString.append(model.name);
                resultString.append("  ");
                resultString.append(model.rate);
            }
        }


        return resultString.toString();

    }
    public String getRateForDateRUB(String date){
        TemplateService templateService = new TemplateService();
        StringBuilder dateString = new StringBuilder();
        dateString.append("https://developerhub.alfabank.by:8273/partner/1.0.1/public/rates");
        List<AlphaModel> alphaModel = templateService.getAlphaValues(dateString.toString());

        StringBuilder resultString = new StringBuilder();



        for(AlphaModel model : alphaModel) {
            if(Objects.equals(model.name, "российских рублей")){
                resultString.append("100 ");
                resultString.append(model.name);
                resultString.append("  ");
                resultString.append(model.rate);
            }
        }


        return resultString.toString();

    }
    public String getRateForDateEUR(String date){
        TemplateService templateService = new TemplateService();
        StringBuilder dateString = new StringBuilder();
        dateString.append("https://developerhub.alfabank.by:8273/partner/1.0.1/public/rates");
        List<AlphaModel> alphaModel = templateService.getAlphaValues(dateString.toString());

        StringBuilder resultString = new StringBuilder();

        for(AlphaModel model : alphaModel) {
            if(Objects.equals(model.name, "евро")){
                resultString.append(model.name);
                resultString.append("  ");
                resultString.append(model.rate);
            }
        }


        return resultString.toString();

    }
}


