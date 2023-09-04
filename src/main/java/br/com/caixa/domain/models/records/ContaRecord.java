package br.com.caixa.domain.models.records;

import br.com.caixa.domain.models.TipoConta;

public record ContaRecord(String nomeConta, Integer idGrupo, TipoConta tipoConta) {
}
