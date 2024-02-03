package syberry.hackathon.bot.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class StepCombination {

    private String bankName;

    private String currency;

//    public StepCombination(String bankName) {
//        this.bankName = bankName;
//    }

}
