package Views;

import Models.Furniture;
import java.io.*;
import java.util.logging.*;

import Controllers.FurnitureController;

public class FurnitureView {
    
    public void CreateFurnitureMenu(Logger logger) throws IOException
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Furniture newfurniture = new Furniture();
        
        System.out.println("You would like to create a new furniture item within the system. First Write the SKU of the item");
        newfurniture.set_sKU(reader.readLine());

        System.out.println("\nSecond, what is the name of the item?");
        newfurniture.set_name(reader.readLine());

        System.out.println("\nThird, what is the Type of Furniture");
        newfurniture.set_type(reader.readLine());

        System.out.println("\nFourth, what is the Color");
        newfurniture.set_color(reader.readLine());

        System.out.println("\nPrice, how much does it cost");
        newfurniture.set_price(reader.read());

        System.out.println("\nQuantity, how many of these did we receive");
        newfurniture.set_quantity(reader.read());

        FurnitureController newfurniturecontroller = new FurnitureController();
        
        newfurniturecontroller.Create(newfurniture);
    }

    public void DisplayFurnitureReport()
    {
        System.out.println("PRINTING ALL FURNITURE ITEMS\n______________________\n");

        FurnitureController newfurniturecontroller = new FurnitureController();

        newfurniturecontroller.GetAllFurniture();

    }
}
