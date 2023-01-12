package FinalProject.FinalProject.controller.interfaces;

import FinalProject.FinalProject.controller.DTO.PlatesDTO;
import FinalProject.FinalProject.model.DeliveryOrder;
import FinalProject.FinalProject.model.Plates;
import FinalProject.FinalProject.model.User;

import java.util.HashMap;
import java.util.List;

public interface IDeliveryOrderController {
    //---------GET---------//
    DeliveryOrder getDeliveryOrderById(Integer id);
    List<DeliveryOrder> getDeliveryOrdersByUserId(Integer id);
    //---------POST---------//
    void createDeliveryOrder(DeliveryOrder deliveryOrder);
    //---------PATCH---------//
    void updateDeliveryOrder(PlatesDTO platesDTO, Integer id);
    //---------DELETE---------//
    void deleteDeliveryOrder(Integer id);


}
