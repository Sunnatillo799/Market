package uz.pdp.market.mapper.status;

import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;
import uz.pdp.market.dto.status.StatusCreateDto;
import uz.pdp.market.dto.status.StatusDto;
import uz.pdp.market.dto.status.StatusUpdateDto;
import uz.pdp.market.entity.status.Status;
import uz.pdp.market.mapper.BaseMapper;

import java.util.List;

@Component
@Mapper(componentModel = "spring")
public interface StatusMapper extends BaseMapper<Status, StatusDto, StatusCreateDto, StatusUpdateDto> {
    @Override
    StatusDto toDto(Status status);

    @Override
    List<StatusDto> toDto(List<Status> e);

    @Override
    Status fromCreateDto(final StatusCreateDto statusCreateDto);

    @Override
    Status fromUpdateDto(final StatusUpdateDto statusUpdateDto);
}
