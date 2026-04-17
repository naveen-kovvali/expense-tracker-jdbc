import java.sql.*;
public class AddExpenses{
    public void add(double amount,String category,String date,String description){
        Connection con=null;
        PreparedStatement ps=null;
        con=DBConnection.getConnection();    
        try {
            String query="INSERT INTO expensestable(amount,category,date,description)VALUES(?,?,?,?)";
            ps=con.prepareStatement(query);
            ps.setDouble(1,amount);
            ps.setString(2,category);
            ps.setString(3,date);
            ps.setString(4,description);
            int x=ps.executeUpdate();
            if(x>=1){
                System.out.println("expenses added successfully..");
            }else{
                System.out.println("expenses are not added");
            }
        } catch (Exception e) {
            System.out.println(e);
        }       
        DBConnection.closeConnection(con, ps);
    }
    
}