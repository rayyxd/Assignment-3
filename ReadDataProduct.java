import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class ReadDataProduct {
    public void read_data_from_products_by_type(Connection conn, String type) {
        try {
            String query = String.format("select * from %s where type = '%s'", "products", type);
            Statement statement = conn.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            while(resultSet.next()) {
                System.out.print(resultSet.getString("empid") + ": ");
                System.out.print(resultSet.getString("type") + " ");
                System.out.print(resultSet.getString("company") + " ");
                System.out.print(resultSet.getString("series") + " ");
                System.out.print(resultSet.getString("model") + ", ");
                System.out.print(resultSet.getInt("capacity") + "Gb, ");
                System.out.println(resultSet.getInt("price") + " tg ");
            }
        }
        catch (Exception e) {
            System.out.println(e);
        }
    }
}
