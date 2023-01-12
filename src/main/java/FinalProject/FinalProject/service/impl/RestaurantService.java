package FinalProject.FinalProject.service.impl;

import FinalProject.FinalProject.model.Restaurant;
import FinalProject.FinalProject.model.User;
import FinalProject.FinalProject.repository.RestaurantRepository;
import FinalProject.FinalProject.repository.UserRepository;
import FinalProject.FinalProject.service.interfaces.IRestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

@Service
public class RestaurantService implements IRestaurantService {
    @Autowired
    RestaurantRepository restaurantRepository;

    public Restaurant getRestById(Integer id) {
        Optional<Restaurant> restaurantOptional = restaurantRepository.findById(id);
        if (restaurantOptional.isEmpty()) throw new ResponseStatusException(HttpStatus.NOT_FOUND,"Restaurant not found");
        return restaurantOptional.get();
    }

    public void createRestaurant(Restaurant restaurant) {
        Optional<Restaurant> restaurantOptional = restaurantRepository.findByRestNameAndZipCode(restaurant.getName(), restaurant.getZipCode());
        if (!restaurantOptional.isEmpty())
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"Restaurant already exists");
        restaurantRepository.save(restaurant);
    }
}


