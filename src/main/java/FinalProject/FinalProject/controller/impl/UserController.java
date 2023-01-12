package FinalProject.FinalProject.controller.impl;

import FinalProject.FinalProject.controller.DTO.PointsDTO;
import FinalProject.FinalProject.controller.interfaces.IUserController;
import FinalProject.FinalProject.model.User;
import FinalProject.FinalProject.repository.UserRepository;
import FinalProject.FinalProject.service.impl.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
public class UserController implements IUserController {
    @Autowired
    UserRepository userRepository;
    @Autowired
    UserService userService;

    @GetMapping("/user/all")
    @ResponseStatus(HttpStatus.OK)
    public List<User> getAll(){
        return userRepository.findAll();
    }

    @GetMapping("/user/{id}")
    @ResponseStatus(HttpStatus.OK)
    public User getUserById(@PathVariable(name = "id") Integer id){
        return userService.getUserById(id);
    }

    @GetMapping("/user/{name}/{pass}")
    @ResponseStatus(HttpStatus.OK)
    public User getUserByNameAndPassword(@PathVariable(name = "name") String name,
                                         @PathVariable(name = "pass") String pass) {
        return userService.getUserByNameAndPassword(name, pass);
    }

    @PostMapping("/user/create")
    @ResponseStatus(HttpStatus.CREATED)
    public void createUser(@RequestBody @Valid User user) {
        userService.createUser(user);
    }

    @PatchMapping("/user/add_points/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updatePoints(@RequestBody @Valid PointsDTO pointsDTO, @PathVariable Integer id) {
        userService.updatePoints(pointsDTO.getPoints(),id);
    }

    @DeleteMapping("/user/delete/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteUser(@PathVariable Integer id) {
        userService.deleteUser(id);
    }
}
