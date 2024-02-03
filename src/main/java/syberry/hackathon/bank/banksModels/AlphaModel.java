package syberry.hackathon.bank.banksModels;

import com.fasterxml.jackson.annotation.JsonProperty;

public class AlphaModel {

    @JsonProperty("name")
    public String name;
    @JsonProperty("buyRate")
    public double rate;


    public String getName(){
        return name;
    }
    public double getRate(){return rate;}
}
