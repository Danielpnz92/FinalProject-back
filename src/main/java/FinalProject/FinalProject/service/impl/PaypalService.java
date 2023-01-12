package FinalProject.FinalProject.service.impl;

import FinalProject.FinalProject.model.payment.Paypal;
import FinalProject.FinalProject.repository.PaypalRepository;
import FinalProject.FinalProject.service.interfaces.IPaypalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;
@Service
public class PaypalService implements IPaypalService {
    @Autowired
    PaypalRepository paypalRepository;

    public Paypal getPaypalById(Integer id) {
        Optional<Paypal> paypalOptional = paypalRepository.findById(id);
        if (paypalOptional.isEmpty()) throw new ResponseStatusException(
                HttpStatus.NOT_FOUND,"Paypal account not found");
        return paypalOptional.get();
    }

    public List<Paypal> getPaypalByUserId(Integer id) {
        return paypalRepository.findByUserId(id);
    }

    public void createPaypal(Paypal paypal) {
        Optional<Paypal> paypalOptional = paypalRepository.findByUserAndEmail(paypal.getUser(), paypal.getEmail());
        if (!paypalOptional.isEmpty()) throw new ResponseStatusException(
                HttpStatus.BAD_REQUEST,"Paypal account already exists");
        paypalRepository.save(paypal);
    }

    public void deletePaypal(Integer id) {
        Paypal paypal = getPaypalById(id);
        paypalRepository.deleteById(id);
    }
}
