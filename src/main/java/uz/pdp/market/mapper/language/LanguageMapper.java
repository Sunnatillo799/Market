package uz.pdp.market.mapper.language;

import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;
import uz.pdp.market.dto.language.LanguageCreateDto;
import uz.pdp.market.dto.language.LanguageDto;
import uz.pdp.market.dto.language.LanguageUpdateDto;
import uz.pdp.market.entity.language.Language;
import uz.pdp.market.mapper.BaseMapper;

import java.util.List;

@Component
@Mapper(componentModel = "spring")
public interface LanguageMapper extends BaseMapper<Language, LanguageDto, LanguageCreateDto, LanguageUpdateDto> {
    @Override
    LanguageDto toDto(Language language);

    @Override
    List<LanguageDto> toDto(List<Language> e);

    @Override
    Language fromCreateDto(LanguageCreateDto languageCreateDto);

    @Override
    Language fromUpdateDto(LanguageUpdateDto languageUpdateDto);
}
