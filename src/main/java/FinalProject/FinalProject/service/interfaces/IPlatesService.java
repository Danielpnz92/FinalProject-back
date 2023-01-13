package FinalProject.FinalProject.service.interfaces;

import FinalProject.FinalProject.model.Plates;
import FinalProject.FinalProject.model.Restaurant;

import java.util.List;

public interface IPlatesService {
    //---------GET---------//
    Plates getPlateById(Integer id);
    List<Plates> getPlatesByRestId(Integer id);
}
