package org.auladesignos.desafiojuliano.desafiotarefa;

import org.auladesignos.desafiojuliano.desafiotarefa.dtos.PessoaMaiorMenorIdade;
import org.auladesignos.desafiojuliano.desafiotarefa.dtos.PessoaMaisVelhoMaisNovo;
import org.auladesignos.desafiojuliano.desafiotarefa.dtos.PessoasIdadeMediaIdadeTotal;
import org.auladesignos.sistemasignoslucas.Signos;

import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
import java.util.*;
import java.util.stream.Collectors;

public class Desafio03OutubroApplication {

    public static List<Pessoa> grupoItalia = new ArrayList<>();

    public static void main(String[] args) {
        grupoItalia.add(new Pessoa("Caique", ZoneId.of("America/Sao_Paulo"), LocalDate.of(1996, 5, 3)));
        grupoItalia.add(new Pessoa("Cristiano", ZoneId.of("America/Sao_Paulo"), LocalDate.of(1972, 12, 20)));
        grupoItalia.add(new Pessoa("Davi", ZoneId.of("America/Sao_Paulo"), LocalDate.of(1992, 10, 29)));
        grupoItalia.add(new Pessoa("Daiane", ZoneId.of("America/Sao_Paulo"), LocalDate.of(1989, 7, 2)));
        grupoItalia.add(new Pessoa("Eric", ZoneId.of("America/Sao_Paulo"), LocalDate.of(2009, 10, 1)));
        grupoItalia.add(new Pessoa("João", ZoneId.of("America/Fortaleza"), LocalDate.of(1995, 3, 17)));

        List<Pessoa> pessoasPorSignoEidade = getPessoasPorSignoEIdadeMaiorQue(Signos.TOURO, 20);
        PessoaMaiorMenorIdade pessoaMaiorMenorIdade = getPessoaMaiorMenorIdade();
        List<Pessoa> pessoasPorGeracao = getPessoasPorGeracao(Geracao.Y);
        PessoaMaisVelhoMaisNovo pessoaMaisVelhoMaisNovo = getPessoaMaisVelhaEMaisNova();
        List<Pessoa> pessoasIdadeProximaCopaDoMundo = getPessoasIdadeProximaCopaDoMundo();
        PessoasIdadeMediaIdadeTotal pessoasIdadeMediaIdadeTotal = exibirIdadeMediaEIdadeTotal();

        System.out.println("=========================");

        System.out.println("PESSOAS POR SIGNOS E IDADE MAIOR QUE (TOURO, 20)");
        pessoasPorSignoEidade.forEach(System.out::println);
        System.out.println();
        System.out.println("PESSOAS MAIORES DE 18 ANOS DE IDADE");
        pessoaMaiorMenorIdade.getMaioresDeIdade().forEach(System.out::println);
        System.out.println();
        System.out.println("PESSOAS MENORES DE 18 ANOS DE IDADE");
        pessoaMaiorMenorIdade.getMenoresDeIdade().forEach(System.out::println);
        System.out.println();
        System.out.println("PESSOAS POR GERACAO (Y)");
        pessoasPorGeracao.forEach(System.out::println);
        System.out.println();
        System.out.println("PESSOAS MAIS VELHA");
        System.out.println(pessoaMaisVelhoMaisNovo.getMaisVelho());
        System.out.println();
        System.out.println("PESSOAS MAIS NOVA");
        System.out.println(pessoaMaisVelhoMaisNovo.getMaisNovo());
        System.out.println();
        System.out.println("PESSOAS - IDADE PROX COPA DO MUNDO (2026 - JULHO)");
        pessoasIdadeProximaCopaDoMundo.forEach(System.out::println);
        System.out.println();
        System.out.println("PESSOAS - IDADE MEDIA");
        System.out.println(pessoasIdadeMediaIdadeTotal.getIdadeMedia());
        System.out.println();
        System.out.println("PESSOAS - IDADE TOTAL");
        System.out.println(pessoasIdadeMediaIdadeTotal.getIdadeTotal());

    }


    static List<Pessoa> getPessoasPorSignoEIdadeMaiorQue(Signos signo, Integer anos) {
        return grupoItalia
                .stream()
                .filter(pessoa -> pessoa.getSigno().equals(signo))
                .filter(pessoa -> pessoa.getIdade() >= anos)
                .collect(Collectors.toList());
    }

    static PessoaMaiorMenorIdade getPessoaMaiorMenorIdade() {
        List<Pessoa> maioresDeIdade = grupoItalia.stream()
                .filter(pessoa -> pessoa.getIdade() >= 18)
                .collect(Collectors.toList());

        List<Pessoa> menoresDeIdade = grupoItalia.stream()
                .filter(pessoa -> pessoa.getIdade() < 18)
                .collect(Collectors.toList());

        return new PessoaMaiorMenorIdade(maioresDeIdade, menoresDeIdade);
    }

    static List<Pessoa> getPessoasPorGeracao(Geracao geracao) {
        return grupoItalia
                .stream()
                .filter(pessoa -> pessoa.getGeracao().equals(geracao))
                .collect(Collectors.toList());
    }

    static List<Pessoa> getPessoasIdadeProximaCopaDoMundo() {

        return grupoItalia.stream()
                .map(pessoa -> {
                    Period period = Period.between(pessoa.getDataNascimento(), LocalDate.of(2026, 7, 10));
                    Pessoa pessoa1 = new Pessoa(pessoa.getNome(), pessoa.getLocalNascimento(), pessoa.getDataNascimento());
                    pessoa1.setIdade(period.getYears());
                    return pessoa1;
                })
                .collect(Collectors.toList());
    }

    static PessoaMaisVelhoMaisNovo getPessoaMaisVelhaEMaisNova() {
        Pessoa maisVelho = grupoItalia
                .stream()
                .max(Comparator.comparingInt(Pessoa::getIdade))
                .orElseThrow();

        Pessoa maisNovo = grupoItalia
                .stream()
                .min(Comparator.comparingInt(Pessoa::getIdade))
                .orElseThrow();

        return new PessoaMaisVelhoMaisNovo(maisVelho, maisNovo);
    }

    static PessoasIdadeMediaIdadeTotal exibirIdadeMediaEIdadeTotal() {
        Double mediaIdade = grupoItalia.stream()
                .mapToInt(Pessoa::getIdade)
                .average()
                .orElse(-1);


        Integer totalIdade = grupoItalia.stream()
                .mapToInt(Pessoa::getIdade)
                .reduce((acc, op) -> acc + op)
                .orElse(-1);

        return new PessoasIdadeMediaIdadeTotal(mediaIdade.intValue(), totalIdade);
    }

}
