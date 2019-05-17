package Services;

import Models.User;

import java.sql.*;

public class UserJDBC {
    private static UserJDBC ourInstance = new UserJDBC();

    public static UserJDBC getInstance() {
        return ourInstance;
    }

    private UserJDBC() {
    }

    public void CreateTableUser(){

        AuditService.getInstance().writeAuditLine("CreateTableUser " + ", Thread: " + Thread.currentThread());

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/sys?serverTimezone=UTC",
                    "root", "admin");
            Statement statement = connection.createStatement();

            statement.executeUpdate("CREATE TABLE `sys`.`user` (\n" +
                    "  `id_user` VARCHAR(45) NOT NULL,\n" +
                    "  `password` VARCHAR(45) NOT NULL,\n" +
                    "  PRIMARY KEY (`id_angajat`));");



        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public void InsertUser(User user){

        AuditService.getInstance().writeAuditLine("InsertUser " + ", Thread: " + Thread.currentThread());

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/sys?serverTimezone=UTC",
                    "root", "admin");
            PreparedStatement preparedStatement = null;

            String comanda = "INSERT INTO user(id_user, password) values(?,?)";


            preparedStatement = connection.prepareStatement(comanda);
            preparedStatement.setString(1, user.getId());
            preparedStatement.setString(2, user.getPassword());


            preparedStatement.executeUpdate();

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public void UpdateUser(String new_id, String password, String id){

        AuditService.getInstance().writeAuditLine("UpdateUser " + ", Thread: " + Thread.currentThread());

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/sys?serverTimezone=UTC",
                    "root", "admin");
            PreparedStatement preparedStatement = null;

            String comanda = "UPDATE user SET id_user = ?, password = ? WHERE id_user = ?";
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

    public void ReadUser(){

        AuditService.getInstance().writeAuditLine("ReadUser " + ", Thread: " + Thread.currentThread());


        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/sys?serverTimezone=UTC",
                    "root", "admin");

            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * from user");
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
                System.out.println("id_user=" + resultSet.getInt(1)
                        + ", password=" + resultSet.getString(2));

            }



        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }


    public void DeleteUser(String id){

        AuditService.getInstance().writeAuditLine("DeleteUser " + ", Thread: " + Thread.currentThread());

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/sys?serverTimezone=UTC",
                    "root", "admin");
            PreparedStatement preparedStatement = null;

            String comanda = "DELETE from user WHERE id_user = ?";

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
