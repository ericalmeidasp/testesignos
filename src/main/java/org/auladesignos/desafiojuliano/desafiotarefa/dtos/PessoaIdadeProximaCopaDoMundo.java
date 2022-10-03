package org.auladesignos.desafiojuliano.desafiotarefa.dtos;

import org.auladesignos.desafiojuliano.desafiotarefa.Pessoa;

public class PessoaIdadeProximaCopaDoMundo {
    private Pessoa pessoa;
    private Integer idadeProximaCopa;

    public PessoaIdadeProximaCopaDoMundo(Pessoa pessoa, Integer idadeProximaCopa) {
        this.pessoa = pessoa;
        this.idadeProximaCopa = idadeProximaCopa;
    }

    public Integer getIdadeProximaCopa() {
        return idadeProximaCopa;
    }
}
