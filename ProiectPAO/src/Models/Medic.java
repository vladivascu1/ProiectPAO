package Models;

import java.util.Date;
import java.util.Objects;

public class Medic extends Angajat {

    private String specializare;
    private Integer vechime;

    public Medic(String id, String password, String nume, String prenume, Date dataAngajare, Integer salary, String specializare, Integer vechime) {
        super(id, password, nume, prenume, dataAngajare, salary);
        this.specializare = specializare;
        this.vechime = vechime;
    }

    public Medic(String nume, String prenume, Date dataAngajare, Integer salary, String specializare, Integer vechime) {
        super(nume, prenume, dataAngajare, salary);
        this.specializare = specializare;
        this.vechime = vechime;
    }

    public String getSpecializare() {
        return specializare;
    }

    public void setSpecializare(String specializare) {
        this.specializare = specializare;
    }

    public Integer getVechime() {
        return vechime;
    }

    public void setVechime(Integer vechime) {
        this.vechime = vechime;
    }

    @Override
    public void afisareInfo() {

        super.afisareInfo();
        System.out.println("Specializare: " + specializare);
        System.out.println("Vechime: " + vechime);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Medic medic = (Medic) o;
        return specializare.equals(medic.specializare) &&
                vechime.equals(medic.vechime);
    }

    @Override
    public int verificaSpecializare(String aux) {
        if(this.getSpecializare().equals(aux))
            return 1;
        return 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), specializare, vechime);
    }
}
