package FinalProject.FinalProject.controller.interfaces;

import FinalProject.FinalProject.model.Restaurant;

public interface IRestaurantController {
    //---------GET---------//
    Restaurant getRestById(Integer id);
    //---------POST---------//
    void createRestaurant(Restaurant restaurant);
}
