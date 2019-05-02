package com.fmi.proiect;
import Models.*;
import Services.*;

import java.util.*;

public class Main {

    public static void main(String[] args) {

 // Testam metodele din AngajatService :

/*

     AngajatService.getInstance().Autentificare();

     AngajatService.getInstance().SchimbareParola();

     AngajatService.getInstance().AngajatiAlfabetic();

     AngajatService.getInstance().AngajatiSalariuDescrescator();

     AngajatService.getInstance().NrSpecializariDiferite();

*/


  // Testam pentru operatie(va fi inclusa, ulterior, tot in AngajatService) :

  /*

     Calendar c1 = GregorianCalendar.getInstance();
     c1.set(2000, Calendar.JUNE, 25);
     Date data1 = c1.getTime();

     Medic medic = new Medic("Robert", "Doctorasul", data1, 300, "Neurochirurg", 34);
     Pacient pacient = new Pacient("Bendeac", "Mihai", "198050651194", 34, null);

     Operatie operatie = new Operatie(medic, pacient, "", 3, data1);
     operatie.adaugaPersonal(medic);
     operatie.verificaListaPersonal();

   */

  // Testam metodele din PacientService :

    /*

     PacientService.getInstance().PacientiAlfabetic();

     PacientService.getInstance().PacientiDupaVarstaCrescator();

     PacientService.getInstance().PacientiDupaDataExternare();

     PacientService.getInstance().AfisarePacientiUnici();

     Pacient pacient1 = PacientService.getInstance().GasestePacient("Dima", "Alin");

     if(pacient1 != null) // GasestePacient intoarce null daca nu reuseste identificarea
         pacient1.afisareInfoPacient();

     Pacient pacient2 = PacientService.getInstance().GasestePacientCnp("1980346123456");

     if(pacient2 != null) // GasestePacientCnp intoarce null daca nu reuseste identificarea
            pacient2.afisareInfoPacient();

     Reteta reteta1 = new Reteta(34, "Medicament1 Medicament2 Medicament3", "Popescu Petrescu", "CNAS Bucuresti");

     PacientService.getInstance().PrescrieReteta("Dima", "Alin", reteta1);
     pacient1 = PacientService.getInstance().GasestePacient("Dima", "Alin");
     pacient1.afisareInfoPacient();

     PacientService.getInstance().cautareDupaData(); //Se introduce o data, iar apoi vor fi afisati toti pacientii ce trebuie externati pana la data respectiva

    */

     // TESTARE FILE SERVICE PENTRU RETETE

        /*

     FileServiceReteta.getInstance().ScrieRetetaFisier("3,simae,test,testtest\n","test.csv");
     FileServiceReteta.getInstance().ScrieRetetaFisier("4,simae,aux,auxaux\n","test.csv");
   //  Reteta auxreteta =  FileServiceReteta.getInstance().CitesteRetetaFisier("test.csv");
    // auxreteta.afisareInfoReteta();
    List<Reteta> retete = FileServiceReteta.getInstance().CitesteToateRetele("test.csv");

        for (int i = 0; i < retete.size(); i++) {
            retete.get(i).afisareInfoReteta();

        }

        Reteta reteta1 = new Reteta(34, "Medicament1 Medicament2 Medicament3", "Popescu Petrescu", "CNAS Bucuresti");

       String aux = FileServiceReteta.getInstance().getTextForm(reteta1);
       FileServiceReteta.getInstance().ScrieRetetaFisier(aux, "test.csv");

        */

     // TESTARE FILE SERVICE PENTRU ANGAJAT

        /*
     FileServiceAngajat.getInstance().ScrieAngajatFisier("idtest,parolatest,numetest,prenumetest,11/11/2016,3000\n", "testangajat.csv");
     Angajat auxangajat = FileServiceAngajat.getInstance().CitesteAngajatFisier("testangajat.csv");
     auxangajat.afisareInfo();

        List<Angajat> angajati = FileServiceAngajat.getInstance().CitesteTotiAngajatii("testangajat.csv");

        for (int i = 0; i < angajati.size(); i++) {
            angajati.get(i).afisareInfo();

        }

     */

        /* TESTARE FILE SERVICE MEDIC

        Calendar c2 = GregorianCalendar.getInstance();
        c2.set(2000, Calendar.JUNE, 25);
        Date data1 = c2.getTime();

        Medic medic = new Medic("Robert", "Doctorasul", data1, 300, "Neurochirurg", 34);
        Medic medic2;

        FileServiceMedic.getInstance().ScrieMedicFisier(medic, "testmedic.csv");
        medic2 = FileServiceMedic.getInstance().CitesteMedicFisier("testmedic.csv");
        medic2.afisareInfo();

        */

        /* // TESTARE USER SERVICE(SERIALIZABLE)

        User useraux = new User("saga","daba");
        FileServiceUserSerializable.getInstance().ScrieObiectFisier(useraux, "testobject");
        User user2;
        user2 = (User)FileServiceUserSerializable.getInstance().CitesteObiectFisier("testobject");
        user2.afisareInfo();

        */

        /* // TESTARE AUDIT SERVICE

        // AuditService.getInstance().AutentificareWrapper();
        // AuditService.getInstance().SchimbareParolaWrapper();
        // AuditService.getInstance().AutentificareWrapper();
        AuditService.getInstance().AngajatiAlfabeticWrapper();
        AuditService.getInstance().AngajatiSalariuDescrescatorWrapper();
        AuditService.getInstance().PacientiDupaDataExternareWrapper();

        */

    }


}
