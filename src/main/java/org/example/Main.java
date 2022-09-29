package org.example;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class Main {

    public static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
    public static final DateTimeFormatter FORMATTER_SIGNO = DateTimeFormatter.ofPattern("dd/MM");

    public static void main(String[] args) {
        System.out.println("SIGNOS");
        System.out.println();

        LocalDateTime localDateTimeLucas = LocalDateTime.of(1993, 5, 11, 12, 30);

        System.out.println("IDADE DO LUCAS: ");
        Period period = Period.between(localDateTimeLucas.toLocalDate(), LocalDate.now());
        System.out.println(period.getYears() + " ANOS");

        System.out.println();

        System.out.println("SIGNO DO LUCAS: ");
        System.out.println(Signos.getSigno(MonthDay.of(localDateTimeLucas.getMonth(), localDateTimeLucas.getDayOfMonth())));

        System.out.println();

        System.out.println("NASCEU EM ANO BISSEXTO: ");
        System.out.println(Year.isLeap(localDateTimeLucas.getYear()));

        System.out.println("================= 29-09 ==============");

        List<LocalDateTime> aniversarios = new ArrayList<>();
        aniversarios.add(localDateTimeLucas);
        aniversarios.add(LocalDateTime.of(1994, 10, 1, 1, 30));
        aniversarios.add(LocalDateTime.of(1972, 12, 20, 1, 24));
        aniversarios.add(LocalDateTime.of(1992, 10, 29, 8, 12));
        aniversarios.add(LocalDateTime.of(1989, 7, 2, 6, 0));
        aniversarios.add(LocalDateTime.of(1995, 3, 17, 3, 30));
        aniversarios.add(LocalDateTime.of(1996, 5, 3, 19, 30));


        System.out.println();
        System.out.println("DATA FORMATADA");
        System.out.println("CLASSE ANONIMA");

        aniversarios.forEach(new Consumer<LocalDateTime>() {
            @Override
            public void accept(LocalDateTime localDateTime) {
                System.out.println(localDateTime.format(FORMATTER));
            }
        });

        System.out.println("LAMBDA");

        aniversarios.forEach((aniversario) -> System.out.println(aniversario.format(FORMATTER)));

        System.out.println("CONVENCIONAL");

        formatConvencional(aniversarios);

        System.out.println();
        System.out.println("GERAÇÃO Z");
        System.out.println("CLASSE ANONIMA");

        Predicate<LocalDateTime> informarGeracao = new Predicate<LocalDateTime>() {
            @Override
            public boolean test(LocalDateTime localDateTime) {
                int year = localDateTime.getYear();
                return year >= 1995 && year <= 2010;
            }
        };

        aniversarios.forEach(aniversario -> System.out.println("É DA GERAÇÃO Z?  " + informarGeracao.test(aniversario)));


        System.out.println("LAMBDA");


        var novaGeracao = aniversarios.stream().filter(data -> data.getYear() >= 1995 && data.getYear() <= 2010);
        novaGeracao.forEach(data -> System.out.println(data.getYear()));

        System.out.println("CONVENCIONAL");

        selecionaNovaGeracao(aniversarios);

        System.out.println();
        System.out.println("SUPPLIER PARA SIGNOS");
        System.out.println("CLASSE ANONIMA");

        Supplier<Signos[]> listarSignos = new Supplier<Signos[]>() {
            @Override
            public Signos[] get() {
                return Signos.values();
            }
        };

        for (int i = 0; i < listarSignos.get().length; i++) {
            System.out.println("NOME: " + listarSignos.get()[i] + " DATA INICIAL: " + listarSignos.get()[i].getInitDate().format(FORMATTER_SIGNO) +
                    "  --  DATA FINAL: " + listarSignos.get()[i].getLastDate().format(FORMATTER_SIGNO));
        }

        System.out.println("LAMBDA");

        Supplier<Signos[]> listarSignosLambda = () -> Signos.values();


        for (int i = 0; i < listarSignosLambda.get().length; i++) {
            System.out.println("NOME: " + listarSignosLambda.get()[i] + " DATA INICIAL: " + listarSignosLambda.get()[i].getInitDate().format(FORMATTER_SIGNO) +
                    "  --  DATA FINAL: " + listarSignosLambda.get()[i].getLastDate().format(FORMATTER_SIGNO));
        }

        System.out.println("CONVENCIONAL");

        imprimirSignos();

        System.out.println();
        System.out.println("ORDENAR DATA DE NASCIMENTO DO GRUPO");
        // System.out.println("CLASSE ANONIMA");

        aniversarios.sort(new Comparator<LocalDateTime>() {
            @Override
            public int compare(LocalDateTime o1, LocalDateTime o2) {
                if (o1.isAfter(o2)) {
                    return 1;
                } else if (o1.isBefore(o2)) {
                    return -1;
                } else {
                    return 0;
                }
            }
        });

        // System.out.println("LAMBDA");

        aniversarios.sort((o1, o2) -> {
            if (o1.isAfter(o2)) {
                return 1;
            } else if (o1.isBefore(o2)) {
                return -1;
            } else {
                return 0;
            }
        });


        aniversarios.forEach((aniversario) -> System.out.println(aniversario.format(FORMATTER)));


    }

    public static void formatConvencional(List<LocalDateTime> lista) {
        for (LocalDateTime aniversario : lista) {
            System.out.println(aniversario.format(FORMATTER));
        }
    }

    public static void selecionaNovaGeracao(List<LocalDateTime> listaAniversario) {
        for (LocalDateTime aniversario : listaAniversario) {
            boolean novaGeracao = aniversario.getYear() >= 1995 && aniversario.getYear() <= 2010;
            System.out.println("É DA GERAÇÃO Z?  " + novaGeracao);
        }
    }

    public static void imprimirSignos() {
        for (Signos signo : Signos.values()) {
            System.out.println("NOME: " + signo + " DATA INICIAL: " + signo.getInitDate().format(FORMATTER_SIGNO) +
                    "  --  DATA FINAL: " + signo.getLastDate().format(FORMATTER_SIGNO));
        }
    }

}

// - Consumer para data formatada (dd/MM/yyyy HH:mm:ss)
// - Predicate para informar se a pessoa é da geração Z (nasceu entre 1995 e 2010)
// - Supplier para informar os signos com as datas
// - Ordernar datas de nascimento do grupo com o comparator

// - Consumer, Predicate e  Supplier em três formas:
// - Convencional
// - Com classe anônima
// - Com lambda