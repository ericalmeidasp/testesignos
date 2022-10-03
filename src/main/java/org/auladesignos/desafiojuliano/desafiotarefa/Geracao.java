package org.auladesignos.desafiojuliano.desafiotarefa;

import java.time.LocalDate;
import java.time.Year;

public enum Geracao {
    X(Year.of(1980)),
    Y(Year.of(1990)),
    Z(Year.of(2000)),
    BOOMER(Year.of(2010));

    private Year year;

    Geracao(Year year) {
        this.year = year;
    }

    public Year getYear() {
        return year;
    }

    public static Geracao getGeracao(LocalDate nascimento) {
        for (Geracao geracao : Geracao.values()) {
            if (nascimento.getYear() < geracao.getYear().getValue()) {
                return geracao;
            }
        }
        throw new RuntimeException("Pessoa muito nova");
    }
}
