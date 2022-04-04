package uz.pdp.market.mapper.sales;

import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;
import uz.pdp.market.dto.sales.SalesCreateDto;
import uz.pdp.market.dto.sales.SalesDto;
import uz.pdp.market.dto.sales.SalesUpdateDto;
import uz.pdp.market.entity.sales.Sales;
import uz.pdp.market.mapper.BaseMapper;

import java.util.List;

@Component
@Mapper(componentModel = "spring")
public interface SalesMapper extends BaseMapper<Sales, SalesDto, SalesCreateDto, SalesUpdateDto> {
    @Override
    SalesDto toDto(Sales sales);

    @Override
    List<SalesDto> toDto(List<Sales> e);

    @Override
    Sales fromCreateDto(SalesCreateDto salesCreateDto);

    @Override
    Sales fromUpdateDto(SalesUpdateDto salesUpdateDto);
}
