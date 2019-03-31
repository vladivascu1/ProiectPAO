package Models;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class Operatie implements Programare {

    private Medic medic;
    private List<Angajat> listaPersonal;
    private Pacient pacient;
    private String infoPacienti;
    private Integer sala;
    private Date data;

    public Operatie(Medic medic, Pacient pacient, String infoPacienti, Integer sala, Date data) {
        this.medic = medic;
        this.listaPersonal = new ArrayList<Angajat>();
        this.pacient = pacient;
        this.infoPacienti = infoPacienti;
        this.sala = sala;
        this.data = data;
        listaPersonal.add(medic);
    }

    public Medic getMedic() {
        return medic;
    }

    public void setMedic(Medic medic) {
        this.medic = medic;
    }

    public List<Angajat> getListaPersonal() {
        return listaPersonal;
    }

    public void setListaPersonal(List<Angajat> listaPersonal) {
        this.listaPersonal = listaPersonal;
    }

    public Pacient getPacient() {
        return pacient;
    }

    public void setPacient(Pacient pacient) {
        this.pacient = pacient;
    }

    public String getInfoPacienti() {
        return infoPacienti;
    }

    public void setInfoPacienti(String infoPacienti) {
        this.infoPacienti = infoPacienti;
    }

    public Integer getSala() {
        return sala;
    }

    public void setSala(Integer sala) {
        this.sala = sala;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public void adaugaPersonal(Angajat ob) {

        listaPersonal.add(ob);
    }

    public void afisareInfoPersonal() {

        for (int i = 0; i < listaPersonal.size(); i++) {
            listaPersonal.get(i).afisareInfo();

        }

    }

    public void metodaPlata(){

        //placeholder
        System.out.println("Plata: cash");
    }

    public void verificaListaPersonal(){ // verificam,de exemplu, daca in lista de personal medical atasata operatiei exista un Anestezist, un Neurochirurg etc.

        System.out.println("Introduceti numele specializarii ce necesita verificare: ");
        Scanner input = new Scanner(System.in).useDelimiter("\\n");
        String in = input.next();
        int gasit = 0;

        List<Angajat> gasiti = new ArrayList<Angajat>();

        for (int i = 0; i < listaPersonal.size(); i++)
            if(listaPersonal.get(i).verificaSpecializare(in) == 1) {
                gasit = 1;
                gasiti.add(listaPersonal.get(i));
            }

        if(gasit == 0)
            System.out.println("ATENTIE!Niciunul dintre medici nu are specializarea cautata!");

        else {
            System.out.println("Urmatorii medici au specializarea precizata: ");
            for (int i = 0; i < gasiti.size(); i++)
                listaPersonal.get(i).afisareInfo();

        }
    }

}
