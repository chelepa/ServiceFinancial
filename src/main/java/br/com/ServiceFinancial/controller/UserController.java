package br.com.ServiceFinancial.controller;

import br.com.ServiceFinancial.dto.user.UserRequestDTO;
import br.com.ServiceFinancial.dto.user.UserResponseDTO;
import br.com.ServiceFinancial.service.FinancialService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
public class UserController {

    private final FinancialService financialService;

    @PostMapping(value = "/v1/User")
    public ResponseEntity<UserResponseDTO> createUser(@RequestBody UserRequestDTO request) {
        return ResponseEntity.status(HttpStatus.CREATED).body(financialService.createUser(request));
    }

    @GetMapping(value = "/v1/User/{userId}")
    public ResponseEntity<UserResponseDTO> getUserById(@PathVariable("userId") Long userId){
        return ResponseEntity.status(HttpStatus.OK).body(financialService.getUserById(userId));
    }

    @DeleteMapping(value = "/v1/User/{userId}")
    public ResponseEntity<Void> deleteUser(@PathVariable("userId") Long userId) {
        financialService.deleteUserById(userId);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
