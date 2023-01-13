package FinalProject.FinalProject.service.interfaces;

import FinalProject.FinalProject.model.DeliveryOrder;
import FinalProject.FinalProject.model.OrderQuantity;
import FinalProject.FinalProject.model.Plates;

import java.util.HashMap;
import java.util.List;
import java.util.Set;

public interface IDeliveryOrderServive {
    //---------GET---------//
    DeliveryOrder getDeliveryOrderById(Integer id);
    List<DeliveryOrder> getDeliveryOrdersByUserId(Integer id);
    //---------POST---------//
    void createDeliveryOrder(DeliveryOrder deliveryOrder);
    //---------PATCH---------//
    void updateDeliveryOrder(List<OrderQuantity> platesQuantity, Set<Plates> platesSet, Integer id);
    //---------DELETE---------//
    void deleteDeliveryOrder(Integer id);
}
