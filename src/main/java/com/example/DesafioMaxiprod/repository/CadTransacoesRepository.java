package com.example.DesafioMaxiprod.repository;

import com.example.DesafioMaxiprod.domain.CadTransacoes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CadTransacoesRepository extends JpaRepository<CadTransacoes, Integer> {
}
