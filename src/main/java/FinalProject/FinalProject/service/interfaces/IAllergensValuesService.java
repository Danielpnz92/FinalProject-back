package FinalProject.FinalProject.service.interfaces;

import FinalProject.FinalProject.model.AllergensValues;

public interface IAllergensValuesService {
    //---------GET---------//
    AllergensValues getAllergensValuesById(Integer id);
    //---------POST---------//
    void createAllergensValues(AllergensValues creditCard);
}
