import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
    {
        Connection conn = null;
        try {
            String url       = "jdbc:mysql://localhost:3306/stevesfurniture";
            String user      = "root";
            String password  = "secret";

            conn = DriverManager.getConnection(url, user, password);

        } 
        catch (Exception ex) {
            System.out.println(ex.getMessage());
        } 
        finally 
        {
            try
            {
                if(conn != null)
                conn.close();
            }
            catch(SQLException ex)
            {
                System.out.println(ex.getMessage());
            }
        }
    }
}
