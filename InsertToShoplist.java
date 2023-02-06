import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class InsertToShoplist {
    public void insert_row_to_shoplist_by_id(Connection conn, int id) {
        try {
            String query1 = String.format("select * from products where empid = %d", id);
            Statement statement = conn.createStatement();
            ResultSet resultSet = statement.executeQuery(query1);
            resultSet.next();

            String product = "";
            product += resultSet.getString("type") + " ";
            product += resultSet.getString("company") + " ";
            product += resultSet.getString("series") + ", ";
            product += resultSet.getString("model") + ", ";
            product += resultSet.getString("capacity") + "Gb";

            int price;
            price = resultSet.getInt("price");

            String query2 = String.format("insert into shoplist(product, price) values('%s','%s');", product, price);
            statement.executeUpdate(query2);
            System.out.println("----product added");
        }catch (Exception e) {
            System.out.println(e);
        }
    }
}
