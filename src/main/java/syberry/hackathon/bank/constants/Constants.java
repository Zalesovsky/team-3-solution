package syberry.hackathon.bank.constants;

import syberry.hackathon.bank.entity.BankEntity;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Constants {
    public static Set<BankEntity> banks = new HashSet<>(
            Arrays.asList(
                    new BankEntity(
                            "Нацбанк Республики Беларусь"),
                    new BankEntity(
                            "Альфа-Банк"),
                    new BankEntity(
                            "Беларусбанк")
            ));
}
