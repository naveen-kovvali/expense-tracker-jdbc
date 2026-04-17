import java.sql.*;
public class ReportExpenses{     
    public void totalExpenses(){      
          Connection con=null;
         PreparedStatement ps=null;   
         ResultSet rs=null;    
        try {
            con=DBConnection.getConnection();
            String query="SELECT SUM(amount) As total FROM expensestable";
            ps=con.prepareStatement(query);
             rs=ps.executeQuery();
            if(rs.next()){
                double total=rs.getDouble("total");
                if(rs.wasNull()){
                    System.out.println("No expenses found.");
                }else{
                    System.out.println("Total Expenses: "+total);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
       try {
            if(rs!=null) rs.close();
       } catch (Exception e) {
        e.printStackTrace();
       }
        DBConnection.closeConnection(con, ps);
    }
    public void categoryWiseReport(){
          Connection con=null;
        PreparedStatement ps=null; 
        ResultSet rs=null;
       try {
           con=DBConnection.getConnection();
           String query="SELECT category,sum(amount)as total FROM expensestable GROUP BY category";
           ps=con.prepareStatement(query);
            rs=ps.executeQuery();
            System.out.println("------------------");
            System.out.println("Category | Total");
            System.out.println("------------------");
           while(rs.next()){
            String category=rs.getString("category");
            double total=rs.getDouble("total");
            System.out.println(category+" | "+total);
           }
       } catch (Exception e) {
        e.printStackTrace();
       }
       try {
           if(rs!=null) rs.close();
       } catch (Exception e) {
        e.printStackTrace();
       }
       DBConnection.closeConnection(con, ps);
    }
}