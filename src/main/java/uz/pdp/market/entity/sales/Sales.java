package uz.pdp.market.entity.sales;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import uz.pdp.market.entity.base.Auditable;
import uz.pdp.market.entity.customer.Customer;

import javax.persistence.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "sales")
public class Sales extends Auditable {

    @Column(name = "sale_type")
    private String saleType;

    @Column(name = "sale_description")
    private String saleDescription;

    @Column(name = "sale_amount")
    private String saleAmount;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "customer_id")
    private Customer customer;
}
