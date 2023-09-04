package br.com.caixa.domain.models.records;

import java.time.LocalDate;
import java.time.LocalDateTime;

public record DataRequisicaoDTO(LocalDateTime dataInicio, LocalDateTime dataFim) {
}
