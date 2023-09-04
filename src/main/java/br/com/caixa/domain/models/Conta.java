package br.com.caixa.domain.models;

import br.com.caixa.domain.models.records.ContaRecord;
import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "conta")
public class Conta {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer id;
    private String nomeConta;
    @ManyToOne
    @JoinColumn(name = "grupo_id")
    private Grupo grupo;
    private TipoConta tipoConta;

    public Conta() {
    }

    public Conta(ContaRecord contaRecord, Grupo grupo) {
        this.nomeConta = contaRecord.nomeConta();
        this.grupo = grupo;
        this.tipoConta = contaRecord.tipoConta();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNomeConta() {
        return nomeConta;
    }

    public void setNomeConta(String nomeConta) {
        this.nomeConta = nomeConta;
    }

    public Grupo getGrupo() {
        return grupo;
    }

    public void setGrupo(Grupo grupo) {
        this.grupo = grupo;
    }

    public TipoConta getTipoConta() {
        return tipoConta;
    }

    public void setTipoConta(TipoConta tipoConta) {
        this.tipoConta = tipoConta;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Conta conta = (Conta) o;
        return Objects.equals(id, conta.id) && Objects.equals(nomeConta, conta.nomeConta) && Objects.equals(grupo, conta.grupo) && tipoConta == conta.tipoConta;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nomeConta, grupo, tipoConta);
    }
}
