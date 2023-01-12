package FinalProject.FinalProject.controller.impl;

import FinalProject.FinalProject.controller.interfaces.IAllergensValuesController;
import FinalProject.FinalProject.model.AllergensValues;
import FinalProject.FinalProject.service.impl.AllergensValuesService;
import FinalProject.FinalProject.service.impl.PlatesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
public class AllergensValuesController implements IAllergensValuesController {
    @Autowired
    AllergensValuesService allergensValuesService;
    @GetMapping("/allergens/{id}")
    @ResponseStatus(HttpStatus.OK)
    public AllergensValues getAllergensValuesById(@PathVariable(name = "id") Integer id) {
        return allergensValuesService.getAllergensValuesById(id);
    }
    @PostMapping("/allergens/create")
    @ResponseStatus(HttpStatus.CREATED)
    public void createAllergensValues(@RequestBody @Valid AllergensValues allergensValues) {
        allergensValuesService.createAllergensValues(allergensValues);
    }
}
