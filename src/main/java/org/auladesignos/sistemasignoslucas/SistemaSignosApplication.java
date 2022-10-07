package org.auladesignos.sistemasignoslucas;

import org.auladesignos.sistemasignoslucas.exceptions.SignoLunarNaoEncontradoException;

import java.time.*;
import java.time.format.DateTimeFormatter;

public class SistemaSignosApplication {

    public final static DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("dd/MM/yyy hh:mm");

    public static void main(String[] args) {
        System.out.println("SIGNOS");
        System.out.println();

        // INSERIR DATA E HORA DO NASCIMENTO
        LocalDateTime dataHoraNascimentoLucas = LocalDateTime.of(1993, 5, 11, 10, 36);
        // INSERIR LOCAL DO NASCIMENTO DE ACORDO COM O TIMEZONE
        ZoneId localNascimentoLucas = ZoneId.of("America/Sao_Paulo");

        ZonedDateTime dataHoraLocalNascimentoLucas = ZonedDateTime.of(dataHoraNascimentoLucas, localNascimentoLucas);

        System.out.println("IDADE DO LUCAS: ");
        Period period = Period.between(dataHoraLocalNascimentoLucas.toLocalDate(), LocalDate.now());
        System.out.println(period.getYears() + " ANOS");

        System.out.println();

        System.out.println("SIGNO DO LUCAS: ");
        System.out.println(Signos.getSigno(MonthDay.of(dataHoraLocalNascimentoLucas.getMonth(), dataHoraLocalNascimentoLucas.getDayOfMonth())));

        System.out.println();

        System.out.println("ASCENDENTE DO LUCAS: ");
        System.out.println(Ascendente.getAscendente(dataHoraLocalNascimentoLucas.toLocalTime()));

        System.out.println();

        System.out.println("SIGNO LUNAR DO LUCAS: ");
        try {
            System.out.println(Lunar.getLunar(dataHoraLocalNascimentoLucas));
        } catch (SignoLunarNaoEncontradoException exception) {
            System.out.println(exception.getLocalizedMessage());
        }

        System.out.println();

        System.out.println("NASCEU EM ANO BISSEXTO: ");
        System.out.println(Year.isLeap(dataHoraLocalNascimentoLucas.getYear()));

        System.out.println();

        System.out.println("DATA DE NASCIMENTO: ");
        System.out.println(dataHoraLocalNascimentoLucas.format(FORMATTER));

        System.out.println();

        System.out.println("TimeZone do Local de nascimento: ");
        System.out.println(dataHoraLocalNascimentoLucas.getZone());

    }

}