package jdbc;

import java.sql.*;
import  jdbc.JDBCutility;
public class LaunchJDBC2 {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
//        Class.forName("com.mysql.cj.jdbc.Driver");

        Connection connection = JDBCutility.getConnection();

     String q = "insert into student(student_id,name,age,gender) values(6,'surya',28,'male'),(7,'krishna',26,'male')";
//        String q = "update student set name='Krishna Radha' where student_id=7";
//        String q ="delete from student where student_id=7";
        Statement stmt = connection.createStatement();
        int rowAffected = stmt.executeUpdate(q);
        if(rowAffected>0){
            System.out.println("data deleted");
        }
        else{
            System.out.println("no data deleted");
        }
        stmt.close();
        connection.close();
    }
}
