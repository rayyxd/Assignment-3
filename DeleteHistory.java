import java.sql.Connection;
import java.sql.Statement;

public class DeleteHistory {
    public void delete_history(Connection conn) {
        try {
            String query = "delete from history";
            Statement statement = conn.createStatement();
            statement.executeUpdate(query);
            System.out.println("----history deleted");
        }
        catch (Exception e) {
            System.out.println(e);
        }
    }
}
