package services;

import models.Angajat;
import java.sql.*;

public class AngajatJDBC {
    private static AngajatJDBC ourInstance = new AngajatJDBC();

    public static AngajatJDBC getInstance() {
        return ourInstance;
    }

    private AngajatJDBC() {
    }

    public void CreateTableAngajat(){

        AuditService.getInstance().writeAuditLine("CreateTableAngajat " + ", Thread: " + Thread.currentThread());

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/sys?serverTimezone=UTC",
                    "root", "admin");
            Statement statement = connection.createStatement();

            statement.executeUpdate("CREATE TABLE `sys`.`angajat` (\n" +
                    "  `id_angajat` VARCHAR(45) NOT NULL,\n" +
                    "  `password` VARCHAR(45) NOT NULL,\n" +
                    "  `nume` VARCHAR(45) NOT NULL,\n" +
                    "  `prenume` VARCHAR(45) NOT NULL,\n" +
                    "  `data_angajare` DATE NULL,\n" +
                    "  `salariu` INT NULL,\n" +
                    "  PRIMARY KEY (`id_angajat`));");



        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public void InsertAngajat(Angajat angajat){

        AuditService.getInstance().writeAuditLine("InsertAngajat " + ", Thread: " + Thread.currentThread());

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/sys?serverTimezone=UTC",
                    "root", "admin");
            PreparedStatement preparedStatement = null;

            String comanda = "INSERT INTO angajat(id_angajat, password, nume, prenume, data_angajare, salariu) values(?,?,?,?,?,?)";


            preparedStatement = connection.prepareStatement(comanda);
            preparedStatement.setString(1, angajat.getId());
            preparedStatement.setString(2, angajat.getPassword());
            preparedStatement.setString(3, angajat.getNume());
            preparedStatement.setString(4, angajat.getPrenume());
            preparedStatement.setDate(5, new java.sql.Date(angajat.getDataAngajare().getTime()));
            preparedStatement.setInt(6, angajat.getSalary());


            preparedStatement.executeUpdate();

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public void UpdateAngajat(String new_id, String password, String id){

        AuditService.getInstance().writeAuditLine("UpdateAngajat " + ", Thread: " + Thread.currentThread());


        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/sys?serverTimezone=UTC",
                    "root", "admin");
            PreparedStatement preparedStatement = null;

            String comanda = "UPDATE angajat SET id_angajat = ?, password = ? WHERE id_angajat = ?";
            preparedStatement = connection.prepareStatement(comanda);
            preparedStatement.setString(1, new_id);
            preparedStatement.setString(2, password);
            preparedStatement.setString(3, id);


            preparedStatement.executeUpdate();

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public void ReadAngajat(){

        AuditService.getInstance().writeAuditLine("ReadAngajat " + ", Thread: " + Thread.currentThread());


        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/sys?serverTimezone=UTC",
                    "root", "admin");

            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * from angajat");
//            ResultSetMetaData resultSetMetaData = resultSet.getMetaData();
//
//            for(int i = 1; i <= resultSetMetaData.getColumnCount(); i++) {
//
//                System.out.println("COLOANA: " + resultSetMetaData.getColumnName(i)
//                        + ", TIP: " + resultSetMetaData.getColumnType(i));
//
//
//            }

            while (resultSet.next()) {
                System.out.println("id=" + resultSet.getInt(1)
                        + ", password=" + resultSet.getString(2)
                        + ", nume=" + resultSet.getString(3)
                        + ", prenume= " + resultSet.getString(4)
                        + ", data= " + resultSet.getString(5)
                        + ", salariu= " + resultSet.getInt(6));

            }



        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }


    public void DeleteAngajat(String id){

        AuditService.getInstance().writeAuditLine("DeleteAngajat " + ", Thread: " + Thread.currentThread());

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/sys?serverTimezone=UTC",
                    "root", "admin");
            PreparedStatement preparedStatement = null;

            String comanda = "DELETE from angajat WHERE id_angajat = ?";

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
