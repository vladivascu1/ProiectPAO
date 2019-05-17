package models;

import java.util.Date;
import java.util.Objects;

public class Infirmiera extends Angajat{

    private Integer salon;
    private Asistenta asistenta;

    public Infirmiera(String id, String password, String nume, String prenume, Date dataAngajare, Integer salary, Integer salon, Asistenta asistenta) {
        super(id, password, nume, prenume, dataAngajare, salary);
        this.salon = salon;
        this.asistenta = asistenta;
    }

    public Infirmiera(String nume, String prenume, Date dataAngajare, Integer salary, Integer salon, Asistenta asistenta) {
        super(nume, prenume, dataAngajare, salary);
        this.salon = salon;
        this.asistenta = asistenta;
    }

    public Integer getSalon() {
        return salon;
    }

    public void setSalon(Integer salon) {
        this.salon = salon;
    }

    public Asistenta getAsistenta() {
        return asistenta;
    }

    public void setAsistenta(Asistenta asistenta) {
        this.asistenta = asistenta;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Infirmiera that = (Infirmiera) o;
        return Objects.equals(salon, that.salon) &&
                asistenta.equals(that.asistenta);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), salon, asistenta);
    }

    @Override
    public void afisareInfo() {

        super.afisareInfo();
        System.out.println("Salon: " + salon);
        if(asistenta != null) {
            System.out.println("Cu asistent-sef: ");
            asistenta.afisareInfo();
        }
    }
}
