package FinalProject.FinalProject.service.impl;

import FinalProject.FinalProject.model.User;
import FinalProject.FinalProject.model.enums.PrimeCategories;
import FinalProject.FinalProject.repository.UserRepository;
import FinalProject.FinalProject.service.interfaces.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.Date;
import java.util.Optional;
@Service
public class UserService implements IUserService {
    @Autowired
    UserRepository userRepository;

    public User getUserById(Integer id) {
        Optional<User> userOptional = userRepository.findById(id);
        if (userOptional.isEmpty()) throw new ResponseStatusException(HttpStatus.NOT_FOUND,"User not found");
        return userOptional.get();
    }

    public User getUserByNameAndPassword(String name, String pass) {
        Optional<User> userOptional = userRepository.findByNameAndPassword(name, pass);
        if (userOptional.isEmpty()) throw new ResponseStatusException(HttpStatus.NOT_FOUND,"User not found");
        return userOptional.get();
    }

    public void createUser(User user) {
        Optional<User> userOptional = userRepository.findByNameAndEmail(user.getName(), user.getEmail());
        if (!userOptional.isEmpty()) throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"User already exists");
        user.setRegistrationDate(new Date());
        user.setCategory(PrimeCategories.NONE);
        user.setPoints(0.0);
        userRepository.save(user);
    }

    public void updatePoints(Double points, Integer id) {
        User user = getUserById(id);
        user.setPoints(user.getPoints()+points);
        userRepository.save(user);
    }

    public void deleteUser(Integer id) {
        User user = getUserById(id);
        userRepository.deleteById(id);
    }
}
