package uz.pdp.market.validator.permission;

import org.springframework.stereotype.Component;
import uz.pdp.market.dto.permission.PermissionCreateDto;
import uz.pdp.market.dto.permission.PermissionUpdateDto;
import uz.pdp.market.validator.AbstractValidator;

import javax.xml.bind.ValidationException;

@Component
public class PermissionValidator extends AbstractValidator<PermissionCreateDto, PermissionUpdateDto, Long> {
    @Override
    public void validKey(Long id) throws ValidationException {

    }

    @Override
    public void validOnCreate(PermissionCreateDto permissionCreateDto) throws ValidationException {

    }

    @Override
    public void validOnUpdate(PermissionUpdateDto permissionUpdateDto) throws ValidationException {

    }
}
