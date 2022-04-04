package uz.pdp.market.entity.auth;

import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import uz.pdp.market.entity.language.Language;
import uz.pdp.market.entity.role.Role;
import uz.pdp.market.entity.status.Status;
import uz.pdp.market.entity.base.Auditable;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "users", indexes = {
        @Index(name = "auth_user_username_key",
                columnList = "username", unique = true
        )
})
public class AuthUser extends Auditable implements GrantedAuthority {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String firstName;

    private String lastName;

    private String username;

    private String password;

    private String email;

    private String phone;

    @OneToOne
    private Language language;

    @OneToOne
    @JoinColumn(name = "status_id")
    private Status status;

    private boolean deleted;

    @OneToOne
    @JoinColumn(name = "role_id")
    private Role role;

    @Override
    public String getAuthority() {
        return role.getName();
    }

    @Builder(builderMethodName = "childBuilder")
    public AuthUser(Long id, Long createdBy, Long updatedBy, LocalDateTime createdAt, LocalDateTime updatedAt, boolean deleted, String username, String password, String firstName, String lastName, String phone, Language language, Role role, Status status, String email) {
        super(id, createdBy, updatedBy, createdAt, updatedAt, deleted);
        this.username = username;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phone = phone;
        this.language = language;
        this.role = role;
        this.status = status;
        this.email = email;
    }
}
