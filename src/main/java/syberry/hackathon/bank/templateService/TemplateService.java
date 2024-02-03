package syberry.hackathon.bank.templateService;

import org.springframework.web.client.RestTemplate;
import syberry.hackathon.bank.BnbApi.NrbModel;

public class TemplateService {

    RestTemplate restTemplate = new RestTemplate();

    public String getStringJson(String url){

        return restTemplate.getForObject(url, String.class);
    }

    public NrbModel[] getNRBValues(String url){
        return restTemplate.getForObject(url, NrbModel[].class);

    }

}
