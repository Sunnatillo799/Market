package uz.pdp.market.mapper.permission;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;
import uz.pdp.market.dto.permission.PermissionCreateDto;
import uz.pdp.market.dto.permission.PermissionDto;
import uz.pdp.market.dto.permission.PermissionUpdateDto;
import uz.pdp.market.entity.permission.Permission;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-04-04T22:48:27+0500",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 17 (Oracle Corporation)"
)
@Component
public class PermissionMapperImpl implements PermissionMapper {

    @Override
    public PermissionDto toDto(Permission permission) {
        if ( permission == null ) {
            return null;
        }

        PermissionDto permissionDto = new PermissionDto();

        return permissionDto;
    }

    @Override
    public List<PermissionDto> toDto(List<Permission> e) {
        if ( e == null ) {
            return null;
        }

        List<PermissionDto> list = new ArrayList<PermissionDto>( e.size() );
        for ( Permission permission : e ) {
            list.add( toDto( permission ) );
        }

        return list;
    }

    @Override
    public Permission fromCreateDto(PermissionCreateDto permissionCreateDto) {
        if ( permissionCreateDto == null ) {
            return null;
        }

        Permission permission = new Permission();

        return permission;
    }

    @Override
    public Permission fromUpdateDto(PermissionUpdateDto permissionUpdateDto) {
        if ( permissionUpdateDto == null ) {
            return null;
        }

        Permission permission = new Permission();

        permission.setId( permissionUpdateDto.getId() );

        return permission;
    }
}
