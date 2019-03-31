package Models;

import java.util.Objects;

public class Pacient implements Comparable<Pacient> {

    protected String nume;
    protected String prenume;
    protected String cnp;
    protected Integer varsta;
    protected Reteta reteta;

    public Pacient(String nume, String prenume, String cnp, Integer varsta, Reteta reteta) {
        this.nume = nume;
        this.prenume = prenume;
        this.cnp = cnp;
        this.varsta = varsta;
        this.reteta = reteta;
    }

    public String getNume() {
        return nume;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    public String getPrenume() {
        return prenume;
    }

    public void setPrenume(String prenume) {
        this.prenume = prenume;
    }

    public String getCnp() {
        return cnp;
    }

    public void setCnp(String cnp) {
        this.cnp = cnp;
    }

    public Integer getVarsta() {
        return varsta;
    }

    public void setVarsta(Integer varsta) {
        this.varsta = varsta;
    }

    public Reteta getReteta() {
        return reteta;
    }

    public void setReteta(Reteta reteta) {
        this.reteta = reteta;
    }

    public void afisareInfoPacient() {

        System.out.println("Nume: " + nume + "\nPrenume: " + prenume + "\nCNP: " + cnp + "\nVarsta: " + varsta + "\n");
        if(reteta != null)
            reteta.afisareInfoReteta();

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        //if (o == null || getClass() != o.getClass()) return false; comentat pentru a putea avea egalitate intre pacient si pacient internat
        if(o == null) return false;
        Pacient pacient = (Pacient) o;
        return nume.equals(pacient.nume) &&
                prenume.equals(pacient.prenume) &&
                cnp.equals(pacient.cnp);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nume, prenume, cnp);
    }

    @Override
    public int compareTo(Pacient ob) {

        int numefamilie = this.nume.compareTo(ob.nume);
        return numefamilie == 0 ? this.nume.compareTo(ob.prenume) : numefamilie;
    }


}
