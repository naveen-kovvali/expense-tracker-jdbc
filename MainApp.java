import java.util.*;
public class MainApp{
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        AddExpenses add=new AddExpenses();
        ViewExpenses view=new ViewExpenses();
        UpdateExpense update=new UpdateExpense();
        DeleteExpense delete=new DeleteExpense();
        ReportExpenses report=new ReportExpenses();
        while(true){
            System.out.println("-------------------------");
            System.out.println("1.Add Expenses.");
            System.out.println("2.View Expenses.");
            System.out.println("3.Update Expenses.");
            System.out.println("4.Delete Expenses.");
            System.out.println("5.Get total Sum of Expenses.");
            System.out.println("6.Category wise Expenses.");
            System.out.println("7.Exit.");
            System.out.println("Enter your choice:");
            int ch=sc.nextInt();
            switch(ch){
                case 1:
                     System.out.println("Enter amount:");
                     double amount=sc.nextDouble();
                     sc.nextLine();
                     System.out.println("Enter Category(clothes/food/ect..):");
                     String category=sc.nextLine();
                     System.out.println("Enter Date(yyyy/mm/dd):");
                     String date=sc.nextLine();
                     System.out.println("Enter Description:");
                     String description=sc.nextLine();
                     add.add(amount,category,date,description);
                     break;
                case 2:
                    view.view();
                    break;
                case 3:
                    System.out.println("Enter new amount:");
                    double Newamount=sc.nextDouble();
                    System.out.println("Enter your Id:");
                    int newid=sc.nextInt();
                    update.update(Newamount,newid);
                   break;
                case 4:
                    System.out.println("Enter the id to delete:");
                    int id=sc.nextInt();
                    delete.delete(id);
                    break;
                case 5:
                    report.totalExpenses();
                    break;
                case 6:
                    report.categoryWiseReport();
                case 7:return;                   
            }
        }
    }
}