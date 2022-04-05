package uz.pdp.market.mapper.stores;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.stereotype.Component;
import uz.pdp.market.dto.stores.StoresCreateDto;
import uz.pdp.market.dto.stores.StoresDto;
import uz.pdp.market.dto.stores.StoresUpdateDto;
import uz.pdp.market.entity.stores.Stores;
import uz.pdp.market.mapper.BaseMapper;

import java.util.List;

@Component
@Mapper(componentModel = "spring")
public interface StoresMapper extends BaseMapper<Stores, StoresDto, StoresCreateDto, StoresUpdateDto> {
    @Override
    StoresDto toDto(Stores stores);

    @Override
    List<StoresDto> toDto(List<Stores> e);

    @Override
    Stores fromCreateDto(StoresCreateDto storesCreateDto);

    @Override
    Stores fromUpdateDto(StoresUpdateDto storesUpdateDto);
}
