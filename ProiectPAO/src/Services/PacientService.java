package Services;

import Models.Pacient;
import Models.PacientInternat;
import Models.Reteta;

import java.util.*;

class PacientiVarsta implements Comparator<Pacient> {

    public int compare(Pacient ob1, Pacient ob2) {

        return ob1.getVarsta() - ob2.getVarsta();
    }

}

class PacientiDataExternare implements Comparator<PacientInternat> {

    public int compare(PacientInternat ob1, PacientInternat ob2) {

        return ob1.getDataExternare().compareTo(ob2.getDataExternare());

    }

}

public class PacientService {


    private static final Pacient[] listaPacienti = new Pacient[5];
    private static final PacientInternat[] listaPacientiInternati = new PacientInternat[3];
    private static final PacientService ourInstance = new PacientService();

    private PacientService() {

        /* Initializare lista pacienti */

        listaPacienti[0] = new Pacient("Dima","Alin", "1980346123456", 34, null);
        listaPacienti[1] = new Pacient("Vlad","Leontin", "4980366123456", 56, null);
        listaPacienti[2] = new Pacient("Staniea","Alexandru", "2980340123456", 12, null);
        listaPacienti[3] = new Pacient("Secatureanu","Vlad-Cristian", "2980396123456", 44, null);
        listaPacienti[4] = new Pacient("Ivascu","Vlad-Mihai", "1980346123889", 20, null);

        /* Initializare lista pacienti internati */

        Calendar calendar = Calendar.getInstance();
        calendar.set(2016, Calendar.MARCH, 18);
        Date data1 = calendar.getTime();
        calendar.set(2016, Calendar.MARCH, 23);
        Date data2 = calendar.getTime();

        listaPacientiInternati[0] = new PacientInternat("Popescu", "Xulescu", "123", 12, null, data1, data2, 4 );

        calendar.set(2015, Calendar.JUNE, 12);
        data1 = calendar.getTime();
        calendar.set(2017, Calendar.MARCH, 29);
        data2 = calendar.getTime();

        listaPacientiInternati[1] = new PacientInternat("Dima", "Alin", "1980346123456", 45, null, data1, data2, 5 );

        calendar.set(2002, Calendar.FEBRUARY, 6);
        data1 = calendar.getTime();
        calendar.set(2003, Calendar.JULY, 12);
        data2 = calendar.getTime();

        listaPacientiInternati[2] = new PacientInternat("Bercenaru", "Mihai", "123456789", 16, null, data1, data2, 7 );


    }

    public void PacientiAlfabetic() {

        List<Pacient> pacientiAlfabetic = new ArrayList<Pacient>();

        for (int i = 0; i < listaPacienti.length; i++) {
            pacientiAlfabetic.add(listaPacienti[i]);
        }

        Collections.sort(pacientiAlfabetic);

        System.out.println("Pacientii in ordine alfabetica sunt: \n");

        for (int i = 0; i < pacientiAlfabetic.size(); i++) {
            pacientiAlfabetic.get(i).afisareInfoPacient();
        }

    }

    public void AfisarePacientiUnici() {

        System.out.println("Afisam pacientii unici(internati sau nu): riven");

        Set<Pacient> test = new HashSet<Pacient>();

        test.addAll(Arrays.asList(listaPacientiInternati));

        test.addAll(Arrays.asList(listaPacienti));

        for (Pacient iterator : test) {
            iterator.afisareInfoPacient();
        }


    }

    public void PacientiDupaVarstaCrescator() {

        List<Pacient> pacientiVarsta = new ArrayList<Pacient>();

        for (int i = 0; i < listaPacienti.length; i++) {
            pacientiVarsta.add(listaPacienti[i]);
        }

        System.out.println("Pacientii, crescator dupa varsta, sunt: ");

        Collections.sort(pacientiVarsta, new PacientiVarsta());

        for (int i = 0; i < pacientiVarsta.size(); i++) {
            pacientiVarsta.get(i).afisareInfoPacient();
        }


    }

    public void PacientiDupaDataExternare() {

        List<PacientInternat> pacientidata = new ArrayList<PacientInternat>();

        for (int i = 0; i < listaPacientiInternati.length; i++) {
            pacientidata.add(listaPacientiInternati[i]);
        }

        Collections.sort(pacientidata, new PacientiDataExternare());

        System.out.println("Pacientii internati in ordinea datei de externare sunt: ");

        for (int i = 0; i < pacientidata.size(); i++) {
            pacientidata.get(i).afisareInfoPacient();

        }
    }

    public Pacient GasestePacient(String nume, String prenume) {

        for (int i = 0; i < listaPacienti.length; i++)
            if(listaPacienti[i].getNume() == nume && listaPacienti[i].getPrenume() == prenume)
                return listaPacienti[i];

        return null;

    }

    public Pacient GasestePacientCnp(String cnp) {

        for (int i = 0; i < listaPacienti.length; i++)
            if(listaPacienti[i].getCnp() == cnp)
                return listaPacienti[i];

        return null;

    }

    public void PrescrieReteta(String nume, String prenume, Reteta reteta) {

        for (int i = 0; i < listaPacienti.length; i++)
            if(listaPacienti[i].getNume() == nume && listaPacienti[i].getPrenume() == prenume)
               listaPacienti[i].setReteta(reteta);

    }

    public void cautareDupaData() {

        System.out.println("Introduceti data(aaaa ll zz) si apasati tasta 'Enter': ");
        Scanner input = new Scanner(System.in).useDelimiter("\\n");
        String in = input.next();
        //System.out.println(in);
        String[] arr = in.split("\\s", 4);
        System.out.println(arr[0] + "\n" + arr[1] + "\n" + arr[2]);
        int an, luna, zi;
        an = Integer.parseInt(arr[0]);
        luna = Integer.parseInt(arr[1]) - 1;
        zi = Integer.parseInt(arr[2]);
       // System.out.println(an + " " + luna + " " + zi);

        Calendar calendar = Calendar.getInstance();
        calendar.set(an, luna, zi);
        Date data1 = calendar.getTime();
        System.out.println(data1);

        System.out.println("Afisam pacientii care vor fi externati pana la data introdusa: ");
        for (int i = 0; i < listaPacientiInternati.length; i++) {
            if(listaPacientiInternati[i].getDataExternare().compareTo(data1) < 0)
                listaPacientiInternati[i].afisareInfoPacient();
        }

    }


    public static PacientService getInstance() {
        return ourInstance;
    }

}
