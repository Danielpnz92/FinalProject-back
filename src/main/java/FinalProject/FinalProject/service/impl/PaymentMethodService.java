package FinalProject.FinalProject.service.impl;

import FinalProject.FinalProject.repository.PaymentMethodRepository;
import FinalProject.FinalProject.service.interfaces.IPaymentMethodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PaymentMethodService implements IPaymentMethodService {
    @Autowired
    PaymentMethodRepository paymentMethodRepository;
}
