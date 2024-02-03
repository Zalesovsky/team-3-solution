package syberry.hackathon.bank.entity;

import lombok.Data;
import syberry.hackathon.bank.entity.enums.BankType;

@Data
public abstract class BankEntity {
    private String name;
    private BankType bankType;
}
