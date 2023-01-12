package FinalProject.FinalProject.service.interfaces;

import FinalProject.FinalProject.model.User;

public interface IUserService {
    //---------GET---------//
    User getUserById(Integer id);
    User getUserByNameAndPassword(String name, String pass);
    //---------POST---------//
    void createUser(User user);
    //---------PATCH---------//
    void updatePoints(Double points, Integer id);
    //---------DELETE---------//
    void deleteUser(Integer id);

}
