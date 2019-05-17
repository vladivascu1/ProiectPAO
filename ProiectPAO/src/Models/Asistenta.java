package models;

import java.util.Date;
import java.util.Objects;

public class Asistenta extends Angajat {

    private Integer sectie;
    private Medic medic;

    public Asistenta(String id, String password, String nume, String prenume, Date dataAngajare, Integer salary, Integer sectie, Medic medic) {
        super(id, password, nume, prenume, dataAngajare, salary);
        this.sectie = sectie;
        this.medic = medic;
    }

    public Asistenta(String nume, String prenume, Date dataAngajare, Integer salary, Integer sectie, Medic medic) {
        super(nume, prenume, dataAngajare, salary);
        this.sectie = sectie;
        this.medic = medic;
    }



    public Integer getSectie() {
        return sectie;
    }

    public void setSectie(Integer sectie) {
        this.sectie = sectie;
    }

    public Medic getMedic() {
        return medic;
    }

    public void setMedic(Medic medic) {
        this.medic = medic;
    }

    @Override
    public void afisareInfo() {

        super.afisareInfo();
        if(medic != null) {
            System.out.println("Cu medic-sef: ");
            medic.afisareInfo();
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Asistenta asistenta = (Asistenta) o;
        return sectie.equals(asistenta.sectie) &&
                medic.equals(asistenta.medic);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), sectie, medic);
    }


}
