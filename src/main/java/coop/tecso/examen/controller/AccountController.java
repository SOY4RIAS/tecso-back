package coop.tecso.examen.controller;

import coop.tecso.examen.exception.AppException;
import coop.tecso.examen.model.Account;
import coop.tecso.examen.model.dto.AccountRequest;
import coop.tecso.examen.service.AccountService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/account")
public class AccountController {

    private static final Logger logger = LogManager.getLogger(AuthController.class);

    @Autowired
    private AccountService accountService;


    @PostMapping(path = "save")
    public ResponseEntity<Account> accountSave(@RequestBody Account account) {
        return accountService.saveAccount(account)
                .map(accountSave -> {
                    logger.info("Created new Account: " + accountSave.toString());
                    return ResponseEntity.ok(accountSave);
                })
                .orElseThrow(() -> new AppException("Unexpected error during save account. Please try again"));
    }

    @PutMapping(path = "update")
    public ResponseEntity<Account> accountUpdate(@RequestBody AccountRequest accountRequest){
        return accountService.updateAccount(accountRequest)
                .map(account -> {
                    logger.info("Update Account: " + account.toString());
                    return ResponseEntity.ok(account);
                })
                .orElseThrow(() -> new AppException("Unexpected error during update account. Please try again"));
    }
}
