package Controllers;

import Models.Furniture;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class FurnitureController {
    private static Furniture _furnituremodel;

    public FurnitureController(Furniture furniture)
    {
        _furnituremodel = furniture;
    }

    public void CreateNewFurniture(
    int    Id,
    String Sku, 
    String name, 
    String type, 
    String color, 
    double price, 
    int remaining)
    {
        _furnituremodel.set_sKU(Sku);
        _furnituremodel.set_name(name);
        _furnituremodel.set_type(type);
        _furnituremodel.set_color(color);
        _furnituremodel.set_price(price);
        _furnituremodel.set_quantity(remaining);

        SaveFurnitureToDatabase(_furnituremodel);
    }

    public String PrintFurniture()
    {
        return _furnituremodel.get_color();
    }

    private void SaveFurnitureToDatabase(Furniture furniture)
    {
        Connection conn = null;
        try {
            String url       = "jdbc:mysql://localhost:3306/stevesfurniture";
            String user      = "root";
            String password  = "";

            conn = DriverManager.getConnection(url, user, password);

            furniture.toString();

            PreparedStatement ps = conn.prepareStatement("insert into product values(?,?,?,?,?,?)");
            ps.setString(1, furniture.get_sKU());
            ps.setString(2, furniture.get_name());
            ps.setString(3, furniture.get_type());
            ps.setString(4, furniture.get_color());
            ps.setDouble(5, furniture.get_price());
            ps.setInt(6, furniture.get_quantity());

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
}