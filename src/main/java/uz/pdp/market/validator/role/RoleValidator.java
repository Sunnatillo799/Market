package uz.pdp.market.validator.role;

import org.springframework.stereotype.Component;
import uz.pdp.market.dto.role.RoleCreateDto;
import uz.pdp.market.dto.role.RoleUpdateDto;
import uz.pdp.market.validator.AbstractValidator;

import javax.xml.bind.ValidationException;

@Component
public class RoleValidator extends AbstractValidator<RoleCreateDto, RoleUpdateDto, Long> {
    @Override
    public void validKey(Long id) throws ValidationException {

    }

    @Override
    public void validOnCreate(RoleCreateDto roleCreateDto) throws ValidationException {

    }

    @Override
    public void validOnUpdate(RoleUpdateDto roleUpdateDto) throws ValidationException {

    }
}
