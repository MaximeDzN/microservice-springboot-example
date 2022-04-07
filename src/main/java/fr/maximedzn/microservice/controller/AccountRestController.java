package fr.maximedzn.microservice.controller;

import fr.maximedzn.microservice.domain.Account.Account;
import fr.maximedzn.microservice.dto.TransferRequestDto;
import fr.maximedzn.microservice.repository.AccountRepository;
import fr.maximedzn.microservice.service.AccountService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("accounts")
public class AccountRestController {

    private AccountService accountService;

    public AccountRestController(AccountService accountService) {
        this.accountService = accountService;
    }

    @PutMapping("transfer")
    public void transfer(@RequestBody TransferRequestDto transferRequestDto){
       accountService.transfer(
               transferRequestDto.getCodeFrom(),
               transferRequestDto.getCodeTo(),
               transferRequestDto.getBalance());
    }


}
