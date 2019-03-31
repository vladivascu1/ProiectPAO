package com.fmi.proiect;
import Models.*;
import Services.*;

import java.util.*;

import static Services.PacientService.*;
import static Services.AngajatService.*;

public class Main {

    public static void main(String[] args) {

 // Testam metodele din AngajatService :

     Autentificare();

     SchimbareParola();

     AngajatiAlfabetic();

     AngajatiSalariuDescrescator();

     NrSpecializariDiferite();


  // Testam pentru operatie(va fi inclusa, ulterior, tot in AngajatService) :

     Calendar c1 = GregorianCalendar.getInstance();
     c1.set(2000, Calendar.JUNE, 25);
     Date data1 = c1.getTime();

     Medic medic = new Medic("Robert", "Doctorasul", data1, 300, "Neurochirurg", 34);
     Pacient pacient = new Pacient("Bendeac", "Mihai", "198050651194", 34, null);

     Operatie operatie = new Operatie(medic, pacient, "", 3, data1);
     operatie.adaugaPersonal(medic);
     operatie.verificaListaPersonal();


  // Testam metodele din PacientService :

     PacientiAlfabetic();

     PacientiDupaVarstaCrescator();

     PacientiDupaDataExternare();

     AfisarePacientiUnici();

     Pacient pacient1 = GasestePacient("Dima", "Alin");

     if(pacient1 != null) // GasestePacient intoarce null daca nu reuseste identificarea
         pacient1.afisareInfoPacient();

     Pacient pacient2 = GasestePacientCnp("1980346123456");

     if(pacient2 != null) // GasestePacientCnp intoarce null daca nu reuseste identificarea
            pacient2.afisareInfoPacient();

     Reteta reteta1 = new Reteta(34, "Medicament1 Medicament2 Medicament3", "Popescu Petrescu", "CNAS Bucuresti");

     PrescrieReteta("Dima", "Alin", reteta1);
     pacient1 = GasestePacient("Dima", "Alin");
     pacient1.afisareInfoPacient();

     cautareDupaData(); //Se introduce o data, iar apoi vor fi afisati toti pacientii ce trebuie externati pana la data respectiva


    }
}
