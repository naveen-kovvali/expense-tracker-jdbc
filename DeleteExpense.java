import java.sql.*;
public class DeleteExpense{
    public void delete(int id){
        Connection con=null;
        PreparedStatement ps=null;        
        try {
            con=DBConnection.getConnection();
            String query="DELETE FROM expensestable WHERE id=?";
            ps=con.prepareStatement(query);
            ps.setInt(1,id);
            int x=ps.executeUpdate();
            if(x>=1){
                System.out.println("deleted successfully..");
            }else{
                System.out.println("not deleted");
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        DBConnection.closeConnection(con, ps);
    }
}