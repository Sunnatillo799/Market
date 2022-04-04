package uz.pdp.market.validator.customer;

import org.springframework.stereotype.Component;
import uz.pdp.market.dto.customer.CustomerCreateDto;
import uz.pdp.market.dto.customer.CustomerUpdateDto;
import uz.pdp.market.validator.AbstractValidator;

import javax.xml.bind.ValidationException;

@Component
public class CustomerValidator extends AbstractValidator<CustomerCreateDto, CustomerUpdateDto, Long> {
    @Override
    public void validKey(Long id) throws ValidationException {

    }

    @Override
    public void validOnCreate(CustomerCreateDto customerCreateDto) throws ValidationException {

    }

    @Override
    public void validOnUpdate(CustomerUpdateDto customerUpdateDto) throws ValidationException {

    }
}
