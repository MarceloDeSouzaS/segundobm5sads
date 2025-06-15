package com.example.jwt.controller;

import com.example.jwt.Dto.AuthenticationDto;
import com.example.jwt.Dto.LoginResponseDto;
import com.example.jwt.Dto.PessoaDto;
import com.example.jwt.Dto.RegisterDto;
import com.example.jwt.infra.security.TokenService;
import com.example.jwt.model.Pessoa;
import com.example.jwt.repository.PessoaRepository;
import com.example.jwt.service.PessoaService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthController {
    @Autowired
    private PessoaService pessoaService;
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    PessoaRepository pessoaRepository;
    @Autowired
    TokenService tokenService;

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody @Valid RegisterDto dto) {
        if(pessoaRepository.findByLogin(dto.login()) != null ) return ResponseEntity.badRequest().build();

        String senhaEncrpitografada = new BCryptPasswordEncoder().encode(dto.password());
        Pessoa pessoa = new Pessoa(senhaEncrpitografada, dto.login(), dto.role());

        pessoaRepository.save(pessoa);
        return ResponseEntity.ok().build();

    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody @Valid AuthenticationDto dto) {
        var user = new UsernamePasswordAuthenticationToken(dto.login(), dto.password());
        var auth = this.authenticationManager.authenticate(user);
        var token = tokenService.generateToken((Pessoa)auth.getPrincipal());

        return ResponseEntity.ok(new LoginResponseDto(token));
    }
}
