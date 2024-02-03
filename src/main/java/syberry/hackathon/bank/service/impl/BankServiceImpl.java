package syberry.hackathon.bank.service.impl;

import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Service;
import syberry.hackathon.bank.constants.Constants;
import syberry.hackathon.bank.entity.BankEntity;
import syberry.hackathon.bank.service.BankService;

import java.util.ArrayList;
import java.util.List;

@Service
public class BankServiceImpl implements BankService {
    private List<BankEntity> banks;

    public List<String> getAllBankNames() {
        List<String> names = new ArrayList<>();
        banks.forEach((bank) -> names.add(bank.getName()));
        return names;
    }

    @PostConstruct
    private void initConfig(){
        banks = new ArrayList<>(Constants.banks);
    }
}
