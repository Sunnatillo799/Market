package uz.pdp.market.entity.customer;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import uz.pdp.market.entity.base.Auditable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "customer")
public class Customer extends Auditable {

    private String name;

    private String phone;

    @Column(nullable = false, unique = true)
    private String email;

    private String address;

    @Column(nullable = false, unique = true)
    private String username;

    private String password;
}
