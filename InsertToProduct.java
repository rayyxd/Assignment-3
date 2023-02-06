import java.sql.Connection;
import java.sql.Statement;

public class InsertToProduct {
    public void insert_row_to_products(Connection conn, String table_name, String type, String company, String series, String model, int capacity, int price) {
        Statement statement;
        try {
            String query = String.format("insert into %s(type, company, series, model, capacity, price) values('%s','%s','%s','%s','%s','%s');", table_name, type, company, series, model, capacity, price);
            statement = conn.createStatement();
            statement.executeUpdate(query);
        }catch (Exception e) {
            System.out.println(e);
        }
    }
}
