package FinalProject.FinalProject.controller.impl;

import FinalProject.FinalProject.controller.interfaces.IRestaurantController;
import FinalProject.FinalProject.model.Restaurant;
import FinalProject.FinalProject.model.User;
import FinalProject.FinalProject.repository.RestaurantRepository;
import FinalProject.FinalProject.service.impl.RestaurantService;
import FinalProject.FinalProject.service.impl.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class RestaurantController implements IRestaurantController {

    @Autowired
    RestaurantService restaurantService;
    @Autowired
    RestaurantRepository restaurantRepository;
    @GetMapping("/restaurant/all")
    @ResponseStatus(HttpStatus.OK)
    public List<Restaurant> getAll(){
        return restaurantRepository.findAll();
    }
    @GetMapping("/restaurant/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Restaurant getRestById(@PathVariable(name = "id") Integer id) {
        return restaurantService.getRestById(id);
    }
    @PostMapping("/restaurant/create")
    @ResponseStatus(HttpStatus.CREATED)
    public void createRestaurant(@RequestBody @Valid Restaurant restaurant) {
        restaurantService.createRestaurant(restaurant);
    }
}
