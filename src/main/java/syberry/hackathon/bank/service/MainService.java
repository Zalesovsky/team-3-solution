package syberry.hackathon.bank.service;

import syberry.hackathon.bank.constants.Constants;

import java.util.ArrayList;
import java.util.List;

public interface MainService {
    default List<String> getAllBankNames() {
        List<String> names = new ArrayList<>();
        Constants.banks.forEach((bank) -> names.add(bank.getName()));
        return names;
    }
}
