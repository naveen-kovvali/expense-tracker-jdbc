import java.sql.*;
public class DBConnection{
    static{
       try {
           Class.forName("com.mysql.cj.jdbc.Driver");
       } catch (Exception e) {
        System.out.println(e);
       }

    }
    public static Connection getConnection(){
        Connection con=null;
        try {
            String url="jdbc:mysql://localhost:3307/expenses";
            String user="root";
            String pass="";
            con=DriverManager.getConnection(url,user,pass);            

        } catch (Exception e) {
           e.printStackTrace();
        }
        return con;
    }
    public static void closeConnection(Connection con,PreparedStatement ps){
        try {
           if(con!=null) con.close();
          if(ps!=null)  ps.close();
         
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}