package uz.pdp.market.dto.payment;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import uz.pdp.market.dto.Dto;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PaymentCreateDto implements Dto {
    private String amount;
    private String description;

}
