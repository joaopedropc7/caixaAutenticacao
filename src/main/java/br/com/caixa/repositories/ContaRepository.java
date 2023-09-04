package br.com.caixa.repositories;

import br.com.caixa.domain.models.Conta;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContaRepository extends JpaRepository<Conta, Integer> {
}
