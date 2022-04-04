package uz.pdp.market.dto.auth;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class RegisterDto {
    private String username;
    private String password;
    private String firstName;
    private String lastName;
    private String phone_number;
    private Long language_id;
    private String email;
    private Long role_id;
}
