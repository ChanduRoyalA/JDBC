package jdbc;

import java.sql.*;

public class JDBCutility {
    static{
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
        }
        catch (Exception e){
            System.out.println(e);
        }
    }
    static Connection connection;
    public static Connection getConnection() throws  SQLException{
        String url = "jdbc:mysql://localhost:3306/jdbc";
        String username = "root";
        String password = "7102";
        try{
            connection = DriverManager.getConnection(url,username,password);
        }
        catch (Exception e){
            System.out.println(e);

        }
        return connection;
    }
    public static void closeConnections(Connection connection,Statement stmt,ResultSet res) throws SQLException {
        connection.close();
        stmt.close();
        res.close();

    }
}
