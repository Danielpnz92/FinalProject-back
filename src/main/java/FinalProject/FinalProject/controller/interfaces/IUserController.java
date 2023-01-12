package FinalProject.FinalProject.controller.interfaces;

import FinalProject.FinalProject.controller.DTO.PointsDTO;
import FinalProject.FinalProject.model.User;

public interface IUserController {
    //---------GET---------//
    User getUserById(Integer id);
    User getUserByNameAndPassword(String name, String pass);
    //---------POST---------//
    void createUser(User user);
    //---------PATCH---------//
    void updatePoints(PointsDTO pointsDTO, Integer id);
    //---------DELETE---------//
    void deleteUser(Integer id);

}
