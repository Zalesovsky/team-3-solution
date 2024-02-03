package syberry.hackathon.bank.service.impl;

import org.springframework.stereotype.Service;
import syberry.hackathon.bank.constants.BankConstants;

import java.util.Set;

@Service
public class BankNamesServiceImpl {
    public Set<String> getAllBankNames(){
        return BankConstants.banks;
    }
}
