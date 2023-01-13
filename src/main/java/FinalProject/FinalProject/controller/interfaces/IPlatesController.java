package FinalProject.FinalProject.controller.interfaces;

import FinalProject.FinalProject.model.Plates;
import FinalProject.FinalProject.model.Restaurant;

import java.util.List;

public interface IPlatesController {
    //---------GET---------//
    Plates getPlateById(Integer id);
    List<Plates> getPlatesByRestId(Integer id);
    //---------POST---------//
    void createPlate(Plates plate);

}
