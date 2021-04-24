package Views;

import java.util.logging.*;
import java.io.*;
import Models.User;

public class Login {

    public void LoginMenu(Logger logger) throws IOException
    {
        
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    User newuser = new User(); 

        System.out.println("There are no known users within the system. Please Create an account\n\n1.Username");
        var username = reader.readLine();
        newuser.set_username(username);
        logger.info("Created account with username: " + username);

        System.out.println("\n\n2.Create a New Password");
        var password = reader.readLine();
        newuser.set_password(password);
        logger.info("Created Password: " + password);

        System.out.println("\n\n3.Employee Id");
        var employeeid = reader.readLine();
        newuser.set_employeeId(employeeid);
        logger.info("Employee Id: " + employeeid);

        newuser.set_id(0);
}
}
