package br.com.ServiceFinancial.controller;

import br.com.ServiceFinancial.dto.users.UserRequestDTO;
import br.com.ServiceFinancial.dto.users.UserResponseDTO;
import br.com.ServiceFinancial.service.FinancialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {

    @Autowired
    private FinancialService service;

    @PostMapping(value = "/v1/User")
    public ResponseEntity<UserResponseDTO> createUser(@RequestBody UserRequestDTO request){
        return ResponseEntity.status(HttpStatus.CREATED).body(service.createUser(request));
    }

    @GetMapping(value = "/v1/User/{id}")
    public ResponseEntity<UserResponseDTO> getUserById(@PathVariable("id") Long id){
        return ResponseEntity.status(HttpStatus.OK).body(service.getUserById(id));
    }

    @DeleteMapping(value = "/v1/User/{id}")
    public ResponseEntity<Void> deleteUserById(@PathVariable("id") Long id){
        service.deleteUserById(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
