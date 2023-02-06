import java.sql.Connection;
import java.sql.Statement;

public class DeleteShoplist {
    public void delete_shoplist(Connection conn) {
        try {
            String query = "delete from shoplist";
            Statement statement = conn.createStatement();
            statement.executeUpdate(query);
            System.out.println("----shopping list deleted");
        }
        catch (Exception e) {
            System.out.println(e);
        }
    }
}
