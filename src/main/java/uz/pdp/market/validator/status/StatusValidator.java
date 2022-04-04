package uz.pdp.market.validator.status;

import org.springframework.stereotype.Component;
import uz.pdp.market.dto.status.StatusCreateDto;
import uz.pdp.market.dto.status.StatusUpdateDto;
import uz.pdp.market.validator.AbstractValidator;

import javax.xml.bind.ValidationException;

@Component
public class StatusValidator extends AbstractValidator<StatusCreateDto, StatusUpdateDto, Long> {
    @Override
    public void validKey(Long id) throws ValidationException {

    }

    @Override
    public void validOnCreate(StatusCreateDto statusCreateDto) throws ValidationException {

    }

    @Override
    public void validOnUpdate(StatusUpdateDto statusUpdateDto) throws ValidationException {

    }
}
