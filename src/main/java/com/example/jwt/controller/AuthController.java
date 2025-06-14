package com.example.jwt.controller;

import com.example.jwt.Dto.PessoaDto;
import com.example.jwt.service.PessoaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthController {
    @Autowired
    private PessoaService pessoaService;

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody PessoaDto dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(pessoaService.salvar(dto.ToModel()));
    }
}
