package jdbc;
import java.sql.*;
import jdbc.JDBCutility;

public class LaunchJDBCAll {
    public static void main(String[] args) throws SQLException {
        Connection connection = null;
        Statement stmt = null;
        ResultSet res = null;
        try{
            connection = JDBCutility.getConnection();
            if(connection!=null){
                stmt = connection.createStatement();
            }
            if(stmt!=null){

//                boolean status  = stmt.execute("Select * from student");
//                if(status){
//                    res = stmt.getResultSet();
//                }
//                else{
//                    int countRowUpdated = stmt.getUpdateCount();
//                }
                res = stmt.executeQuery("Select * from student");


            }
            if(res!=null){
                while(res.next()){
                    System.out.println(res.getInt(1)+" "+res.getString(2)+" "+res.getInt(3)+" "+res.getString(4));
                }
            }
            System.out.println("\nData Fecthed and Displayed");
        }catch (SQLException e){
            System.out.println(e);
        }
        catch (Exception e){
            System.out.println(e);
        }
        finally {
            JDBCutility.closeConnections(connection,stmt,res);
        }
    }
}
