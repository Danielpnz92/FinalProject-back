package FinalProject.FinalProject.service.impl;

import FinalProject.FinalProject.model.payment.CreditCard;
import FinalProject.FinalProject.repository.CreditCardRepository;
import FinalProject.FinalProject.service.interfaces.ICreditCardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;
@Service
public class CreditCardService implements ICreditCardService {
    @Autowired
    CreditCardRepository creditCardRepository;

    public CreditCard getCreditCardById(Integer id) {
        Optional<CreditCard> creditCardOptional = creditCardRepository.findById(id);
        if (creditCardOptional.isEmpty()) throw new ResponseStatusException(
                HttpStatus.NOT_FOUND,"CreditCard account not found");
        return creditCardOptional.get();
    }

    public List<CreditCard> getCreditCardByUserId(Integer id) {
        return creditCardRepository.findByUserId(id);
    }

    public void createCreditCard(CreditCard creditCard) {
        Optional<CreditCard> creditCardOptional = creditCardRepository.findByUserAndLongNumber(creditCard.getUser(), creditCard.getLongNumber());
        if (!creditCardOptional.isEmpty()) throw new ResponseStatusException(
                HttpStatus.BAD_REQUEST,"CreditCard account already exists");
        creditCardRepository.save(creditCard);
    }

    public void deleteCreditCard(Integer id) {
        CreditCard creditCard = getCreditCardById(id);
        creditCardRepository.deleteById(id);
    }
}

