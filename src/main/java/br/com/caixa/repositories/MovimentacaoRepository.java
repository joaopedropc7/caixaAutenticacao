package br.com.caixa.repositories;

import br.com.caixa.domain.models.Grupo;
import br.com.caixa.domain.models.Movimentacao;
import br.com.caixa.domain.models.TipoReceita;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDateTime;
import java.util.List;

public interface MovimentacaoRepository extends JpaRepository<Movimentacao, Integer> {
    List<Movimentacao> findByTipoReceita(TipoReceita tipoReceita);
    List<Movimentacao> findByContaIdIn(List<Integer> contaId);

    @Query("SELECT m FROM Movimentacao m WHERE m.dataMovimentacao >= :dataInicio AND m.dataMovimentacao <= :dataFim")
    List<Movimentacao> findByDataMovimentacaoBetween(@Param("dataInicio") LocalDateTime dataInicio, @Param("dataFim") LocalDateTime dataFim);

    List<Movimentacao> findByConta_Grupo(Grupo grupo);

}
