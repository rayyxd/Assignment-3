import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class ReadDataFromUsers {
    public void read_data_from_users(Connection conn) {
        try {
            String query = String.format("select * from %s", "users");
            Statement statement = conn.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            while(resultSet.next()) {
                System.out.print(resultSet.getString("empid") + " ");
                System.out.print(resultSet.getString("name") + " ");
                System.out.println(resultSet.getString("phone") + " ");
            }
        }
        catch (Exception e) {
            System.out.println(e);
        }
    }
}
