package uz.pdp.market.validator;

import uz.pdp.market.dto.Dto;
import uz.pdp.market.dto.GenericDto;

import javax.xml.bind.ValidationException;
import java.io.Serializable;

public abstract class AbstractValidator<
        CD extends Dto,
        UD extends GenericDto,
        K extends Serializable> implements Validator {

    public abstract void validKey(K id) throws ValidationException;

    public abstract void validOnCreate(CD cd) throws ValidationException;

    public abstract void validOnUpdate(UD ud) throws ValidationException;

}
