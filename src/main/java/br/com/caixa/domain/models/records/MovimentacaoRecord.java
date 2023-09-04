package br.com.caixa.domain.models.records;

import br.com.caixa.domain.models.TipoReceita;

public record MovimentacaoRecord(Integer idConta, Double valor, TipoReceita tipoReceita, String historico) {
}
