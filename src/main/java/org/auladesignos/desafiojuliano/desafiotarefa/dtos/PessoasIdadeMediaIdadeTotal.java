package org.auladesignos.desafiojuliano.desafiotarefa.dtos;

public class PessoasIdadeMediaIdadeTotal {

    private Integer idadeMedia;
    private Integer idadeTotal;

    public PessoasIdadeMediaIdadeTotal(Integer idadeMedia, Integer idadeTotal) {
        this.idadeMedia = idadeMedia;
        this.idadeTotal = idadeTotal;
    }

    public Integer getIdadeMedia() {
        return idadeMedia;
    }

    public Integer getIdadeTotal() {
        return idadeTotal;
    }
}
