package syberry.hackathon.bank.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

public class BankEntity {
    private String name;

    public BankEntity(){
    }

    public BankEntity(String name) {
        this.name = name;
    }

    public String getName(){
        return name;
    }
}
