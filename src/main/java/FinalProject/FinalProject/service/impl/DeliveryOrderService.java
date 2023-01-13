package FinalProject.FinalProject.service.impl;

import FinalProject.FinalProject.model.DeliveryOrder;
import FinalProject.FinalProject.model.OrderQuantity;
import FinalProject.FinalProject.model.Plates;
import FinalProject.FinalProject.repository.DeliveryOrderRepository;
import FinalProject.FinalProject.repository.OrderQuantityRepository;
import FinalProject.FinalProject.repository.PlatesRepository;
import FinalProject.FinalProject.service.interfaces.IDeliveryOrderServive;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.*;

@Service
public class DeliveryOrderService implements IDeliveryOrderServive {
    @Autowired
    DeliveryOrderRepository deliveryOrderRepository;
    @Autowired
    PlatesRepository platesRepository;
    @Autowired
    OrderQuantityRepository orderQuantityRepository;

    public DeliveryOrder getDeliveryOrderById(Integer id) {
        Optional<DeliveryOrder> deliveryOrderOptional = deliveryOrderRepository.findById(id);
        if (deliveryOrderOptional.isEmpty()) throw new ResponseStatusException(HttpStatus.NOT_FOUND,"Order not found");
        return deliveryOrderOptional.get();
    }

    public List<DeliveryOrder> getDeliveryOrdersByUserId(Integer id) {
        List<DeliveryOrder> orderList = deliveryOrderRepository.findByUserId(id);
        return orderList;
    }

    public void createDeliveryOrder(DeliveryOrder deliveryOrder) {
        //Primero instanciamos las cantidades en la tabla de OrderQuantity si no existen ya
        for (OrderQuantity orderQuantity : deliveryOrder.getPlatesQuantity()) {
            OrderQuantity oq = new OrderQuantity(orderQuantity.getQuantity());
            orderQuantityRepository.save(oq);
        }

        //Podrán repetirse órdenes idénticas, por lo que no hay lógica de comprobación en este caso
        deliveryOrder.setCreationDate(new Date());
        //Cuando la orden ya ha sido instanciada, se añadirán sus platos completando también el Set<DeliveryOrder>
        //de cada plato ya que la relación es ManyToMany
        for (Plates plates : deliveryOrder.getPlatesSet()) {
            Optional<Plates> platesOptional = platesRepository.findById(plates.getId());
            Set<DeliveryOrder> deliveryOrderSet = platesOptional.get().getOrderSet();
            deliveryOrderSet.add(deliveryOrder);
            platesOptional.get().setOrderSet(deliveryOrderSet);
            /*platesRepository.save(platesOptional.get());*/
        }
        deliveryOrderRepository.save(deliveryOrder);

        //añadir puntos de fidelización al cliente


    }

    public void updateDeliveryOrder(List<OrderQuantity> platesQuantity, Set<Plates> platesSet, Integer id) {
    //Siguiendo la misma lógica que para la creación de la orden:

        //Primero instanciamos las cantidades en la tabla de OrderQuantity si no existen ya
        for (OrderQuantity orderQuantity : platesQuantity) {
            OrderQuantity oq = new OrderQuantity(orderQuantity.getQuantity());
            orderQuantityRepository.save(oq);
        }

        for (Plates plates : platesSet) {
            System.out.println(plates);
        }

        //el pedido podrá ser modificado en los 5 minutos siguientes a haber sido creado
        DeliveryOrder deliveryOrder = getDeliveryOrderById(id);
        Date nowTime = new Date();
        int diffInMinutes = (int)( (nowTime.getTime() - deliveryOrder.getCreationDate().getTime())
                / (1000 * 60));
        System.out.println(diffInMinutes);
        if(diffInMinutes < 5) {
            //se sustituye el set actual de platos y su array de cantidades
            System.out.println(platesQuantity);
            deliveryOrder.setPlatesSet(platesSet);
            deliveryOrder.setPlatesQuantity(platesQuantity);
        }
        else throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST,"More than 5 minute have passed since the order was created");

        deliveryOrderRepository.save(deliveryOrder);
    }

    public void deleteDeliveryOrder(Integer id) {
        //el pedido podrá ser modificado en los 5 minutos siguientes a haber sido creado
        DeliveryOrder deliveryOrder = getDeliveryOrderById(id);
        Date nowTime = new Date();
        int diffInMinutes = (int)( (nowTime.getTime() - deliveryOrder.getCreationDate().getTime())
                / (1000 * 60));
        if(diffInMinutes < 5) deliveryOrderRepository.delete(deliveryOrder);
        else throw new ResponseStatusException(
                HttpStatus.BAD_REQUEST,"More than 5 minute have passed since the order was created");

    }
}
