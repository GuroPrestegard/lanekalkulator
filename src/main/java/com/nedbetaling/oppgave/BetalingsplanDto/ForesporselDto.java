package com.nedbetaling.oppgave.BetalingsplanDto;

/**
 * Dto for forespørsel
 */
public class ForesporselDto {

    public Integer laanebelop;
    public Integer nominellRente;
    public Integer terminGebyr;
    public String utlopsDato;
    public String saldoDato;
    public String datoForsteInnbetaling;
    public String ukjentVerdi;

    public ForesporselDto(Integer laanebelop, Integer nominellRente, Integer terminGebyr, String utlopsDato, String saldoDato, String datoForsteInnbetaling, String ukjentVerdi) {
        this.laanebelop = laanebelop;
        this.nominellRente = nominellRente;
        this.terminGebyr = terminGebyr;
        this.utlopsDato = utlopsDato;
        this.saldoDato = saldoDato;
        this.datoForsteInnbetaling = datoForsteInnbetaling;
        this.ukjentVerdi = ukjentVerdi;
    }

    public ForesporselDto() {

    }

    public Integer getLaanebelop() {
        return laanebelop;
    }

    public void setLaanebelop(Integer laanebelop) {
        this.laanebelop = laanebelop;
    }

    public Integer getNominellRente() {
        return nominellRente;
    }

    public void setNominellRente(Integer nominellRente) {
        this.nominellRente = nominellRente;
    }

    public Integer getTerminGebyr() {
        return terminGebyr;
    }

    public void setTerminGebyr(Integer terminGebyr) {
        this.terminGebyr = terminGebyr;
    }

    public String getUtlopsDato() {
        return utlopsDato;
    }

    public void setUtlopsDato(String utlopsDato) {
        this.utlopsDato = utlopsDato;
    }

    public String getSaldoDato() {
        return saldoDato;
    }

    public void setSaldoDato(String saldoDato) {
        this.saldoDato = saldoDato;
    }

    public String getDatoForsteInnbetaling() {
        return datoForsteInnbetaling;
    }

    public void setDatoForsteInnbetaling(String datoForsteInnbetaling) {
        this.datoForsteInnbetaling = datoForsteInnbetaling;
    }

    public String getUkjentVerdi() {
        return ukjentVerdi;
    }

    public void setUkjentVerdi(String ukjentVerdi) {
        this.ukjentVerdi = ukjentVerdi;
    }

    @Override
    public String toString() {
        return "ForesporselDto{" +
                "laanebelop:" + laanebelop +
                ", nominellRente:" + nominellRente +
                ", terminGebyr:" + terminGebyr +
                ", utlopsDato:'" + utlopsDato + '\'' +
                ", saldoDato:'" + saldoDato + '\'' +
                ", datoForsteInnbetaling:'" + datoForsteInnbetaling + '\'' +
                ", ukjentVerdi:'" + ukjentVerdi + '\'' +
                '}';
    }
}
