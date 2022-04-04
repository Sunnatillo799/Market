package uz.pdp.market.validator.sales;

import org.springframework.stereotype.Component;
import uz.pdp.market.dto.sales.SalesCreateDto;
import uz.pdp.market.dto.sales.SalesUpdateDto;
import uz.pdp.market.validator.AbstractValidator;

import javax.xml.bind.ValidationException;

@Component
public class SalesValidator extends AbstractValidator<SalesCreateDto, SalesUpdateDto, Long> {
    @Override
    public void validKey(Long id) throws ValidationException {

    }

    @Override
    public void validOnCreate(SalesCreateDto salesCreateDto) throws ValidationException {

    }

    @Override
    public void validOnUpdate(SalesUpdateDto salesUpdateDto) throws ValidationException {

    }
}
