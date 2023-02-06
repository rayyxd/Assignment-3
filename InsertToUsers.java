import java.sql.Connection;
import java.sql.Statement;

public class InsertToUsers {
    public void insert_row_to_users(Connection conn, String name, String phone) {
        try {
            String query = String.format("insert into users(name,phone) values('%s','%s');", name, phone);
            Statement statement = conn.createStatement();
            statement.executeUpdate(query);
        }catch (Exception e) {
            System.out.println(e);
        }
    }
}
