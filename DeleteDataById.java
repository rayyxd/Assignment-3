import java.sql.Connection;
import java.sql.Statement;

public class DeleteDataById {
    public void delete_data_by_id(Connection conn, String table_name, int id) {
        try {
            String query = String.format("delete from %s where empid = '%d'", table_name, id);
            Statement statement = conn.createStatement();
            statement.executeUpdate(query);
            System.out.println("----successful deleted");
        }
        catch (Exception e) {
            System.out.println(e);
        }
    }
}
