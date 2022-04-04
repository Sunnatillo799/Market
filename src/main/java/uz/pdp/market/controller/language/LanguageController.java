package uz.pdp.market.controller.language;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import uz.pdp.market.controller.AbstractController;
import uz.pdp.market.dto.language.LanguageCreateDto;
import uz.pdp.market.response.Response;
import uz.pdp.market.service.language.LanguageService;

@Controller
public class LanguageController extends AbstractController<LanguageService> {

    public LanguageController(LanguageService service) {
        super(service);
    }

    @PostMapping(PATH + "/language/add")
    public ResponseEntity<Response> add(@RequestBody LanguageCreateDto languageCreateDto) {
        return service.add(languageCreateDto);
    }
}
