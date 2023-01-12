package FinalProject.FinalProject.service.interfaces;

import FinalProject.FinalProject.model.Restaurant;
import FinalProject.FinalProject.model.User;
import FinalProject.FinalProject.model.payment.Paypal;

public interface IRestaurantService {
    //---------GET---------//
    Restaurant getRestById(Integer id);
    //---------POST---------//
    void createRestaurant(Restaurant restaurant);
}
