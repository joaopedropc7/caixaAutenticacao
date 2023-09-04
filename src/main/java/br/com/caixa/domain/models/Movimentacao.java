package br.com.caixa.domain.models;

import br.com.caixa.domain.models.records.MovimentacaoRecord;
import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.Objects;

@Entity
@Table(name = "movimentacao")
public class Movimentacao {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer id;;
    private Double valor;
    private TipoReceita tipoReceita;
    @ManyToOne
    @JoinColumn(name = "conta_id")
    private Conta conta;
    private String historico;
    private LocalDateTime dataMovimentacao;

    public Movimentacao() {
    }

    public Movimentacao(MovimentacaoRecord movimentacaoRecord, Conta contaVO) {
        this.valor = movimentacaoRecord.valor();
        this.conta =  contaVO;
        this.tipoReceita = movimentacaoRecord.tipoReceita();
        this.historico = movimentacaoRecord.historico();
        this.dataMovimentacao = LocalDateTime.now();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public LocalDateTime getDataMovimentacao() {
        return dataMovimentacao;
    }

    public void setDataMovimentacao(LocalDateTime dataMovimentacao) {
        this.dataMovimentacao = dataMovimentacao;
    }

    public Conta getConta() {
        return conta;
    }

    public String getHistorico() {
        return historico;
    }

    public void setHistorico(String historico) {
        this.historico = historico;
    }

    public void setConta(Conta conta) {
        this.conta = conta;
    }

    public TipoReceita getTipoReceita() {
        return tipoReceita;
    }

    public void setTipoReceita(TipoReceita tipoReceita) {
        this.tipoReceita = tipoReceita;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Movimentacao that = (Movimentacao) o;
        return Objects.equals(id, that.id) && Objects.equals(valor, that.valor) && tipoReceita == that.tipoReceita && Objects.equals(conta, that.conta) && Objects.equals(historico, that.historico) && Objects.equals(dataMovimentacao, that.dataMovimentacao);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, valor, tipoReceita, conta, historico, dataMovimentacao);
    }
}
