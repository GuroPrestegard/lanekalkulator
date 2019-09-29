package com.nedbetaling.oppgave.Domain;

import java.time.LocalDate;

/**
 * klasse som representerer ein nedbetaling.
 */
public class Nedbetaling {

    double restgjeld;
    LocalDate dato;
    double innbetaling;
    double gebyr;
    double rente;
    double total;

    public Nedbetaling(double restgjeld, LocalDate dato, double innbetaling, double gebyr, double rente, double total) {
        this.restgjeld = restgjeld;
        this.dato = dato;
        this.innbetaling = innbetaling;
        this.gebyr = gebyr;
        this.rente = rente;
        this.total = total;
    }

    public double getRestgjeld() {
        return restgjeld;
    }

    public void setRestgjeld(double restgjeld) {
        this.restgjeld = restgjeld;
    }

    public LocalDate getDato() {
        return dato;
    }

    public void setDato(LocalDate dato) {
        this.dato = dato;
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