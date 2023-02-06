import java.sql.Connection;
import java.sql.Statement;

public class CreateTableShoplist {
    public void createTableShoplist(Connection conn) {
        Statement statement;
        try {
            String query = "create table " + "shoplist" + "(empid SERIAL, product varchar(200), price integer, primary key(empid));";
            statement = conn.createStatement();
            statement.executeUpdate(query);
            System.out.println("Table shoplist Created");
        }catch (Exception e) {
            System.out.println(e);
        }
    }
}
