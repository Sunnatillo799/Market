package uz.pdp.market.dto.role;

import lombok.Getter;
import lombok.Setter;
import uz.pdp.market.dto.GenericDto;

@Getter
@Setter
public class RoleUpdateDto extends GenericDto {
    private String name;
    private String code;
}
