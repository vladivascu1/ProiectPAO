package models;

import java.util.Objects;

public class Reteta {

    protected Integer nr;
    protected String medicamente;
    protected String doctor;
    protected String casaAsigurare;

    public Reteta(Integer nr, String medicamente, String doctor, String casaAsigurare) {
        this.nr = nr;
        this.medicamente = medicamente;
        this.doctor = doctor;
        this.casaAsigurare = casaAsigurare;
    }

    public Integer getNr() {
        return nr;
    }

    public void setNr(Integer nr) {
        this.nr = nr;
    }

    public String getMedicamente() {
        return medicamente;
    }

    public void setMedicamente(String medicamente) {
        this.medicamente = medicamente;
    }

    public String getDoctor() {
        return doctor;
    }

    public void setDoctor(String doctor) {
        this.doctor = doctor;
    }

    public String getCasaAsigurare() {
        return casaAsigurare;
    }

    public void setCasaAsigurare(String casaAsigurare) {
        this.casaAsigurare = casaAsigurare;
    }

    public void afisareInfoReteta() {
        System.out.println("\nNr reteta: " + nr + "\nReteta : " + medicamente + "\nDoctor: " + doctor + "\nCasa asigurari: " + casaAsigurare);

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Reteta reteta = (Reteta) o;
        return nr.equals(reteta.nr) &&
                medicamente.equals(reteta.medicamente) &&
                doctor.equals(reteta.doctor) &&
                casaAsigurare.equals(reteta.casaAsigurare);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nr, medicamente, doctor, casaAsigurare);
    }
}

