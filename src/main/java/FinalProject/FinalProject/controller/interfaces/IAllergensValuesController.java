package FinalProject.FinalProject.controller.interfaces;

import FinalProject.FinalProject.model.AllergensValues;

public interface IAllergensValuesController {
    //---------GET---------//
    AllergensValues getAllergensValuesById(Integer id);
    //---------POST---------//
    void createAllergensValues(AllergensValues creditCard);
}
