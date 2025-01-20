package jdbc;
import java.sql.*;
import java.util.Scanner;

import jdbc.JDBCutility;
public class JDBCPreparedStatement {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        Connection connection=null;
        PreparedStatement stmt = null;
        try{
            connection = JDBCutility.getConnection();
            if(connection!=null){
                stmt = connection.prepareStatement("insert into student(student_id,name,age,gender) values(?,?,?,?)");
            }
            if(stmt!=null){
                System.out.println("Enter Details (id,name,age,gender)");
                Integer id = in.nextInt();
                String name = in.next();
                Integer age = in.nextInt();
                String gender = in.next();

                stmt.setInt(1,id);
                stmt.setString(2,name);
                stmt.setInt(3,age);
                stmt.setString(4,gender);
                int rowsUpdate = stmt.executeUpdate();
                System.out.println(rowsUpdate+" :Rows Updated");
                System.out.println("Follow(0,1) ?");
                int follow = in.nextInt();
                if(follow==1){
                    LaunchJDBC1.getStudentDetails(stmt);
                }
                else{
                    System.out.println("Data added");
                }
            }

        }
        catch (SQLException e){
            System.out.println(e);
        }
        catch (Exception e){
            System.out.println(e);
        }
        finally {
            try{
                JDBCutility.closeConnections(connection,stmt,null);
            }
            catch (Exception e){
                System.out.println();
            }

        }
    }
}
