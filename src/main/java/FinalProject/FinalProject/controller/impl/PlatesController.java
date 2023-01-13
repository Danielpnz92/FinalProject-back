package FinalProject.FinalProject.controller.impl;

import FinalProject.FinalProject.controller.interfaces.IPlatesController;
import FinalProject.FinalProject.model.Plates;
import FinalProject.FinalProject.model.User;
import FinalProject.FinalProject.service.impl.PlatesService;
import FinalProject.FinalProject.service.impl.RestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class PlatesController implements IPlatesController {
    @Autowired
    PlatesService platesService;

    @GetMapping("/plates/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Plates getPlateById(@PathVariable(name = "id") Integer id) {
        return platesService.getPlateById(id);
    }

    @GetMapping("/plates/rest/{id}")
    @ResponseStatus(HttpStatus.OK)
    public List<Plates> getPlatesByRestId(@PathVariable(name = "id") Integer id) {
        return platesService.getPlatesByRestId(id);
    }

    @PostMapping("/plates/create")
    @ResponseStatus(HttpStatus.CREATED)
    public void createPlate(@RequestBody @Valid Plates plate) {
        platesService.createPlate(plate);
    }
    /*public void createPlate(@RequestBody @Valid createPlateDTO createPlateDTO) {
        platesService.createPlate(createPlateDTO);
    }*/
}


