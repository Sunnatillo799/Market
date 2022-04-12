package uz.pdp.market.dto.sales;

import lombok.Getter;
import lombok.Setter;
import uz.pdp.market.dto.Dto;
import uz.pdp.market.entity.customer.Customer;

import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Getter
@Setter
public class SalesCreateDto implements Dto {

    private String saleType;

    private String saleDescription;

    private String saleAmount;

//    private Long customer;
}
