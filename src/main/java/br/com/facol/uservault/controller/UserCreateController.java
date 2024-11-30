package br.com.facol.uservault.controller;

import br.com.facol.uservault.dto.UserCreateRequestDTO;
import br.com.facol.uservault.dto.UserCreateResponseDTO;
import br.com.facol.uservault.service.UserCreateService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserCreateController {

    private final UserCreateService service;

    @Autowired
    private UserCreateService userCreateService;

    // Construtor para injeção de dependência
    public UserCreateController(UserCreateService service) {
        this.service = service;
    }

    // Método para listar todos os usuários (apenas administradores)
    @GetMapping
    @PreAuthorize("hasRole('ADMIN')") // Somente administradores podem acessar
    public ResponseEntity<List<UserCreateResponseDTO>> listUsers() {
        List<UserCreateResponseDTO> users = userCreateService.findAllUsers();
        return ResponseEntity.ok(users);
    }

    // Método para criar um novo usuário
    @PostMapping
    public ResponseEntity<UserCreateResponseDTO> create(@RequestBody UserCreateRequestDTO userCreateRequestDTO) {
        UserCreateResponseDTO response = service.create(userCreateRequestDTO);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    // Método alternativo para listar todos os usuários (rota diferenciada)
    @GetMapping("/all")
    public ResponseEntity<List<UserCreateResponseDTO>> listAll() {
        List<UserCreateResponseDTO> users = service.findAll();
        return ResponseEntity.ok(users);
    }

}
