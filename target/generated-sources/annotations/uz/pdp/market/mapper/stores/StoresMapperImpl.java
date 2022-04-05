package uz.pdp.market.mapper.stores;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;
import uz.pdp.market.dto.stores.StoresCreateDto;
import uz.pdp.market.dto.stores.StoresDto;
import uz.pdp.market.dto.stores.StoresUpdateDto;
import uz.pdp.market.entity.stores.Stores;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-04-05T12:02:13+0500",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 17 (Oracle Corporation)"
)
@Component
public class StoresMapperImpl implements StoresMapper {

    @Override
    public StoresDto toDto(Stores stores) {
        if ( stores == null ) {
            return null;
        }

        StoresDto storesDto = new StoresDto();

        return storesDto;
    }

    @Override
    public List<StoresDto> toDto(List<Stores> e) {
        if ( e == null ) {
            return null;
        }

        List<StoresDto> list = new ArrayList<StoresDto>( e.size() );
        for ( Stores stores : e ) {
            list.add( toDto( stores ) );
        }

        return list;
    }

    @Override
    public Stores fromCreateDto(StoresCreateDto storesCreateDto) {
        if ( storesCreateDto == null ) {
            return null;
        }

        Stores stores = new Stores();

        stores.setName( storesCreateDto.getName() );
        stores.setDescription( storesCreateDto.getDescription() );
        stores.setType( storesCreateDto.getType() );

        return stores;
    }

    @Override
    public Stores fromUpdateDto(StoresUpdateDto storesUpdateDto) {
        if ( storesUpdateDto == null ) {
            return null;
        }

        Stores stores = new Stores();

        stores.setId( storesUpdateDto.getId() );
        stores.setName( storesUpdateDto.getName() );
        stores.setDescription( storesUpdateDto.getDescription() );
        stores.setType( storesUpdateDto.getType() );

        return stores;
    }
}
