package com.example.DesafioMaxiprod.controller;

import com.example.DesafioMaxiprod.domain.CadTransacoes;
import com.example.DesafioMaxiprod.dto.CadTransacoesDto;
import com.example.DesafioMaxiprod.service.CadTransacoesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/cadastrotransacoes")
public class CadTransacoesController {

    @Autowired
    private CadTransacoesService cadTransacoesService;

    @PostMapping
    public ResponseEntity<Void> insert(@Validated @RequestBody CadTransacoes cadTransacoes){
        CadTransacoes obj = cadTransacoesService.insert(cadTransacoes);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getIdTransacoes()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<CadTransacoes> find(@PathVariable Integer id){
        CadTransacoes cadTransacoes = cadTransacoesService.find(id);
        return ResponseEntity.ok(cadTransacoes);
    }

    @GetMapping
    public ResponseEntity<List<CadTransacoes>> findAll(){
        List<CadTransacoes> list = cadTransacoesService.findAll();
        return ResponseEntity.ok().body(list);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> update(@RequestBody CadTransacoesDto dto, @PathVariable Integer id){
        CadTransacoes obj = cadTransacoesService.fromDto(dto);
        obj.setIdTransacoes(id);
        cadTransacoesService.update(obj);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id){
        cadTransacoesService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
