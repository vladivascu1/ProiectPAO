package Services;

import Models.Medic;

import javax.xml.transform.Result;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MedicJDBC {
    private static MedicJDBC ourInstance = new MedicJDBC();

    public static MedicJDBC getInstance() {
        return ourInstance;
    }

    private MedicJDBC() {

    }

    public void CreateTableMedic(){

        AuditService.getInstance().writeAuditLine("CreateTableMedic " + ", Thread: " + Thread.currentThread());

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/sys?serverTimezone=UTC",
                    "root", "admin");
            Statement statement = connection.createStatement();
           // String comanda = new String()

            statement.executeUpdate("CREATE TABLE `sys`.`medic` (\n" +
                    "  `id_medic` VARCHAR(45) NOT NULL,\n" +
                    "  `password` VARCHAR(45) NOT NULL,\n" +
                    "  `nume` VARCHAR(45) NOT NULL,\n" +
                    "  `prenume` VARCHAR(45) NOT NULL,\n" +
                    "  `data_angajare` DATE NULL,\n" +
                    "  `salariu` INT NULL,\n" +
                    "  `specializare` VARCHAR(45) NULL,\n" +
                    "  `vechime` INT NULL,\n" +
                    "  PRIMARY KEY (`id_medic`));");


        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public void InsertMedic(Medic medic){

        AuditService.getInstance().writeAuditLine("InsertMedic " + ", Thread: " + Thread.currentThread());

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/sys?serverTimezone=UTC",
                    "root", "admin");
            PreparedStatement preparedStatement = null;

            String comanda = "INSERT INTO medic(id_medic, password, nume, prenume, data_angajare, salariu, specializare, vechime) values(?,?,?,?,?,?,?,?)";
            preparedStatement = connection.prepareStatement(comanda);
            preparedStatement.setString(1, medic.getId());
            preparedStatement.setString(2, medic.getPassword());
            preparedStatement.setString(3, medic.getNume());
            preparedStatement.setString(4, medic.getPrenume());
            preparedStatement.setDate(5, new java.sql.Date(medic.getDataAngajare().getTime()));
            preparedStatement.setInt(6, medic.getSalary());
            preparedStatement.setString(7, medic.getSpecializare());
            preparedStatement.setInt(8, medic.getVechime());

            preparedStatement.executeUpdate();

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public void UpdateMedic(String specializare, Integer salariu, String id){

        AuditService.getInstance().writeAuditLine("UpdateMedic " + ", Thread: " + Thread.currentThread());


        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/sys?serverTimezone=UTC",
                    "root", "admin");
            PreparedStatement preparedStatement = null;

            String comanda = "UPDATE medic SET specializare = ?, vechime = ? WHERE id_medic = ?";
            preparedStatement = connection.prepareStatement(comanda);
            preparedStatement.setString(1, specializare);
            preparedStatement.setInt(2, salariu);
            preparedStatement.setString(3, id);


            preparedStatement.executeUpdate();

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public List<Medic> ReadMedicList(){

        List<Medic> lista = new ArrayList<Medic>();

        AuditService.getInstance().writeAuditLine("ReadMedicList " + ", Thread: " + Thread.currentThread());

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/sys?serverTimezone=UTC",
                    "root", "admin");

            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * from medic");


            while (resultSet.next()) {
                        String id =  resultSet.getString(1);
                        String password = resultSet.getString(2);
                        String nume = resultSet.getString(3);
                        String prenume = resultSet.getString(4);
                        java.sql.Date data = resultSet.getDate(5);

                        java.util.Date datautil = new java.util.Date(data.getTime());

                        Integer salariu = resultSet.getInt(6);
                        String specializare= resultSet.getString(7);
                        Integer vechime =   resultSet.getInt(8);

                        Medic medic = new Medic(id, password, nume, prenume, datautil, salariu, specializare, vechime );
                        lista.add(medic);

            }



        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return lista;

    }

    public void ReadMedic(){

        AuditService.getInstance().writeAuditLine("ReadMedic " + ", Thread: " + Thread.currentThread());

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/sys?serverTimezone=UTC",
                    "root", "admin");

            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * from medic");
            ResultSetMetaData resultSetMetaData = resultSet.getMetaData();

            for(int i = 1; i <= resultSetMetaData.getColumnCount(); i++) {

                System.out.println("COLOANA: " + resultSetMetaData.getColumnName(i)
                        + ", TIP: " + resultSetMetaData.getColumnType(i));


            }

            while (resultSet.next()) {
                System.out.println("id=" + resultSet.getInt(1)
                        + ", password=" + resultSet.getString(2)
                        + ", nume=" + resultSet.getString(3)
                        + ", prenume= " + resultSet.getString(4)
                        + ", data= " + resultSet.getString(5)
                        + ", salariu= " + resultSet.getInt(6)
                        + ", specializare= " + resultSet.getString(7)
                        + ", vechime= " + resultSet.getInt(8));

                }



        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }


    public void DeleteMedic(String id){

        AuditService.getInstance().writeAuditLine("DeleteMedic " + ", Thread: " + Thread.currentThread());

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/sys?serverTimezone=UTC",
                    "root", "admin");
            PreparedStatement preparedStatement = null;

            String comanda = "DELETE from medic WHERE id_medic = ?";

            preparedStatement = connection.prepareStatement(comanda);

            preparedStatement.setString(1, id);


            preparedStatement.executeUpdate();

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }



}
