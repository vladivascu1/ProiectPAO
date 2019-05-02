package Services;

import Models.Reteta;

import java.io.*;
import java.util.*;

public class FileServiceReteta {
    private static FileServiceReteta ourInstance = new FileServiceReteta();

    public static FileServiceReteta getInstance() {
        return ourInstance;
    }

    private FileServiceReteta() {
    }

    public void ScrieRetetaFisier(String text, String CaleFisier){

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

    public Reteta CitesteRetetaFisier(String CaleFisier) {

        Reteta reteta = null;
        try {

            LineNumberReader lineNumberReader = new LineNumberReader(new FileReader(CaleFisier));

            String line = lineNumberReader.readLine();
            String[] values = line.split(",");
            reteta = new Reteta(Integer.parseInt(values[0]), values[1], values[2], values[3]);

            lineNumberReader.close();

        }catch(IOException e) {

            e.printStackTrace();
        }

        return reteta;
    }

    public List<Reteta> CitesteToateRetele(String CaleFisier){

        List<Reteta> retete = new ArrayList<Reteta>();

        try {
            String row;

            BufferedReader reader = new BufferedReader(new FileReader(CaleFisier));
            while ((row = reader.readLine()) != null) {
                String[] values = row.split(",");
                Reteta aux = new Reteta(Integer.parseInt(values[0]), values[1], values[2], values[3]);
                retete.add(aux);

            }
            reader.close();

        }catch(IOException e) {

            e.printStackTrace();
        }

        return retete;

    }

    public String getTextForm(Reteta reteta){

        StringBuilder text = new StringBuilder();
        text.append(reteta.getNr().toString());
        text.append(',');
        text.append(reteta.getMedicamente());
        text.append(',');
        text.append(reteta.getDoctor());
        text.append(',');
        text.append(reteta.getCasaAsigurare());
        text.append('\n');

        return text.toString();
    }

}
