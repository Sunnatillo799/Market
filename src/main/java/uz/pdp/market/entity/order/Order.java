package uz.pdp.market.entity.order;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import uz.pdp.market.entity.address.Address;
import uz.pdp.market.entity.auth.AuthUser;
import uz.pdp.market.entity.base.Auditable;
import uz.pdp.market.entity.product.Product;

import javax.persistence.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "product_order")
public class Order extends Auditable {

    @ManyToOne
    @JoinColumn(name = "user_id")
    private AuthUser authUser;

    @OneToOne
    private Address address;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;



}
