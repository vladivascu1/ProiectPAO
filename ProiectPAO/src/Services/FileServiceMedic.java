package Services;

import Models.Angajat;
import Models.Medic;

import java.io.*;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class FileServiceMedic {
    private static FileServiceMedic ourInstance = new FileServiceMedic();

    public static FileServiceMedic getInstance() {
        return ourInstance;
    }

    private FileServiceMedic() {
    }

    public void ScrieMedicFisier(Medic medic, String CaleFisier){

        try
        {
            BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(CaleFisier, true), "UTF-8"));

                StringBuffer row = new StringBuffer();

                row.append(medic.getId());
                row.append(',');
                row.append(medic.getPassword());
                row.append(',');
                row.append(medic.getNume());
                row.append(',');
                row.append(medic.getPrenume());
                row.append(',');

                DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
                String strDate = dateFormat.format(medic.getDataAngajare());

                row.append(strDate);
                row.append(',');
                row.append(medic.getSalary().toString());
                row.append(',');
                row.append(medic.getSpecializare());
                row.append(',');
                row.append(medic.getVechime().toString());
                row.append('\n');

                bufferedWriter.write(row.toString());

                bufferedWriter.flush();
                bufferedWriter.close();
        }
        catch (UnsupportedEncodingException e) {e.printStackTrace();}
        catch (FileNotFoundException e){e.printStackTrace();}
        catch (IOException e){e.printStackTrace();}


    }

    public Medic CitesteMedicFisier(String CaleFisier){

        Medic medic = null;

        try {

            FileReader fileReader = new FileReader(CaleFisier);
            LineNumberReader lineNumberReader = new LineNumberReader(fileReader);

            String line = lineNumberReader.readLine();
            String[] values = line.split(",");
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");

            medic = new Medic(values[0], values[1], values[2], values[3], simpleDateFormat.parse(values[4]), Integer.parseInt(values[5]), values[6], Integer.parseInt(values[7]));

            lineNumberReader.close();

        }catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return medic;
    }


}
