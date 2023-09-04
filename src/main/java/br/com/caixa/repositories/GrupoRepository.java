package br.com.caixa.repositories;

import br.com.caixa.domain.models.Grupo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GrupoRepository extends JpaRepository<Grupo, Integer> {
}
