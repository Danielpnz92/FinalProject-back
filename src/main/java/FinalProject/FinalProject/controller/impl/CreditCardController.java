package FinalProject.FinalProject.controller.impl;

import FinalProject.FinalProject.controller.interfaces.ICreditCardControlller;
import FinalProject.FinalProject.model.payment.CreditCard;
import FinalProject.FinalProject.service.impl.CreditCardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CreditCardController implements ICreditCardControlller {
    @Autowired
    CreditCardService creditCardService;
    @GetMapping("/creditCard/user/{id}")
    @ResponseStatus(HttpStatus.OK)
    public List<CreditCard> getCreditCardByUserId(@PathVariable(name = "id")Integer id) {
        return creditCardService.getCreditCardByUserId(id);
    }

    public void createCreditCard(CreditCard creditCard) {

    }
}
