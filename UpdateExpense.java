import java.sql.*;
public class UpdateExpense{
    public void update(double Newamount,int id){
        Connection con=null;
        PreparedStatement ps=null;       
        try {
             con=DBConnection.getConnection();
            String query="UPDATE expensestable SET amount=? WHERE id=?";
            ps=con.prepareStatement(query);
            ps.setDouble(1,Newamount);
            ps.setInt(2,id);           
            int x=ps.executeUpdate();
            if(x>=1){
                System.out.println("updated successfully...");
            }else{
                System.out.println("not updated..");
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        DBConnection.closeConnection(con, ps);
    }
}
