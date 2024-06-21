package br.com.ServiceFinancial.controller;

import br.com.ServiceFinancial.dto.account.AccountFilterResponseDTO;
import br.com.ServiceFinancial.dto.account.AccountRequestDTO;
import br.com.ServiceFinancial.dto.account.AccountResponseDTO;
import br.com.ServiceFinancial.service.FinancialService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
public class AccountController {

    private final FinancialService financialService;

    @PostMapping(value = "/v1/account")
    public ResponseEntity<AccountResponseDTO> createAccount(@RequestBody AccountRequestDTO request) {
        return ResponseEntity.status(HttpStatus.CREATED).body(financialService.createAccount(request));
    }

    @PostMapping(value = "/v1/account/all")
    public ResponseEntity<List<AccountResponseDTO>> createAllAccount(@RequestBody List<AccountRequestDTO> request) {
        return ResponseEntity.status(HttpStatus.CREATED).body(financialService.createAllAccount(request));
    }

    @PostMapping(value = "/v1/account/pay/{userId}/{accountId}")
    public ResponseEntity<AccountResponseDTO> paymentAccount(@PathVariable("userId") Long userId,
                                                             @PathVariable("accountId") Long accountId) {
        return ResponseEntity.status(HttpStatus.OK).body(financialService.paymentAccount(userId, accountId));
    }

    @PutMapping(value = "/v1/account/{userId}/{accountId}")
    public ResponseEntity<AccountResponseDTO> updateAccount(@PathVariable("userId") Long userId,
                                                            @PathVariable("accountId") Long accountId,
                                                            @RequestBody AccountRequestDTO request) {
        return ResponseEntity.status(HttpStatus.OK).body(financialService.updateAccount(userId, accountId, request));
    }

    @DeleteMapping(value = "/v1/account/{userId}/{accountId}")
    public ResponseEntity<Void> deleteAccount(@PathVariable("userId") Long userId, @PathVariable("accountId") Long accountId) {
        financialService.deleteAccount(userId, accountId);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @GetMapping(value = "/v1/account")
    public ResponseEntity<AccountFilterResponseDTO> getAccount(@RequestParam(value = "page", defaultValue = "0") Integer page,
                                                               @RequestParam(value = "size", defaultValue = "20") Integer size,
                                                               @RequestParam(value = "sort", defaultValue = "asc") String sort,
                                                               @RequestParam(value = "name", required = false) String name,
                                                               @RequestParam(value = "userId", required = false) String userId,
                                                               @RequestParam(value = "monthId", required = false) String monthId,
                                                               @RequestParam(value = "year", required = false) String year,
                                                               @RequestParam(value = "categoryId", required = false) String categoryId,
                                                               @RequestParam(value = "subCategoryId", required = false) String subCategoryId) {

        var response = financialService.getAccount(page, size, sort, name, userId, monthId, year, categoryId, subCategoryId);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @GetMapping(value = "/v1/account/{userId}/{accountId}")
    public ResponseEntity<AccountResponseDTO> getAccountByUserIdAndAccountId(@PathVariable("userId") Long userId,
                                                                             @PathVariable("accountId") Long accountId) {
        return ResponseEntity.status(HttpStatus.OK).body(financialService.getAccountByUserIdAndAccountId(userId, accountId));
    }
}
