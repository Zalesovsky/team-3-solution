package syberry.hackathon.bank.templateService;

import org.springframework.web.client.RestTemplate;
import syberry.hackathon.bank.banksModels.AlphaHigherModel;
import syberry.hackathon.bank.banksModels.AlphaModel;
import syberry.hackathon.bank.banksModels.NrbModel;

import java.util.List;

public class TemplateService {

    RestTemplate restTemplate = new RestTemplate();

    public String getStringJson(String url){

        return restTemplate.getForObject(url, String.class);
    }

    public NrbModel[] getNRBValues(String url){
        return restTemplate.getForObject(url, NrbModel[].class);

    }

//    public AlphaModel[] getAlphaValues(String url){
//        return  restTemplate.getForObject(url, AlphaModel[].class);
//    }

    public List<AlphaModel> getAlphaValues(String url){

        AlphaHigherModel model = restTemplate.getForObject(url, AlphaHigherModel.class);
        return model.getRates();
    }

}
