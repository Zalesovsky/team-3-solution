package syberry.hackathon.bank.service.impl;

import org.springframework.stereotype.Service;
import org.telegram.telegrambots.meta.api.objects.Message;
import syberry.hackathon.bank.banksModels.NrbModel;
import syberry.hackathon.bank.service.BankService;
import syberry.hackathon.bank.templateService.TemplateService;

import java.text.MessageFormat;
import java.time.temporal.TemporalAccessor;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

@Service
public class NationalBankServiceImpl implements BankService {


    @Override
    public String getAllCurrencies() {

        TemplateService templateService = new TemplateService();
        NrbModel[] nrbArray = templateService.getNRBValues("https://api.nbrb.by/exrates/currencies");

        StringBuilder resultString = new StringBuilder();

        for(NrbModel model : nrbArray){
            resultString.append(model.getCurName());
            resultString.append(", ");
        }

        return resultString.toString();
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
