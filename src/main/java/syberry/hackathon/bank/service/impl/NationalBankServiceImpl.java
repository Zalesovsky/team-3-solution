package syberry.hackathon.bank.service.impl;

import org.springframework.stereotype.Service;
import syberry.hackathon.bank.banksModels.NrbModel;
import syberry.hackathon.bank.service.BankService;
import syberry.hackathon.bank.templateService.TemplateService;

import java.util.Objects;
import java.util.Set;

@Service
public class NationalBankServiceImpl implements BankService {


    @Override
    public Set<String> getAllCurrencies() {
        return Set.of("евро", "доллар", "российиский рубль");
    }

    public String getRateForDate(String date){
        TemplateService templateService = new TemplateService();
        StringBuilder dateString = new StringBuilder();
        dateString.append("https://api.nbrb.by/exrates/rates?onDate=");
        dateString.append(date);
        dateString.append("&periodicity=0");
        NrbModel[] nrbArray = templateService.getNRBValues(dateString.toString());

        StringBuilder resultString = new StringBuilder();

        for(NrbModel model : nrbArray){
            if(Objects.equals(model.getCurName(), "Евро") || Objects.equals(model.getCurName(), "Доллар США") || Objects.equals(model.getCurName(), "Российских рублей")) {
                resultString.append(model.getCurName());
                resultString.append(" ");
                resultString.append(model.getCurOfficialRate());
                resultString.append(", ");
            }
        }

        //return "hello";
        return resultString.toString();

    }
}
