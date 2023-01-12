package FinalProject.FinalProject.service.interfaces;

import FinalProject.FinalProject.model.payment.CreditCard;
import FinalProject.FinalProject.model.payment.Paypal;

import java.util.List;

public interface ICreditCardService {
    //---------GET---------//
    CreditCard getCreditCardById(Integer id);
    List<CreditCard> getCreditCardByUserId(Integer id);
    //---------POST---------//
    void createCreditCard(CreditCard creditCard);
    //---------DELETE---------//
    void deleteCreditCard(Integer id);
}
