package uz.pdp.market.mapper.language;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;
import uz.pdp.market.dto.language.LanguageCreateDto;
import uz.pdp.market.dto.language.LanguageDto;
import uz.pdp.market.dto.language.LanguageUpdateDto;
import uz.pdp.market.entity.language.Language;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-04-12T10:24:02+0500",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 17 (Oracle Corporation)"
)
@Component
public class LanguageMapperImpl implements LanguageMapper {

    @Override
    public LanguageDto toDto(Language language) {
        if ( language == null ) {
            return null;
        }

        LanguageDto languageDto = new LanguageDto();

        return languageDto;
    }

    @Override
    public List<LanguageDto> toDto(List<Language> e) {
        if ( e == null ) {
            return null;
        }

        List<LanguageDto> list = new ArrayList<LanguageDto>( e.size() );
        for ( Language language : e ) {
            list.add( toDto( language ) );
        }

        return list;
    }

    @Override
    public Language fromCreateDto(LanguageCreateDto languageCreateDto) {
        if ( languageCreateDto == null ) {
            return null;
        }

        Language language = new Language();

        language.setName( languageCreateDto.getName() );
        language.setCode( languageCreateDto.getCode() );

        return language;
    }

    @Override
    public Language fromUpdateDto(LanguageUpdateDto languageUpdateDto) {
        if ( languageUpdateDto == null ) {
            return null;
        }

        Language language = new Language();

        language.setId( languageUpdateDto.getId() );

        return language;
    }
}
