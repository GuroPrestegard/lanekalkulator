package com.nedbetaling.oppgave.Service;

import com.nedbetaling.oppgave.BetalingsplanDto.ForesporselDto;
import com.nedbetaling.oppgave.Domain.Nedbetaling;

import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;

/**
 * @author guroprestegard
 * Klasse som regner ut terminbeløp, renter og avdrag.
 */
public class NedbetalingsService {

    public double gjenstaaende;
    public LocalDate currentDate;
    public ArrayList<Nedbetaling> nedbetalingsplan;

    public double laanebelop;
    public double nominellRente;
    public double terminGebyr;
    public LocalDate saldoDato;
    public LocalDate datoForsteInnbetaling;
    public LocalDate utlopsdato;

    public NedbetalingsService(ForesporselDto foresporselDto) {
        this.gjenstaaende = foresporselDto.getLaanebelop();
        this.currentDate = LocalDate.parse(foresporselDto.getSaldoDato());
        this.nedbetalingsplan = new ArrayList<>();
        this.laanebelop = foresporselDto.getLaanebelop();
        this.nominellRente = foresporselDto.getNominellRente();
        this.terminGebyr = foresporselDto.getTerminGebyr();
        this.saldoDato = LocalDate.parse(foresporselDto.getSaldoDato());
        this.datoForsteInnbetaling = LocalDate.parse(foresporselDto.getDatoForsteInnbetaling());
        this.utlopsdato = LocalDate.parse(foresporselDto.getUtlopsDato());
    }

    /**
     * Regner ut renter og avdrag for ein gitt tidsperiode og mengde.
     * @return Ei liste med nedbetalingar
     */
    public ArrayList<Nedbetaling> nedbetaling() {
        Integer maaneder = veker();
        double rentesats = this.nominellRente / 12 / 100;
        double terminbelop = (this.laanebelop * Math.pow(((rentesats) + 1), maaneder) * rentesats / ((Math.pow(((rentesats) + 1), maaneder)) - 1));

        nedbetalingsplan.add(new Nedbetaling(gjenstaaende, currentDate, 0, 0, 0, 0));
        for (int i = 0; i < maaneder; i++) {
            this.currentDate = currentDate.plusMonths(1);
            double terminrente = this.gjenstaaende * (this.nominellRente / 100) / 12;
            double avdrag = terminbelop - terminrente;
            this.gjenstaaende = gjenstaaende - avdrag;
            if (this.gjenstaaende < 0) {
                double overflodig = Math.abs(this.gjenstaaende);
                this.gjenstaaende = this.gjenstaaende + overflodig;
                avdrag = avdrag - overflodig;
            }
            nedbetalingsplan.add(new Nedbetaling(this.gjenstaaende, this.currentDate, avdrag, this.terminGebyr, terminrente, (avdrag + terminrente + this.terminGebyr)));
        }
        return nedbetalingsplan;
    }

    /**
     * Regner ut kor mange veker det er mellom to gitte datoar.
     * @return antal veker.
     */
    private Integer veker() {
        Period diff = Period.between(saldoDato, utlopsdato);
        Integer maneder = (diff.getYears() * 12) + diff.getMonths();
        return maneder;
    }

}
