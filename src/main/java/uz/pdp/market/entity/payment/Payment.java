package uz.pdp.market.entity.payment;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import uz.pdp.market.entity.base.Auditable;
import uz.pdp.market.entity.customer.Customer;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "payment")
public class Payment extends Auditable {

    @OneToOne(fetch = FetchType.LAZY)
    private Customer customer;

    private String amount;

    private String description;
}
