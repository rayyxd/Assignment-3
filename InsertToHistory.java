import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class InsertToHistory {
    public void insert_row_to_history(Connection conn, String name, String phone) {
        try {
            String query1 = String.format("select * from %s", "shoplist");
            Statement statement = conn.createStatement();
            ResultSet resultSet = statement.executeQuery(query1);
            int totalPrice = 0;
            while(resultSet.next()) {
                int price = resultSet.getInt("price");
                totalPrice += price;
            }
            String query2 = String.format("insert into history(name,phone,price) values('%s','%s','%d');", name, phone, totalPrice);
            statement.executeUpdate(query2);
        }catch (Exception e) {
            System.out.println(e);
        }
    }
}
