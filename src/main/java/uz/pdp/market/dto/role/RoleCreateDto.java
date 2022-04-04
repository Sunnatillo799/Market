package uz.pdp.market.dto.role;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import uz.pdp.market.dto.Dto;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class RoleCreateDto implements Dto {
    private String name;
    private String code;
}
