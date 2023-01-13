package FinalProject.FinalProject.controller.impl;

import FinalProject.FinalProject.controller.DTO.PlatesDTO;
import FinalProject.FinalProject.controller.interfaces.IDeliveryOrderController;
import FinalProject.FinalProject.model.DeliveryOrder;
import FinalProject.FinalProject.repository.DeliveryOrderRepository;
import FinalProject.FinalProject.service.impl.DeliveryOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@RestController
public class DeliveryOrderController implements IDeliveryOrderController {
    @Autowired
    DeliveryOrderRepository deliveryOrderRepository;
    @Autowired
    DeliveryOrderService deliveryOrderService;

    @GetMapping("/orders/all")
    @ResponseStatus(HttpStatus.OK)
    public List<DeliveryOrder> getAll(){
        return deliveryOrderRepository.findAll();
    }

    @GetMapping("/orders/{id}")
    @ResponseStatus(HttpStatus.OK)
    public DeliveryOrder getDeliveryOrderById(@PathVariable(name = "id") Integer id) {
        return deliveryOrderService.getDeliveryOrderById(id);
    }
    @GetMapping("/orders/user/{id}")
    @ResponseStatus(HttpStatus.OK)
    public List<DeliveryOrder> getDeliveryOrdersByUserId(@PathVariable(name = "id") Integer id) {
        return deliveryOrderService.getDeliveryOrdersByUserId(id);
    }

    @PostMapping("/orders/create")
    @ResponseStatus(HttpStatus.CREATED)
    public void createDeliveryOrder(@RequestBody @Valid DeliveryOrder deliveryOrder) {
        deliveryOrderService.createDeliveryOrder(deliveryOrder);
    }

    @PatchMapping("/orders/modify/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateDeliveryOrder(@RequestBody @Valid PlatesDTO platesDTO, @PathVariable(name = "id") Integer id) {
        deliveryOrderService.updateDeliveryOrder(platesDTO.getPlatesQuantity(), platesDTO.getPlatesSet(), id);
    }

    @PatchMapping("/orders/delete/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteDeliveryOrder(@PathVariable(name = "id") Integer id) {
        deliveryOrderService.deleteDeliveryOrder(id);
    }
}
