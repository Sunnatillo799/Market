package uz.pdp.market.validator.language;

import org.springframework.stereotype.Component;
import uz.pdp.market.dto.language.LanguageCreateDto;
import uz.pdp.market.dto.language.LanguageUpdateDto;
import uz.pdp.market.validator.AbstractValidator;

import javax.xml.bind.ValidationException;

@Component
public class LanguageValidator extends AbstractValidator<LanguageCreateDto, LanguageUpdateDto, Long> {
    @Override
    public void validKey(Long id) throws ValidationException {

    }

    @Override
    public void validOnCreate(LanguageCreateDto languageCreateDto) throws ValidationException {

    }

    @Override
    public void validOnUpdate(LanguageUpdateDto languageUpdateDto) throws ValidationException {

    }
}
