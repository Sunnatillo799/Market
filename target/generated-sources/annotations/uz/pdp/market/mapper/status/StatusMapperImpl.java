package uz.pdp.market.mapper.status;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;
import uz.pdp.market.dto.status.StatusCreateDto;
import uz.pdp.market.dto.status.StatusDto;
import uz.pdp.market.dto.status.StatusUpdateDto;
import uz.pdp.market.entity.status.Status;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-04-04T22:48:27+0500",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 17 (Oracle Corporation)"
)
@Component
public class StatusMapperImpl implements StatusMapper {

    @Override
    public StatusDto toDto(Status status) {
        if ( status == null ) {
            return null;
        }

        StatusDto statusDto = new StatusDto();

        return statusDto;
    }

    @Override
    public List<StatusDto> toDto(List<Status> e) {
        if ( e == null ) {
            return null;
        }

        List<StatusDto> list = new ArrayList<StatusDto>( e.size() );
        for ( Status status : e ) {
            list.add( toDto( status ) );
        }

        return list;
    }

    @Override
    public Status fromCreateDto(StatusCreateDto statusCreateDto) {
        if ( statusCreateDto == null ) {
            return null;
        }

        Status status = new Status();

        return status;
    }

    @Override
    public Status fromUpdateDto(StatusUpdateDto statusUpdateDto) {
        if ( statusUpdateDto == null ) {
            return null;
        }

        Status status = new Status();

        status.setId( statusUpdateDto.getId() );

        return status;
    }
}
