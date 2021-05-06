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

        System.out.println("\nPrice, how much does it cost");

        try
        {
            newfurniture.set_price(Double.parseDouble(reader.readLine()));
        } catch (Exception ex)
        {
            logger.severe("User did not Input a Correct quanitity" + ex);
            System.out.println("You did not enter the correct quanitity, please try again" + ex);
        }


        System.out.println("\nQuantity, how many of these did we receive");
        
        try{
            newfurniture.set_quantity(Integer.parseInt(reader.readLine()));
        } catch (Exception ex)
        {
            logger.severe("User did not Input a Correct quanitity" + ex);
            System.out.println("You did not enter the correct quanitity, please try again" + ex);
        }
        

        System.out.println("\nLastly, what is the Color");
        newfurniture.set_color(reader.readLine());


        FurnitureController newfurniturecontroller = new FurnitureController();
        
        newfurniturecontroller.Create(newfurniture);

        logger.info("Created New Furniture Item" + newfurniture.get_sKU());
    }

    public void DisplayFurnitureReport()
    {
        System.out.println("PRINTING ALL FURNITURE ITEMS\n______________________\n");

        FurnitureController newfurniturecontroller = new FurnitureController();

        newfurniturecontroller.GetAllFurniture();

    }

    public void SellFurnitureItem(Logger logger) throws IOException {
        System.out.println("You have sold a piece of Furniture. Congratulations! Please write down the Id of the Furniture that you sold: \n");
        
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String id = reader.readLine();

        FurnitureController newfurniturecontroller = new FurnitureController();
        
        newfurniturecontroller.RemoveQuanitityFromSKU(id);
    }
}
