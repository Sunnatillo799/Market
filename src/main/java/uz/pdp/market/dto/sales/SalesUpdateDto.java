package uz.pdp.market.dto.sales;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import uz.pdp.market.dto.GenericDto;

@Getter
@Setter
@AllArgsConstructor
public class SalesUpdateDto extends GenericDto {

    private String saleType;

    private String saleDescription;

    private String saleAmount;

}
