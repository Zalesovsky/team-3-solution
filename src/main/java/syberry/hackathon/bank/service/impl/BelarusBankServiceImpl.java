package syberry.hackathon.bank.service.impl;

import org.springframework.stereotype.Service;
import syberry.hackathon.bank.banksModels.AlphaModel;
import syberry.hackathon.bank.banksModels.BelarusBankModel;
import syberry.hackathon.bank.service.BankService;
import syberry.hackathon.bank.templateService.TemplateService;

import java.util.Arrays;
import java.util.List;
import java.util.Set;

@Service
public class BelarusBankServiceImpl implements BankService {


    @Override
    public Set<String> getAllCurrencies() {
        return Set.of("евро", "доллар", "российиский рубль");
    }

    public String getRateForDate(String date) {
        TemplateService templateService = new TemplateService();
        StringBuilder dateString = new StringBuilder();
        dateString.append("https://belarusbank.by/api/kurs_cards");


        BelarusBankModel[] belarusBankModel = templateService.getBelarusValues(dateString.toString());

        StringBuilder resultString = new StringBuilder();

        for (BelarusBankModel model : belarusBankModel) {
            resultString.append("USD ");
            resultString.append(model.getUsdRate());
            resultString.append("  ");
            resultString.append("EUR ");
            resultString.append(model.getEurRate());
            resultString.append("  ");
            resultString.append("100 RUB ");
            resultString.append(model.getRubRate());
            resultString.append("  ");
            break;
        }
        return resultString.toString();
    }

}
