package syberry.hackathon.bank.controller;

import org.apache.coyote.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import syberry.hackathon.bank.service.impl.BankServiceImpl;

@RestController
@CrossOrigin
@RequestMapping("api/banks")
public class BankController {
    private final BankServiceImpl bankService;

    public BankController(BankServiceImpl bankService) {
        this.bankService = bankService;
    }

    @RequestMapping("")
    public ResponseEntity<?> getAllBanks() {
        return ResponseEntity.ok(bankService.getAllBankNames());
    }
}
