package uz.pdp.market.mapper.sales;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;
import uz.pdp.market.dto.sales.SalesCreateDto;
import uz.pdp.market.dto.sales.SalesDto;
import uz.pdp.market.dto.sales.SalesUpdateDto;
import uz.pdp.market.entity.sales.Sales;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-04-12T10:24:02+0500",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 17 (Oracle Corporation)"
)
@Component
public class SalesMapperImpl implements SalesMapper {

    @Override
    public SalesDto toDto(Sales sales) {
        if ( sales == null ) {
            return null;
        }

        SalesDto salesDto = new SalesDto();

        return salesDto;
    }

    @Override
    public List<SalesDto> toDto(List<Sales> e) {
        if ( e == null ) {
            return null;
        }

        List<SalesDto> list = new ArrayList<SalesDto>( e.size() );
        for ( Sales sales : e ) {
            list.add( toDto( sales ) );
        }

        return list;
    }

    @Override
    public Sales fromCreateDto(SalesCreateDto salesCreateDto) {
        if ( salesCreateDto == null ) {
            return null;
        }

        Sales sales = new Sales();

        sales.setSaleType( salesCreateDto.getSaleType() );
        sales.setSaleDescription( salesCreateDto.getSaleDescription() );
        sales.setSaleAmount( salesCreateDto.getSaleAmount() );

        return sales;
    }

    @Override
    public Sales fromUpdateDto(SalesUpdateDto salesUpdateDto) {
        if ( salesUpdateDto == null ) {
            return null;
        }

        Sales sales = new Sales();

        sales.setId( salesUpdateDto.getId() );
        sales.setSaleType( salesUpdateDto.getSaleType() );
        sales.setSaleDescription( salesUpdateDto.getSaleDescription() );
        sales.setSaleAmount( salesUpdateDto.getSaleAmount() );

        return sales;
    }
}
