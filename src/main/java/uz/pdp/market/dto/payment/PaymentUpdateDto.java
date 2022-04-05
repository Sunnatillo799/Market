package uz.pdp.market.dto.payment;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import uz.pdp.market.dto.GenericDto;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PaymentUpdateDto extends GenericDto {
    private String amount;
    private String description;
}
