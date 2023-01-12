package FinalProject.FinalProject.controller.impl;

import FinalProject.FinalProject.controller.interfaces.IPaypalController;
import FinalProject.FinalProject.model.payment.Paypal;
import FinalProject.FinalProject.repository.DeliveryOrderRepository;
import FinalProject.FinalProject.repository.PaypalRepository;
import FinalProject.FinalProject.service.impl.PaypalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PaypalController implements IPaypalController {
    @Autowired
    PaypalRepository paypalRepository;
    @Autowired
    PaypalService paypalService;

    @GetMapping("/paypal/user/{id}")
    @ResponseStatus(HttpStatus.OK)
    public List<Paypal> getPaypalByUserId(@PathVariable(name = "id")Integer id) {
        return paypalService.getPaypalByUserId(id);
    }

    @GetMapping("/paypal/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Paypal getPaypalById(@PathVariable(name = "id")Integer id) {
        return paypalService.getPaypalById(id);
    }

    public void createPaypal(Paypal paypal) {

    }

    public void deletePaypal(Integer id) {

    }
}
