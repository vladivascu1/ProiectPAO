package models;

import java.util.Date;

public class PacientInternat extends Pacient {

    private Date dataInternare;
    private Date dataExternare;
    private Integer salon;

    public PacientInternat(String nume, String prenume, String cnp, Integer varsta, Reteta reteta, Date dataInternare, Date dataExternare, Integer salon) {
        super(nume, prenume, cnp, varsta, reteta);
        this.dataInternare = dataInternare;
        this.dataExternare = dataExternare;
        this.salon = salon;
    }

    public Date getDataInternare() {
        return dataInternare;
    }

    public void setDataInternare(Date dataInternare) {
        this.dataInternare = dataInternare;
    }

    public Date getDataExternare() {
        return dataExternare;
    }

    public void setDataExternare(Date dataExternare) {
        this.dataExternare = dataExternare;
    }

    public Integer getSalon() {
        return salon;
    }

    public void setSalon(Integer salon) {
        this.salon = salon;
    }

    @Override
    public void afisareInfoPacient() {

        System.out.println("Nume: " + nume + "\nPrenume: " + prenume + "\nCNP: " + cnp + "\nVarsta: " + varsta);
        if(reteta != null)
            reteta.afisareInfoReteta();
        System.out.println("Data internare : " + dataInternare + "\nData externare: " + dataExternare + "\nSalon: " + salon + "\n");

    }



}
