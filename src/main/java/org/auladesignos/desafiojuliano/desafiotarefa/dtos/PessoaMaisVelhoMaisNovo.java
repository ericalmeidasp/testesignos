package org.auladesignos.desafiojuliano.desafiotarefa.dtos;

import org.auladesignos.desafiojuliano.desafiotarefa.Pessoa;

public class PessoaMaisVelhoMaisNovo {
    private final Pessoa maisVelho;
    private final Pessoa maisNovo;

    public PessoaMaisVelhoMaisNovo(Pessoa maisVelho, Pessoa maisNovo) {
        this.maisVelho = maisVelho;
        this.maisNovo = maisNovo;
    }

    public Pessoa getMaisNovo() {
        return maisNovo;
    }

    public Pessoa getMaisVelho() {
        return maisVelho;
    }
}
