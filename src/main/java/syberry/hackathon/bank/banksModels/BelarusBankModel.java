package syberry.hackathon.bank.banksModels;

import com.fasterxml.jackson.annotation.JsonProperty;

public class BelarusBankModel {

    @JsonProperty("USDCARD_in")
    private double usdRate;


    @JsonProperty("EURCARD_in")
    private double eurRate;

    @JsonProperty("RUBCARD_in")
    private double rubRate;

    public double getUsdRate(){
        return usdRate;
    }
    public double getEurRate(){
        return eurRate;
    }
    public double getRubRate(){
        return rubRate;
    }
}
