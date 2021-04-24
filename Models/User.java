package Models;

public class User {
 
    //#region Properties

    private static int    _id;
    private static String _username;
    private static String _password;
    private static String _employeeId;
    private static User user_instance = null;

    //#endregion


    //#region Constructor

    public static User getInstance()
    {
        if(user_instance == null)
        user_instance = new User();
        
        return user_instance;
    }

    //#endregion


    //#region Public Getter / Setters

   
    public  int get_id() 
    {
        return _id;
    }

    public  void set_id(int id) 
    {
        _id = id;
    }

    public String get_username() 
    {
        return _username;
    }

    public void set_username(String username) 
    {
        _username = username;
    }

    public String get_password() 
    {
        return _password;
    }

    public void set_password(String password) 
    {
        _password = password;
    }

    public String get_employeeId() 
    {
        return _employeeId;
    }

    public void set_employeeId(String employeeId) 
    {
        _employeeId = employeeId;
    }

    //#endregion

}
