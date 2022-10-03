package org.auladesignos.desafiojuliano.desafiotarefa.dtos;

import org.auladesignos.desafiojuliano.desafiotarefa.Pessoa;

import java.util.List;

public class PessoaMaiorMenorIdade {
    private List<Pessoa> maioresDeIdade;
    private List<Pessoa> menoresDeIdade;

    public PessoaMaiorMenorIdade(List<Pessoa> maioresDeIdade, List<Pessoa> menoresDeIdade) {
        this.maioresDeIdade = maioresDeIdade;
        this.menoresDeIdade = menoresDeIdade;
    }

    public List<Pessoa> getMaioresDeIdade() {
        return maioresDeIdade;
    }

    public List<Pessoa> getMenoresDeIdade() {
        return menoresDeIdade;
    }
}
