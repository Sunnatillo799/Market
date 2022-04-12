package uz.pdp.market.entity.address;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import uz.pdp.market.entity.base.Auditable;

import javax.persistence.Entity;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Address extends Auditable {

    private String city;
    private String district;
    private String street;
    private String home_number;
}
