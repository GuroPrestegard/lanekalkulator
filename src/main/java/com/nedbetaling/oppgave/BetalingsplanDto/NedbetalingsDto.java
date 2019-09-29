package com.nedbetaling.oppgave.BetalingsplanDto;

import java.time.LocalDate;

/**
 * Dto for nedbetaling.
 */
public class NedbetalingsDto {

    double restgjeld;
    String dato;
    double innbetaling;
    double gebyr;
    double rente;
    double total;

    public NedbetalingsDto(double restgjeld, LocalDate dato, double innbetaling, double gebyr, double rente, double total) {
        this.restgjeld = restgjeld;
        setDato(dato);
        this.innbetaling = innbetaling;
        this.gebyr = gebyr;
        this.rente = rente;
        this.total = total;
    }

    public NedbetalingsDto() {

    }

    public double getRestgjeld() {
        return restgjeld;
    }

    public void setRestgjeld(double restgjeld) {
        this.restgjeld = restgjeld;
    }

    public String getDato() {
        return dato;
    }

    public void setDato(LocalDate dato) {
        this.dato = dato.toString();
    }

    public double getInnbetaling() {
        return innbetaling;
    }

    public void setInnbetaling(double innbetaling) {
        this.innbetaling = innbetaling;
    }

    public double getGebyr() {
        return gebyr;
    }

    public void setGebyr(double gebyr) {
        this.gebyr = gebyr;
    }

    public double getRente() {
        return rente;
    }

    public void setRente(double rente) {
        this.rente = rente;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    @Override
    public String toString() {
        return "Nedbetaling{" +
                "restgjeld=" + restgjeld +
                ", dato=" + dato +
                ", innbetaling=" + innbetaling +
                ", gebyr=" + gebyr +
                ", rente=" + rente +
                ", total=" + total +
                '}';
    }
}