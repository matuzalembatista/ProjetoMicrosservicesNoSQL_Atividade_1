package com.example.user_api.controller;

import org.springframework.web.bind.annotation.RestController;

import com.example.user_api.dto.UserDTO;

import jakarta.annotation.PostConstruct;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/user")
public class UserController {

    public static List<UserDTO> users = new ArrayList<UserDTO>();

    @PostConstruct
    public void initiateList() {
        UserDTO userDTO = new UserDTO();
        userDTO.setName("Eduardo");
        userDTO.setCpf("123");
        userDTO.setAdress("Rua a");
        userDTO.setEmail("eduardo@email.com");
        userDTO.setPhone("1234-3454");
        userDTO.setSignUpDate(LocalDateTime.now());
        users.add(userDTO);

    UserDTO anotherUserDTO = new UserDTO();
    anotherUserDTO.setName("Maria");
    anotherUserDTO.setCpf("456");
    anotherUserDTO.setAdress("Rua b");
    anotherUserDTO.setEmail("maria@email.com");
    anotherUserDTO.setPhone("5678-9101");
    anotherUserDTO.setSignUpDate(LocalDateTime.now());
    users.add(anotherUserDTO);
    }

    @GetMapping
    public List<UserDTO> getUsers() {
        return users;
    }

    @GetMapping("/{cpf}")
    public UserDTO getUserByCpf(@PathVariable String cpf) {
        return users.stream()
            .filter(user -> user.getCpf().equals(cpf))
            .findFirst()
            .orElseThrow(() -> new RuntimeException("User not found"));
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public UserDTO createUser(@Valid @RequestBody UserDTO userDTO) {
        userDTO.setSignUpDate(LocalDateTime.now());
        users.add(userDTO);
        return userDTO;
    }

    @DeleteMapping("/{cpf}")
    public boolean deleteUser(@PathVariable String cpf) {
        return users.removeIf(user -> user.getCpf().equals(cpf));
    }

}
