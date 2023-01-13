package FinalProject.FinalProject.service.impl;

import FinalProject.FinalProject.model.AllergensValues;
import FinalProject.FinalProject.model.DeliveryOrder;
import FinalProject.FinalProject.model.Plates;
import FinalProject.FinalProject.model.Restaurant;
import FinalProject.FinalProject.repository.AllergensValuesRepository;
import FinalProject.FinalProject.repository.PlatesRepository;
import FinalProject.FinalProject.repository.RestaurantRepository;
import FinalProject.FinalProject.service.interfaces.IPlatesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class PlatesService implements IPlatesService {
    @Autowired
    PlatesRepository platesRepository;
    @Autowired
    AllergensValuesRepository allergensValuesRepository;

    public Plates getPlateById(Integer id) {
        Optional<Plates> platesOptional = platesRepository.findById(id);
        if (platesOptional.isEmpty()) throw new ResponseStatusException(HttpStatus.NOT_FOUND,"Restaurant not found");
        return platesOptional.get();
    }

    public List<Plates> getPlatesByRestId(Integer id) {
        List<Plates> platesList = platesRepository.findByRestaurantId(id);
        return platesList;
    }

    public void createPlate(Plates plate) {
        Optional<Plates> platesOptional = platesRepository.findByPlateNameAndRestaurant(plate.getPlateName(), plate.getRestaurant());
        if (!platesOptional.isEmpty())
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Plate already exists in the restaurant");
        platesRepository.save(plate);

        //ahora que el plato ha sido creado, se guardan sus alérgenos correspondientes
        for (AllergensValues allergensValue : plate.getAllergens()) {
            Optional<AllergensValues> allergensValuesOptional = allergensValuesRepository.findById(allergensValue.getId());
            Set<Plates> platesSet = allergensValuesOptional.get().getPlatesSet();
            platesSet.add(plate);
            allergensValuesOptional.get().setPlatesSet(platesSet);
            allergensValuesRepository.save(allergensValuesOptional.get());
        }


    }
    /*public void createPlate(createPlateDTO plateDTO) {
        Optional<Restaurant> restaurantOptional = restaurantRepository.findById(plateDTO.getRestaurant());
        if (restaurantOptional.isEmpty())
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"not found");
        restaurantRepository.save(restaurantOptional.get());
        Optional<Plates> platesOptional = platesRepository.findByPlateNameAndRestaurant(plateDTO.getPlateName(), restaurantOptional.get());
        if (!platesOptional.isEmpty())
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"Plate already exists in the restaurant");
        Plates plate = new Plates(
                plateDTO.getPlateName(),
                plateDTO.getPlateDesc(),
                plateDTO.getImageURL(),
                plateDTO.getPrice(),
                restaurantOptional.get()
        );
        platesRepository.save(plate);
        //ahora que el plato ha sido creado, se guardan sus alérgenos correspondientes
        System.out.println(plateDTO.getAllergensValues());
        for (AllergensValues allergensValue : plateDTO.getAllergensValues()) {
            allergensValuesRepository.save(allergensValue);
        }
        Optional<Plates> savedPlate = platesRepository.findByPlateNameAndRestaurant(plateDTO.getPlateName(), restaurantOptional.get());
        savedPlate.get().setAllergens(plateDTO.getAllergensValues());
        platesRepository.save(savedPlate.get());
    }*/
}


