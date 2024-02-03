package syberry.hackathon.bank.templateService;

import org.springframework.web.client.RestTemplate;

public class templateService {

    RestTemplate restTemplate = new RestTemplate();

    public String getStringJson(String url){
        return restTemplate.getForObject(url, String.class);
    }

}
