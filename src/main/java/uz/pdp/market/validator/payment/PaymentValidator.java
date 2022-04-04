package uz.pdp.market.validator.payment;

import org.springframework.stereotype.Component;
import uz.pdp.market.dto.payment.PaymentCreateDto;
import uz.pdp.market.dto.payment.PaymentUpdateDto;
import uz.pdp.market.validator.AbstractValidator;

import javax.xml.bind.ValidationException;

@Component
public class PaymentValidator extends AbstractValidator<PaymentCreateDto, PaymentUpdateDto, Long> {
    @Override
    public void validKey(Long id) throws ValidationException {

    }

    @Override
    public void validOnCreate(PaymentCreateDto paymentCreateDto) throws ValidationException {

    }

    @Override
    public void validOnUpdate(PaymentUpdateDto paymentUpdateDto) throws ValidationException {

    }
}
