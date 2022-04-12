package uz.pdp.market.mapper.permission;

import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;
import uz.pdp.market.dto.permission.PermissionCreateDto;
import uz.pdp.market.dto.permission.PermissionDto;
import uz.pdp.market.dto.permission.PermissionUpdateDto;
import uz.pdp.market.entity.permission.Permission;
import uz.pdp.market.mapper.BaseMapper;

import java.util.List;

@Component
@Mapper(componentModel = "spring")
public interface PermissionMapper extends BaseMapper<Permission, PermissionDto, PermissionCreateDto, PermissionUpdateDto> {
    @Override
    PermissionDto toDto(Permission permission);

    @Override
    List<PermissionDto> toDto(List<Permission> e);

    @Override
    Permission fromCreateDto(final PermissionCreateDto permissionCreateDto);

    @Override
    Permission fromUpdateDto(final PermissionUpdateDto permissionUpdateDto);
}
