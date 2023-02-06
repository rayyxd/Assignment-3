import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class SearchByPrice {
    public void search_by_price(Connection conn, String table_name, int price) {
        try {
            String query = String.format("select * from %s where price = '%d'", table_name, price);
            Statement statement = conn.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                System.out.print(resultSet.getString("empid") + " ");
                System.out.print(resultSet.getString("company") + " ");
                System.out.print(resultSet.getString("series") + " ");
                System.out.print(resultSet.getString("model") + " ");
                System.out.print(resultSet.getInt("capacity") + " ");
                System.out.println(resultSet.getInt("price"));
            }
        }
        catch (Exception e) {
            System.out.println(e);
        }
    }
}
