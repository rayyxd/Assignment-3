import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class ReadDataShoplist {
    public void read_data_from_shoplist(Connection conn) {
        try {
            String query = "select * from shoplist";
            Statement statement = conn.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            int totalPrice = 0;
            while(resultSet.next()) {
                System.out.print("id " + resultSet.getString("empid") + ": ");
                System.out.print(resultSet.getString("product") + " | ");
                System.out.println(resultSet.getInt("price") + " tg");
                totalPrice += resultSet.getInt("price");
            }
            System.out.println("----total cost of your shopping list: "+totalPrice+" tg");
        }
        catch (Exception e) {
            System.out.println(e);
        }
    }
}
