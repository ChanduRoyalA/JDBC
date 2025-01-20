package jdbc;

import java.sql.*;
// Get Details for the MySql DB
public class LaunchJDBC1 {
    public static void getStudentDetails(Statement stmt) throws SQLException {

        ResultSet res = stmt.executeQuery("select * from student");
        while(res.next()){
            System.out.println(res.getInt(1)+" "+res.getString(2)+" "+res.getInt(3)+" "+res.getString(4));
        }
        res.close();
    }
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        // load and register the driver
        Class.forName("com.mysql.cj.jdbc.Driver");
        System.out.println("Driver is Registered");

        //Establish the Connection
        String url = "jdbc:mysql://localhost:3306/jdbc";
        String userName = "root";
        String password = "7102";
        Connection connection = DriverManager.getConnection(url,userName,password);
        System.out.println("Connection Established");

        //Sql Queries
        Statement stmt = connection.createStatement();
        stmt.close();
        connection.close();
    }
}
