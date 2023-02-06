import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;

public class JavaProject {
    public static void main(String[] args) throws SQLException {
        //creating new dbFunctions function to use its methods
        dbFunctions db = new dbFunctions();
        InsertToHistory ith = new InsertToHistory();
        InsertToUsers itu = new InsertToUsers();
        InsertToShoplist its = new InsertToShoplist();
        ReadDataProduct rdp = new ReadDataProduct();
        ReadDataShoplist rds = new ReadDataShoplist();
        DeleteShoplist ds = new DeleteShoplist();
        DeleteDataById ddbi = new DeleteDataById();
        //connecting to database
        Connection conn = db.connect_to_db("postgres", "postgres", "root8");

        //endless menu with while loop
        while(true) {
            boolean isExit = false;
            System.out.println("----Hello, it's our mini-smart-market, please, choose the category (enter number)");
            System.out.println("1.Phones");
            System.out.println("2.Laptops");
            System.out.println("3.Show my shopping list");
            System.out.println("4.Buy and leave");
            System.out.println("5.Exit");
            //scanner to choose an option
            Scanner scanner = new Scanner(System.in);
            int option = scanner.nextInt();
            //switch
            switch (option) {
                //the first option
                case 1 -> {
                    //show all phones
                    rdp.read_data_from_products_by_type(conn, "phone");
                    System.out.println("----choose the product number to add it in your shopping list");
                    int choose = scanner.nextInt();
                    //add chosen phone to shopping list
                    its.insert_row_to_shoplist_by_id(conn, choose);
                }
                //the second option
                case 2 -> {
                    //show all laptops
                    rdp.read_data_from_products_by_type(conn, "laptop");
                    System.out.println("----choose the product number to add it in your shopping list");
                    int choose = scanner.nextInt();
                    //add chosen laptop to shopping list
                    its.insert_row_to_shoplist_by_id(conn, choose);
                }
                //the third option
                //show user's shopping list and option to delete product from shopping list
                case 3 -> {
                    rds.read_data_from_shoplist(conn);
                    System.out.println("----choose the option (enter number)");
                    System.out.println("1.Delete product from shopping list");
                    System.out.println("2.Go back to main menu");
                    int option_in_shoplist = scanner.nextInt();
                    //delete product with if condition
                    if (option_in_shoplist == 1) {
                        System.out.println("----enter id to delete");
                        int id_to_delete = scanner.nextInt();
                        ddbi.delete_data_by_id(conn, "shoplist", id_to_delete);
                    }
                }
                //the fourth option
                case 4 -> {
                    System.out.println("----before you buy, please enter your name and phone number");
                    Scanner choose = new Scanner(System.in);
                    System.out.println("name: ");
                    String name = choose.nextLine();
                    System.out.println("phone: ");
                    String phone = choose.nextLine();
                    ith.insert_row_to_history(conn, name, phone);
                    itu.insert_row_to_users(conn, name, phone);
                    System.out.println("----thanks for visiting!");
                    isExit = true;
                }
                //the fifth option, isExit statement becomes true
                case 5 -> isExit = true;
                //if user inputs another symbols
                default -> System.out.println("!!!WRONG ENTER!!!");
            }
            //checking boolean isExit
            if(isExit) {
                //delete shoplist's all rows whenever exit the programme
                ds.delete_shoplist(conn);
                System.out.println("----byeeeee...");
                break;
            }
        }
    }
}