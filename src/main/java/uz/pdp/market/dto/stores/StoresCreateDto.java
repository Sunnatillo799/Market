package uz.pdp.market.dto.stores;

import lombok.*;
import uz.pdp.market.dto.Dto;

import javax.validation.constraints.NotNull;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class StoresCreateDto implements Dto {
    private String name;
    private String description;
    private String type;
}
