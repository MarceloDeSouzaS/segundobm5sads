package com.example.jwt.controller;

import com.example.jwt.Dto.PessoaDto;
import com.example.jwt.model.Pessoa;
import com.example.jwt.repository.PessoaRepository;
import com.example.jwt.service.PessoaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("pessoa")
public class PessoaController {

    @Autowired
    PessoaService pessoaService;

    @PostMapping()
    ResponseEntity<Pessoa> cadastrar(@RequestBody PessoaDto dto){
        return ResponseEntity.status(HttpStatus.CREATED).body(pessoaService.salvar(dto.ToModel()));
    }
}
