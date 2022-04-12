package uz.pdp.market.mapper.role;

import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;
import uz.pdp.market.dto.role.RoleCreateDto;
import uz.pdp.market.dto.role.RoleDto;
import uz.pdp.market.dto.role.RoleUpdateDto;
import uz.pdp.market.entity.role.Role;
import uz.pdp.market.mapper.BaseMapper;

import java.util.List;

@Component
@Mapper(componentModel = "spring")
public interface RoleMapper extends BaseMapper<Role, RoleDto, RoleCreateDto, RoleUpdateDto> {
    @Override
    RoleDto toDto(Role role);

    @Override
    List<RoleDto> toDto(List<Role> e);

    @Override
    Role fromCreateDto(final RoleCreateDto roleCreateDto);

    @Override
    Role fromUpdateDto(final RoleUpdateDto roleUpdateDto);
}
