package uz.pdp.market.dto.customer;

import lombok.*;
import uz.pdp.market.dto.Dto;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class CustomerCreateDto implements Dto {
    private String name;
    private String phone;
    private String email;
    private String address;
    private String username;
    private String password;
    private Long language_id;
}
