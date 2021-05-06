package Controllers;

import Models.Furniture;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class FurnitureController {

    public FurnitureController()
    {
    }
    

    public void GetAllFurniture()
    {
        Connection conn = null;

        try {
            String url       = "jdbc:mysql://localhost:3306/stevesfurniture";
            String user      = "root";
            String password  = "MyNewPass";

            conn = DriverManager.getConnection(url, user, password);

            PreparedStatement ps = conn.prepareStatement("select * FROM furniture");
            ResultSet rs = ps.executeQuery();

            while(rs.next())
            {
                System.out.println("\n\nITEM\n____________\n");
                System.out.println("Id: " + rs.getString("id") + "\n" + 
                    "Stock keeping Unit: " + rs.getString("sku") + "\n" +
                    "Name of Furniture: " + rs.getString("name") + "\n" +
                    "Type of Furniture: " + rs.getString("type") + "\n" +
                    "Color of Furniture: " + rs.getString("color") + "\n" +
                    "Price of Furniture: " + rs.getString("price") + "\n" +
                    "Quantity On Hand: " + rs.getString("quantity") + "\n");
            }

            System.out.print("\n\n");

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

    public void Create(Furniture _furnituremodel)
    {
        Connection conn = null;
        try {
            String url       = "jdbc:mysql://localhost:3306/stevesfurniture";
            String user      = "root";
            String password  = "MyNewPass";

            conn = DriverManager.getConnection(url, user, password);

            _furnituremodel.toString();

            PreparedStatement ps = conn.prepareStatement("INSERT into furniture (SKU, Name, Type, Color, Price, Quantity) values(?,?,?,?,?,?)");
            ps.setString(1, _furnituremodel.get_sKU());
            ps.setString(2, _furnituremodel.get_name());
            ps.setString(3, _furnituremodel.get_type());
            ps.setString(4, _furnituremodel.get_color());
            ps.setDouble(5, _furnituremodel.get_price());
            ps.setInt(6, _furnituremodel.get_quantity());

            ps.executeUpdate();

            System.out.println("Inserted item into Database");

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

    public void RemoveQuanitityFromSKU(String id)
    {
        Connection conn = null;
        try {
            String url       = "jdbc:mysql://localhost:3306/stevesfurniture";
            String user      = "root";
            String password  = "MyNewPass";

            conn = DriverManager.getConnection(url, user, password);

            PreparedStatement ps = conn.prepareStatement("UPDATE furniture SET quantity= quantity - 1 WHERE id= " + id);
            ps.executeUpdate();
            
            
            System.out.println("Removed a quantity from the database! Keep Selling that Furniture!");

        } catch (Exception e)
        {
            System.out.println(e.getMessage());
        }
    }
}