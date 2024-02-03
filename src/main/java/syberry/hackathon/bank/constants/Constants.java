package syberry.hackathon.bank.constants;

import syberry.hackathon.bank.entity.BankEntity;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Constants {
    public static Set<BankEntity> banks = new HashSet<>(
            Arrays.asList(
                    new BankEntity(
                            "Нацбанк Республики Беларусь",
                            "https://api.nbrb.by/exrates/currencies"),
                    new BankEntity(
                            "Альфа-Банк",
                            "https://developerhub.alfabank.by:8273/partner/1.0.1/public/rates"),
                    new BankEntity(
                            "Беларусбанк",
                            "https://belarusbank.by/api/kurs_cards")
            ));
}
