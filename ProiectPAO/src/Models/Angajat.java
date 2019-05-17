package models;

import java.util.Date;
import java.util.Objects;

public class Angajat extends User implements Comparable<Angajat>{

    protected String nume;
    protected String prenume;
    protected Date dataAngajare;
    protected Integer salary;

    public Angajat(String id, String password, String nume, String prenume, Date dataAngajare, Integer salary) {
        super(id, password);
        this.nume = nume;
        this.prenume = prenume;
        this.dataAngajare = dataAngajare;
        this.salary = salary;
    }

    public Angajat(String nume, String prenume, Date dataAngajare, Integer salary) {

        this.nume = nume;
        this.prenume = prenume;
        this.dataAngajare = dataAngajare;
        this.salary = salary;
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

    public Date getDataAngajare() {
        return dataAngajare;
    }

    public void setDataAngajare(Date dataAngajare) {
        this.dataAngajare = dataAngajare;
    }

    public Integer getSalary() {
        return salary;
    }

    public void setSalary(Integer salary) {
        this.salary = salary;
    }

    @Override
    public void afisareInfo() {
        super.afisareInfo();
        System.out.println("Nume: " + nume + "\nPrenume: " + prenume + "\nData: " + dataAngajare + "\nSalariu: " + salary);

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Angajat angajat = (Angajat) o;
        return Objects.equals(nume, angajat.nume) &&
                Objects.equals(prenume, angajat.prenume);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nume, prenume);
    }

    @Override
    public int compareTo(Angajat ob) {

        int numefamilie = this.nume.compareTo(ob.nume);
        return numefamilie == 0 ? this.nume.compareTo(ob.prenume) : numefamilie;
    }

    public int verificaSpecializare(String aux){
        System.out.println("Verificam pentru: " + aux);
        return 0;
    }



}
