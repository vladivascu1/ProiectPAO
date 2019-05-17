package services;

import models.Reteta;

import java.sql.*;

public class RetetaJDBC {
    private static RetetaJDBC ourInstance = new RetetaJDBC();

    public static RetetaJDBC getInstance() {
        return ourInstance;
    }

    private RetetaJDBC() {
    }

    public void CreateReteta(){

        AuditService.getInstance().writeAuditLine("CreateReteta " + ", Thread: " + Thread.currentThread());

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/sys?serverTimezone=UTC",
                    "root", "admin");
            Statement statement = connection.createStatement();

            statement.executeUpdate("CREATE TABLE `sys`.`reteta`(\n"+
                    " `numar` INT NOT NULL,\n" +
                    "`medicamente` VARCHAR(45) NULL,\n"+
                    "`doctor` VARCHAR(45) NULL,\n"+
                    "`casa_asigurare` VARCHAR(45) NULL,\n"+
                    "PRIMARY KEY (`numar`));");

            System.out.println("Tabelul 'reteta' a fost creat cu succes");

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void InsertReteta(Reteta reteta){

        AuditService.getInstance().writeAuditLine("InsertReteta " + ", Thread: " + Thread.currentThread());

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/sys?serverTimezone=UTC",
                    "root", "admin");
            PreparedStatement preparedStatement = null;

            String comanda = "INSERT INTO reteta(numar, medicamente, doctor, casa_asigurare) values(?,?,?,?)";
            preparedStatement = connection.prepareStatement(comanda);

            preparedStatement.setInt(1, reteta.getNr());
            preparedStatement.setString(2, reteta.getMedicamente());
            preparedStatement.setString(3, reteta.getDoctor());
            preparedStatement.setString(4, reteta.getCasaAsigurare());


            preparedStatement.executeUpdate();

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }


    public void UpdateReteta(String medicamente, String casa_asigurare, Integer numar){

        AuditService.getInstance().writeAuditLine("UpdateReteta " + ", Thread: " + Thread.currentThread());

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/sys?serverTimezone=UTC",
                    "root", "admin");
            PreparedStatement preparedStatement = null;

            String comanda = "UPDATE reteta SET medicamente = ?, casa_asigurare = ? WHERE numar = ?";

            preparedStatement = connection.prepareStatement(comanda);
            preparedStatement.setString(1, medicamente);
            preparedStatement.setString(2, casa_asigurare);
            preparedStatement.setInt(3, numar);


            preparedStatement.executeUpdate();
            System.out.println("Update tabel reteta cu succes!");

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }


    public void ReadReteta(){

        AuditService.getInstance().writeAuditLine("ReadReteta " + ", Thread: " + Thread.currentThread());

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/sys?serverTimezone=UTC",
                    "root", "admin");

            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * from reteta");
            ResultSetMetaData resultSetMetaData = resultSet.getMetaData();

            for(int i = 1; i <= resultSetMetaData.getColumnCount(); i++) {

                System.out.println("COLOANA: " + resultSetMetaData.getColumnName(i)
                        + ", TIP: " + resultSetMetaData.getColumnType(i));


            }

            while (resultSet.next()) {
                System.out.println("numar reteta=" + resultSet.getInt(1)
                        + ", medicamente prescrise=" + resultSet.getString(2)
                        + ", nume doctor=" + resultSet.getString(3)
                        + ", casa asigurare = " + resultSet.getString(4));
            }

            System.out.println("Citire din tabelul reteta terminata.");

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public void DeleteReteta(Integer numar){

        AuditService.getInstance().writeAuditLine("DeleteReteta " + ", Thread: " + Thread.currentThread());

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/sys?serverTimezone=UTC",
                    "root", "admin");
            PreparedStatement preparedStatement = null;

            String comanda = "DELETE from reteta WHERE numar = ?";

            preparedStatement = connection.prepareStatement(comanda);

            preparedStatement.setInt(1, numar);

            preparedStatement.executeUpdate();

            System.out.println("Delete din tabelul reteta cu succes.");

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }



}
