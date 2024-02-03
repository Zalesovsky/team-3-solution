package syberry.hackathon.bank.controller;

import org.apache.coyote.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
@RequestMapping("api/banks")
public class BankController {

    @RequestMapping("")
    ResponseEntity<?> getAllBanks(){
        return ResponseEntity.ok("");
    }
}
