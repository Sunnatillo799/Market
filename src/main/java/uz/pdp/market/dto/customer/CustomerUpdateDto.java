package uz.pdp.market.dto.customer;

import lombok.*;
import uz.pdp.market.dto.GenericDto;

@Getter
@Setter
public class CustomerUpdateDto extends GenericDto {
    private String name;
    private String phone;
    private String email;
    private String address;
    private String username;
    private String password;
}
