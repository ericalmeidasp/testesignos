package org.auladesignos.desafiojuliano.desafiotarefa;

import org.auladesignos.sistemasignoslucas.Signos;

import java.time.*;

public class Pessoa {
    private String nome;
    private ZoneId localNascimento;
    private LocalDate dataNascimento;
    private Signos signo;
    private Integer idade;
    private Geracao geracao;

    public Pessoa(String nome, ZoneId localNascimento, LocalDate dataNascimento) {
        this.nome = nome;
        this.localNascimento = localNascimento;
        this.dataNascimento = dataNascimento;
        MonthDay yearMonth = MonthDay.of(dataNascimento.getMonth(), dataNascimento.getDayOfMonth());
        this.signo = Signos.getSigno(yearMonth);
        Period period = Period.between(dataNascimento, LocalDate.now());
        this.idade = period.getYears();
        this.geracao = Geracao.getGeracao(dataNascimento);
    }

    public String getNome() {
        return nome;
    }

    public ZoneId getLocalNascimento() {
        return localNascimento;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public Signos getSigno() {
        return signo;
    }

    public Integer getIdade() {
        return idade;
    }

    public void setIdade(Integer idade) {
        this.idade = idade;
    }

    public Geracao getGeracao() {
        return geracao;
    }

    @Override
    public String toString() {
        return "Pessoa{" +
                "nome='" + nome + '\'' +
                ", localNascimento=" + localNascimento +
                ", dataNascimento=" + dataNascimento +
                ", signo=" + signo +
                ", idade=" + idade +
                ", geracao=" + geracao +
                '}';
    }
}

//- Nome
//        - Cidade de nascimento
//        - Data de nascimento
//        - Signo (com base na data de nascimento)
//        - Idade (com base na data de nascimento)
//        - Geração (X, Y, Z ou Boomer, com base na data de nascimento)