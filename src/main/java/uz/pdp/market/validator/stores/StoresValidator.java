package uz.pdp.market.validator.stores;

import org.springframework.stereotype.Component;
import uz.pdp.market.dto.stores.StoresCreateDto;
import uz.pdp.market.dto.stores.StoresUpdateDto;
import uz.pdp.market.validator.AbstractValidator;

import javax.xml.bind.ValidationException;

@Component
public class StoresValidator extends AbstractValidator<StoresCreateDto, StoresUpdateDto, Long> {
    @Override
    public void validKey(Long id) throws ValidationException {

    }

    @Override
    public void validOnCreate(StoresCreateDto storesCreateDto) throws ValidationException {

    }

    @Override
    public void validOnUpdate(StoresUpdateDto storesUpdateDto) throws ValidationException {

    }
}
