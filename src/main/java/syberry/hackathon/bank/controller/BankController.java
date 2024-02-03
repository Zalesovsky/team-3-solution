package syberry.hackathon.bank.controller;

import org.springframework.web.bind.annotation.*;
import syberry.hackathon.bank.BnbApi.NrbModel;
import syberry.hackathon.bank.templateService.TemplateService;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;

@RestController
@CrossOrigin
@RequestMapping("api/banks")
public class BankController {

    TemplateService template = new TemplateService();

    @RequestMapping(value = "/{bankName}/currencies", method = RequestMethod.GET)
    public String getBankCurrencies(@PathVariable("bankName") String bankName){

        NrbModel[] nrbArray = template.getNRBValues("https://api.nbrb.by/exrates/currencies/");

        StringBuilder stringBuilder = new StringBuilder();


        for(NrbModel soleModel :nrbArray){
            stringBuilder.append(soleModel.getCurName());
            stringBuilder.append(", ");
        }
        return stringBuilder.toString();
    }

    @RequestMapping(value = "/{bankName}/Rate")
    public String getRates(){
        return "ok";
    }



}
