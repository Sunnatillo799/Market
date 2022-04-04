package uz.pdp.market.service.language;

import net.bytebuddy.pool.TypePool;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import uz.pdp.market.dto.language.LanguageCreateDto;
import uz.pdp.market.entity.language.Language;
import uz.pdp.market.mapper.language.LanguageMapper;
import uz.pdp.market.repository.language.LanguageRepository;
import uz.pdp.market.response.Response;
import uz.pdp.market.service.AbstractService;
import uz.pdp.market.service.BaseService;
import uz.pdp.market.validator.language.LanguageValidator;

@Service
public class LanguageService extends AbstractService<LanguageRepository, LanguageMapper, LanguageValidator> {

    protected LanguageService(LanguageRepository repository, @Qualifier("languageMapperImpl") LanguageMapper mapper, LanguageValidator validator) {
        super(repository, mapper, validator);
    }

    public ResponseEntity<Response> add(LanguageCreateDto languageCreateDto) {
        Language language = mapper.fromCreateDto(languageCreateDto);
        repository.save(language);
        return ResponseEntity.ok(new Response("Successfully added", 200));
    }
}
