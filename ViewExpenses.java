import java.sql.*;
public class ViewExpenses{
    public void view(){
        Connection con=null;
        PreparedStatement ps=null;
        ResultSet rs=null;
        try {
            con=DBConnection.getConnection();
            String query="SELECT * FROM expensestable";
            ps=con.prepareStatement(query);
             rs=ps.executeQuery();
            while(rs.next()){
                System.out.println(rs.getInt(1)+" "+rs.getDouble(2)+" "+rs.getString(3)+" "+rs.getString(4)+" "+rs.getString(5));
            }
        }catch(Exception e){
            System.out.println(e);
        }
        try {
            if(rs!=null) rs.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        DBConnection.closeConnection(con, ps);

    }
}