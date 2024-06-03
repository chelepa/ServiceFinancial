package br.com.ServiceFinancial.controller;

import br.com.ServiceFinancial.dto.account_bank.AccountBankRequestDTO;
import br.com.ServiceFinancial.dto.account_bank.AccountBankResponseDTO;
import br.com.ServiceFinancial.service.FinancialService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
public class AccountBankController {

    private final FinancialService financialService;

    @PostMapping(value = "/v1/account/bank")
    public ResponseEntity<AccountBankResponseDTO> createAccountBank(@RequestBody AccountBankRequestDTO request) {
        return ResponseEntity.status(HttpStatus.CREATED).body(financialService.createAccountBank(request));
    }

    @GetMapping(value = "/v1/account/bank/{userId}")
    public ResponseEntity<List<AccountBankResponseDTO>> getAccountBankByUserId(@PathVariable("userId") Long userId){
        return ResponseEntity.status(HttpStatus.OK).body(financialService.getAccountBankByUserId(userId));
    }

    @GetMapping(value = "/v1/account/bank/{userId}/{id}")
    public ResponseEntity<AccountBankResponseDTO> getAccountBankByUserIdAndId(@PathVariable("userId") Long userId, @PathVariable("id") Long id){
        return ResponseEntity.status(HttpStatus.OK).body(financialService.getAccountBankByUserIdAndId(userId, id));
    }

    @PutMapping(value = "/v1/account/bank/{userId}/{id}")
    public ResponseEntity<AccountBankResponseDTO> updateAccountBankByUserIdAndId(@PathVariable("userId") Long userId, @PathVariable("id") Long id, @RequestBody AccountBankRequestDTO request){
        return ResponseEntity.status(HttpStatus.OK).body(financialService.updateAccountBankByUserIdAndId(userId, id, request));
    }

    @DeleteMapping(value = "/v1/account/bank/{userId}/{id}")
    public ResponseEntity<Void> deleteAccountBankByUserIdAndId(@PathVariable("userId") Long userId, @PathVariable("id") Long id){
        financialService.deleteAccountBankByUserIdAndId(userId, id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
