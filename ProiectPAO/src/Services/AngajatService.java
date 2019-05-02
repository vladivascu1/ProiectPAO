package Services;

import Models.*;

import java.util.*;

class AngajatiSalariu implements Comparator<Angajat> {

    public int compare(Angajat ob1, Angajat ob2) {

        return ob2.getSalary() - ob1.getSalary();
    }

}

public class AngajatService {

    private static final User[] listaUser = new User[4];
    private static final Angajat[] listaAngajati = new Angajat[5];
    private static final Medic[] listaMedici = new Medic[3]; // pentru a ilustra Map
    private static final AngajatService ourInstance = new AngajatService();



    public static AngajatService getInstance() {
        return ourInstance;
    }

    private AngajatService() {

        Calendar calendar = Calendar.getInstance();
        calendar.set(2010, Calendar.JANUARY, 17);
        Date date1 = calendar.getTime();


        listaUser[0] = new Medic("19234", "parolamea","Leonardo", "Dicaprio", date1, 4300, "Neurochirurg", 10 );
        listaUser[1] = new Asistenta("2456", "parolita", "Sophia", "Scorsese", date1, 2300, 3, null );
        listaUser[2] = new Infirmiera("5678", "mypassword", "Maria", "Coppola", date1, 1700, 4, null );
        listaUser[3] = new Medic("9768","lionking","Steve", "Buscemi", date1, 6300, "Pediatrie", 12 );


        listaAngajati[0] = new Medic("Leonardo", "Dicaprio", date1, 4300, "Neurochirurg", 10 );
        listaAngajati[1] = new Asistenta("Sophia", "Scorsese", date1, 2300, 3, null );
        listaAngajati[2] = new Infirmiera("Maria", "Coppola", date1, 1700, 4, null );
        listaAngajati[3] = new Medic("Steve", "Buscemi", date1, 6300, "Pediatrie", 12 );
        listaAngajati[4] = new Medic("Ryan", "Reynolds", date1, 3300, "Pediatrie", 8 );


        listaMedici[0] = new Medic("Leonardo", "Dicaprio", date1, 4300, "Neurochirurg", 10 );
        listaMedici[1] = new Medic("Steve", "Buscemi", date1, 6300, "Pediatrie", 12 );
        listaMedici[2] = new Medic("Ryan", "Reynolds", date1, 3300, "Pediatrie", 8 );
    }

    public void Autentificare() {

        System.out.println("Introduceti id-ul: ");
        Scanner input = new Scanner(System.in).useDelimiter("\\n");
        String id = input.next();
        System.out.println("Introduceti parola: ");
        String pass = input.next();
        int gasit = 0;

        for(int i = 0; i < listaUser.length; i++)
           if(listaUser[i].getId().equals(id) && listaUser[i].getPassword().equals(pass))
            {
                System.out.println("Autentificare reusita!Afisam informatiile personale: ");
                gasit = 1;
                listaUser[i].afisareInfo();
                break;
            }

        if(gasit == 0)
            System.out.println("Autentificare esuata!Incercati din nou.");

    }

    public int SchimbareParola() {

        System.out.println("Introduceti id-ul: ");
        Scanner input = new Scanner(System.in).useDelimiter("\\n");
        String id = input.next();
        int i, gasit = 0;

        for (i = 0; i < listaUser.length; i++)
            if (listaUser[i].getId().equals(id)) {
                gasit = 1;
                break;
            }

        if (gasit == 0) {
            System.out.println("Id invalid! Incercati din nou!");
            return 1;
        }

        int aux = 0;

        while (aux == 0) {

            System.out.println("Introduceti parola curenta: ");
            String pass = input.next();
            if (listaUser[i].getPassword().equals(pass))
                aux = 1;
        }

        aux = 0;
        String par1 = "", par2 = "";

        while(aux == 0) {

            System.out.println("Introduceti noua parola: ");
            par1 = input.next();
            System.out.println("Introduceti din nou parola cea noua: ");
            par2 = input.next();
            if(par1.equals(par2))
                aux = 1;

        }

        listaUser[i].setPassword(par1);
        System.out.println("Parola a fost schimbata cu succes!");
        return 0;
    }

    public void AngajatiAlfabetic(){

        List<Angajat> angajatiAlfabetic = new ArrayList<Angajat>();
        angajatiAlfabetic.addAll(Arrays.asList(listaAngajati));
        Collections.sort(angajatiAlfabetic);

        System.out.println("Afisam angajatii in ordine alfabetica: ");

        for(int i = 0; i < angajatiAlfabetic.size(); i++)
            angajatiAlfabetic.get(i).afisareInfo();

    }

    public void AngajatiSalariuDescrescator() {

        List<Angajat> angajatiSalariu = new ArrayList<Angajat>();
        angajatiSalariu.addAll(Arrays.asList(listaAngajati));
        Collections.sort(angajatiSalariu, new AngajatiSalariu());

        System.out.println("Afisam angajatii in ordine descrescatoare, dupa salariu: ");

        for(int i = 0; i < angajatiSalariu.size(); i++)
            angajatiSalariu.get(i).afisareInfo();

    }

    public void NrSpecializariDiferite() {  //test Map

        Medic test;
        Map<String, Medic> hm = new HashMap<String, Medic>();

        for(int i = 0; i < listaMedici.length; i++)
           hm.put(listaMedici[i].getSpecializare(), listaMedici[i]);

        Set< Map.Entry< String, Medic> > st = hm.entrySet();

        System.out.println("Numar de specializari diferite: " + hm.size());

        for (Map.Entry<String, Medic> me:st)
        {
            System.out.print(me.getKey()+ " , ");

        }


    }

}
