import java.sql.Connection;
import java.sql.Statement;

public class CreateTableHistory {
    public void createTableHistory(Connection conn) {
        Statement statement;
        try {
            String query = "create table " + "history" + "(empid SERIAL, name varchar(200), phone varchar(200), price integer, primary key(empid));";
            statement = conn.createStatement();
            statement.executeUpdate(query);
            System.out.println("Table history Created");
        }catch (Exception e) {
            System.out.println(e);
        }
    }
}
