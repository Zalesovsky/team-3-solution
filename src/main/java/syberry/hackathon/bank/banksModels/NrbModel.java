package syberry.hackathon.bank.banksModels;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class NrbModel {
    @JsonProperty("Cur_ID")
    private int curId;
    private int Cur_ParentID;
    private int Cur_Code;

    @JsonProperty("Cur_Abbreviaton")
    private String abbreviation;
    @JsonProperty("Cur_Name")
    private String curName;
    private int Cur_Name_Bel;
    private int Cur_Name_Eng;
    private int Cur_QoutName;
    private int Cur_QoutName_Bel;
    private int Cur_QoutName_Eng;
    private int Cur_NameMulti;
    private int Cur_Name_BelMulti;
    private int Cur_Name_EngMulti;
    private int Cur_Scale;
    private int Cur_Periodicity;
    private String Cur_DateStart;
    private String Cur_DateEnd;
    @JsonProperty("Cur_OfficialRate")
    private double curOfficialRate;

    public double getCurOfficialRate(){
        return curOfficialRate;
    }
    public String getAbbreviaton() {
        return abbreviation;
    }

    public String getCurName(){
        return curName;
    }
}
