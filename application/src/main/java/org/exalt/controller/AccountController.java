package org.exalt.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.exalt.converter.AccountApiConverter;
import org.exalt.converter.TransactionApiConverter;
import org.exalt.dto.AccountResponse;
import org.exalt.dto.DepositRequest;
import org.exalt.dto.TransactionResponse;
import org.exalt.dto.WithdrawRequest;
import org.exalt.service.AccountService;
import org.exalt.service.DepositService;
import org.exalt.service.WithdrawService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/account")
@RequiredArgsConstructor
@Slf4j
public class AccountController {


    private final AccountService accountService;
    private final DepositService depositService;
    private final WithdrawService withdrawService;

    @GetMapping("/{id}")
    public ResponseEntity<AccountResponse> getAccount(@PathVariable UUID id) {
        log.info("Retrieve account");
        ResponseEntity.status(HttpStatus.OK);
        return ResponseEntity.ok(AccountApiConverter.toAccountResponse(accountService.getAccount(id)));
    }

    @GetMapping("/{id}/transaction/")
    public ResponseEntity<Set<TransactionResponse>> getTransaction(@PathVariable UUID id) {
        log.info("Retrieve transaction");
        ResponseEntity.status(HttpStatus.OK);
        return ResponseEntity.ok(accountService.getTransactions(id)
                .stream()
                .map(TransactionApiConverter::toTransactionResponse)
                .collect(Collectors.toSet()));
    }

    @PostMapping("/{id}/transaction/deposit/")
    ResponseEntity<String> deposit(@PathVariable UUID id, @RequestBody DepositRequest depositRequest) {
        log.info("Retrieve deposit");
        depositService.deposit(id, depositRequest.getAmount());
        ResponseEntity.status(HttpStatus.OK);
        return ResponseEntity.ok("deposit done");
    }

    @PostMapping("/{id}/transaction/withdraw/")
    ResponseEntity<String> withdraw(@PathVariable UUID id, @RequestBody WithdrawRequest withdrawRequest) {
        log.info("Retrieve transaction");
        withdrawService.withdraw(id, withdrawRequest.getAmount());
        ResponseEntity.status(HttpStatus.OK);
        return ResponseEntity.ok("withdraw done");
    }

}
