package uz.pdp.market.dto.language;

import lombok.Getter;
import lombok.Setter;
import uz.pdp.market.dto.Dto;

@Getter
@Setter
public class LanguageCreateDto implements Dto {
    private String name;
    private String code;
}
