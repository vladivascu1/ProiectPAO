package Services;

import Models.Angajat;

import java.io.*;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class FileServiceAngajat {
    private static FileServiceAngajat ourInstance = new FileServiceAngajat();

    public static FileServiceAngajat getInstance() {
        return ourInstance;
    }

    private FileServiceAngajat() {
    }

    public Angajat CitesteAngajatFisier(String CaleFisier) {
        Angajat angajat = null;
        try {

            LineNumberReader lineNumberReader = new LineNumberReader(new FileReader(CaleFisier));

            String line = lineNumberReader.readLine();
            String[] values = line.split(",");
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
            angajat = new Angajat(values[0], values[1], values[2], values[3], simpleDateFormat.parse(values[4]), Integer.parseInt(values[5]));

            lineNumberReader.close();

        }  catch (IOException e) {
            e.printStackTrace();
        }catch (ParseException e) {
            e.printStackTrace();
        }

        return angajat;
    }

    public void ScrieAngajatFisier(String text, String CaleFisier){

        try {
            FileWriter fileWriter = new FileWriter(CaleFisier, true);

            fileWriter.write(text);

            fileWriter.flush();
            fileWriter.close();

            System.out.println("Succes la scrierea in fisierul : " + CaleFisier);

        }catch(IOException e){

            System.out.println("Eroare la scrierea in fisierul : " + CaleFisier);
            e.printStackTrace();
        }

    }

    public List<Angajat> CitesteTotiAngajatii(String CaleFisier){

        List<Angajat> angajati = new ArrayList<Angajat>();

        try {
            String row;

            BufferedReader reader = new BufferedReader(new FileReader(CaleFisier));
            while ((row = reader.readLine()) != null) {
                String[] values = row.split(",");
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
                Angajat aux = new Angajat(values[0], values[1], values[2], values[3], simpleDateFormat.parse(values[4]), Integer.parseInt(values[5]));
                angajati.add(aux);
            }
            reader.close();

        }catch(IOException e) {

            e.printStackTrace();
        }catch(ParseException e) {

            e.printStackTrace();
        }

        return angajati;

    }


    public String getTextForm(Angajat angajat){

        StringBuilder text = new StringBuilder();
        text.append(angajat.getId());
        text.append(',');
        text.append(angajat.getPassword());
        text.append(',');
        text.append(angajat.getNume());
        text.append(',');
        text.append(angajat.getPrenume());
        text.append(',');
        text.append(angajat.getPrenume());
        text.append(',');
        text.append(angajat.getPrenume());

        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        String strDate = dateFormat.format(angajat.getDataAngajare());

        text.append(strDate);
        text.append(',');
        text.append(angajat.getSalary().toString());
        text.append(',');
        text.append('\n');

        return text.toString();
    }




}
