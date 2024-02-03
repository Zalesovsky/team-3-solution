package syberry.hackathon.bank.banksModels;

import com.fasterxml.jackson.annotation.JsonProperty;

public class AlphaModel {

    @JsonProperty("name")
    public String name;

    public String getName(){
        return name;
    }
}
