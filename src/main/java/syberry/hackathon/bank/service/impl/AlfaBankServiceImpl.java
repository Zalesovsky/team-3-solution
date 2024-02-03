package syberry.hackathon.bank.service.impl;

import org.springframework.stereotype.Service;
import syberry.hackathon.bank.service.BankService;

import java.util.Arrays;
import java.util.List;

@Service
public class AlfaBankServiceImpl implements BankService {


    @Override
    public List<String> getAllCurrencies() {
        return Arrays.asList("alf bank");

    }
}
