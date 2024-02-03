package syberry.hackathon.bank.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import syberry.hackathon.bank.entity.enums.BankType;
import syberry.hackathon.bank.service.impl.AlfaBankServiceImpl;
import syberry.hackathon.bank.service.impl.BelarusBankServiceImpl;
import syberry.hackathon.bank.service.impl.MainServiceImpl;
import syberry.hackathon.bank.service.impl.NationalBankServiceImpl;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("api/banks")
public class BankController {
    private final MainServiceImpl mainService;
    private final AlfaBankServiceImpl alfaBankbankService;
    private final BelarusBankServiceImpl belarusBankService;
    private final NationalBankServiceImpl nationalBankService;

    public BankController(
            MainServiceImpl mainService,
            AlfaBankServiceImpl alfaBankbankService,
            BelarusBankServiceImpl belarusBankService,
            NationalBankServiceImpl nationalBankService) {
        this.mainService = mainService;
        this.alfaBankbankService = alfaBankbankService;
        this.belarusBankService = belarusBankService;
        this.nationalBankService = nationalBankService;
    }

    @RequestMapping("")
    public ResponseEntity<?> getAllBanks() {
        return ResponseEntity.ok(mainService.getAllBankNames());
    }

    @RequestMapping("/{bankName}/currencies")
    public ResponseEntity<?> getBankCurrencies(@PathVariable String bankName) {
        ResponseEntity<?> responseEntity;
        switch (BankType.fromString(bankName)) {
            case ALFA_BANK -> responseEntity = ResponseEntity.ok(alfaBankbankService.getAllCurrencies());
            case BELARUSBANK -> responseEntity = ResponseEntity.ok(belarusBankService.getAllCurrencies());
            case NATIONAL_BELARUS_BANK -> responseEntity = ResponseEntity.ok(nationalBankService.getAllCurrencies());
            default -> responseEntity = new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return responseEntity;

    }
    @RequestMapping("/{bankName}/rate/{date}")
    public ResponseEntity<?> getBankRateForDate(@PathVariable String bankName,@PathVariable String date) {
        ResponseEntity<?> responseEntity;
        switch (BankType.fromString(bankName)) {
            case ALFA_BANK -> responseEntity = ResponseEntity.ok(alfaBankbankService.getAllCurrencies());
            case BELARUSBANK -> responseEntity = ResponseEntity.ok(belarusBankService.getAllCurrencies());
            case NATIONAL_BELARUS_BANK -> responseEntity = ResponseEntity.ok(nationalBankService.getRateForDate(date));
            default -> responseEntity = new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return responseEntity;

    }
}
