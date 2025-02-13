package com.example.DesafioMaxiprod.repository;

import com.example.DesafioMaxiprod.domain.CadPessoas;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CadPessoasRepository extends JpaRepository<CadPessoas,Integer> {
}
