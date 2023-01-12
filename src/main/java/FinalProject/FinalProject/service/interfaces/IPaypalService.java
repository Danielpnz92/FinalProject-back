package FinalProject.FinalProject.service.interfaces;

import FinalProject.FinalProject.model.payment.Paypal;

import java.util.List;

public interface IPaypalService {
    //---------GET---------//
    Paypal getPaypalById(Integer id);
    List<Paypal> getPaypalByUserId(Integer id);
    //---------POST---------//
    void createPaypal(Paypal paypal);
    //---------DELETE---------//
    void deletePaypal(Integer id);
}
