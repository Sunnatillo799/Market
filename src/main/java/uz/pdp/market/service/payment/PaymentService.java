package uz.pdp.market.service.payment;


import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import uz.pdp.market.dto.payment.PaymentCreateDto;
import uz.pdp.market.entity.payment.Payment;
import uz.pdp.market.mapper.payment.PaymentMapper;
import uz.pdp.market.repository.payment.PaymentRepository;
import uz.pdp.market.response.Response;
import uz.pdp.market.service.AbstractService;
import uz.pdp.market.validator.payment.PaymentValidator;

import javax.xml.bind.ValidationException;

@Service
public class PaymentService extends AbstractService<PaymentRepository, PaymentMapper, PaymentValidator> {

    protected PaymentService(PaymentRepository repository, @Qualifier("paymentMapperImpl") PaymentMapper mapper, PaymentValidator validator) {
        super(repository, mapper, validator);
    }

    public ResponseEntity<Response> create(PaymentCreateDto paymentCreateDto) throws ValidationException {
        validator.validOnCreate(paymentCreateDto);
        Payment payment = mapper.fromCreateDto(paymentCreateDto);
        repository.save(payment);
        return ResponseEntity.ok(new Response("Successfully", 200));
    }
}
