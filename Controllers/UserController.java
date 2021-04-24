package Controllers;

import Models.User;

public class UserController {
    
    private static User _user;

    public UserController(User user) {
        _user = user;
    }


    public void CreateNewUser(User user)
    {
        _user.set_id(user.get_id());
        _user.set_username(user.get_username());
        _user.set_password(user.get_password());
        _user.set_employeeId(user.get_employeeId());
    }
}
