package uz.pdp.market.mapper.role;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;
import uz.pdp.market.dto.role.RoleCreateDto;
import uz.pdp.market.dto.role.RoleDto;
import uz.pdp.market.dto.role.RoleUpdateDto;
import uz.pdp.market.entity.role.Role;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-04-12T10:24:02+0500",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 17 (Oracle Corporation)"
)
@Component
public class RoleMapperImpl implements RoleMapper {

    @Override
    public RoleDto toDto(Role role) {
        if ( role == null ) {
            return null;
        }

        RoleDto roleDto = new RoleDto();

        return roleDto;
    }

    @Override
    public List<RoleDto> toDto(List<Role> e) {
        if ( e == null ) {
            return null;
        }

        List<RoleDto> list = new ArrayList<RoleDto>( e.size() );
        for ( Role role : e ) {
            list.add( toDto( role ) );
        }

        return list;
    }

    @Override
    public Role fromCreateDto(RoleCreateDto roleCreateDto) {
        if ( roleCreateDto == null ) {
            return null;
        }

        Role role = new Role();

        role.setName( roleCreateDto.getName() );
        role.setCode( roleCreateDto.getCode() );

        return role;
    }

    @Override
    public Role fromUpdateDto(RoleUpdateDto roleUpdateDto) {
        if ( roleUpdateDto == null ) {
            return null;
        }

        Role role = new Role();

        role.setId( roleUpdateDto.getId() );
        role.setName( roleUpdateDto.getName() );
        role.setCode( roleUpdateDto.getCode() );

        return role;
    }
}
