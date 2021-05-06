import java.io.*;

import Views.FurnitureView;
import Views.Login;

import java.util.logging.*;

public class Main
{
    static Logger logger = Logger.getLogger(Main.class.getName());
    
    public static void main(String []args) throws IOException, FileNotFoundException
    {  
        //#region Logger Information
        
        try {
			LogManager.getLogManager().readConfiguration(new FileInputStream("mylogging.properties"));	
		} catch (SecurityException | IOException e) {
			e.printStackTrace();
		}

        logger.setLevel(Level.FINE);
		FileHandler fh;

		// Stops error from being displayed in console window and only show up in the log file
		logger.setUseParentHandlers(false);

		try {  

			// This block configure the logger with handler and formatter  
			fh = new FileHandler("C:/Users/jack.jenkins/Desktop/logger.log");  
			logger.addHandler(fh);
			SimpleFormatter formatter = new SimpleFormatter();  
			fh.setFormatter(formatter);  
		
			// the following statement is used to log any messages  
			logger.info("Starting the Logger \n\n");  
		
		  } catch (SecurityException e) {  
			  e.printStackTrace();  
		  } catch (IOException e) {  
			  throw e;
		  }

        //#endregion

        Login newlogin = new Login();
        FurnitureView newFurnitureView = new FurnitureView();
        newlogin.LoginMenu(logger);
        
        // Reader Method Class
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        
        do
        {
            System.out.println("What would you like to do? Enter the Number below:"
            + "\n1. Create new Furniture"
            + "\n2. View Furniture Report"
            + "\n3. Sell Furniture Item"
            + "\n4. Exit\n");

            String UserInput = reader.readLine();

            switch(UserInput)
            {
                case "1":
                newFurnitureView.CreateFurnitureMenu(logger);
                break;
                case "2":
                newFurnitureView.DisplayFurnitureReport();
                break;
                case "3":
                newFurnitureView.SellFurnitureItem(logger);
                break;
                case "4":
                // Exit the Application
                System.exit(0);
            }
        }
        while(true);
    }
}