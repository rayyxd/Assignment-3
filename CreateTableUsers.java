import java.sql.Connection;
import java.sql.Statement;

public class CreateTableUsers {
    public void createTableUsers(Connection conn) {
        Statement statement;
        try {
            String query = "create table " + "users" + "(empid SERIAL, name varchar(200), phone varchar(200), primary key(empid));";
            statement = conn.createStatement();
            statement.executeUpdate(query);
            System.out.println("Table users Created");
        }catch (Exception e) {
            System.out.println(e);
        }
    }
}
