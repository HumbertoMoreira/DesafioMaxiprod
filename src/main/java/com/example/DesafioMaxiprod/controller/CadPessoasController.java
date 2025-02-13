package com.example.DesafioMaxiprod.controller;

import com.example.DesafioMaxiprod.domain.CadPessoas;
import com.example.DesafioMaxiprod.dto.CadPessoasDto;
import com.example.DesafioMaxiprod.service.CadPessoaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/cadastropessoas")
public class CadPessoasController {

    @Autowired
    private CadPessoaService cadPessoaService;

    @PostMapping
    public ResponseEntity<Void> insert(@Validated @RequestBody CadPessoas cadPessoas){
        CadPessoas obj = cadPessoaService.insert(cadPessoas);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<CadPessoas> find(@PathVariable Integer id){
        CadPessoas cadPessoas = cadPessoaService.find(id);
        return ResponseEntity.ok(cadPessoas);
    }

    @GetMapping
    public ResponseEntity<List<Object>> findAll(){
        List<Object> list = cadPessoaService.findAll();
        return ResponseEntity.ok().body(list);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> update(@RequestBody CadPessoasDto dto, @PathVariable Integer id){
        CadPessoas obj = cadPessoaService.fromDto(dto);
        obj.setId(id);
        cadPessoaService.update(obj);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id){
        cadPessoaService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
