package syberry.hackathon.bank.service.impl;

import org.springframework.stereotype.Service;
import syberry.hackathon.bank.service.BankService;

import java.util.Arrays;
import java.util.List;
import java.util.Set;

@Service
public class BelarusBankServiceImpl implements BankService {


    @Override
    public Set<String> getAllCurrencies() {
        return Set.of("евро", "доллар", "российиский рубль", "белорусский рубль");
    }
}
