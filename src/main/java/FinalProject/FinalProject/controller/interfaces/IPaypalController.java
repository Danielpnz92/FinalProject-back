package FinalProject.FinalProject.controller.interfaces;

import FinalProject.FinalProject.model.payment.Paypal;

import java.util.List;

public interface IPaypalController {
    //---------GET---------//
    List<Paypal> getPaypalByUserId(Integer id);
    Paypal getPaypalById(Integer id);
    //---------POST---------//
    void createPaypal(Paypal paypal);
    //---------DELETE---------//
    void deletePaypal(Integer id);
}
