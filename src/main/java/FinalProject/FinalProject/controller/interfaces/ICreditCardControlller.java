package FinalProject.FinalProject.controller.interfaces;

import FinalProject.FinalProject.model.payment.CreditCard;

import java.util.List;

public interface ICreditCardControlller {
    //---------POST---------//
    List<CreditCard> getCreditCardByUserId(Integer id);
    void createCreditCard(CreditCard creditCard);
}
