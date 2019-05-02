package Services;


import Models.Pacient;
import Models.Reteta;

import java.io.FileWriter;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class AuditService {
    private static AuditService ourInstance = new AuditService();
    private static String CaleFisier = "testaudit.csv";

    public static AuditService getInstance() {
        return ourInstance;
    }

    private AuditService() {
    }

    public void AutentificareWrapper(){

        AngajatService.getInstance().Autentificare();
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        Date date = new Date();

        try {
            FileWriter fileWriter = new FileWriter(CaleFisier, true);
            fileWriter.write("Autentificare,");
            fileWriter.write(dateFormat.format(date));
            fileWriter.write("\n");

            fileWriter.flush();
            fileWriter.close();



        }catch(IOException e){

            e.printStackTrace();
        }


    }

    public int SchimbareParolaWrapper(){

        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        Date date = new Date();

        try {
            FileWriter fileWriter = new FileWriter(CaleFisier, true);
            fileWriter.write("SchimbareParola,");
            fileWriter.write(dateFormat.format(date));
            fileWriter.write("\n");

            fileWriter.flush();
            fileWriter.close();



        }catch(IOException e){

            e.printStackTrace();
        }

        return AngajatService.getInstance().SchimbareParola();

    }

    public void AngajatiAlfabeticWrapper(){

        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        Date date = new Date();

        try {
            FileWriter fileWriter = new FileWriter(CaleFisier, true);
            fileWriter.write("AngajatiAlfabetic,");
            fileWriter.write(dateFormat.format(date));
            fileWriter.write("\n");

            fileWriter.flush();
            fileWriter.close();

        }catch(IOException e){

            e.printStackTrace();
        }

        AngajatService.getInstance().AngajatiAlfabetic();

    }

    public void AngajatiSalariuDescrescatorWrapper(){

        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        Date date = new Date();

        try {
            FileWriter fileWriter = new FileWriter(CaleFisier, true);
            fileWriter.write("AngajatiSalariuDescrescator,");
            fileWriter.write(dateFormat.format(date));
            fileWriter.write("\n");

            fileWriter.flush();
            fileWriter.close();

        }catch(IOException e){

            e.printStackTrace();
        }

        AngajatService.getInstance().AngajatiSalariuDescrescator();

    }


    public void NrSpecializariDiferiteWrapper(){

        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        Date date = new Date();

        try {
            FileWriter fileWriter = new FileWriter(CaleFisier, true);
            fileWriter.write("NrSpecializariDiferite,");
            fileWriter.write(dateFormat.format(date));
            fileWriter.write("\n");

            fileWriter.flush();
            fileWriter.close();

        }catch(IOException e){

            e.printStackTrace();
        }

        AngajatService.getInstance().NrSpecializariDiferite();

    }


    public void PacientiAlfabeticWrapper(){

        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        Date date = new Date();

        try {
            FileWriter fileWriter = new FileWriter(CaleFisier, true);
            fileWriter.write("PacientiAlfabetic,");
            fileWriter.write(dateFormat.format(date));
            fileWriter.write("\n");

            fileWriter.flush();
            fileWriter.close();

        }catch(IOException e){

            e.printStackTrace();
        }

        PacientService.getInstance().PacientiAlfabetic();

    }

    public void AfisarePacientiUniciWrapper(){

        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        Date date = new Date();

        try {
            FileWriter fileWriter = new FileWriter(CaleFisier, true);
            fileWriter.write("AfisarePacientiUnici,");
            fileWriter.write(dateFormat.format(date));
            fileWriter.write("\n");

            fileWriter.flush();
            fileWriter.close();

        }catch(IOException e){

            e.printStackTrace();
        }

        PacientService.getInstance().AfisarePacientiUnici();

    }


    public void PacientiDupaVarstaCrescatorWrapper(){

        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        Date date = new Date();

        try {
            FileWriter fileWriter = new FileWriter(CaleFisier, true);
            fileWriter.write("PacientiDupaVarstaCrescator,");
            fileWriter.write(dateFormat.format(date));
            fileWriter.write("\n");

            fileWriter.flush();
            fileWriter.close();

        }catch(IOException e){

            e.printStackTrace();
        }

        PacientService.getInstance().PacientiDupaVarstaCrescator();


    }


    public void PacientiDupaDataExternareWrapper(){

        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        Date date = new Date();

        try {
            FileWriter fileWriter = new FileWriter(CaleFisier, true);
            fileWriter.write("PacientiDupaDataExternare,");
            fileWriter.write(dateFormat.format(date));
            fileWriter.write("\n");

            fileWriter.flush();
            fileWriter.close();

        }catch(IOException e){

            e.printStackTrace();
        }

        PacientService.getInstance().PacientiDupaDataExternare();

    }

    public Pacient GasestePacientWrapper(String nume, String prenume){

        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        Date date = new Date();

        try {
            FileWriter fileWriter = new FileWriter(CaleFisier, true);
            fileWriter.write("GasestePacient,");
            fileWriter.write(dateFormat.format(date));
            fileWriter.write("\n");

            fileWriter.flush();
            fileWriter.close();

        }catch(IOException e){

            e.printStackTrace();
        }

       return PacientService.getInstance().GasestePacient(nume, prenume);

    }

    public Pacient GasestePacientCnp(String cnp){

        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        Date date = new Date();

        try {
            FileWriter fileWriter = new FileWriter(CaleFisier, true);
            fileWriter.write("GasestePacientCnp,");
            fileWriter.write(dateFormat.format(date));
            fileWriter.write("\n");

            fileWriter.flush();
            fileWriter.close();

        }catch(IOException e){

            e.printStackTrace();
        }

        return PacientService.getInstance().GasestePacientCnp(cnp);

    }

    public void PrescrieRetetaWrapper(String nume, String prenume, Reteta reteta){

        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        Date date = new Date();

        try {
            FileWriter fileWriter = new FileWriter(CaleFisier, true);
            fileWriter.write("PrescrieReteta,");
            fileWriter.write(dateFormat.format(date));
            fileWriter.write("\n");

            fileWriter.flush();
            fileWriter.close();

        }catch(IOException e){

            e.printStackTrace();
        }

        PacientService.getInstance().PrescrieReteta(nume, prenume, reteta);

    }

    public void cautareDupaDataWrapper(){

        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        Date date = new Date();

        try {
            FileWriter fileWriter = new FileWriter(CaleFisier, true);
            fileWriter.write("cautareDupaData,");
            fileWriter.write(dateFormat.format(date));
            fileWriter.write("\n");

            fileWriter.flush();
            fileWriter.close();

        }catch(IOException e){

            e.printStackTrace();
        }

        PacientService.getInstance().cautareDupaData();

    }


}
