import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

public class DBTest {
    public static void main(String[] args) {
        // Database connection properties
        Properties props = new Properties();
        props.setProperty("user", "sql12794970");
        props.setProperty("password", "7uwdtxm4TB");

        // JDBC URL for FreeSQLDatabase.com (no SSL required)
        String url = "jdbc:mysql://sql12.freesqldatabase.com:3306/sql12794970";

        try (Connection conn = DriverManager.getConnection(url, props)) {
            System.out.println("Connected successfully!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
